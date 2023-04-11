window.addEventListener("load", function () {
console.log("estoy en el addeventlistener");

apiCall();
});

function apiCall() {
const url = "/turnos/";
const settings = {
    method: "GET",
};

fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
    for (turnosList of data) {
        console.log("Entre al data");
        let turnosGET = document.getElementById("box-turnos");
        turnosGET.innerHTML +=
        '<div  id="turno' +
        turnosList.id +
        '" class="odonto_card gap-3 " ' +
        ' <div class="card-body text-center border border-secondary  ">' +
        '<h5 class="card-title"> ' +
        turnosList.paciente.nombre +
        "  " +
        turnosList.paciente.apellido +
        " </h5> " +
        '<p style="font-weight: bold;">Fecha del turno: ' +
        turnosList.fechaTurno +
        "</p>" +
        '<p style="font-weight: bold;">Hora del turno: ' +
        turnosList.horaTurno +
        "</p>" +
        '<p style="font-weight: bold;">Odontologo asignado: ' +
        turnosList.odontologo.nombre +
        "</p>" +
        '<span><button  type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#turno_modal_update" onclick="update_turno_by(' +
        turnosList.id +
        ')">Modificar Turno</button><button type="button" class="btn btn-danger btn_delete" onclick="delete_turno_by(' +
        turnosList.id +
        ')">Eliminar Turno</button></span> </div> </div>';
    
    }})
    .catch(() => alert("No se pudo crear el turno"));
}

// for(turnosList of data){
//     let turnosGET = document.getElementById("turnosGET");
//     turnosGET.innerHTML += '<tr>' +
//     '<th scope="row" id="turno'+turnosList.id+'"><i class="fa-solid fa-person fa-beat-fade"></i>'+ turnosList.id + '</th>' +
//     '<td>' +turnosList.paciente.nombre + '</td>'+
//     '<td>' +turnosList.odontologo.nombre + '</td>'+
//     '<td>' +turnosList.fechaTurno+ '</td>'+
//     '<td> '+turnosList.horaTurno+ '<span><button  type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#turno_modal_update" onclick="update_turno_by('+turnosList.id+')">Modificar Turno</button><button type="button" class="btn btn-danger btn_delete" onclick="delete_turno_by('+ turnosList.id+')">Eliminar Turno</button></span></td> </tr>';
//     console.log(turnosGET);
//     console.log(data);
//     console.log(turnosList);
// }
