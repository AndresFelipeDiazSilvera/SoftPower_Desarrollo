package com.softpower.controllers;

import com.softpower.models.services.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    private IproductoService iproductoService;

    @GetMapping("/listaProducto")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Productos");
        model.addAttribute("productos", iproductoService.findAll());
        return "ListarProducto";
    }
}
