const loginButton = document.getElementById('logClick');
logClick.addEventListener("click", handleLogin);

let BuyerAccount = {
    userId: 1,
    userEmail: '',
    userPassword: '',
    securityQuestion: '',
    securityAnswer: ''
}

function handleLogin() {
    BuyerAccount.userEmail = document.getElementById("emailInput").value;
    BuyerAccount.userPassword = document.getElementById("passwordInput").value;
    
    async function fetchData() {

        let response = await fetch("http://localhost:8080/login", {
        method: "POST",
        body: JSON.stringify(BuyerAccount),
        headers: {"Content-type": "application/json; charset=UTF-8"}
        })

        if(response.status >= 400)
        {
            document.getElementById("errorMsg").innerHTML = "<h4>Incorrect Email or Password</h4>";
        }
        else
        {
            let data = await response.json();
            console.log(data);
            localStorage.setItem("userId", data.userId);
            window.location.href = "./LoggedInHome.html";
        }
    }

    fetchData();


    /*let response = fetch("http://localhost:8080/login", {
        method: "POST",
        body: JSON.stringify(BuyerAccount),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })

    .then((response) => {
        data = response.json()
        console.log(response);
        console.log(data);
    })
    .then((json) => {
        console.log(json);
        localStorage.setItem("userId", json.userId);
        window.location.href = "./LoggedInHome.html";
    });*/

    
}