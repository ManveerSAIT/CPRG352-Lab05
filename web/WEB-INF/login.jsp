<%-- 
    Document   : login
    Created on : Oct 13, 2021, 6:18:48 PM
    Author     : manve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <div>
                <label>Username: </label>
                <input type="text" name="username" value="${user.username}">
                <br>
                <label>Password: </label>
                <input type="text" name="password" value="${user.password}">
                <br>
                <input type="submit" name="submitbutton" value="Log in">
            </div>
        </form>
        <h4>${invalidLogin}</h4>
        <h4>${logoutMessage}</h4>
    </body>
</html>
