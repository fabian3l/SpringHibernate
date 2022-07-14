<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 14/07/2022
  Time: 16:25
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
<a href="/publisher/all">Wydawnictwo</a>
<br>
<a href="/publisher/form/add">Dodaj wydawnictwo</a>
<table>
  <br><br>
  <tr>
    <td>ID</td>
    <td>Nazwa</td>
  </tr>
  <c:forEach items="${publishers}" var="publisher">
    <tr>
      <td>${publisher.id}</td>
      <td>${publisher.name}</td>
      <td><a href="/publisher/form/edit/${publisher.id}">Edytuj wydawnictwo</a> </td>
      <td><a href="/publisher/form/deletePublisher/${publisher.id}">Usun wydawnictwo</a> </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
