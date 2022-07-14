<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 13/07/2022
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/book/all">Wszystkie ksiazki</a>
    <a href="/author/all">Autorzy</a>
    <a href="/publishers/all">Wydawnictwo</a>
    <br>
    <a href="/author/form/add">Dodaj autora</a>

<table>
    <br><br>
    <tr>
        <td>ID</td>
        <td>Imie</td>
        <td>Nazwisko</td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/author/form/edit/${author.id}">Edytuj autora</a></td>
            <td><a href="/author/form/deleteAuthor/${author.id}">Usun autora</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
