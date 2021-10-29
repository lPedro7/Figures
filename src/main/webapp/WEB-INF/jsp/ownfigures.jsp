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
<style>
    <%@include file="/WEB-INF/jsp/css/listFigures.css" %>
</style>
<nav>
    <button onclick="window.location.href='allfigures'">Veure totes les figures</button>
    <button onclick="window.location='draw'">Crear nova figura</button>
    <button onclick="window.location='combine'">Combinar Figures</button>
    <button onclick="window.location='../logout'">Logout</button>
</nav>
<h2>My Figures</h2>

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
