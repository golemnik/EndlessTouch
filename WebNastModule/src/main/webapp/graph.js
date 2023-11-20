window.onload = function(){
    canv();
};

    
function canv () {
    const can = document.querySelector("canvas");
    const r = (can.width+can.height)/21;
    can.addEventListener('click',function (event){
        let xx = Math.round((event.pageX - can.offsetLeft-can.width/2)/r);
        let yy= -(event.pageY - can.offsetTop - can.height/2)/r;
        if (xx > 4  || xx < -4){
            alert("x вышло из области определния");
        }
        else{
            if(yy<-3 || yy>3){
                alert("y вышло из области определения");
            }
            else{
                document.querySelector("input[name=x]").value = xx;
                document.querySelector("input[name=y]").value = yy;
                document.querySelector("select[name=r]").value = 1;
                document.forms["form"].submit();
            }
        }
    });
}
