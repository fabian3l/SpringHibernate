<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 14/07/2022
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
  Nazwa: <form:input path="name"/>
  <input type="submit" value="Wyślij">
</form:form>

</body>
</html>
