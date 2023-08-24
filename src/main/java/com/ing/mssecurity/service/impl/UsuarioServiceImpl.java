package com.ing.mssecurity.service.impl;

import com.ing.mssecurity.model.Usuario;
import com.ing.mssecurity.repository.UsuarioRepository;
import com.ing.mssecurity.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @project ms-integrated
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 18/08/2023
 **/
@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    private final UsuarioRepository usuarioRepository;


    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        //usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> porEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.porEmail(email)
                .map(usuario -> new User(email, usuario.getPassword(), true, true, true, true,
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))))
                .orElseThrow(() -> new UsernameNotFoundException("El email "+ email +" no existe."));
    }
}
