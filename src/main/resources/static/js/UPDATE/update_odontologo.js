
function update_by(id){


  const formulario = document.querySelector("#update_odontologo");
  formulario.addEventListener("submit", function (event) {
    event.preventDefault()


    const formData = {
      id: id,
      numero_matricula: document.querySelector("#numero_matricula").value,
      nombre: document.querySelector("#nombre").value,
      apellido: document.querySelector("#apellido").value,
    };


    while(isNaN(formData.numero_matricula)){
      alert("Por favor introduci un numero de matricula valido, recuerda que solo se permiten numeros")
      break;
    }
    if(!isNaN(formData.numero_matricula)){
      llamarApi(formData);
    }





});


function llamarApi (formData){
  const url = "/odontologos";
  const settings = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  };

  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      
      console.log("soy la data " + data);
    })
    .catch(() => {
      console.log("no se puede modificar");

    })

    .finally(() => {
      console.log("Llegue al finaly");
      resetUploadForm()
      location.reload()
      
    });

};

function resetUploadForm() {
  document.querySelector("#numero_matricula").value = "";
  document.querySelector("#nombre").value = "";
  document.querySelector("#apellido").value = "";
}

}

