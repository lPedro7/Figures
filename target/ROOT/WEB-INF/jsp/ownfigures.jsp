<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 25/10/2021
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Figures</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav>
    <ul class="nav">
        <li class="nav-item">
            <button onclick="window.location.href='allfigures'" class="nav-link">Veure totes les figures</button>
        </li>
        <li class="nav-item">
            <button onclick="window.location='draw'" class="nav-link">Crear nova figura</button>
        </li>
        <li class="nav-item">
            <button onclick="window.location='combine'" class="nav-link">Combinar Figures</button>
        </li>
        <li class="nav-item">
            <button onclick="window.location='../logout'" class="nav-link">Logout</button>
        </li>
    </ul>
</nav>

<h2>My Figures</h2>

<table border="1" class="table">
    <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Tipus</th>
            <th scope="col">X</th>
            <th scope="col">Y</th>
            <th scope="col">Grandaria</th>
            <th scope="col">Color</th>
            <th scope="col">Visualitza</th>
            <th scope="col">Elimina</th>
        </tr>
    </thead>
    <c:forEach items="${figures}" var="figura">
        <tr>
            <form method="post">
                <td scope="row"><input type="text" disabled value="${figura.nom}" name="name"></td>
                <c:if test="${figura.composed == false}">
                    <td><input type="text" disabled value="${figura.tipus}" name="tipus"></td>
                </c:if>
                <c:if test="${figura.composed == true}">
                    <td><input type="text" disabled value="composed" name="tipus"></td>
                </c:if>

                <td><input type="text" disabled value="${figura.coordX}" name="coordX"></td>
                <td><input type="text" disabled value="${figura.coordY}" name="coordY"></td>
                <td><input type="text" disabled value="${figura.grandaria}"></td>
                <td><input type="text" disabled value="${figura.color}"></td>
                <td><a href="verfigura?nom=${figura.nom}&user_owner=${figura.username_owner}">Visualitza</a>
                </td>
                <td>
                    <button formaction="figures?nom=${figura.nom}">Elimina</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>


<script>


</script>
</body>
</html>
