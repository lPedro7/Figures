<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 25/10/2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Figures</title>
</head>
<style>
    <%@include file="/WEB-INF/jsp/css/listFigures.css" %>
</style>
<body>
<nav>
    <button onclick="window.location.href='figures'">Les meves figures</button>
    <button onclick="window.location='../logout'">Logout</button>
</nav>


<h2>Figures</h2>


<table border="1">
    <tr>
        <th>Nom</th>
        <th>Tipus</th>
        <th>X</th>
        <th>Y</th>
        <th>Grandaria</th>
        <th>Color</th>
        <th>Propietari</th>
        <th>Visualitza</th>
    </tr>
    <c:forEach items="${allfigures}" var="figura">
        <tr>
            <td>${figura.nom}</td>
            <td>${figura.tipus}</td>
            <td>${figura.coordX}</td>
            <td>${figura.coordY}</td>
            <td>${figura.grandaria}</td>
            <td>${figura.color}</td>
            <td>${figura.username_owner}</td>
            <td><a href="verfigura?nom=${figura.nom}&user_owner=${figura.username_owner}">Visualitza</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
