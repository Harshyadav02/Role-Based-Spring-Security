package com.harsh.springSecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        
        http.authorizeHttpRequests(request -> request 
        .requestMatchers("/admin/**").authenticated()
        .anyRequest().permitAll())
        .httpBasic(Customizer.withDefaults())
        .userDetailsService(userDetailsServiceImp)
        .csrf(csrf -> csrf.disable());
        return http.build();
    }
}



