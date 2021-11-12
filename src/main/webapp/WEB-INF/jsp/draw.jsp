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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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
        <div class="form-group">
            <label for="name">Nom :</label>
            <input type="text" name="name" id="name">

        </div>
        <div class="form-group">
            <label for="tipus">Figura :</label>
            <select name="tipus" id="tipus" class="form-select">
                <option value="cercle">Cercle</option>
                <option value="quadrat">Quadrat</option>
                <option value="triangle">Triangle</option>
                <option value="pentagon">Pentàgon</option>
                <option value="estrella">Estrella 7 Puntes</option>
            </select>

        </div>
        <label>Coordenades</label>

        <div class="form-group">

            <label for="coordsX">X :</label>
            <input type="number" name="coordsX" id="coordsX" required>

        </div>

        <div class="form-group">

            <label for="coordsX">Y :</label>
            <input type="number" name="coordsY" id="coordsY" required>

        </div>

        <div class="form-group">
            <label for="grandaria">Grandària :</label>
            <input type="number" name="grandaria" id="grandaria" required>
        </div>

        <div class="form-group">

            <label for="color">Color :</label>
            <input type="color" name="color" id="color">

        </div>


        <button type="submit" onclick="draw()">Desa</button>
    </form>
    <button onclick='visualitza()' id="visualitzar" class="btn btn-primary"> Visualitza</button>

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
        chooseType(tipusFigura, coordX, coordY, grandaria, color);

    }


    function visualitza() {
        ctx.clearRect(0, 0, 1024, 768);

        let visNom = document.querySelector('#name').value;
        const visTipus = document.querySelector('#tipus').value
        let visCoordX = document.querySelector('#coordsX').value
        let visCoordY = document.querySelector('#coordsY').value
        let visGrandaria = document.querySelector('#grandaria').value;
        let visColor = document.querySelector('#color').value

        chooseType(visTipus, visCoordX, visCoordY, visGrandaria, visColor);

    }

    <%@include file="js/draw.js" %>

</script>
</body>
</html>
