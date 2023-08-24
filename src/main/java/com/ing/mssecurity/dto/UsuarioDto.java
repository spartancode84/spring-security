package com.ing.mssecurity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @project ms-security
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 23/08/2023
 **/
@Data
@Builder
public class UsuarioDto {
    private Long idUsuario;
    private String email;
    private String passwordEntity;
    private String passwordInput;
}
