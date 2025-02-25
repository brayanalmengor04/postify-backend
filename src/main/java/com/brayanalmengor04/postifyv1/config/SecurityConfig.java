package com.brayanalmengor04.postifyv1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Deshabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Permite acceso a todas las rutas
                )
                .formLogin(login -> login.disable())  // Deshabilita el formulario de login de Spring
                .httpBasic(basic -> basic.disable()); // Deshabilita autenticación básica

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(); // No define usuarios, evita la autenticación por defecto
    }
}
