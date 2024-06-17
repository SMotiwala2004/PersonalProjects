let min = document.getElementById("min");
let max = document.getElementById("max");
let generate = document.getElementById("Generate");
let final = document.getElementById("total");


generate.onclick = function() {
    let minValue = Math.ceil(Number(min.value));
    let maxValue = Math.floor(Number(max.value));
    final.textContent = Math.round(Math.random() * (maxValue - minValue)) + minValue;
}