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
<body>
<style><%@include file="/WEB-INF/jsp/css/index.css"%></style>
<h2>Inici de Sessió</h2>



<form action="login" method="post">

  <c:if test="${not empty loginMessage}">
    <div id="errorMessage">
        ${loginMessage}
    </div>
  </c:if>
  <label for="username">Usuari</label>
  <input type="text" name="username">
  <label for="password">Password</label>
  <input type="password" name="password">

  <button type="submit">Entrar</button>
  <a href="register"> Registra't ! </a>

</form>


</body>
<head>
    <title>Login</title>
</head>
</html>
