txt = "";

function cartHandler() {
    let userId = localStorage.getItem("userId");
    fetch("http://localhost:8080/accounts/" + Number(userId) + "/cartitems", {
        method: "GET",
    })

    .then((response) => response.json())
    .then((json) => {
        console.log(json);

        for(i = 0; i < json.length; i++)
        {
            getItem(json[i].itemId, json[i].itemQuantity);
        }
        //document.getElementById('cart').innerHTML = txt;
    })
}

function getItem(itemId, itemQuantity){
    
    
    fetch("http://localhost:8080/shopitem/" + itemId, {
        method: "GET",
    })

    .then((response) => response.json())
    .then((json) => {
        console.log(json);

        foo(json);
        txt = txt + "<h3>Quantity: "+ itemQuantity +"</h3></div>";
        document.getElementById('cart').innerHTML = txt;
    })
}


function foo(value, index, array) {
    txt = txt + "<div id='productGrid'><h1>" + value["itemName"] +"</h1><br><img src='" + value["itemPicture"] + "' style='max-width:600px;'><br><h3>$" + value["itemPrice"] + "</h3><input id='removeCart' type='button' value='Remove From Cart' onclick='removeFromCartHandler(" + value["itemIdId"] +")'>";
}

function removeFromCartHandler(itemId)
{

    fetch("http://localhost:8080/cart/" + itemId, {
        method: "DELETE"
    })

    .then((response) => response.json())
    .then((json) => {
        console.log(json);
        window.location.href = "./ShoppingCart.html";
    });
}