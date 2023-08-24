package com.ing.mssecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class MsSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSecurityApplication.class, args);
    }

}
