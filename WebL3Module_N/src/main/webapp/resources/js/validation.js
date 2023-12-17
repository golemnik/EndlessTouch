function validateY(input) {
    const value = input.value.trim();


    const pattern = /^(-?[1-3])|(0)|(-?[0-3]\.[1-9]+)|(-?[0-3]\.[0]+\d*[1-9]+)$/;


    const isValid = pattern.test(value);


    if (!isValid) {
        alert("Введите значение от -5 до 3, исключая -0.");
        input.value = '';
        input.focus();
    }
}

function uncheck(box) {
    let ix = document.querySelectorAll("div.x input")
    ix.forEach(x => x.checked = false);
    box.checked = true;
}