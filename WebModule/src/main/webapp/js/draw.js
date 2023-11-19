
const black = "rgb(255,255,255)";
const d_black = "rgb(107,107,107)";
const red = "rgb(186,95,255)"
const d_red = "rgb(75,0,126)"
const graph = "rgba(255,255,255,0.5)";
const d_graph = "rgba(80,80,80,0.5)";
function draw(arr, r) {
    const canvas = document.getElementById("canvas");
    // const r = (canvas.width+canvas.height)/25;
    const scale = ~~(Math.sqrt((canvas.width**2 + canvas.height**2)/2)/r)-1;
    const center = new Point(canvas.width/2, canvas.height/2);

    if (canvas.getContext) {
        const ctx = canvas.getContext("2d");
        ctx.clearRect(0,0,canvas.width,canvas.height);
        axis(ctx, center, scale, r, black);
        area (ctx, center, r, graph);

        for (let i = 0; i < arr.length; i++) {
            dot(ctx, convert( arr[i].x, arr[i].y, arr[i].r, center, r), black, red);
        }
    }
}

function darkDot (dx, dy, dr, arr) {
    const canvas = document.getElementById("canvas");
    const r = (canvas.width+canvas.height)/25;
    const scale = ~~(Math.sqrt((canvas.width**2 + canvas.height**2)/2)/r)-1;
    const center = new Point(canvas.width/2, canvas.height/2);

    if (canvas.getContext) {
        const ctx = canvas.getContext("2d");
        axis(ctx, center, scale, r, d_black);
        area (ctx, center, r, d_graph);
        for (let i = 0; i < arr.length; i++) {
            dot(ctx, convert( arr[i].x, arr[i].y, arr[i].r, center, r), d_black, d_red);
        }
        dot(ctx, convert( dx, dy, dr, center, r), black, red);
    }
}
function lightDot (arr) {
    const canvas = document.getElementById("canvas");
    const r = (canvas.width+canvas.height)/25;
    draw(arr, r);
    // const scale = ~~(Math.sqrt((canvas.width**2 + canvas.height**2)/2)/r)-1;
    // const center = new Point(canvas.width/2, canvas.height/2);
    //
    // if (canvas.getContext) {
    //     const ctx = canvas.getContext("2d");
    //     axis(ctx, center, scale, r, black);
    //     area (ctx, center, r, graph);
    //     for (let i = 0; i < arr.length; i++) {
    //         dot(ctx, convert( arr[i].x, arr[i].y, arr[i].r, center, r), black, red);
    //     }
    // }
}
function area (ctx, center, r, side) {
    ctx.beginPath();
    ctx.lineTo(center.x - r, center.y);
    ctx.lineTo(center.x - r, center.y - r);
    ctx.lineTo(center.x, center.y - r);
    ctx.arc(center.x, center.y, r, -Math.PI/2, 0, false);
    ctx.lineTo(center.x, center.y + r/2);
    ctx.lineTo(center.x, center.y);
    ctx.strokeStyle = side;
    ctx.fillStyle = side;
    ctx.fill();
    ctx.stroke();
    ctx.closePath();
}

class Point {
    x;
    y;
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

function axis (ctx, center, scale, r, side) {
    ctx.fillStyle = black;
    ctx.fillRect(center.x - (scale/2)*r, center.y, scale*r, 1);
    ctx.fillRect(center.x, center.y - (scale/2)*r, 1, scale*r);

    ctx.beginPath();
    // ctx.lineWidth = 1.5;
    ctx.moveTo(center.x+(scale/2)*r*0.95, center.y-center.y/45);
    ctx.lineTo(center.x+(scale/2)*r, center.y+0.5);
    ctx.lineTo(center.x+(scale/2)*r*0.95, center.y+center.y/40);

    ctx.moveTo(center.x-center.x/45, center.y - (scale/2)*r*0.95);
    ctx.lineTo(center.x+0.5, center.y - (scale/2)*r);
    ctx.lineTo(center.x+center.x/45, center.y - (scale/2)*r*0.95);
    ctx.strokeStyle = side;
    ctx.fillStyle = side;
    ctx.font = "15px serif";
    ctx.fillText("x", center.x+(scale/2)*r, center.y+center.y/15);
    ctx.fillText("y", center.x-center.x/15, center.y - (scale/2)*r);
    ctx.stroke();
    ctx.closePath();

    for (let i = 1; i <= scale-1; i++) {
        mark_v(ctx, new Point(center.x+i*r/2, center.y), i/2+"R", side);
        mark_v(ctx, new Point(center.x-i*r/2, center.y), "-"+i/2+"R", side);
        mark_h(ctx, new Point(center.x, center.y-i*r/2), i/2+"R", side);
        mark_h(ctx, new Point(center.x, center.y+i*r/2), "-"+i/2+"R", side);
    }

}

function mark_v (ctx, p, t, side) {
    ctx.beginPath();
    ctx.lineWidth = 1.5;
    ctx.moveTo(p.x, p.y);
    ctx.lineTo(p.x, p.y+p.y/50);
    ctx.lineTo(p.x, p.y-p.y/50);
    ctx.strokeStyle = side;
    ctx.fillStyle = side;
    ctx.font = "12px serif";
    ctx.fillText(t, p.x, p.y - p.y/40);
    ctx.fill();
    ctx.stroke();
    ctx.closePath();
}

function mark_h (ctx, p, t, side) {
    ctx.beginPath();
    ctx.lineWidth = 1.5;
    ctx.moveTo(p.x, p.y);
    ctx.lineTo(p.x+p.x/50, p.y);
    ctx.lineTo(p.x-p.x/50, p.y);
    ctx.strokeStyle = side;
    ctx.fillStyle = side;
    ctx.font = "12px serif";
    ctx.fillText(t, p.x + p.x/40, p.y - p.y/40);
    ctx.fill();
    ctx.stroke();
    ctx.closePath();
}

function dot (ctx, p, side, fill) {
    ctx.beginPath();
    ctx.lineWidth = 1;
    ctx.arc(p.x, p.y, 4, 0, 2*Math.PI, true);
    ctx.strokeStyle = side;
    ctx.fillStyle = fill;
    ctx.fill();
    ctx.stroke();
    ctx.closePath();
}

function convert (u_x, u_y, u_r, center, r) {
    console.log(((u_x/u_r)*r + center.x) + "   " + ((-u_y/u_r)*r + center.y));
    return new Point((u_x/u_r)*r + center.x, (-u_y/u_r)*r + center.y);
}