<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 09.05.2021
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <link rel="stylesheet" href="/resources/css/style6.css" >
</head>
<body>
<a class="c1" href="/logout">ВЫЙТИ</a>
<form  method="post"
       action="/registerFlight" modelAttribute="flight"/>
<div class="form">
    <h1 class="title">Регистрация нового рейса</h1>
    <div class="input-town">
        <input class="departure_city" type="text" name = "departure_city" placeholder="Введите город отправления" required>
    </div>
    <div class="input-town">
        <input class="arrival_city" type="text" name = "arrival_city"  placeholder="Введите город прибытия" required>
    </div>
    <div class="input-town">
        <input class="flight_number" type="text" name = "flight_number"  placeholder="Введите номер рейса" required>
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