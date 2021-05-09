
<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<jsp:useBean id="obj" class="org.aviacompany.model.TestList" scope="page"/>

<select>
    <c:forEach var="item" items="${obj.items}">
        <option>${item}</option>
    </c:forEach>
</select>
</body>
</html>