package com.softpower.controllers;

import com.softpower.entities.Marca;
import com.softpower.models.services.ImarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("marca")
public class MarcaController {

    @Autowired
    private ImarcaService imarcaService;
    private Marca marcaObject;

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

    @RequestMapping(value = "/eliminarMarca/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            imarcaService.remove(id);
            flash.addFlashAttribute("succes", "Marca eliminada con éxito");
        }
        return "redirect:/marca/listarMarca";
    }

    @RequestMapping(value = "/editarMarca/{id}")
    public String editar(@PathVariable Long id, Model model) throws Exception{
        marcaObject = imarcaService.findById(id);
        model.addAttribute("marcaObject", marcaObject);
        model.addAttribute("titulo", "Actualizar Marca");
        model.addAttribute("tituloPage", "Marcas");

        return "marca/crearMarca";
    }

    private void setParameters(Marca marca){
        marcaObject.setNombre(marca.getNombre());
    }

    private void initObject(){
        this.marcaObject = new Marca();
    }
}
