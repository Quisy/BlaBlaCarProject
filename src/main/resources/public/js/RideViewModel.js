const getRidesUrl = () => `/rides/getAll`;
const getUserRidesUrl = (login) => `/rides/getByUser/${login}`;
const joinRideUrl = (id,login) => `/rides/join/${id}/${login}`;
const leaveRideUrl = (id,login) => `/rides/leave/${id}/${login}`;
const getOrderedRidesUrl = (login) => `/rides/getOrdered/${login}`;
const addRideUrl = (login) => `/rides/add/${login}`;
const deleteRideUrl = (id) => `/rides/delete/${id}`;


    function Ride(data) {
        this.id = data.id;
        this.from = data.from;
        this.to = data.to;
        this.owner = data.owner;
        this.date = data.date;
        this.price = data.price;
        this.seats = data.seats;
        this.users = data.users;

        this.freeSeats = ko.computed(() =>{
            return (this.seats - this.users.length) + " / " + this.seats
        });

        this.isNotFull = ko.computed(() => {
            return  (this.seats - this.users.length) > 0;
        });

        this.isNotOrdered = ko.computed(() => {
            return this.users.filter(u => u == getLogin()).length === 0;
        });

        this.orderButtonVisible = ko.computed(() => {
            return this.users.filter(u => u == getLogin()).length === 0 && (this.seats - this.users.length) > 0 && this.owner.email != getLogin() && checkIfLogged();
        });

    }

    function NewRide() {
            this.id = 0;
            this.from = "";
            this.to = "";
            this.price = 0;
            this.owner = null;
            this.date = new Date();
            this.seats = 0;
            this.users = [];
        }

    function RideViewModel(){
        var self = this;
        self.rides = ko.observableArray([]);
        self.newRide = ko.observable(new NewRide());
        self.userRides = ko.observableArray([]);
        self.orderedRides = ko.observableArray([]);
        self.isLogged = ko.observable(checkIfLogged());

        var allRides = [];
        self.queryFrom = ko.observable('');
        self.queryTo = ko.observable('');


        self.searchByFrom = function(valueFrom){
            self.rides(allRides.filter(r => r.from.toLowerCase().indexOf(valueFrom.toLowerCase()) >= 0 && r.to.toLowerCase().indexOf(self.queryTo().toLowerCase()) >= 0));
        }

        self.searchByTo = function(valueTo){
            self.rides(allRides.filter(r => r.from.toLowerCase().indexOf(self.queryFrom().toLowerCase()) >= 0 && r.to.toLowerCase().indexOf(valueTo.toLowerCase()) >= 0));
        }



        this.addRide = function(){
            self.newRide().date = new Date(this.newRide().date);
            var data = ko.toJSON(this.newRide());
            console.log(data);
            var login = getLogin();
            if (login != null)
            {
                $.post(addRideUrl(login), data, (data, status) => {
                    this.getAll();
                    this.getUserRides();
                    $("#addRide").collapse('hide');
                    alert("Dodano");

                }).fail( (err, status) => {
                    alert("Wystąpił błąd");
                });
            };
        }


        this.deleteRide = function(rideID) {
            $.ajax({
                type: "DELETE",
                url: deleteRideUrl(rideID),
                data: "name=someValue",
                success: (data) => {
                    this.getAll();
                    this.getUserRides();
                    alert("Usunięto!");
                }
            });
        }


        this.getAll = function(){
            $.getJSON(getRidesUrl(), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    self.rides(rides);
                    allRides = rides;
                });
        }


        this.getUserRides = function(){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(getUserRidesUrl(login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    self.userRides(rides);
                });
            };
        }

        this.getOrderedRides = function(){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(getOrderedRidesUrl(login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    self.orderedRides(rides);
                });
            };
        }

        this.joinRide = function(rideID){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(joinRideUrl(rideID, login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    self.orderedRides(rides);
                    this.getAll();
                });
            };

        }

         this.leaveRide = function(rideID){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(leaveRideUrl(rideID, login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    self.orderedRides(rides);
                    this.getAll();
                });
            };

        }


    }

    var vm = new RideViewModel();
    vm.getAll();
    vm.getUserRides();
    vm.getOrderedRides();

    ko.applyBindings(vm, document.getElementById("allRides"));
    vm.queryFrom.subscribe(vm.searchByFrom);
    vm.queryTo.subscribe(vm.searchByTo);