const regButton = document.getElementById('regClick');
regClick.addEventListener("click", handleRegister);

let BuyerAccount = {
    userId: 1,
    userEmail: '',
    userPassword: '',
    securityQuestion: '',
    securityAnswer: ''
}


function handleRegister() {
    BuyerAccount.userEmail = document.getElementById("emailReg").value;
    BuyerAccount.userPassword = document.getElementById("passwordReg").value;
    BuyerAccount.securityQuestion = document.getElementById("securityQReg").value;
    BuyerAccount.securityAnswer = document.getElementById("securityAReg").value;

    if((BuyerAccount.userEmail).length < 12 || (BuyerAccount.userEmail).length > 100)
    {
        document.getElementById("errorMsgEmail").innerHTML = "<h4>Invalid Email</h4>";
    }
    else if((BuyerAccount.userPassword).length < 6 || (BuyerAccount.userPassword).length > 100)
    {
        document.getElementById("errorMsgPass").innerHTML = "<h4>Invalid Password</h4>";
    }
    else if((BuyerAccount.securityQuestion).length == 0)
    {
        document.getElementById("errorMsgQ").innerHTML = "<h4>Must include security question</h4>";
    }
    else if((BuyerAccount.securityAnswer).length == 0)
    {
        document.getElementById("errorMsgA").innerHTML = "<h4>Must include security answer</h4>";
    }
    else
    {
        fetchData();
    }

    async function fetchData() {

        let response = await fetch("http://localhost:8080/register", {
        method: "POST",
        body: JSON.stringify(BuyerAccount),
        headers: {"Content-type": "application/json; charset=UTF-8"}
        })

        if(response.status >= 400 && response.status < 500)
        {
            document.getElementById("errorMsg").innerHTML = "<h4>Invalid Email or Password</h4>";
        }
        else
        {
            let data = await response.json();
            console.log(data);
            localStorage.setItem("userId", data.userId);
            window.alert("Sucess!!! Account Created");
            window.location.href = "./LoggedInHome.html";
        }
    }

    
    
    /*fetch("http://localhost:8080/register", {
        method: "POST",
        body: JSON.stringify(BuyerAccount),
        headers: {"Content-type": "application/json; charset=UTF-8"},
    })

    .then((response) => {
        response.json()
        if(response.status >= 400 && response.status < 500)
        {
            document.getElementById("errorMsg").innerHTML = "<h4>Invalid Email or Password</h4>";
        }
    })
    .then((json) => {
        console.log(json);
        localStorage.setItem("userId", json.userId);
        window.location.href = "./LoggedInHome.html";
    });*/

    
}