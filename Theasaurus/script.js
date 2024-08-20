let word = document.getElementById('synonyms-word');
let results = document.getElementById('results');
let syn = document.getElementById('gen-syn');

syn.onclick = async function fetchSyn() {
    const url = `https://wordsapiv1.p.rapidapi.com/words/${word.value}/synonyms`;
    const options = {
        method: 'GET',
        headers: {
            'x-rapidapi-key': 'bb1488d736msh587665e0c5f1a71p12374cjsn54a52adc8c35',
            'x-rapidapi-host': 'wordsapiv1.p.rapidapi.com'
        }
    }
        try {
            const response = await fetch(url, options);
            const result = await response.json();
            console.log(result);
            if(result.synonyms){
                results.textContent = result.synonyms.join(", ")
            }
            else {
                results.textContent = 'Word not found!';
            }
        } catch (error) {
            console.error(error);
            results.textContent = `Error: ${error.message}`;
        }
}