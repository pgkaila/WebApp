<%--
  Created by IntelliJ IDEA.
  User: piyush
  Date: 27/3/16
  Time: 2:52 PM
  Purpose: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
    <div>
        <label for="username">Username:</label> <input id="username" name="username" type="text" placeholder="username"/>
    </div>
    <div>
        <label for="password">Password:</label> <input id="password" name="password" type="password" placeholder="password"/>
    </div>
    <div>
        <input type="hidden" name="spring-security-redirect" value="${httpRefererUrl}"/>
        <input type="submit" value="Login"/>
    </div>
</form>
</body>
</html>
