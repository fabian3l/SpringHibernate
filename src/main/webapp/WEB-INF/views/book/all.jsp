<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 10/07/2022
  Time: 15:14
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
<a href="/book/form/add">Dodaj ksiazke</a>


  <table>
  <br><br>
    <tr>
      <td>Id</td>
      <td>Tytuł</td>
      <td>Rating</td>
      <td>Opis</td>
      <td>Wydawca</td>
      <td>Edycja</td>
      <td>Usuwanie</td>
    </tr>
    <c:forEach items="${books}" var="book">
      <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.rating}</td>
        <td>${book.description}</td>
        <td>${book.publisher.name}</td>
        <td><a href="/book/form/edit/${book.id}">Edytuj ksiażke</a></td>
        <td><a href="/book/form/deleteBook/${book.id}">Usun ksiazke</a></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
