# odontoMax

Bienvenidos al proyecto integrador de Backend que he desarrollado.

# Requerimientos del proyecto
Sistema de reserva de turnos
Se desea implementar un sistema que permita administrar la reserva de turnos para una clínica odontológica. Este debe cumplir con los siguientes requerimientos:
Administración de datos de odontólogos: listar, agregar, modificar y eliminar odontólogos. Registrar apellido, nombre y matrícula de los mismos.

Administración de datos de los pacientes: listar, agregar, modificar y eliminar pacientes. De cada uno se almacenan: nombre, apellido, domicilio, DNI y fecha de alta.

Registrar turno: se tiene que poder permitir asignar a un paciente un turno con un odontólogo a una determinada fecha y hora.

Login: validar el ingreso al sistema mediante un login con usuario y password. Se debe permitir a cualquier usuario logueado (ROLE_USER) registrar un turno, pero solo a quienes tengan un rol de administración (ROLE_ADMIN) poder gestionar odontólogos y pacientes. Un usuario podrá tener un único rol y los mismos se ingresarán directamente en la base de datos.

Requerimientos técnicos
La aplicación debe ser desarrollada en capas:

Capa de entidades de negocio: son las clases Java de nuestro negocio modelado a través del paradigma orientado a objetos.

Capa de acceso a datos (Repository): son las clases que se encargarán de acceder a la base de datos.

Capa de datos (base de datos): es la base de datos de nuestro sistema modelado a través de un modelo entidad-relación. Utilizaremos la base H2 por su practicidad.

Capa de negocio: son las clases service que se encargan de desacoplar el acceso a datos de la vista.

Capa de presentación: son las pantallas web que tendremos que desarrollar utilizando el framework de Spring Boot MVC con los controladores y alguna de estas dos opciones: HTML+JavaScript o React para la vista.

Es importante realizar el manejo de excepciones logueando cualquier excepción que se pueda generar y la realización de test unitarios para garantizar la calidad de los desarrollos.

# Informacion

El objetivo de este proyecto es satisfacer las necesidades de una clínica odontológica mediante el registro de odontólogos y pacientes, así como la gestión de turnos. Cabe destacar que el proyecto cuenta con dos tipos de usuario, administrador y cliente, que se autentican mediante Spring Security.

Este proyecto ha sido desarrollado utilizando Spring Boot, lo que nos ha permitido aprovechar dependencias como H2 para la base de datos, Spring Starter Web para el desarrollo de aplicaciones web y Log4j para la integración de loggers. Además, se han llevado a cabo testeos unitarios y testeos por integración para garantizar el correcto funcionamiento del proyecto.



