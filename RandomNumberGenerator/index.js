let min = document.getElementById("min");
let max = document.getElementById("max");
let generate = document.getElementById("Generate");
let final = document.getElementById("total");


generate.onclick = function() {
    let minValue = Math.ceil(Number(min.value));
        let maxValue = Math.floor(Number(max.value));
    if(minValue < maxValue) {
        final.textContent = Math.round(Math.random() * (maxValue - minValue)) + minValue;
    }
    else {
        window.alert("The minimum value must be less then the maximum value");
    }
}
