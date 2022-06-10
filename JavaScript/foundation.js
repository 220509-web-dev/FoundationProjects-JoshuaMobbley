window.onload = function() {
    console.log('The page loaded!');
    let button = document.getElementById('login-button');
    button.addEventListener('click', login);

    let passwordField = document.getElementById('login-password');
    passwordField.addEventListener('keyup', function(e) {
        if (e.key === 'Enter') {
            login();
        }
    });

}

function login() {
    let username = document.getElementById('login-username').value;
    let password = document.getElementById('login-password').value;
    
    if (username && password) {
        let errorContainer = document.getElementById('error-message');
        errorContainer.setAttribute('hidden', true);

        fetch('http://localhost:8080/foundation/auth', {
            method: 'POST', 
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({username, password})
        });

    }else {
        let errorContainer = document.getElementById('error-message');
        errorContainer.removeAttribute('hidden');
        errorContainer.innerText = "You must provide a username and password!"
    }

}