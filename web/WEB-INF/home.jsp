
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h2>Hello ${user.username}!</h2>
        <form method="get" action="login">
            <input type="submit" value="Log out">
            <input type="hidden" name="logoutbutton" value="logout">
        </form>
    </body>
</html>
