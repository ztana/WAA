<%-- 
    Document   : login
    Created on : Apr 25, 2016, 2:44:37 PM
    Author     : Rakesh Shrestha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            User ID: <input type="text" name="userId" value="${user.userId}"/><br/>
            Password: <input type="password" name="password" value="${user.password}"/><br/>
            <input type="submit" value="Login"/>
            <p>
                <c:if test="${!requestScope.errors.isEmpty()}">
                    <c:forEach var="error" items="${requestScope.errors}">
                        <span style="color: red">${error.value}</span><br/>
                        
                    </c:forEach>
                </c:if>
            </p>
        </form>
    </body>
</html>
