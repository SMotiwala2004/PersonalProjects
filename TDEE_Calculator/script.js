let sex = document.getElementById("Select-Sex");
let weight = document.getElementById("weight");
let height = document.getElementById("height");
let age = document.getElementById("age");
let generate = document.getElementById("calculate");
let multiply = document.getElementById("multiplier")
let kcal = document.getElementById("kcal-burned")

let burned = 0;
let multiplier;


generate.onclick = function() {
    if(multiply.value === "Sedentary") {
        multiplier = 1.2;
    }
    if(multiply.value === "Lightly-Active") {
        multiplier = 1.375;
    }
    if(multiply.value === "Moderately-Active"){
        multiplier = 1.55;
    }
    if(multiply.value === "Active"){
        multiplier = 1.725;
    }
    if(multiply.value === "Very-Active"){
        multiplier = 1.9;
    }

    if(age.value <= 0 || weight.value <= 0 || height.value <= 0) {
        window.alert("Cannot enter a negative value");
        event.preventDefault();
    } 
    if(sex.value === "Male") {
            burned = Math.floor(multiplier*((10*weight.value) + (6.25*height.value) - (5*age.value) + 5));
            kcal.textContent = burned;
    } else if(sex.value === "Female") {
        burned = Math.floor(multiplier*((10*weight.value) + (6.25*height.value) - (5*age.value) - 161));
        kcal.textContent = burned;
    }
}