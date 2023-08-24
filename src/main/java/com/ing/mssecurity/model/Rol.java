package com.ing.mssecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

/**
 * @project ms-security
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 23/08/2023
 **/
@Entity
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    private String name;

    private String description;


}
