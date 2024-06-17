let counter = document.getElementById("count");
const decrButton = document.getElementById("Decrease");
const resetButton = document.getElementById("Reset");
const incButton = document.getElementById("Increase");

const plus5 = document.getElementById("plus5");
const plus10 = document.getElementById("plus10");
const plus20 = document.getElementById("plus20");

const minus5 = document.getElementById("minus5");
const minus10 = document.getElementById("minus10");
const minus20 = document.getElementById("minus20");

let count = 0;


decrButton.onclick = function() {
    count--;
    counter.textContent = count;
}
resetButton.onclick = function() {
    count = 0;
    counter.textContent = count;
}
incButton.onclick = function() {
    count++;
    counter.textContent = count;
}
plus5.onclick = function() {
    count+=5;
    counter.textContent = count;
}
plus10.onclick = function() {
    count+=10;
    counter.textContent = count;
}
plus20.onclick = function() {
    count+=20;
    counter.textContent = count;
}
minus5.onclick = function() {
    count-=5;
    counter.textContent = count;
}
minus10.onclick = function() {
    count-=10;
    counter.textContent = count;
}
minus20.onclick = function() {
    count-=20;
    counter.textContent = count;
}
