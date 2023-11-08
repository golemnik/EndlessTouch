
const black = "rgb(255,255,255)";
const red = "rgb(248,91,91)"
const c_graph = "rgba(255,255,255,0.5)";
function draw(arr, r) {
    const canvas = document.getElementById("canvas");
    // const r = 80;
    const scale = ~~(Math.sqrt((canvas.width**2 + canvas.height**2)/2)/r)-1;
    const center = new Point(canvas.width/2, canvas.height/2);

    if (canvas.getContext) {
        const ctx = canvas.getContext("2d");
        axis(ctx, center, scale, r);
        area (ctx, center, r);

        for (let i = 0; i < arr.length; i++) {
            dot(ctx, convert( arr[i].x, arr[i].y, arr[i].r, center, r));
        }
    }
}

function area (ctx, center, r) {
    ctx.beginPath();
    ctx.arc(center.x, center.y, r/2, Math.PI, Math.PI/2, true);
    ctx.lineTo(center.x, center.y + r);
    ctx.lineTo(center.x + r/2, center.y + r);
    ctx.lineTo(center.x + r/2, center.y);
    ctx.lineTo(center.x, center.y);
    ctx.lineTo(center.x, center.y - r);
    ctx.lineTo(center.x - r/2, center.y);
    ctx.strokeStyle = c_graph;
    ctx.fillStyle = c_graph;
    ctx.fill();
    ctx.stroke();
}

class Point {
    x;
    y;
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

function axis (ctx, center, scale, r) {
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
    ctx.strokeStyle = black;
    ctx.fillStyle = black;
    ctx.font = "15px serif";
    ctx.fillText("x", center.x+(scale/2)*r, center.y+center.y/15);
    ctx.fillText("y", center.x-center.x/15, center.y - (scale/2)*r);
    ctx.stroke();

    for (let i = 1; i <= scale-1; i++) {
        mark_v(ctx, new Point(center.x+i*r/2, center.y), i/2+"R");
        mark_v(ctx, new Point(center.x-i*r/2, center.y), "-"+i/2+"R");
        mark_h(ctx, new Point(center.x, center.y-i*r/2), i/2+"R");
        mark_h(ctx, new Point(center.x, center.y+i*r/2), "-"+i/2+"R");
    }

}

function mark_v (ctx, p, t) {
    ctx.beginPath();
    ctx.lineWidth = 1.5;
    ctx.moveTo(p.x, p.y);
    ctx.lineTo(p.x, p.y+p.y/50);
    ctx.lineTo(p.x, p.y-p.y/50);
    ctx.strokeStyle = black;
    ctx.fillStyle = black;
    ctx.font = "12px serif";
    ctx.fillText(t, p.x, p.y - p.y/40);
    ctx.fill();
    ctx.stroke();
}

function mark_h (ctx, p, t) {
    ctx.beginPath();
    ctx.lineWidth = 1.5;
    ctx.moveTo(p.x, p.y);
    ctx.lineTo(p.x+p.x/50, p.y);
    ctx.lineTo(p.x-p.x/50, p.y);
    ctx.strokeStyle = black;
    ctx.fillStyle = black;
    ctx.font = "12px serif";
    ctx.fillText(t, p.x + p.x/40, p.y - p.y/40);
    ctx.fill();
    ctx.stroke();
}

function dot (ctx, p) {
    ctx.beginPath();
    ctx.lineWidth = 1;
    ctx.arc(p.x, p.y, 3, 0, 2*Math.PI, true);
    ctx.strokeStyle = black;
    ctx.fillStyle = red;
    ctx.fill();
    ctx.stroke();
}

function convert (u_x, u_y, u_r, center, r) {
    console.log(((u_x/u_r)*r + center.x) + "   " + ((-u_y/u_r)*r + center.y));
    return new Point((u_x/u_r)*r + center.x, (-u_y/u_r)*r + center.y);
}