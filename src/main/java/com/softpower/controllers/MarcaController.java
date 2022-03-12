package com.softpower.controllers;

import com.softpower.entities.Marca;
import com.softpower.models.services.ImarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("marca")
public class MarcaController {

    @Autowired
    private ImarcaService imarcaService;

    @GetMapping("/marca/listarMarca")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Marcas");
        model.addAttribute("marca", imarcaService.findAll());
        return "marca/listarMarca";
    }
    @GetMapping(value = "/marca/crearMarca")
    public String create(Model model){
        model.addAttribute("marca",new Marca());
        model.addAttribute("titulo","Crear Marca");
        return "marca/crearMarca";
    }

    @PostMapping(value = "/marca/crearMarca")
    public String guardarmarca(@Validated Marca marca, BindingResult result, Model model){
        if (result.hasErrors()){
            return "marca/crearMarca";
        }
        imarcaService.save(marca);
        return "redirect:/marca/listarMarca";
    }


}
