package com.codeprophecy.demo.controllers;

import com.codeprophecy.demo.entities.Salut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController
{

    @GetMapping("/rest")
    public Salut theSaluter(
            @RequestParam(required = false, defaultValue = "Haj Abbas")
            String nomre)
    {
        return new Salut(String.format("Bon Journo, %s", nomre));
    }

}
