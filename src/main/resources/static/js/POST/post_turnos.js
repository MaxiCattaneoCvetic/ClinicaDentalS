window.addEventListener("load", function () {
    getApi()
    getApiOdonto()
    const formulario = document.querySelector("#sacar_turno");
    

    formulario.addEventListener("submit", function (event) {
        event.preventDefault();

    
        let fechaTurno = document.querySelector("#fechaTurno").value;
        let horaTurno = document.querySelector("#horaTurno").value;
        let pacienteID = document.querySelector("#pacientes").value;
        let odontologoID = document.querySelector("#odontologo").value;

    let paciente = {
        id:pacienteID
    }

    let odontologo = {
        id:odontologoID
    }

        let turnoData = {
            paciente: paciente,
            odontologo: odontologo,
            fechaTurno: fechaTurno,
            horaTurno: horaTurno,
        }
    
        postAPI(turnoData)
    
    });
});




function postAPI(turnoData) {
    function loader(){
    console.log("llamaste a load");
    return location.reload();

    }

    const url = "/turnos";
    const settings = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(turnoData),
    };
    
    fetch(url, settings)
        .then((response) => response.json())
        .then(() => {
            Swal.fire({
                title: 'Gestor de turnos..',
                text: '¡Excelente, ya tenes tu turno!',
                icon: 'success',
                confirmButtonText: '¡Adios!'
            })

            
        })
        .catch(() => alert("No se pudo cargar el turno "))
        .finally(() => {
            setTimeout(loader,1500)
            
        });
}


function getApi(){
    const url = "/pacientes/";
    const settings = {
        method: "GET",
    };

    fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            const select = document.querySelector("#pacientes");
            select.innerHTML = "<option value='' disabled selected>Seleccione un paciente</option>";
            for (let paciente of data) {
                const option = document.createElement("option");
                option.value = paciente.id;
                option.textContent = paciente.nombre;
                select.appendChild(option);
            }
        })
        .catch(() => alert("No se pudo obtener la lista de pacientes"));
}

function getApiOdonto(){
    const url = "/odontologos";
    const settings = {
        method: "GET",
    };

    fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
        const select = document.querySelector("#odontologo");
        select.innerHTML = "<option value='' disabled selected>Seleccione un odontologo</option>";
        for (let odontologo of data) {
            const option = document.createElement("option");
            option.value = odontologo.id;
            option.textContent = odontologo.nombre;
            select.appendChild(option);
        }
    })
    .catch(() => alert("No se pudo obtener la lista de odontólogos"));
}






