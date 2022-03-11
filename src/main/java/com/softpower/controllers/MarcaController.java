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

    @GetMapping("/listarMarca")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Marcas");
        model.addAttribute("marcas", imarcaService.findAll());
        return "ListarMarca";
    }
    @GetMapping(value = "/createMarca")
    public String create(Model model){
        model.addAttribute("marca",new Marca());
        model.addAttribute("titulo","Create Marca");
        return "createMarca";
    }

    @PostMapping(value = "/createMarca")
    public String guardarmarca(@Validated Marca marca, BindingResult result, Model model){
        if (result.hasErrors()){
            return "createMarca";
        }
        //marca.setWeb(toString());
        imarcaService.save(marca);
        return "redirect:/listarMarca";
    }


}
