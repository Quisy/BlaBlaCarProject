
function checkIfLogged()
{
    return (sessionStorage.getItem('login') != null && sessionStorage.getItem('password') != null);
}

function getLogin()
{
    return sessionStorage.getItem('login');
}