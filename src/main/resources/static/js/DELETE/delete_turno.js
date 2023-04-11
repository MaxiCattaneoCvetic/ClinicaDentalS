function delete_turno_by(id)
{

    let confirmacion = confirm("¿Estas seguro que quieres eliminar el turno?")
    if(confirmacion){
        eliminadorDeTurno(id)
    }else{
        console.log("No se pudo eliminar por falta de cofirmacion");
    }

        

}

function eliminadorDeTurno(id){

    const url = 'turnos/'+ id;
    const settings = {
        method: 'DELETE'
    }
    fetch(url,settings)
    .then(response => response.json())

    location.reload();
    let row_id = "#turno" + id;
    document.querySelector(row_id).remove();

}