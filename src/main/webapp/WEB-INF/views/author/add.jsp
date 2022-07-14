<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 13/07/2022
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    Imie: <form:input path="firstName"/>
    Nazwisko: <form:input path="lastName"/>
    <input type="submit" value="Wyślij">
</form:form>

</body>
</html>
