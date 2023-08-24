package com.ing.mssecurity.config;

import com.ing.mssecurity.dto.UsuarioDto;
import com.ing.mssecurity.repository.UsuarioRepository;
import com.ing.mssecurity.repository.UsuarioRolRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @project ms-security
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 23/08/2023
 **/
@Component
@AllArgsConstructor
public class MyAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioRolRepository usuarioRolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsuarioDto userDto = this.usuarioRepository.findByEmail(authentication.getName())
                .map(usuario -> UsuarioDto.builder()
                        .idUsuario(usuario.getIdUsuario())
                        .email(authentication.getName())
                        .passwordEntity(usuario.getPassword())
                        .passwordInput(authentication.getCredentials().toString())
                        .build())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        if (passwordEncoder.matches(userDto.getPasswordInput(), userDto.getPasswordEntity())) {
            return new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPasswordInput(),
                    usuarioRolRepository.findRolesByIdUsuario(userDto.getIdUsuario()).stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
