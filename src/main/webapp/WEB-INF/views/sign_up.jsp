<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 09.05.2021
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h3>Welcome, Enter The User Details</h3>
<form:form method="post"
           action="/addUser" modelAttribute="user">
    <table>
        <div>
            Login: <input name="login" type="login">
        </div>
        <div>
            Password: <input name="password" type="password">
        </div>
        <div>
            Email:
            <form:input path="email"/>
            <form:errors path="email"/>
        </div>
        <div>
            Role: <input name="role" type="role">
        </div>
        <div class="input-form">
            <input type="submit" value="AddUser">
        </div>
    </table
</form:form>
</body>
</html>