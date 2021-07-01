<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
</head>

<body>

<table>
    <tr>
        <td> Login:</td>
        <td> ${user.login}</td>
    </tr>
    <tr>
        <td> Password:</td>
        <td> ${user.password}</td>
    </tr>
    <tr>
        <td> Email:</td>
        <td> ${user.email}</td>
    </tr>
</table>

<ul>
    <c:forEach var="listValue" items="${list}">
        <li>${listValue}</li>
    </c:forEach>
</ul>
<table>
    <form method="post"
          class="login" action="/testValue" modelAttribute="value" name="login"/>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="listValue">
            <tr>
                <td> Login:</td>
                <td> ${listValue.login}</td>
            </tr>
            <tr>
                <td> Password:</td>
                <td> ${listValue.password} </td>
            </tr>
            <tr>
                <td> Email:</td>
                <td> ${listValue.email}</td>
            </tr>
            <input type="submit" class="submit" value="Выбрать">
        </c:forEach>
    </c:if>

</table>
</body>

