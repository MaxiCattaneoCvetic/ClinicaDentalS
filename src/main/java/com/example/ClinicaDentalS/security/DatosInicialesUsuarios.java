package com.example.ClinicaDentalS.security;

import com.example.ClinicaDentalS.Entity.Usuario;
import com.example.ClinicaDentalS.Entity.UsuarioRole;
import com.example.ClinicaDentalS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component //aca hardcodeo el usuario
public class DatosInicialesUsuarios  implements ApplicationRunner {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // aca cremos el user & pass
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();

        //admin
        String passwordSinCifrar = "admin";
        String passwordCifrado = cifrador.encode(passwordSinCifrar);
        Usuario usuarioADM = new Usuario("admin","admina","admin",passwordCifrado, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuarioADM);

        //user
        String passwordSinCifraruSER = "maxi";
        String passwordCifradouSER = cifrador.encode(passwordSinCifraruSER);
        Usuario usuarioUS = new Usuario("maxi","maxic","maxi",passwordCifradouSER, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuarioUS);


    }
}
