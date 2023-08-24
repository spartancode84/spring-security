package com.ing.mssecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @project ms-security
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 23/08/2023
 **/
@RestController
@RequestMapping(path = "/about_us")
public class AboutUsController {
    @GetMapping
    Map<String, String> welcome(){
        return Collections.singletonMap("Estoy Aqui ->", "about_us");
    }
}
