document.getElementById("user-info").addEventListener("click", () => { location.href = "/catalog" });
document.getElementById("addp").addEventListener("click", (event) => {
    document.getElementById("black-curtain").attributes[1].value = "true";
    document.getElementById("add-product-panel").attributes[1].value = "true";
});
document.getElementById("modp").addEventListener("click", (event) => {
    document.getElementById("black-curtain").attributes[1].value = "true";
    document.getElementById("search-panel").attributes[1].value = "true";
    document.getElementById("search-title").textContent = "Modificar Productos"
});
document.getElementById("remp").addEventListener("click", (event) => {
    document.getElementById("black-curtain").attributes[1].value = "true";
    document.getElementById("search-panel").attributes[1].value = "true";
    document.getElementById("search-title").textContent = "Remover Productos"
});

function cancelButton(event) {
    if(event.path[2].attributes[0].value == "search-panel"){
        event.path[2].attributes[1].value = "false";
    }else if( event.path[3].attributes[0].value == "search-panel"){
        event.path[3].attributes[1].value = "false";
    }else{
        event.path[6].attributes[1].value = 'false';
    }
    document.getElementById('black-curtain').attributes[1].value = 'false';
    document.getElementById("error-search").attributes[2].value = "false";
    document.getElementById("content-search").attributes[3].value = "false";
}

for (let i = 0; i < document.getElementsByClassName("mascota-filter-btn").length; i++) {
    document.getElementsByClassName("mascota-filter-btn").item(i).addEventListener("click", (event) => {
        switch (event.path[1].attributes[0].value) {
            case "cbperritos":
                document.getElementById("mascota-filter-btn").src = "resource/btnfiltroperro.png";
                document.getElementById("input-typepet").value = "Perro"
                document.getElementById("input-typepet").text = "Perro"
                break;
            case "cbgatitos":
                document.getElementById("mascota-filter-btn").src = "resource/btnfiltrogato.png";
                document.getElementById("input-typepet").value = "Gato"
                break;
            case "cbpececitos":
                document.getElementById("mascota-filter-btn").src = "resource/btnfiltropez.png";
                document.getElementById("input-typepet").value = "Pez"
                break;
            case "cbpajaritos":
                document.getElementById("mascota-filter-btn").src = "resource/btnfiltroave.png";
                document.getElementById("input-typepet").value = "Ave"
                break;
        }
    });
}

let inputFile = document.getElementById("input-file-add");

inputFile.addEventListener("change", (event) => {
    if(event.path[0].files.length > 0){
        document.getElementById("img-add").src = URL.createObjectURL(event.path[0].files[0]);
    }
});

function searchId(){
    let id = document.getElementById("input-id").value;
    if (id.length > 0) {
        fetch("/request?value="+id)
            .then(response => response.text())
            .then(respuesta => {
            
                if(respuesta.length == 0){
                    document.getElementById("error-search").attributes[2].value = "true block";
                    document.getElementById("content-search").attributes[3].value = "false";
                }else{
                    document.getElementById("error-search").attributes[2].value = "false";
                    document.getElementById("content-search").attributes[3].value = "true block";
                    let product = JSON.parse(respuesta);
                    document.getElementById("input-name-search").value = product["name"];
                    document.getElementById("input-mark-search").value = product["mark"];
                    document.getElementById("input-typepet-search").value = product["typePet"];
                    document.getElementById("search-desc-id").value = product["description"];
                    document.getElementById("search-price-id").value = product["price"];
                    document.getElementById("search-quanty-id").value = product["quantyStock"];

                }
    
            });
    }else{
        alert("rellene el campo")
    }
}