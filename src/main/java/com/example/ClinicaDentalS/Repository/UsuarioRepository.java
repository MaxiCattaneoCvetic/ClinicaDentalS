package com.example.ClinicaDentalS.Repository;

import com.example.ClinicaDentalS.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    //definimos
    Optional<Usuario> findByEmail(String email);


}
