<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 23/10/2021
  Time: 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registre</title>
</head>
<body>

<h2>Registra't</h2>

<c:if test="${not empty registerMessage}">
  ${registerMessage}
</c:if>

<form action="/Figures_war/register" method="post">

  <label for="username">Usuari</label>
  <input type="text" name="username">
  <label for="password">Password</label>
  <input type="password" name="password">

  <button type="submit">Registra't</button>
</form>

<a href="/Figures_war/login">Ja tens compte? Logueja't !</a>

</body>
</html>
