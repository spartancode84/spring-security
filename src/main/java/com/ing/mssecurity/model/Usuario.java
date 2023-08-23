package com.ing.mssecurity.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @project ms-integrated
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 18/08/2023
 **/
@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;
    private String password;
}
