const productsAll = [];
const productsDogs = [];
const productsCats = [];
const productsBirds = [];
const productsFishes = [];

function load() {
    for (let i = 0; i < document.getElementsByClassName("card-item").length; i++) {
        let card = document.getElementsByClassName("card-item").item(i);
        productsAll.push(card);
        switch (card.attributes.type.value) {
            case "perro":
                productsDogs.push(card);
                break;
            case "ave":
                productsBirds.push(card);
                break;
            case "gato":
                productsCats.push(card);
                break;
            case "pez":
                productsFishes.push(card);
                break;
        }
    }
}

function filtreSearch(event) {
    
    switch (event.path[1].attributes.id.value) {
        case "perros-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltroperro.png";
            filtre(productsDogs);
            break;
        case "gatos-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltrogato.png";
            filtre(productsCats);
            break;
        case "peces-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltropez.png";
            filtre(productsFishes);
            break;
        case "aves-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltroave.png";
            filtre(productsBirds);
            break;
        case "todos-filter":
            document.getElementById("mascota-filter-btn").src = "resource/btnfiltromascotas.png";
            filtre(productsAll);
            break;
    }

    function filtre(list) {
        let main = document.getElementById("content");
        let title = document.getElementById("title");
        console.log(list.length);
        main.innerHTML = nodeToString(title);
        main.innerHTML += `<div class="group-cards row"></div>`;
        for (let i = 0; i < list.length; i++) {
            main.children[1].innerHTML += nodeToString(list[i]);
        }
    }
}

function nodeToString ( node ) {
    var tmpNode = document.createElement( "div" );
    tmpNode.appendChild( node.cloneNode( true ) );
    var str = tmpNode.innerHTML;
    tmpNode = node = null;
    return str;
 }