package com.example.productos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Menu {

    @GetMapping("/create")
    public String crearProducto(){
        return "createProductView";
    }

}
