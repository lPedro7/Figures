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
    </tr>
    <c:forEach items="${figures}" var="figura">
        <tr>
            <td>${figura.nom}</td>
            <td>${figura.tipus}</td>
            <td>${figura.coordX}</td>
            <td>${figura.coordY}</td>
            <td>${figura.grandaria}</td>
            <td>${figura.color}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
