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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Registra't</h2>


<form action="register" method="post" class="form-floating">
    <c:if test="${not empty registerMessage}">
        <div id="errorMessage">
                ${registerMessage}
        </div>
    </c:if>
    <div class="form-group">
        <label for="username">Usuari</label>
        <input type="text" name="username" class="form-control">
    </div>
    <div class="form-group">

        <label for="password">Password</label>
        <input type="password" name="password" class="form-control">
    </div>
    <div class="form-group">
    </div>
    <button type="submit" class="btn btn-primary">Registra't</button>
    <a href="login">Ja tens compte? Logueja't !</a>

    <p>·L'username ha de tenir mínim 6 caràcters</p>
    <p>·La contrassenya ha de tenir mínim 8 caràcters</p>
</form>


</body>
</html>
