window.addEventListener("load", function () {
(function () {
    const url = "/pacientes/";
    const settings = {
    method: "GET",
    };

    fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
        for (pacienteList of data) {
        let containerIterador = document.getElementById("containerMM");
        console.log("Estoy dentro");
        console.log(data);
        containerIterador.innerHTML +=
            '<div  id="odonto' +
            pacienteList.id +
            '" class="odonto_card gap-3 " ' +
            ' <div class="card-body text-center border border-secondary  ">' +
            '<h5 class="card-title"> ' +
            pacienteList.nombre +
            "  " +
            pacienteList.apellido +
            " </h5> " +
            '<p style="font-weight: bold;">Correo Electronico: ' +
            pacienteList.email +
            "</p>" +
            '<span><button  type="button" data-bs-toggle="modal" data-bs-target="#pacienteModal" onclick="update_Paciente_by(' +
            pacienteList.id +
            ')" class="btn btn-primary">Modificar</button>' +
            '<button type="button" onclick="deletePacienteBy(' +
            pacienteList.id +
            ')" class="btn btn-danger btn_delete">Eliminar</button> </span> </div> </div>';
        }
    });
})(function () {
    let pathname = window.location.pathname;
    if (pathname == "/ListarOdontologos.html") {
    document.querySelector(".nav .nav-item a:last").addClass("active");
    }
});
});



function update_Paciente_by(id) {
    console.log("TOcaste el boton ");
    console.log(pacienteList);
    document.querySelector("#nombre").value = pacienteList.nombre;
    document.querySelector("#apellido").value = pacienteList.apellido;
    document.querySelector("#dni").value = pacienteList.dni;
    document.querySelector("#fechaIngreso").value = pacienteList.fechaIngreso;
    document.querySelector("#calle").value = pacienteList.domicilio.calle;
    document.querySelector("#numero").value = pacienteList.domicilio.numero;
    document.querySelector("#localidad").value = pacienteList.domicilio.localidad;
    document.querySelector("#privincia").value = pacienteList.domicilio.provincia;
    document.querySelector("#email").value = pacienteList.email;
    
    const formulario = document.querySelector("#update_paciente");
    formulario.addEventListener("submit", function (event) {
    event.preventDefault();
    console.log("Estoy en modificar  fech");
    let nombre = document.querySelector("#nombre").value
    let apellido = document.querySelector("#apellido").value;
    let fechaIngreso = document.querySelector("#fechaIngreso").value;
    let dni = document.querySelector("#dni").value;
    let calle = document.querySelector("#calle").value;
    let numero = document.querySelector("#numero").value;
    let localidad = document.querySelector("#localidad").value;
    let provincia = document.querySelector("#privincia").value;
    let email = document.querySelector("#email").value;

    let domicilio = {
        calle: calle,
        numero: numero,
        localidad: localidad,
        provincia: provincia,
    };

    let paciente = {
        id: id,
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        fechaIngreso: fechaIngreso,
        domicilio: domicilio,
        email: email,
    };

    console.log(paciente);
    llamarApi(paciente);
    });

    function llamarApi(paciente) {
    console.log("LLAME A LA API");
    const url = "/pacientes/update";
    const settings = {
        method: "PUT",
        headers: {
        "Content-Type": "application/json",
        },
        body: JSON.stringify(paciente),
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
        location.reload();
        });
    }

    function resetUploadForm() {
    document.querySelector("#nombre").value = "";
    document.querySelector("#apellido").value = "";
    document.querySelector("#fechaIngreso").value = "";
    document.querySelector("#dni").value = "";
    document.querySelector("#calle").value = "";
    document.querySelector("#numero").value = "";
    document.querySelector("#localidad").value = "";
    document.querySelector("#privincia").value = "";
    document.querySelector("#email").value = "";
    }
}