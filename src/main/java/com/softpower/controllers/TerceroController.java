package com.softpower.controllers;

import com.softpower.entities.Tercero;
import com.softpower.entities.Tercero;
import com.softpower.models.services.IterceroService;
import com.softpower.models.services.IterceroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("tercero")
public class TerceroController {

    private final IterceroService iterceroService;
    public Tercero terceroObject;

    public TerceroController(IterceroService iterceroService) {
        this.iterceroService = iterceroService;
        this.initObject();
    }

    @GetMapping("/tercero/listarTercero")
    public String listar(Model model){
        model.addAttribute("titulo","Terceros");
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
        setParameters(tercero);
        iterceroService.save(terceroObject);
        return "redirect:/tercero/listarTercero";
    }

    @RequestMapping(value = "/tercero/eliminarTercero/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            iterceroService.remove(id);
            flash.addFlashAttribute("succes", "Tercero eliminado con éxito");
        }
        return "redirect:/tercero/listarTercero";
    }

    @RequestMapping(value = "/editarTercero/{id}")
    public String editar(@PathVariable Long id, Model model) throws Exception{
        terceroObject = iterceroService.findById(id);
        model.addAttribute("tercero", terceroObject);
        model.addAttribute("titulo", "Actualizar Tercero");

        return "tercero/crearTercero";
    }

    private void setParameters(Tercero tercero){
        terceroObject.setApellido(tercero.getApellido());
        terceroObject.setTipo_tercero(tercero.getTipo_tercero());
        terceroObject.setNombre(tercero.getNombre());
        terceroObject.setDireccion(tercero.getDireccion());
        terceroObject.setEmail(tercero.getEmail());
        terceroObject.setTelefono(tercero.getTelefono());
        terceroObject.setGenero(tercero.getGenero());
        terceroObject.setTipo_documento(tercero.getTipo_documento());
        terceroObject.setDocumento(tercero.getDocumento());
        terceroObject.setMovimiento(tercero.getMovimiento());
    }

    private void initObject(){
        this.terceroObject = new Tercero();
    }

}
