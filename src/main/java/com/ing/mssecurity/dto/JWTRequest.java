package com.ing.mssecurity.dto;

import lombok.Data;

@Data
public class JWTRequest {

    private String username;
    private String password;
}
