const loginUrl = (login, password) => `/user/login/${login}/pw/${password}`;


    function UserViewModel(){

            this.currentUserLogin = ko.observable(sessionStorage.getItem('login'));
            this.login = ko.observable();
            this.password = ko.observable();
            this.isLogged = ko.observable(checkIfLogged());
            this.isNotLogged = ko.observable(!checkIfLogged());


            this.loginUser = function(){
                        $.getJSON(loginUrl(this.login(), this.password()), (data) => {
                                var result = data;
                                if (result == true)
                                {
                                    sessionStorage.setItem('password', this.password());
                                    sessionStorage.setItem('login', this.login());
                                    window.location.reload();
                                }
                        });
            }

            this.logoutUser = function(){
                sessionStorage.clear();
                window.location.reload();
            }


        }


     ko.applyBindings(new UserViewModel(), document.getElementById("panelLogin"));
