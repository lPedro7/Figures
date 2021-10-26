
export function drawCircle(x, y, gr, col) {
    ctx.clearRect(0, 0, 1024, 768);
    ctx.beginPath();
    ctx.arc(x, y, gr, 0, 2 * Math.PI);
    ctx.fillStyle = col;
    ctx.fill();
}

export function drawSquare(x, y, gr, col) {
    ctx.clearRect(0, 0, 1024, 768);
    ctx.beginPath();
    ctx.rect(x, y, gr, gr);
    ctx.fillStyle = col;
    ctx.fill();
}

export function drawTriangle(x, y, gr, col) {
    ctx.clearRect(0, 0, 1024, 768);
    ctx.beginPath();
    ctx.moveTo(x, y);
    ctx.lineTo((x), (y + gr));
    ctx.lineTo((x + gr), y);
    ctx.closePath();
    ctx.fillStyle = col;
    ctx.fill();
}

export function drawPentagon(x, y, gr, col) {
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

export function drawStar(x, y, gr, col) {
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