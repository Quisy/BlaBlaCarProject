const getRidesUrl = () => `/rides/getAll`;
const getUserRidesUrl = (login) => `/rides/getByUser/${login}`;
const joinRideUrl = (id,login) => `/rides/join/${id}/${login}`;
const leaveRideUrl = (id,login) => `/rides/leave/${id}/${login}`;
const getOrderedRides = (login) => `/rides/getOrdered/${login}`;


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
            return (this.seats - this.users.length)
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

    function RideViewModel(){
        this.rides = ko.observableArray([]);
        this.userRides = ko.observableArray([]);
        this.orderedRides = ko.observableArray([]);
        this.isLogged = ko.observable(checkIfLogged());


        this.getAll = function(){
            $.getJSON(getRidesUrl(), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    this.rides(rides);
                });
        }


        this.getUserRides = function(){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(getUserRidesUrl(login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    this.userRides(rides);
                });
            };
        }

        this.getOrderedRides = function(){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(getOrderedRides(login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    this.orderedRides(rides);
                });
            };
        }

        this.joinRide = function(rideID){
            var login = getLogin();
            if (login != null)
            {
                $.getJSON(joinRideUrl(rideID, login), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    this.orderedRides(rides);
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
                    this.orderedRides(rides);
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