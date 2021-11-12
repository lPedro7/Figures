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
    const coordX = "${verFigura.coordX}";
    const coordY = "${verFigura.coordY}";
    const color = "${verFigura.color}";
    const grandaria = "${verFigura.grandaria}";
    const username_owner = '${verFigura.username_owner}';
    const composed = '${verFigura.composed}'
    const tipus2 = "";
    const coordX2 = "";
    const coordY2 = "";
    const color2 = "";
    const grandaria2 = ""


    ctx.clearRect(0, 0, canvas.width, canvas.height);

    chooseType(tipus,coordX,coordY,grandaria,color);

    if (${verFigura.composed == true}) {
        const tipus2 = "${figura2.tipus}";
        const coordX2 = "${figura2.coordX}";
        const coordY2 = "${figura2.coordY}";
        const color2 = "${figura2.color}";
        const grandaria2 = "${figura2.grandaria}";
        chooseType(tipus2,coordX2,coordY2,grandaria2,color2)
    }else{

        document.querySelector('#name').value = nom;
        document.querySelector('#tipus').value = tipus;
        document.querySelector('#coordsX').value = coordX;
        document.querySelector('#coordsY').value = coordY;
        document.querySelector('#color').value = color;
        document.querySelector('#grandaria').value = grandaria;
    }


    <%@include file="js/draw.js" %>


</script>

</body>
</html>
