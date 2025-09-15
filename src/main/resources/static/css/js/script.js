document.getElementById("resumeForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = document.getElementById("name").value;

    fetch(`/api/analyze?name=${name}`) // Replace with your API endpoint
        .then(res => res.json())
        .then(data => {
            document.getElementById("response").innerText = JSON.stringify(data);
        })
        .catch(err => console.error(err));
});
