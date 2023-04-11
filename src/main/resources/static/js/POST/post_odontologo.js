window.addEventListener("load", function () {
  
  athenticator()
  const formulario = document.querySelector("#add_new_odontologo");


  formulario.addEventListener("submit", function (event) {
    event.preventDefault()
    console.log(event)

    //creamos un JSON que tendrá los datos de la nueva película
    const formData = {
      numero_matricula: document.querySelector("#numero_matricula").value,
      nombre: document.querySelector("#nombre").value,
      apellido: document.querySelector("#apellido").value,
    }


    while(isNaN(formData.numero_matricula)){
      alert("Por favor introduci un numero de matricula valido, recuerda que solo se permiten numeros")
      break;
    }
    if(!isNaN(formData.numero_matricula)){
      postAPI(formData);
    }


  })});






function postAPI (formData){


  const url = "/odontologos";
  const settings = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  };

  fetch(url, settings)
    .then((response) => response.json())
    .then(() => {
      let successAlert =
        '<div class="alert alert-success ">' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        "<strong></strong> Odontologo Creado </div>";

      document.querySelector("#response").innerHTML = successAlert;
      document.querySelector("#response").style.display = "block";
    })
    .catch(() => alert("No se pudo crear el odontólogo"))
    .finally(() => {
            resetUploadForm()
    });

  function resetUploadForm() {
    document.querySelector("#numero_matricula").value = "";
    document.querySelector("#nombre").value = "";
    document.querySelector("#apellido").value = "";
  }
}


function athenticator(){
  console.log("la llame");
  const url = "/odontologos";
  const settings = {
  method: "GET",
  };

  console.log("estoy en el fetch");
  

  fetch(url, settings)
    .then(response => {
      console.log(response.status);
      if (response.status === 403) {
        alert("No puede ingresar aqui con ese usuario")
      } else {
        return response.json();
      }})
      .then((data) => {
        console.log(data);
      });
    

}

