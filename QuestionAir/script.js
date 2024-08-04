let no = document.querySelector('#no');
let yes = document.querySelector('#yes');
let text = document.querySelector('#text');


yes.onclick = function() {
    text.textContent = "HOORAY I LOVE YOUUU🤍";
    yes.remove();
    no.remove();
}

no.onclick = function() {
    text.textContent = "Try again."
    no.remove();
}