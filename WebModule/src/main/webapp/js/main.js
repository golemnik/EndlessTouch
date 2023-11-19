window.onload = function(){
    XX();
    YY();
    RR();
    canv();
};

function check () {
    let x = document.getElementById("x").value;
    let y = document.getElementById("y").value;
    let r = document.getElementById("r").value;

    return (y < 5 && y > -5)
        && /^0|-?[1-4]$/.test(x)
        && /^[1-5]$/.test(r);
}

function RR () {
    document.querySelectorAll("input[name=rb]").forEach((but) => but.addEventListener("click", function () {
        document.querySelector("input[name=r]").value = but.value
    }));
}
function YY () {
    document.querySelector("input[name=y_in]").addEventListener("input", function () {
        document.querySelector("input[name=y]").value = document.querySelector("input[name=y_in]").value
    });
}
function XX () {
    document.querySelectorAll("input[name=xb]").forEach((but) => but.addEventListener("click", function () {
        document.querySelector("input[name=x]").value = but.value
    }));
}

function canv () {
    const can = document.querySelector("canvas");
    can.addEventListener('click', function (event) {
        let xx = Math.round((event.pageX - can.offsetLeft - can.width/2)/r);
        let yy = -(event.pageY - can.offsetTop - can.height/2)/r;
        if(xx > 4 || xx < -4) {
            alert("x {" + xx + "} is out of range");
        }
        else {
            if (yy > 5 || yy < -5) {
                alert("y {" + yy + "} is out of range");
            }
            else {
                document.querySelector("input[name=x]").value = xx;
                document.querySelector("input[name=y]").value = yy;
                document.querySelector("input[name=r]").value = 1;
                document.forms["forma"].submit();
            }
        }
    });
}

function dott (arr) {
    document.querySelectorAll("tr[class=hover]").forEach(
        (row) => {
            let x = row.cells[0].innerHTML;
            let y = row.cells[1].innerHTML;
            let r = row.cells[2].innerHTML;
        row.addEventListener("mouseover", function () {
            darkDot(x, y, r, arr);
        });
        row.addEventListener("mouseout", function () {
            lightDot(arr);
        });
    });
}
