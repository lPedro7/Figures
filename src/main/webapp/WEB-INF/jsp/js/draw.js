function drawCircle(x, y, gr, col) {
    ctx.beginPath();
    ctx.arc(x, y, gr, 0, 2 * Math.PI);
    ctx.fillStyle = col;
    ctx.fill();
}

function drawSquare(x, y, gr, col) {
    ctx.beginPath();
    ctx.rect(x, y, gr, gr);
    ctx.fillStyle = col;
    ctx.fill();
}

function drawTriangle(x, y, gr, col) {
    ctx.beginPath();
    ctx.moveTo(x, y);
    ctx.lineTo(x + gr / 2, y + gr);
    ctx.lineTo(x - gr / 2, y + gr);
    ctx.closePath();
    ctx.fillStyle = col;
    ctx.fill();
}

function drawPentagon(x, y, gr, col) {

    let numberOfSides = 5;
    let radius=gr;


    let angle = 2*Math.PI/numberOfSides;
    ctx.beginPath();
    ctx.translate(x, y);
    ctx.moveTo (radius*Math.cos(0), radius*Math.sin(0));
    for (var i = 1; i <= numberOfSides; i++) {
        ctx.lineTo (radius*Math.cos(i * angle), radius*Math.sin(i * angle));
    }
    ctx.setTransform(1, 0, 0, 1, 0, 0);

    ctx.closePath();
    ctx.fillStyle = col;
    ctx.fill();
}

function drawStar(x, y, gr, col) {

    let n = 7;
    let R = gr;
    let r = gr / 2;

    ctx.beginPath();
    ctx.translate(x, y);
    for (let i = 0; i < n; i++) {
        ctx.lineTo(Math.cos(((1 / 4 + i) * 2 * Math.PI / n)) * R, -Math.sin(((1 / 4 + i) * 2 * Math.PI / n)) * R);
        ctx.lineTo(Math.cos(((3 / 4 + i) * 2 * Math.PI / n)) * r, -Math.sin(((3 / 4 + i) * 2 * Math.PI / n)) * r);
    }
    ctx.setTransform(1, 0, 0, 1, 0, 0);

    ctx.closePath();

    ctx.fillStyle = col;

    ctx.fill();

}


function chooseType(type, x, y ,gr ,col) {
    switch (type) {
        case "cercle":
            drawCircle(x, y, gr, col);
            break;
        case "quadrat":
            drawSquare(x, y, gr, col);
            break;
        case "triangle":
            drawTriangle(x, y, gr, col);
            break;
        case "pentagon":
            drawPentagon(x, y, gr, col);
            break;
        case "estrella":
            drawStar(x, y, gr, col);
            break;
        case "composed":

            chooseType(tipus,x, y, gr, col);
            chooseType(tipus2,x, y, gr, col);
        default:
            break;

    }

}
