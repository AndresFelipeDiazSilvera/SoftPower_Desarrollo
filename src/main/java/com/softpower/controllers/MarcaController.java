package com.softpower.controllers;

import com.softpower.models.services.ImarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("marca")
public class MarcaController {

    @Autowired
    private ImarcaService imarcaService;

    @GetMapping("/listaMarca")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Marcas");
        model.addAttribute("marcas", imarcaService.findAll());
        return "ListarMarca";
    }

}
