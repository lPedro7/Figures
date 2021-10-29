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
<style>
    <%@include file="/WEB-INF/jsp/css/index.css" %>
</style>

<h2>Registra't</h2>


<form action="register" method="post">
    <c:if test="${not empty registerMessage}">
        <div id="errorMessage">
                ${registerMessage}
        </div>
    </c:if>

    <label for="username">Usuari</label>
    <input type="text" name="username">
    <label for="password">Password</label>
    <input type="password" name="password">
    <label for="repPassowrd">Repeteix la password</label>
    <input type="password" name="repPassword">

    <button type="submit">Registra't</button>
    <a href="login">Ja tens compte? Logueja't !</a>
</form>


</body>
</html>
