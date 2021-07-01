<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 09.05.2021
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <p id="panel"> <c:out value="${message}"/></p>
</c:if>

<form  method="get"
       action="/test2" modelAttribute="testValue"/>
<c:set var="departureCity" target="flightData" scope="session" value="Hello!!"/>
<c:set var="testValue" target="testValue" scope="session" value="Hello!!"/>
<input type="testValue" hidden class="testValue" value = "<c:out value="${testValue}"/>" name = "testValue">
<input type="submit" class="submit" value="Подтвердить">
</body>
</html>
