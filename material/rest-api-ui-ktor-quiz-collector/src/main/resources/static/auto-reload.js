setInterval(() => {
    fetch('/parts/graphs')
        .then(response => response.text())
        .then(data => {
            document.getElementById('graphs').innerHTML = data;
        });
}, 2000);