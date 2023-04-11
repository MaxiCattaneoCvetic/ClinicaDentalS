package com.example.ClinicaDentalS.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String userName;
    @Column(unique = true)
    private String email;
    @Column
    private String password;

    //hacemos los roles
    @Column
    private UsuarioRole usuariRole;

    public Usuario(String nombre, String userName, String email, String password, UsuarioRole usuariRole) {
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.usuariRole = usuariRole;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //Aca se manejan los permisos
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(usuariRole.name());
        //este metodo retorna la coleccion
        return Collections.singletonList(simpleGrantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRole getUsuariRole() {
        return usuariRole;
    }

    public void setUsuariRole(UsuarioRole usuariRole) {
        this.usuariRole = usuariRole;
    }
}
