package com.softpower.controllers;

import com.softpower.models.services.ItercerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("terceros")
public class TercerosController {

    @Autowired
    private ItercerosService itercerosService;

    @GetMapping("/listaTerceros")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Tercero");
        model.addAttribute("terceros", itercerosService.findAll());
        return "ListarTerceros";
    }
}
