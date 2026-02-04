function calculate(op) {
    const a = document.getElementById('num1').value;
    const b = document.getElementById('num2').value;

    if (a === '' || b === '') {
        document.getElementById('result').innerText = 'Enter both numbers';
        return;
    }

    const backendUrl = "https://rmi-calculator-backend-latest.onrender.com";

    fetch(`${backendUrl}/api/calculator/${op}?a=${a}&b=${b}`)
        .then(response => {
            if (!response.ok) throw new Error("Server error");
            return response.text();
        })
        .then(data => {
            document.getElementById('result').innerText = data;
        })
        .catch(err => {
            document.getElementById('result').innerText = 'Error';
            console.error(err);
        });
}
