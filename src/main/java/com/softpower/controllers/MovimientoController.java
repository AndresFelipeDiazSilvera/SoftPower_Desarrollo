package com.softpower.controllers;

import com.softpower.entities.Movimiento;
import com.softpower.models.services.ImovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("movimiento")
public class MovimientoController {

    @Autowired
    private ImovimientoService imovimientoService;

    @GetMapping("/movimiento/listarMovimiento")
    public String listar(Model model){
        model.addAttribute("titulo","Listar Movimientos");
        model.addAttribute("movimiento", imovimientoService.findAll());
        return "movimiento/listarMovimiento";
    }

    @GetMapping(value = "/movimiento/crearMovimiento")
    public String create(Model model){
        model.addAttribute("movimiento",new Movimiento());
        model.addAttribute("titulo","Crear Movimiento");
        return "movimiento/crearMovimiento";
    }

    @PostMapping(value = "/movimiento/crearMovimiento")
    public String guardarmovimiento(@Validated Movimiento movimiento, BindingResult result, Model model){
        if (result.hasErrors()){
            return "movimiento/crearMovimiento";
        }
        imovimientoService.save(movimiento);
        return "redirect:/movimiento/listarMovimiento";
    }

    @RequestMapping(value = "/movimiento/eliminarMovimiento/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            imovimientoService.remove(id);
            flash.addFlashAttribute("succes", "Movimiento eliminado con éxito");
        }
        return "redirect:/movimiento/listarMovimiento";
    }

}
