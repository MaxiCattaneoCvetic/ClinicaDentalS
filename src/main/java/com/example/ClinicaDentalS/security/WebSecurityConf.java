package com.example.ClinicaDentalS.security;


import com.example.ClinicaDentalS.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


 //esta clase debe extendender de la websecurity
 @Configuration
 @EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    //necesita al userService y al passwordEncode, para qie sepa de donde usar el user + clave
    @Autowired
    private UsuarioService usuarioService;
     @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .csrf().disable() //cuando vengan solicitudes http de manera cruzada las desactivo, aca le decimos que por ahora solo se comunique con el login
                .authorizeRequests()
                    .antMatchers("/index.html").permitAll()
                    .antMatchers("/ListarOdontologos.html").permitAll()
                    .antMatchers("/listarPacientes.html").permitAll()
                    .antMatchers("/turnos.html").permitAll()
                    .antMatchers("/AltaOdontologo.html").hasRole("ADMIN")
                    .antMatchers("/AltaPaciente.html").hasRole("ADMIN")
                                   .anyRequest()
                                           .authenticated()
                                                    .and()
                                                            .formLogin()
                                                                    .and()
                                                                            .logout();


    }
}

//     csrf().disable(): desactiva la protección CSRF (Cross-Site Request Forgery) para permitir solicitudes HTTP de otras páginas web sin necesidad de proporcionar un token CSRF válido. Sin embargo, es importante tener en cuenta que desactivar CSRF puede hacer que la aplicación sea vulnerable a ataques malintencionados.
//
//        authorizeRequests(): establece una política de autorización para las solicitudes HTTP.
//
//        antMatchers("/....").permitAll(): permite el acceso sin autenticación a cualquier solicitud que coincida con la URL "/...".
//
//        anyRequest().authenticated(): requiere autenticación para cualquier otra solicitud que no coincida con la URL "/...".
//
//        formLogin(): permite a los usuarios autenticarse mediante un formulario de inicio de sesión personalizado.
//
//        logout(): permite a los usuarios cerrar sesión en la aplicación.
