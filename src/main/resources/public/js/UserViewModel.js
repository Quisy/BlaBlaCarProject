const loginUrl = (login, password) => `/user/login/${login}/pw/${password}`;


    function UserViewModel(){

            this.login = ko.observable("bhbhbh");
            this.password = ko.observable("xxx");
            this.isLogged = false;


            this.loginUser = function(){
                if (confirm("asfasfas")) {
                   this.isLogged(true);
                   alert(this.login());
                   console.log(this.login());
                }

                        $.getJSON(loginUrl(this.login(), this.password()), (data) => {
                            if(data.isSuccess){
                                //sessionStorage.setItem(password, this.password);
                                //sessionStorage.setItem(login, this.login);
                                this.isLogged(true);
                                window.location.reload();
                            }
                        });
            }


        }


     ko.applyBindings(new UserViewModel(), document.getElementById("panelLogin"));
