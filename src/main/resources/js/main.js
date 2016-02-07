$(function(){

    function clickme(){
    if (confirm("asfasfas")) {
                       alert("działa");
                    }
    }

    function UserViewModel(){

            this.login = ko.observable("");
            this.password = ko.observable("");
            this.isLogged = ko.observable(false);


            this.zaloguj = function(){
                if (confirm("asfasfas")) {
                   this.isLogged(true);
                   alert(this.login());
                }
            }
        }

     ko.applyBindings(new UserViewModel(), document.getElementById("panelLogin"))
});