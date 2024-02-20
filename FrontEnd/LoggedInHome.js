txt = "";

function shopHandler() {

    fetch("http://localhost:8080/shopitems", {
        method: "GET",
    })

    .then((response) => response.json())
    .then((json) => {
        console.log(json);
        json.forEach(foo);
        document.getElementById('product').innerHTML = txt;
    })

}

function shopSearchHandler() {
    let searchText = document.getElementById("search").value;

    txt = "";

    fetch("http://localhost:8080/shopitems/" + searchText, {
        method: "GET",
    })

    .then((response) => response.json())
    .then((json) => {
        console.log(json);
        json.forEach(foo);
        document.getElementById('product').innerHTML = txt;
    })
}

function shopTagHandler() {
    let searchTag = document.querySelector('#tag').value;

    txt = "";

    fetch("http://localhost:8080/shopitemstag/" + searchTag, {
        method: "GET",
    })

    .then((response) => response.json())
    .then((json) => {
        console.log(json);
        json.forEach(foo);
        document.getElementById('product').innerHTML = txt;
    })
}


function foo(value, index, array) {
    txt = txt + "<div id='productGrid'><h1>" + value["itemName"] +"</h1><br><img src='" + value["itemPicture"] + "' style='max-width:400px;'><br><h3>" + value["itemDescription"] + "</h3><h3>$" + value["itemPrice"] + "</h3><select id='select" + value["itemIdId"] +"'><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select><input id='addToCart' type='button' value='Add To Cart' onclick='addToCartHandler(" + value["itemIdId"] +")'></div>";
}

let CartItem = {
    cartId: 0,
    userId: 0,
    itemId: 0,
    itemName: 'NA',
    itemQuantity: 1
}

function addToCartHandler(itemId) {
    let userId = localStorage.getItem("userId");
    let itemQuantity = document.querySelector('#select' + itemId).value;

    CartItem.userId = Number(userId);
    CartItem.itemId = itemId;
    CartItem.itemQuantity = itemQuantity;

    fetch("http://localhost:8080/addToCart", {
        method: "POST",
        body: JSON.stringify(CartItem),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })

    .then((response) => response.json())
    .then((json) => console.log(json))
}