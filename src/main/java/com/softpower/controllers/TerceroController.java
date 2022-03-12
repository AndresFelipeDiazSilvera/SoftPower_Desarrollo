package com.softpower.controllers;

import com.softpower.entities.Tercero;
import com.softpower.models.services.IterceroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("tercero")
public class TerceroController {

    @Autowired
    private IterceroService iterceroService;

    @GetMapping("/tercero/listarTercero")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Tercero");
        model.addAttribute("tercero", iterceroService.findAll());
        return "tercero/listarTercero";
    }
    @GetMapping(value = "/tercero/crearTercero")
    public String create(Model model){
        model.addAttribute("tercero",new Tercero());
        model.addAttribute("titulo","Crear Tercero");
        return "tercero/crearTercero";
    }
    @PostMapping(value = "/tercero/crearTercero")
    public String guardartercero(@Validated Tercero tercero, BindingResult result, Model model){
        if (result.hasErrors()){
            return "tercero/crearTercero";
        }
        iterceroService.save(tercero);
        return "redirect:/tercero/listarTercero";
    }

}
