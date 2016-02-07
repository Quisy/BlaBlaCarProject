const getRidesUrl = () => `/rides/getAll`;


    function Ride(data) {
        this.id = ko.observable(data.id);
        this.from = ko.observable(data.from);
        this.to = ko.observable(data.to);
        this.owner = ko.observable(data.owner);
        this.date = ko.observable(data.date);
        this.price = ko.observable(data.price);
        this.seats = ko.observable(data.seats);
        this.users = ko.observableArray([data.users]);
    }

    function RideViewModel(){
        this.rides = ko.observableArray([]);


        this.getAll = function(){
            $.getJSON(getRidesUrl(), (data) => {
                    var rides = $.map(data, (item) => new Ride(item));
                    this.rides(rides);
                    console.log(this.rides())
                });
        }


        this.joinRide = function(){

        }


    }

    var vm = new RideViewModel();
    vm.getAll();
    ko.applyBindings(vm, document.getElementById("allRides"));