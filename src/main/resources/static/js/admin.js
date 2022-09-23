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
    console.log(event)
    if(event.path[2].attributes[0].value == "search-panel"){
        event.path[2].attributes[1].value = "false";
    }else if( event.path[3].attributes[0].value == "search-panel"){
        event.path[3].attributes[1].value = "false";
    }else{
        event.path[6].attributes[1].value = 'false';
    }
    document.getElementById('black-curtain').attributes[1].value = 'false';
}

for (let i = 0; i < document.getElementsByClassName("mascota-filter-btn").length; i++) {
    document.getElementsByClassName("mascota-filter-btn").item(i).addEventListener("click", (event) => {
        switch (event.path[1].attributes[0].value) {
            case "cbperritos":
                document.getElementById("mascota-filter-btn").src = "resource/btnfiltroperro.png";
                document.getElementById("input-typepet").value = "Perro"
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

    // fetch("http://localhost:8080/admin/guardar?img="+URL.createObjectURL(event.path[0].files[0]));
    // .then(response => response.text())
    // .then(respuesta =>{

    // })
});