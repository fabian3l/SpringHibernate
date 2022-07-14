<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 10/07/2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Czy chcesz usunąć ksiazke ${book.title}</p>
<a href="/book/form/confirm/${book.id}">Potwierdzam usunięcie książki</a>
<a href="/book/all">Nie chce usuwac jednak</a>
</body>
</html>
