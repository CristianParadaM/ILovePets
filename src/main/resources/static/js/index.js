const sectionDes = document.getElementById("section-destacados").innerHTML;
const sectionPerr = document.getElementById("section-perros").innerHTML;
const sectionGat = document.getElementById("section-gatos").innerHTML;
const sectionAv = document.getElementById("section-aves").innerHTML;
const sectionPec = document.getElementById("section-peces").innerHTML;
const totalCards = document.getElementsByClassName("card-item");
const alertPlaceholder = document.getElementById("liveAlertPlaceholder");
let isLoginOpen = false;
let isCarritoOpen = false;

function filtre() {
    let main = document.getElementById("content");
    let filtre = window.event.currentTarget.attributes[0].value;
    switch (filtre) {
        case "perros-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltroperro.png";
            main.innerHTML = sectionPerr;
            break;
        case "gatos-filter":
            main.innerHTML = sectionGat;
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltrogato.png";
            break;
        case "aves-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltroave.png";
            main.innerHTML = sectionAv;
            break;
        case "peces-filter":
            main.innerHTML = sectionPec;
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltropez.png";
            break;
        case "todos-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltromascotas.png";
            main.innerHTML = sectionDes + sectionPerr + sectionGat + sectionAv + sectionPec;
            break;
    }
}

for (let i = 0; i < document.getElementsByClassName("card-item").length; i++) {
    document.getElementsByClassName("card-item").item(i).addEventListener("click", (event) => {
        if (event.path[0].tagName != "BUTTON" && event.path[0].tagName != "A") {
            if (event.path[0].id == "") {
                showDescription(event.path[1].id);
            } else if (event.path[0].id != "" && event.path[0].id < 3) {
                showDescription(event.path[0].id);
            } else if (event.path[0].id != "") {
                showDescription(event.path[1].id);
            }
        }

        function showDescription(id) {
            let card = document.getElementById(id);
            if (card.childElementCount != 1) {
                let size = card.clientHeight;
                document.getElementById(id).innerHTML = "<div id='sc' style='overflow:scroll;height:" + parseInt((size * 0.94), 10) + "px;'><p id='pa'>" + card.attributes[3].value + "</p></div>";
            } else {
                console.log(id - 1);
                console.log(totalCards.item((id - 1)));
                document.getElementById(id).innerHTML = totalCards.item((id - 1)).innerHTML;
            }
        }
    });
}

document.getElementById("user-info").addEventListener("click", () => {
    isCarritoOpen = false;
    document.getElementById("panel-carrito").style.display = "none";
    if (!isLoginOpen) {
        document.getElementById("panel-login").style.display = "block";
        isLoginOpen = true;
    } else {
        document.getElementById("panel-login").style.display = "none";
        isLoginOpen = false;
    }
});

document.getElementById("carrito-compras").addEventListener("click", () => {
    isLoginOpen = false;
    document.getElementById("panel-login").style.display = "none";
    if (!isCarritoOpen) {
        document.getElementById("panel-carrito").style.display = "block";
        isCarritoOpen = true;
    } else {
        document.getElementById("panel-carrito").style.display = "none";
        isCarritoOpen = false;
    }
});

document.getElementById("username-text").addEventListener("input", (event) => {
    let data = new String(event.data);
    let text = document.getElementById("username-text").value;
    const regex = /[A-Za-z0-9]+/g;
    if (!data.match(regex)) {
        document.getElementById("username-text").value = text.substring(0, text.length - 1);
        alert("caracteres invalidos");
    }
    if (text.length == 40) {
        document.getElementById("username-text").value = text.substring(0, text.length - 1);
        alert("maximo 40 caracteres");
    }
});

document.getElementById("password-text").addEventListener("input", (event) => {
    let data = new String(event.data);
    let text = document.getElementById("password-text").value;
    const regex = /[A-Za-z0-9]+/g;
    if (!data.match(regex)) {
        document.getElementById("password-text").value = text.substring(0, text.length - 1);
        alert("caracteres invalidos");
    }
    if (text.length == 40) {
        document.getElementById("password-text").value = text.substring(0, text.length - 1);
        alert("maximo 40 caracteres");
    }
});

function alert(message, type){
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
    alertPlaceholder.append(wrapper)
}

function addItemsCard(event) {
    let number = document.getElementById("card-ni-" + event.path[1].id + "");
    number.textContent = "" + (parseInt(number.textContent, 10) + 1);
}

function removeItemsCard(event) {
    let number = document.getElementById("card-ni-" + event.path[1].id + "");
    if (parseInt(number.textContent, 10) > 1) {
        number.textContent = "" + (parseInt(number.textContent, 10) - 1);
    }
}

function addItemsCarrito(event) {
    let value = document.getElementById("carrito-compras-valor").textContent.replace(",", "");
    let valuebef = parseFloat(value.substring(1, value.length));
    let valueNew = parseFloat((event.path[1].children[4].textContent).substring(1, event.path[1].children[4].textContent.length).replace(",", ""));
    valueNew = valueNew * event.path[1].children[7].textContent;
    let burbble = document.getElementById("carrito-burbble-text")
    burbble.textContent = parseInt(burbble.textContent, 10) + parseInt(event.path[1].children[7].textContent, 10);
    document.getElementById("carrito-compras-valor").textContent = `${numeral(valuebef + valueNew).format('$0,0')}`;
    document.getElementById("subtotal-value-carrito").textContent = `${numeral(valuebef + valueNew).format('$0,0')}`;
    document.getElementById("total-value-carrito").textContent = `${numeral(valuebef + valueNew).format('$0,0')}`;
    alert(`Se han agregado al carrito ${event.path[1].children[7].textContent} articulo(s).`, 'success')
}

