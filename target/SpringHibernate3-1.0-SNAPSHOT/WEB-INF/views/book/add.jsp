<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 10/07/2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    Tytuł: <form:input path="title"/>
    Rating: <form:input path="rating"/>
    Opis: <form:textarea path="description"/>
    Autor: <form:select path="authors">
            <form:option value="" label="---wybierz---"/>
            <form:options items="${authors}" itemLabel="lastName" itemValue="id"/>

</form:select>
    Wydawca: <form:select path="publisher.id">
            <form:option value="" label="---wybierz---"/>
            <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
</form:select>
    <input type="submit" value="Wyślij">
</form:form>

</body>
</html>
