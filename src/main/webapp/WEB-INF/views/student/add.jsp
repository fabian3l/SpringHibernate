<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 10/07/2022
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>
<body>
<form:form method="post" modelAttribute="student">

  imie:
  <form:input path="firstName"/>
  <br>
  nazwisko:
  <form:input path="lastName"/>
  <br>
  Płeć
  <br>
  Mężczyzna:
  <form:radiobutton path="gender" value="M"/>
  Kobieta:
  <form:radiobutton path="gender" value="K"/>
  <br>
  kraj
  <form:select path="country">
    <form:option value="-" label="proszę wybrać"/>
    <form:options items="${countries}"/>
  </form:select>
  <br>
  notatki
  <form:textarea path="notes"/>
  <br>
  mailing list
  <form:checkbox path="mailingList"/>
  <br>
  programming skills
  <form:select path="programmingSkills" items="${programmingSkills}"/>
  <br>
  hobbies
  <form:checkboxes path="hobbies" items="${hobbies}"/>
  <br>
  <input type="submit" value="wyślij">
  
</form:form>

</body>
</html>
