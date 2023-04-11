window.addEventListener("load", function () {
const formulario = document.querySelector("#add_new_paciente");

formulario.addEventListener("submit", function (event) {
    event.preventDefault();
    console.log(event);


    let nombre= document.querySelector("#nombre").value;
    let apellido=document.querySelector("#apellido").value;
    let fechaIngreso=document.querySelector("#fechaIngreso").value;
    let dni=document.querySelector("#dni").value;
    let calle=document.querySelector("#calle").value;
    let numero=document.querySelector("#numero").value;
    let localidad=document.querySelector("#localidad").value;
    let provincia=document.querySelector("#privincia").value;
    let email=document.querySelector("#email").value;

    let domicilio = {
        calle: calle,
        numero: numero,
        localidad: localidad,
        provincia: provincia,

    }

    let paciente = {
        nombre:nombre,
        apellido:apellido,
        dni:dni,
        fechaIngreso:fechaIngreso,
        domicilio:domicilio,
        email:email
    }

    //creamos un JSON que tendrá los datos de la nueva película

console.log(paciente);
postAPI(paciente)

});
});

function postAPI(paciente) {
const url = "/pacientes/add";
const settings = {
    method: "POST",
    headers: {
    "Content-Type": "application/json",
    },
    body: JSON.stringify(paciente),
};

fetch(url, settings)
    .then((response) => response.json())
    .then(() => {
    let successAlert =
        '<div class="alert alert-success ">' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        "<strong></strong> Paciente Registrado </div>";

    document.querySelector("#response").innerHTML = successAlert;
    document.querySelector("#response").style.display = "block";
    })
    .catch(() => alert("No se pudo registrar el Paciente"))
    .finally(() => {
    resetUploadForm();
    });

function resetUploadForm() {
document.querySelector("#nombre").value = "";
document.querySelector("#apellido").value= "";
document.querySelector("#fechaIngreso").value= "";
document.querySelector("#dni").value= "";
document.querySelector("#calle").value= "";
document.querySelector("#numero").value= "";
document.querySelector("#localidad").value= "";
document.querySelector("#privincia").value= "";
document.querySelector("#email").value= "";
}

}
