let sex = document.getElementById("Select-Sex");
let weight = document.getElementById("weight");
let height = document.getElementById("height");
let age = document.getElementById("age");
let generate = document.getElementById("calculate");
let burned = 0;


generate.onclick = function() {
    if(age.value <= 0 || weight.value <= 0 || height.value <= 0) {
        window.alert("Cannot enter a negative value");
        event.preventDefault();
    } 
    if(sex.value === "Male") {
            burned = Math.ceil((10*weight.value) + (6.25*height.value) - (5*age.value) + 5);
            console.log(burned);
    } else if(sex.value === "Female") {
        burned = Math.ceil(10*weight.value) + (6.25*height.value) - (5*age.value) - 161;
        console.log(burned);
    }
}