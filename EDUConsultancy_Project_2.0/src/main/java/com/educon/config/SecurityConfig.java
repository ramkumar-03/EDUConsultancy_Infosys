package com.educon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(authorize -> authorize
                        //.requestMatchers("/api/v1/user/save").permitAll() // Public access to signup
                        .requestMatchers("/student/**").permitAll() // STUDENT role access
                        .requestMatchers("/parent/**").permitAll()   // PARENT role access
                        .requestMatchers("/teacher/**").permitAll() // TEACHER role access
                        .requestMatchers("/user/**").permitAll()
                        //.requestMatchers("/student/**").hasRole("STUDENT") // STUDENT role access
                        //.requestMatchers("/parent/**").hasRole("PARENT")   // PARENT role access
                        //.requestMatchers("/teacher/**").hasRole("TEACHER") // TEACHER role access
                        //.requestMatchers("/user/**").hasRole("ADMIN")     // ADMIN role access
                        //.anyRequest().authenticated()                      // Other requests need authentication
                )
                .formLogin().permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
