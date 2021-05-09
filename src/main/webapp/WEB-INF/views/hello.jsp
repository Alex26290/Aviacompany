
<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en" xmlns: xmlns:form="http://www.w3.org/1999/xhtml" xmlns="">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Hello!!!!</h1>

<div class="input-form">
    <input type="submit" value="Войти">
</div>
<div class="input-form">
    <input type="password" value="Пароль" placeholder="Введите пароль">
</div>
<div class="input-form">
    <input type="checkbox" value="Checkbox">
</div>


<div class="check-box">
    <input type="checkbox" value="Checkbox2">
</div>

<div class="form">
    <input type="checkbox" value="Checkbox2">

</div>

<label> Users: </label>
<%--<form:select path="users" modelAttribute="userList">--%>
<form:select path="users" modelAttribute="users">
    <form:option value="Kirill" label="Kirill"></form:option>
    <form:option value="Maria" label="Maria"></form:option>
    <form:option value="Dmitrij" label="Dmitrij"></form:option>
    <form:option value="Vladimir" label="Vladimir"></form:option>
</form:select>

<%--<form:label path = "profession">Profession:</form:label>--%>
<%--<form:select path = "profession" items = "${professions}"></form:select>--%>

</body>
</html>