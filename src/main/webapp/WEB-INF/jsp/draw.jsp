<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 22/10/2021
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dibuixa la figura</title>
</head>
<body>
<style>    <%@include file="/WEB-INF/jsp/css/draw.css" %>
</style>
<header>
    <nav>
        <button onclick="window.location.href='figures'">Torna</button>
        <button onclick="window.location='../logout'">Logout</button>

    </nav>

    <h2> Dibuixa la teva figura</h2>
</header>

<div>
    <canvas id="myCanvas" width="1024" height="768" style="border:1px solid #000000;"></canvas>
</div>

<c:if test="${not empty errorMessage}">
    <div>
            ${errorMessage}
    </div>
</c:if>
<div id="form">

    <form action="draw" method="post">

        <label for="name">Nom :</label>
        <input type="text" name="name" id="name">

        <label for="tipus">Figura :</label>
        <select name="tipus" id="tipus">
            <option value="cercle">Cercle</option>
            <option value="quadrat">Quadrat</option>
            <option value="triangle">Triangle</option>
            <option value="pentagon">Pentàgon</option>
            <option value="estrella">Estrella 7 Puntes</option>
        </select>

        <label>Coordenades</label>
        <label for="coordsX">X :</label>
        <input type="number" name="coordsX" id="coordsX" required>
        <label for="coordsX">Y :</label>
        <input type="number" name="coordsY" id="coordsY" required>

        <label for="grandaria">Grandària :</label>
        <input type="number" name="grandaria" id="grandaria" required>

        <label for="color">Color :</label>
        <input type="color" name="color" id="color">


        <button type="submit" onclick="draw()">Desa</button>
    </form>
    <button onclick='visualitza()' id="visualitzar"> Visualitza</button>

</div>
<script>


    let name = '${nomFigura}';
    const tipusFigura = "${tipusFigura}";
    let coordX = parseInt('${coordX}');
    let coordY = parseInt('${coordY}');
    let grandaria = parseInt('${grandaria}');
    let color = '${color}';

    let canvas = document.querySelector('#myCanvas');
    let ctx = canvas.getContext("2d");

    function draw() {
        ctx.clearRect(0, 0, 1024, 768);
        switch (tipusFigura) {
            case "cercle":
                drawCircle(coordX, coordY, grandaria, color);
                break;
            case "quadrat":
                drawSquare(coordX, coordY, grandaria, color);
                break;
            case "triangle":
                drawTriangle(coordX, coordY, grandaria, color);
                break;
            case "pentagon":
                drawPentagon(coordX, coordY, grandaria, color);
                break;
            case "estrella":
                drawStar(coordX, coordY, grandaria, color);
                break;
            default:
                break;
        }
    }


    function visualitza() {
        ctx.clearRect(0, 0, 1024, 768);

        let visNom = document.querySelector('#name').value;
        const visTipus = document.querySelector('#tipus').value
        let visCoordX = document.querySelector('#coordsX').value
        let visCoordY = document.querySelector('#coordsY').value
        let visGrandaria = document.querySelector('#grandaria').value;
        let visColor = document.querySelector('#color').value

        switch (visTipus) {
            case "cercle":
                drawCircle(visCoordX, visCoordY, visGrandaria, visColor);
                break;
            case "quadrat":
                drawSquare(visCoordX, visCoordY, visGrandaria, visColor);
                break;
            case "triangle":
                drawTriangle(visCoordX, visCoordY, visGrandaria, visColor);
                break;
            case "pentagon":
                drawPentagon(visCoordX, visCoordY, visGrandaria, visColor);
                break;
            case "estrella":
                drawStar(visCoordX, visCoordY, visGrandaria, visColor);
                break;
            default:
                break;
        }
    }

    <%@include file="js/draw.js" %>

</script>
</body>
</html>
