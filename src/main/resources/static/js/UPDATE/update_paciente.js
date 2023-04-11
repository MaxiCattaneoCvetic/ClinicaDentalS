// function update_Paciente_by(id) {
//   const formulario = document.querySelector("#update_paciente");
//   formulario.addEventListener("submit", function (event) {
//     event.preventDefault();
//     console.log("Estoy en modificar  fech");
    
//     let nombre = document.querySelector("#nombre").value;
//     let apellido = document.querySelector("#apellido").value;
//     let fechaIngreso = document.querySelector("#fechaIngreso").value;
//     let dni = document.querySelector("#dni").value;
//     let calle = document.querySelector("#calle").value;
//     let numero = document.querySelector("#numero").value;
//     let localidad = document.querySelector("#localidad").value;
//     let provincia = document.querySelector("#privincia").value;
//     let email = document.querySelector("#email").value;

//     let domicilio = {
//       calle: calle,
//       numero: numero,
//       localidad: localidad,
//       provincia: provincia,
//     };

//     let paciente = {
//       id:id,
//       nombre: nombre,
//       apellido: apellido,
//       dni: dni,
//       fechaIngreso: fechaIngreso,
//       domicilio: domicilio,
//       email: email,
//     };

//     console.log(paciente)
//     llamarApi(paciente);
//   });

//   function llamarApi(paciente) {
//     console.log("LLAME A LA API");
//     const url = "/pacientes/update";
//     const settings = {
//       method: "PUT",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify(paciente),
//     };

//     fetch(url, settings)
//       .then((response) => response.json())
//       .then((data) => {
//         console.log("soy la data " + data);
//       })
//       .catch(() => {
//         console.log("no se puede modificar");
//       })

//       .finally(() => {
//         console.log("Llegue al finaly");
//         location.reload();
//       });
//   }

//   function resetUploadForm() {
//     document.querySelector("#nombre").value = "";
//     document.querySelector("#apellido").value = "";
//     document.querySelector("#fechaIngreso").value = "";
//     document.querySelector("#dni").value = "";
//     document.querySelector("#calle").value = "";
//     document.querySelector("#numero").value = "";
//     document.querySelector("#localidad").value = "";
//     document.querySelector("#privincia").value = "";
//     document.querySelector("#email").value = "";
//   }
// }
