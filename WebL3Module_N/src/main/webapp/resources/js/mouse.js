

window.onload = function() {
    const canvas = document.getElementById("canvas");
    const r = (canvas.width + canvas.height) / 25;


    canvas.addEventListener('click', function(event) {
        let xx = Math.round((event.pageX - canvas.offsetLeft - canvas.width / 2) / r);
        let yy = -(event.pageY - canvas.offsetTop - canvas.height / 2) / r;

        if (xx > 4 || xx < -4) {
            alert("x вышло из области определения");
        } else if (yy < -3 || yy > 3) {
            alert("y вышло из области определения");
        } else {
            document.getElementsByName("form:j_idt16")[0] = true;
            document.querySelector("div.x input ").checked = true;
            document.querySelector("div.y input").value = yy;
            document.querySelector("div.r select").value = "1";
            document.querySelector("div.but input[type=submit]").click();
        }
    });
};
