<%-- 
    Document   : login
    Created on : Apr 25, 2016, 4:44:09 PM
    Author     : 984881
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A Simple JavaServer Faces Application JSP version</title>
    </head>
    <body>
        <form name="myform" method="post" action="JSPController">
            <h3>JSP verison of IntroDemo</h3>
            <h3>Please enter your name and password.</h3>
            <p>Name:<input type="text" name="nameAns" value="${name}"/></p>
            <p>Age:<input type="text" name="ageAns"  value="${age}"/></p>
            <p>Password:<input type="password" name="passwordAns" /></p>
            
            <input type="submit" name="tsubmit" value="submit"/><br />
            <font style='color:red'><b>${errMessage}</b></font>
        </form>
    </body>
</html>
