package com.ing.mssecurity.repository;

import com.ing.mssecurity.model.Rol;
import com.ing.mssecurity.model.Usuario;
import com.ing.mssecurity.model.UsuarioRol;
import com.ing.mssecurity.model.UsuarioRolKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @project ms-security
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 23/08/2023
 **/
@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolKey> {

    @Query("select u.rol from UsuarioRol u where u.idUsuarioRol.idUsuario =?1")
    List<Rol> findRolesByIdUsuario(Long idUsuario);

}
