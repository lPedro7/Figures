<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 25/10/2021
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ver Figura</title>
</head>
<style>
    <%@include file="css/draw.css"%>
</style>
<body>
<header>
    <nav>
        <button onclick="window.location.href='figures'">Torna</button>
        <button onclick="window.location='../logout'">Logout</button>
    </nav>

    <h2>Ver figura</h2>
</header>
<div>
    <canvas id="myCanvas" width="1024" height="768" style="border:1px solid #000000;"></canvas>
</div>
<div id="form">

    <h3>Propietats</h3>

    <label for="name">Nom :</label>
    <input type="text" name="name" id="name" disabled>

    <label for="tipus">Figura :</label>
    <select name="tipus" id="tipus" disabled>
        <option value="cercle">Cercle</option>
        <option value="quadrat">Quadrat</option>
        <option value="triangle">Triangle</option>
        <option value="pentagon">Pentàgon</option>
        <option value="estrella">Estrella 7 Puntes</option>
    </select>

    <label>Coordenades</label>
    <label for="coordsX">X :</label>
    <input type="number" name="coordsX" id="coordsX" disabled>
    <label for="coordsX">Y :</label>
    <input type="number" name="coordsY" id="coordsY" disabled>

    <label for="grandaria">Grandària :</label>
    <input type="number" name="grandaria" id="grandaria" disabled>

    <label for="color">Color :</label>
    <input type="color" name="color" id="color" disabled>
</div>

<script>

    let canvas = document.querySelector('#myCanvas');
    let ctx = canvas.getContext("2d");

    const nom = "${verFigura.nom}";
    const tipus = "${verFigura.tipus}";
    const coordX = ${verFigura.coordX};
    const coordY = ${verFigura.coordY};
    const color = "${verFigura.color}";
    const grandaria = ${verFigura.grandaria};
    const username_owner = '${verFigura.username_owner}';

    document.querySelector('#name').value = nom;
    document.querySelector('#tipus').value = tipus;
    document.querySelector('#coordsX').value = coordX;
    document.querySelector('#coordsY').value = coordY;
    document.querySelector('#color').value = color;
    document.querySelector('#grandaria').value = grandaria;




    switch (tipus) {
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



    function drawCircle(x, y, gr, col) {
        ctx.clearRect(0, 0, 1024, 768);
        ctx.beginPath();
        ctx.arc(x, y, gr, 0, 2 * Math.PI);
        ctx.fillStyle = col;
        ctx.fill();
    }

    function drawSquare(x, y, gr, col) {
        ctx.clearRect(0, 0, 1024, 768);
        ctx.beginPath();
        ctx.rect(x, y, gr, gr);
        ctx.fillStyle = col;
        ctx.fill();
    }

    function drawTriangle(x, y, gr, col) {
        ctx.clearRect(0, 0, 1024, 768);
        ctx.beginPath();
        ctx.moveTo(x, y);
        ctx.lineTo((x), (y + gr));
        ctx.lineTo((x + gr), y);
        ctx.closePath();
        ctx.fillStyle = col;
        ctx.fill();
    }

    function drawPentagon(x, y, gr, col) {
        ctx.clearRect(0, 0, 1024, 768);
        ctx.beginPath();
        ctx.moveTo(x + gr * Math.cos(0), y + gr * Math.sin(0));
        let rad = (2 * Math.PI) / 5;
        let x1 = x;
        let y1 = y;
        for (let i = 0; i < 5; i++) {
            x1 = x1 + gr * Math.cos(rad * i);
            y1 = y1 + gr * Math.sin(rad * i);
            ctx.lineTo(x1, y1);
        }
        ctx.closePath();
        ctx.fillStyle = col;
        ctx.fill();
    }

    function drawStar(x, y, gr, col) {
        ctx.clearRect(0, 0, 1024, 768);

        let n = 7;
        let R = gr;
        let r = gr/2;

        ctx.beginPath();
        ctx.translate(x,y);
        for(var i=0;i<n;i++){
            ctx.lineTo(Math.cos(((1/4 + i)*2*Math.PI/n))*R,-Math.sin(((1/4 + i)*2*Math.PI/n))*R);
            ctx.lineTo(Math.cos(((3/4 + i)*2*Math.PI/n))*r,-Math.sin(((3/4 + i)*2*Math.PI/n))*r);
        }
        ctx.setTransform(1, 0, 0, 1, 0, 0);

        ctx.closePath();

        ctx.fillStyle = col;

        ctx.fill();


    }


</script>

</body>
</html>
