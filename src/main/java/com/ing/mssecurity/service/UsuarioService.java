package com.ing.mssecurity.service;

import com.ing.mssecurity.model.Usuario;

import java.util.Optional;

/**
 * @project ms-integrated
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 18/08/2023
 **/
public interface UsuarioService {
    Usuario save(Usuario usuario);
    Optional<Usuario> porEmail(String email);
}
