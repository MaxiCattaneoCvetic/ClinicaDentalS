function deletePacienteBy(id)
{

    let confirmacion = confirm("¿Estas seguro que quieres eliminar el paciente?")
    if(confirmacion){
        eliminadorDeTurno(id)
    }else{
        console.log("No se pudo eliminar por falta de cofirmacion");
    }

        

}

function eliminadorDeTurno(id){

    const url = 'pacientes/'+ id;
    const settings = {
        method: 'DELETE'
    }
    fetch(url,settings)
    .then(response => response.json())

    location.reload();
    let row_id = "#odonto" + id;
    document.querySelector(row_id).remove();

}