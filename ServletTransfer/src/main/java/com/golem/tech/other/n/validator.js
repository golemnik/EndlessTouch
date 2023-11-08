var inputY = document.querySelector("input[name=y]");
inputY.addEventListener("change", function() {
    var yValue = parseFloat(inputY.value);
    if(yValue === -0){
        alert("Ввод неккоректен. ");
        inputY.value='';
    }
    var pattern = /^-?\d+(\.\d*)?$/;
    if (yValue < -3 ) {
        alert("Ввод некорректен. ");
        inputY.value='';

    }
    else if (yValue > 3){
        alert("Ввод неккореткен. ");
        inputY.value='';

    }
    else if(isNaN(yValue)){
        alert("Введите число.")
        inputY.value='';

    }else if(!pattern.test(inputY.value)){
        alert("Ввод неккоректен. ")
        inputY.value='';

    }

});
