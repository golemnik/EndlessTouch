function check () {
    let x = document.getElementById("x").value;
    let y = document.getElementById("y").value;
    let r = document.getElementById("r").value;

    return (y < 5 && y > -5)
        && (x <= 4 && x >= -4 )
        && (r <= 4 && r >= 1 );
}