
function update_turno_by(id) {
    console.log("Llamaste funcion de actualizar");
    console.log(id);

    const formulario = document.querySelector("#update_turno");
    getApiU()
    getApiOdontoU()
    formulario.addEventListener("submit", function (event) {
    event.preventDefault();
    console.log("formulario" + formulario);
    console.log("Estoy en modificar  fech");
    
    let fechaTurno = document.querySelector("#fechaTurno_update").value;
    let horaTurno = document.querySelector("#horaTurno_update").value;
    let pacienteID = document.querySelector("#paciente_update").value;
    let odontologoID = document.querySelector("#odontologo_update").value;



let paciente = {
    id:pacienteID
}

let odontologo ={
    id:odontologoID

}

console.log("--------data----------");
console.log(fechaTurno);
console.log(horaTurno);
console.log(paciente);
console.log(odontologo);
console.log("---fin data---");

    let turnoData = {
        id:id,
        paciente: paciente,
        odontologo: odontologo,
        fechaTurno: fechaTurno,
        horaTurno: horaTurno,
    }

    llamarApi(turnoData)
    });


}

function llamarApi(turnoData) {
    function loaderU(){
        console.log("llamaste a load");
        return location.reload();
    
        }
    console.log("LLAME A LA API");
    const url = "/turnos";
    const settings = {
        method: "PUT",
        headers: {
        "Content-Type": "application/json",
        },
        body: JSON.stringify(turnoData),
    };

    fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            Swal.fire({
                title: 'Modificación Realizada..',
                text: '¡El turno fue modificado con exito!',
                icon: 'success',
                confirmButtonText: '¡Adios!'
            })
        
        })
        .catch(() => {
        console.log("no se puede modificar");
        })

        .finally(() => {
        console.log("Llegue al finaly");
        setTimeout(loaderU,1500)
        });
    }


    function getApiU(){
        const url = "/pacientes/";
        const settings = {
            method: "GET",
        };
    
        fetch(url, settings)
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                const select = document.querySelector("#paciente_update");
                select.innerHTML = "<option value='' disabled selected>Seleccione un paciente</option>";
                for (let paciente of data) {
                    const optionu = document.createElement("option");
                    optionu.value = paciente.id;
                    optionu.textContent = paciente.nombre;
                    select.appendChild(optionu);
                }
            })
            .catch(() => alert("No se pudo obtener la lista de pacientes"));
    }

    function getApiOdontoU(){
        const url = "/odontologos";
        const settings = {
            method: "GET",
        };
    
        fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            const select = document.querySelector("#odontologo_update");
            select.innerHTML = "<option value='' disabled selected>Seleccione un odontologo</option>";
            for (let odontologo of data) {
                const optionUO = document.createElement("option");
                optionUO.value = odontologo.id;
                optionUO.textContent = odontologo.nombre;
                select.appendChild(optionUO);
            }
        })
        .catch(() => alert("No se pudo obtener la lista de odontólogos"));
    }