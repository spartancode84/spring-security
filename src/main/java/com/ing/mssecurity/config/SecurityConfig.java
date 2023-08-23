package com.ing.mssecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @project ms-security
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 22/08/2023
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.build();
    }
}
