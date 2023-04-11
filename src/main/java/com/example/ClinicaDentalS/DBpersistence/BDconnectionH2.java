package com.example.ClinicaDentalS.DBpersistence;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDconnectionH2 {
    private static final String SQL_CREATE_TABLE_PACIENTE = "DROP TABLE IF EXISTS PACIENTES;" +
            "CREATE TABLE PACIENTES(ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "DNI INT NOT NULL," +
            "FECHA_INGRESO DATE NOT NULL," +
            "DOMICILIO_ID INT NOT NULL," +
            "EMAIL VARCHAR(200) NOT NULL," +
            "ODONTOLOGO_ID INT NOT NULL)";

    private static final String SQL_DROP_CREATE_DOMICILO = "DROP TABLE IF EXISTS DOMICILIO;" +
            "CREATE TABLE DOMICILIO (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
            "CALLE VARCHAR(100) NOT NULL," +
            "NUMERO INT NOT NULL," +
            "LOCALIDAD VARCHAR(100) NOT NULL," +
            "PROVINCIA VARCHAR(100) NOT NULL)";

    private static final String SQL_DROP_CREATE_ODONTOLOGOS= "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
            "NUMERO_MATRICULA INT NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL)";

    private static final String SQL_DROP_CREATE_TURNOS= "DROP TABLE IF EXISTS TURNOS;" +
            "CREATE TABLE TURNOS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
            "PACIENTE_ID INT NOT NULL," +
            "ODONTOLOGO_ID INT NOT NULL," +
            "FECHA_TURNO DATE NOT NULL," +
            "HORA_TURNO TIME NOT NULL)";

    private static final String SQL_URL = "jdbc:h2:~/ClinicaDental";
    private static final String SQL_USER = "sa";
    private static final String SQL_PW = "";


    public static void crearTablas(){
        Logger logger = Logger.getLogger(BDconnectionH2.class);
        logger.info("Creando tablas");
        Connection connection=null;

        try {
            connection=getConnection();
            Statement stmt =connection.createStatement();
            stmt.execute(SQL_CREATE_TABLE_PACIENTE);
            stmt.execute(SQL_DROP_CREATE_DOMICILO);
            stmt.execute(SQL_DROP_CREATE_ODONTOLOGOS);
            stmt.execute(SQL_DROP_CREATE_TURNOS);
            logger.info("Tablas creadas con exito");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("Error en la creacion de tablas");

        }
        finally {
           try {
               connection.close();

           }catch (Exception e ){
               e.printStackTrace();
           }
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(SQL_URL,SQL_USER,SQL_PW);


    }




}
