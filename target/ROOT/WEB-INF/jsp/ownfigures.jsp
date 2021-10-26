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
</head>
<body>

<button onclick="window.location.href='/Figures_war/private/allfigures'">Veure totes les figures</button>

<h2>My Figures</h2>

<button onclick="window.location='/Figures_war/private/draw'">Crear nova figura</button>
<table border="1">
    <tr>
        <th>Nom</th>
        <th>Tipus</th>
        <th>X</th>
        <th>Y</th>
        <th>Grandaria</th>
        <th>Color</th>
        <th>Visualitza</th>
        <th>Elimina</th>
    </tr>
    <c:forEach items="${figures}" var="figura">
        <tr>
            <form method="post">
                <td><input type="text" disabled value="${figura.nom}" name="name"></td>
                <td><input type="text" disabled value="${figura.tipus}" name="tipus"></td>
                <td><input type="text" disabled value="${figura.coordX}" name="coordX"></td>
                <td><input type="text" disabled value="${figura.coordY}" name="coordY"></td>
                <td><input type="text" disabled value="${figura.grandaria}"></td>
                <td><input type="text" disabled value="${figura.color}"></td>
                <td><a href="/Figures_war/private/verfigura?nom=${figura.nom}&user_owner=${figura.username_owner}">Visualitza</a>
                </td>
                <td>
                    <button formaction="/Figures_war/private/figures?nom=${figura.nom}&user_owner=${figura.username_owner}">Elimina</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>

<script>


</script>
</body>
</html>
