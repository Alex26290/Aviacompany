<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 08.04.2021
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<form action="/login/process" , method="post"/>
<div class="form">
    <h1>Вход</h1>
    <div><a href="/reg" class = "create">Нет аккаунта?</a></div>
    <div class="input-form">
        <input name="email" type="email" placeholder="Введите email">
    </div>
    <div class="input-form">
        <input name="password" type="password" placeholder="Введите пароль">
    </div>
    <div class="input-form">
        <input type="submit" value="Войти">
    </div>
    <a href="#" class="forget">Забыли пароль?</a>
</div>
</body>
</html>