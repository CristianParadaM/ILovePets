let sectionDes = document.getElementById("section-destacados");
let sectionPerr = document.getElementById("section-perros");
let sectionGat = document.getElementById("section-gatos");
let sectionAv = document.getElementById("section-aves");
let sectionPec = document.getElementById("section-peces");

function chargeTransform() {
    for (let index = 0; index < sectionDes.children[1].children.length; index++) {
        if (sectionDes.children[1].children[index] != undefined) {
            sectionDes.children[1].children[index].style.transform = "perspective(2500px) rotateY(0)";
        }
        if (sectionGat.children[1].children[index] != undefined) {
            sectionGat.children[1].children[index].style.transform = "perspective(2500px) rotateY(0)";
        }
        if (sectionAv.children[1].children[index] != undefined) {
            sectionAv.children[1].children[index].style.transform = "perspective(2500px) rotateY(0)";
        }
        if (sectionPerr.children[1].children[index] != undefined) {
            sectionPerr.children[1].children[index].style.transform = "perspective(2500px) rotateY(0)";
        }
        if (sectionPec.children[1].children[index] != undefined) {
            sectionPec.children[1].children[index].style.transform = "perspective(2500px) rotateY(0)";
        }
    }
}

function filtre() {
    chargeTransform();
    let main = document.getElementById("content");
    let filtre = window.event.currentTarget.attributes[0].value;
    switch (filtre) {
        case "perros-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltroperro.png";
            main.innerHTML = sectionPerr.innerHTML;
            break;
        case "gatos-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltrogato.png";
            main.innerHTML = sectionGat.innerHTML;
            break;
        case "aves-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltroave.png";
            main.innerHTML = sectionAv.innerHTML;
            break;
        case "peces-filter":
            main.innerHTML = sectionPec.innerHTML;
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltropez.png";
            break;
        case "todos-filter":
            location.reload()
            break;
    }
}

const showDescription = (event) => {
    if (event.path[0].tagName != "BUTTON") {
        if (event.path[0].id == "") {
            showDescription(event.path[1].id);
        } else if (event.path[0].id != "" && event.path[0].id.length < 3) {
            showDescription(event.path[0].id);
        } else if (event.path[0].id != "") {
            showDescription(event.path[1].id);
        }
    }

    function showDescription(id) {
        let card = document.getElementById(id);
        if (card.children[card.children.length - 1].attributes[1].value == 'false') {
            for (let i = 0; i < card.children.length - 1; i++) {
                if (card.children[i].attributes.length > 1) {
                    card.children[i].attributes[1].value = 'false';
                } else {
                    card.children[i].attributes[0].value = 'false';
                }
            }
            card.children[card.children.length - 1].attributes[1].value = "true block";
        } else {
            card.children[0].attributes[1].value = 'true inline';
            card.children[1].attributes[1].value = 'true block';
            card.children[2].attributes[1].value = 'true block';
            card.children[3].attributes[1].value = 'true block';
            card.children[4].attributes[1].value = 'true block';
            card.children[5].attributes[1].value = 'true block';
            card.children[6].attributes[1].value = 'true inline';
            card.children[7].attributes[1].value = 'true inline';
            card.children[8].attributes[1].value = 'true inline';
            card.children[9].attributes[0].value = 'true inline';
            card.children[10].attributes[1].value = 'true inline';
            card.children[card.children.length - 1].attributes[1].value = "false";

        }
    }
}

document.getElementById("user-info").addEventListener("click", () => {
    document.getElementById("panel-carrito").attributes[1].value = "false";
    if (document.getElementById("panel-login").attributes[1].value == "false") {
        document.getElementById("panel-login").attributes[1].value = "true";
    } else {
        document.getElementById("panel-login").attributes[1].value = "false";
    }
});

document.getElementById("carrito-compras").addEventListener("click", () => {
    document.getElementById("panel-login").attributes[1].value = "false";
    if (document.getElementById("panel-carrito").attributes[1].value == "false") {
        document.getElementById("panel-carrito").attributes[1].value = "true";
        isCarritoOpen = true;
    } else {
        document.getElementById("panel-carrito").attributes[1].value = "false";
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

function alert(message, type) {
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
    alertPlaceholder.append(wrapper)
}

const alertPlaceholder = document.getElementById("liveAlertPlaceholder");

function addItemsCard(event) {
    let number = event.path[1].children[7];
    number.textContent = "" + (parseInt(number.textContent, 10) + 1);
}

function removeItemsCard(event) {
    let number = event.path[1].children[7];
    if (parseInt(number.textContent, 10) > 1) {
        number.textContent = "" + (parseInt(number.textContent, 10) - 1);
    }
}

function addItemsCarrito(event) {
    let value = document.getElementById("carrito-compras-valor").textContent.replace(",", "").replace(".", "");
    let valuebef = parseFloat(value.substring(1, value.length));
    let index = event.path[1].children[4].children.length-1;
    let valueNew = parseFloat((event.path[1].children[4].children[index].textContent).replace("$", "").replace(",", "").replace(".", ""));
    valueNew = valueNew * event.path[1].children[7].textContent;
    let burbble = document.getElementById("carrito-burbble-text");
    burbble.textContent = parseInt(burbble.textContent, 10) + parseInt(event.path[1].children[7].textContent, 10);
    document.getElementById("carrito-compras-valor").textContent = `${numeral(valuebef + valueNew).format('$0,0')}`;
    document.getElementById("subtotal-value-carrito").textContent = `${numeral(valuebef + valueNew).format('$0,0')}`;
    document.getElementById("total-value-carrito").textContent = `${numeral(valuebef + valueNew).format('$0,0')}`;
    document.getElementById("finish-purchase").attributes[1].value = "enabled";
    document.getElementById("container-carrito").attributes[1].value = "true block";
    document.getElementById("no-items-carrito").attributes[1].value = "false";

    if (isExist(event.path[1].attributes[3].value)) {
        let children = document.getElementById("center-carrito").children;
        for (let i = 0; i < children.length; i++) {
            if (children[i].attributes[0].value == "item-carrito-" + event.path[1].attributes[3].value) {
                let text = children[i].children[2];
                text.textContent = `x${parseInt(text.textContent.substring(1, text.textContent.length), 10) + parseInt(event.path[1].children[7].textContent, 10)}`;
                break;
            }
        }
    } else {
        document.getElementById("center-carrito").innerHTML += `
        <div id="item-carrito-${event.path[1].attributes[3].value}" class="row item-carrito">
            <div class="col">
                <img src="${event.path[1].children[0].attributes[3].value}" class="img-items-carrito">
            </div>
            <div class="col">
                <span class="row title-items-carrito">${event.path[1].children[5].textContent}</span>
                <span class="row price-items-carrito">${event.path[1].children[4].children[index].textContent}</span>
            </div>
                <span class="col nitems-carrito">x${event.path[1].children[7].textContent}</span>
                <button class="btn-items-del center" onClick="removeItemCarrito(event)">X</button>
            </div>
            <div id="separator-item-${event.path[1].attributes[3].value}" class="separator-gray"></div>
        </div>
        `;
    }

    alert(`Se han agregado al carrito ${event.path[1].children[7].textContent} articulo(s).`, 'success');

    function isExist(id) {
        let children = document.getElementById("center-carrito").children;
        for (let i = 0; i < children.length; i++) {
            if (children[i].attributes[0].value == "item-carrito-" + id) {
                return true;
            }
        }
        return false;
    }
}

function removeItemCarrito(event) {

    let nItems = event.path[1].children[2].textContent;
    nItems = nItems.substring(nItems.length - 1, nItems.length);
    let idItem = event.path[1].attributes[0].value;
    document.getElementById(`separator-item-${idItem.split("-")[2]}`).remove();
    event.path[1].remove();

    let burbble = document.getElementById("carrito-burbble-text");
    burbble.textContent = parseInt(burbble.textContent, 10) - parseInt(nItems, 10);

    let valueText = document.getElementById("carrito-compras-valor");
    let value = valueText.textContent.replace(",", "").replace(".", "").replace("$", "");

    let valueItemText = event.path[1].children[1].children[1].textContent;
    valueItemText = valueItemText.replace("$", "").replace(".", "").replace(",", "");
    valueItemText *= nItems

    valueText.textContent = `${numeral(parseInt(value, 10) - parseInt(valueItemText, 10)).format('$0,00')}`;

    let subtotalText = document.getElementById("subtotal-value-carrito");
    let subtotal = subtotalText.textContent.replace(",", "").replace(".", "").replace("$", "");

    let totalText = document.getElementById("total-value-carrito");
    let total = totalText.textContent.replace(",", "").replace("$", "").replace(".", "");

    subtotalText.textContent = `${numeral(parseInt(subtotal, 10) - parseInt(valueItemText, 10)).format('$0,00')}`;
    totalText.textContent = `${numeral(parseInt(total, 10) - parseInt(valueItemText, 10)).format('$0,00')}`;

    if (document.getElementById("center-carrito").children.length == 0) {
        document.getElementById("container-carrito").attributes[1].value = "false";
        document.getElementById("no-items-carrito").attributes[1].value = "true block";
    }
}

function showAllProducts(typeProduct) {
    fetch("/request?value=" + typeProduct)
        .then(response => response.text())
        .then(respuesta => {

            let allProducts = JSON.parse(respuesta)
            let main = document.getElementById("content");
            let count = 0;
            let level = 2;
            console.log(allProducts.length);

            for (let i = 0; i < allProducts.length; i++, count++) {
                if (i == 0) {
                    main.innerHTML = `<div class="row">
                    <button class="back-todos col-md-1" onClick="location.reload()" type="${typeProduct}">Volver atrás</button>
                    <span class="col-md-9 center title">Todos los productos de ${typeProduct}</span>
                    </div>
                    `;
                    main.innerHTML += `<div class="separator"></div>`;
                    main.innerHTML += `<div class="group-cards row">`;
                }
                if (count > 5) {
                    level++;
                    count = 0;
                    main.innerHTML += `<div class="group-cards row">`;
                }
                    main.children[level].innerHTML += `
                    <div class="card-item col-md-5" data-aos="flip-left"
                    type="${allProducts[i]["typePet"]}" id="${allProducts[i]["idProduct"]}"
                    onclick="showDescription(event)">
                    <img width="60%" isVisible="true inline" height="38%" src="${allProducts[i].urlimg}" alt="">
                    <div class="separator" isVisible="true block"></div>
                    <span class="card-tittle" isVisible="true block">${allProducts[i]['mark']}</span>
                    <span class="card-description" isVisible="true block">${allProducts[i].weigth}</span>
                    <span class="card-price" isVisible="true block">${'$' + allProducts[i].price}</span>
                    <span class="card-nameitem" isVisible="true block">${allProducts[i].name}</span>
                    <button class="card-btn-less" isVisible="true inline" type="button"
                        onclick="removeItemsCard(event)">-</button>
                    <span class="card-nitems" isVisible="true inline" id="${'card-ni-' + allProducts[i].idProduct}">1</span>
                    <button class="card-btn-max" isVisible="true inline" type="button"
                        onclick="addItemsCard(event)">+</button>
                    <br isVisible="true inline">
                    <button class="card-btn-add" isVisible="true inline" type="button"
                        onclick="addItemsCarrito(event)">Agregar</button>
                    <p class="description-card" isVisible="false">${allProducts[i].description}</p>
                    </div>
                    `;
            

            }

        });
}
