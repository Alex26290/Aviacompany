<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 10.05.2021
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<form  method="post"
       action="/testFlight" modelAttribute="flight"/>
<div class="form">
    <h1 class="title">Регистрация нового рейса</h1>
    <div class="input-town">
        <input class="departure_city" value="<c:out value="${departure_city}"/>" type="text" name = "departure_city" placeholder="Введите город отправления" required>
<%--        <jsp:setProperty name="FlightData" property="id" value="${flight_number}" />--%>
    </div>
    <div class="input-town">
        <input class="arrival_city" value = "<c:out value="${arrival_city}"/>" type="text" name = "arrival_city"  placeholder="Введите город прибытия" required>
    </div>
<%--    <jsp:useBean id="flightData" class="org.aviacompany.model.FlightData" scope="session"  />--%>
<%--    <jsp:getProperty name="flightData" property="id"/>--%>
    <div class="input-town">
        <jsp:useBean id="flightData" class="org.aviacompany.model.FlightData" scope="session"  />
        <input class="flight_number" type="text" name = "<jsp:getProperty name="flightData" property="id"/>"  placeholder="Введите номер рейса" required>
    </div>
    <div class="input-town">
        <label style="color: aliceblue;">Введите дату вылета</label>
        <input class="departure_date" type="date" name = "departure_date" placeholder="Введите дату вылета" required>
    </div>
    <div class="input-town">
        <label style="color: aliceblue;">Введите дату прилёта</label>
        <input class="arrival_date" type="date" name = "arrival_date" placeholder="Введите дату прилёта" required>
    </div>
    <div class="input-town">
        <label style="color: aliceblue;">Введите время вылета</label>
        <input class="departure_time" type="time"  name = "departure_time" placeholder="Введите время вылета" required>
    </div>
    <div class="input-town">
        <label style="color: aliceblue;">Введите время прилета</label>
        <input class="arrival_time" type="time" name = "arrival_time" placeholder="Введите время прилета" required>
    </div>
    <input type="submit" class="submit" value="Зарегистрировать рейс">
</div>
</body>
</html>
