package com.example.ClinicaDentalS.Service;

import com.example.ClinicaDentalS.Entity.Usuario;
import com.example.ClinicaDentalS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    //este metodo carga un user a travez de un userName
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //el user puede o no estar, lo vamos a buscar
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByEmail(username);

        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else {
            throw  new UsernameNotFoundException("No existe el usuario con ese correo electronico");

        }

    }
}
