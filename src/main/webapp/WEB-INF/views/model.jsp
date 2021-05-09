<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello!!!!</h1>
<form:form modelAttribute="specialist">
    <form:label path="role">Role:</form:label>
    <form:select path="role" items="${roles}"/>

    <form:label path="name">Name:</form:label>
    <form:select path="name" items="${names}"/>
</form:form>
<div class="input-form">
    <input type="submit" value="Войти">
</div>
</body>


</html>
