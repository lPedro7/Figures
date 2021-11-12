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
  <title>
    Login
  </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Inici de Sessió</h2>



<form action="login" method="post" class="form-floating">

  <c:if test="${not empty loginMessage}">
    <div id="errorMessage">
        ${loginMessage}
    </div>
  </c:if>
  <div class="form-group">
    <label for="username">Usuari</label>
    <input type="text" name="username" class="form-control">
  </div>
  <div class="form-group">

    <label for="password" >Password</label>
    <input type="password" name="password" class="form-control">
</div>


  <button type="submit" class="btn btn-primary">Entrar</button>
  <a href="register"> Registra't ! </a>

</form>


</body>
<head>
    <title>Login</title>
</head>
</html>
