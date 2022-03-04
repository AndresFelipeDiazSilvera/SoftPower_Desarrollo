package com.softpower.controllers;

import com.softpower.models.services.ImovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("movimiento")
public class MovimientoController {

    @Autowired
    private ImovimientoService imovimientoService;

    @GetMapping("/listaMoviento")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Movimiento");
        model.addAttribute("movimientos", imovimientoService.findAll());
        return "ListarMovimiento";
    }
}
