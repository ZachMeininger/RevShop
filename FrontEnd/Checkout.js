

function checkoutHandler() {
    
    let userId = localStorage.getItem("userId");

    if((document.getElementById("fName").value).length == 0 || (document.getElementById("fName").value).length > 20 || (document.getElementById("lName").value).length == 0 || (document.getElementById("lName").value).length > 20)
    {
        document.getElementById("errorShipName").innerHTML = "<h4>Must include first and last name</h4>";
    }
    else if((document.getElementById("shippingAddress").value).length < 10 || (document.getElementById("shippingAddress").value).length > 50)
    {
        document.getElementById("errorShipAdd").innerHTML = "<h4>Invalid Shipping Address</h4>";
    }
    else if((document.getElementById("shippingZip").value).length != 5)
    {
        document.getElementById("errorShipZip").innerHTML = "<h4>Invalid Zip Code</h4>";
    }
    else if((document.getElementById("shippingState").value).length != 2)
    {
        document.getElementById("errorShipZip").innerHTML = "<h4>Invalid State</h4>";
    }
    else if((document.getElementById("cardName").value).length < 8 || (document.getElementById("cardName").value).length > 100)
    {
        document.getElementById("errorCardName").innerHTML = "<h4>Invalid Cardholder Name</h4>";
    }
    else if((document.getElementById("cardNum").value).length != 16)
    {
        document.getElementById("errorCardNum").innerHTML = "<h4>Invalid Card Number</h4>";
    }
    else if((document.getElementById("cardCvv").value).length != 3)
    {
        document.getElementById("errorCardDet").innerHTML = "<h4>Invalid CVV</h4>";
    }
    else if((document.getElementById("cardExpiration").value).length != 5)
    {
        document.getElementById("errorCardDet").innerHTML = "<h4>Invalid Expiration Date</h4>";
    }
    else
    {
        fetch("http://localhost:8080/emptycart/" + Number(userId), {
        method: "DELETE"
        })

        .then((response) => response.json())
        .then((json) => {
            console.log(json);
            window.location.href = "./LoggedInHome.html";
        });
    }
    
    
}