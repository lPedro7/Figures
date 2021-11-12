<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 28/10/2021
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Combinar Figures</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<header>
    <nav>
        <ul class="nav">
            <li class="nav-item">
                <button onclick="window.location.href='figures'" class="nav-link">Les meves figures</button>
            </li>
            <li class="nav-item">
                <button onclick="window.location='../logout'" class="nav-link">Logout</button>
            </li>
        </ul>
    </nav>

    <h2>Combinar Figures</h2>

</header>

<form action="combine" method="post">

    <label for="name">Nom</label>
    <input type="text" name="nom">

    <label for="figura1">Primera Figura</label>
    <select name="figura1" id="figura1">
        <c:forEach items="${figures}" var="figura">
            <option value="${figura.nom}" name="${figura.nom}">${figura.nom}</option>
        </c:forEach>
    </select>


    <label for="figura2">Segona Figura</label>
    <select name="figura2" id="figura2">
        <c:forEach items="${figures}" var="figura">
            <option value="${figura.nom}" name="${figura.nom}">${figura.nom}</option>
        </c:forEach>
    </select>

    <button type="submit">Combina</button>
</form>

<script>
</script>
</body>
</html>
