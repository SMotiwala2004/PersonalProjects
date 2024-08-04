let display = document.getElementById("name");

const url = 'https://api.spotify.com/v1/browse/new-releases'

async function getData() {
    const request = new Request(url, {
        headers: {
            'Authorization': 'Bearer ***'
        }
    })
    const response = await fetch(request)
    const data = await response.json()
    console.dir(data, {depth: null});
    const albumNames = data.albums.items.map(album => album.name).join(', ');
    display.textContent = albumNames;

}

getData()