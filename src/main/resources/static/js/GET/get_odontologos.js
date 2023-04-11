window.addEventListener("load", function () {
  (function () {
    const url = "/odontologos";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
    .then(response => {
      if (response.status === 403) {
        alert("No puede ingresar aqui con ese usuario")
      } else {
        return response.json();
      }})
      .then((data) => {
        for (odontologoList of data) {
          let containerIterador = document.getElementById("containerMM");
          console.log("Estoy dentro");
          console.log(data);
          containerIterador.innerHTML +=
            '<div  id="odonto' +
            odontologoList.id +
            '" class="odonto_card gap-3 " ' +
            ' <div class="card-body text-center border border-secondary  ">' +
            '<h5 class="card-title"> ' + odontologoList.nombre +"  " + odontologoList.apellido + " </h5> " +
            '<p style="font-weight: bold;">Matricula: ' + odontologoList.numero_matricula +  '</p>' + 
            '<span><button  type="button" data-bs-toggle="modal" data-bs-target="#OdontoModal" onclick="update_by('+ odontologoList.id +')" class="btn btn-primary">Modificar</button>' +
            '<button type="button" onclick="deleteBy(' + odontologoList.id + ')" class="btn btn-danger btn_delete">Eliminar</button> </span> </div> </div>';
        }
      });
  })(function () {
    let pathname = window.location.pathname;
    if (pathname == "/ListarOdontologos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  });
});

