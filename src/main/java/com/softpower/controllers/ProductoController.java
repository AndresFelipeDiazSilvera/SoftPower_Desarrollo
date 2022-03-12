package com.softpower.controllers;

import com.softpower.entities.Producto;
import com.softpower.models.services.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    private IproductoService iproductoService;

    @GetMapping("/producto/listarProducto")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Productos");
        model.addAttribute("producto", iproductoService.findAll());
        return "producto/listarProducto";
    }

    @GetMapping(value = "/producto/crearProducto")
    public String create(Model model){
        model.addAttribute("producto",new Producto());
        model.addAttribute("titulo","Crear Producto");
        return "producto/crearProducto";
    }

    @PostMapping(value = "/producto/crearProducto")
    public String guardarproducto(@Validated Producto producto, BindingResult result, Model model){
        if (result.hasErrors()){
            return "producto/crearProducto";
        }
        iproductoService.save(producto);
        return "redirect:/producto/listarProducto";
    }
}
