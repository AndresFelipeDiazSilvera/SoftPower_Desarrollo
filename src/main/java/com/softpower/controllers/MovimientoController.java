package com.softpower.controllers;

import com.softpower.entities.Marca;
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


    private final ImovimientoService imovimientoService;
    public Movimiento movimientoObject;

    public MovimientoController(ImovimientoService imovimientoService) {
        this.imovimientoService = imovimientoService;
        this.initObject();
    }

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
        setParameters(movimiento);
        imovimientoService.save(movimientoObject);
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

    @RequestMapping(value = "/editarMovimiento/{id}")
    public String editar(@PathVariable Long id, Model model) throws Exception{
        movimientoObject = imovimientoService.findById(id);
        model.addAttribute("movimiento", movimientoObject);
        model.addAttribute("titulo", "Actualizar Movimiento");

        return "movimiento/crearMovimiento";
    }

    private void setParameters(Movimiento movimiento){
        movimientoObject.setProducto(movimiento.getProducto());
        movimientoObject.setTipo_movimiento(movimiento.getTipo_movimiento());
        movimientoObject.setFecha(movimiento.getFecha());
        movimientoObject.setTotal(movimiento.getTotal());
        movimientoObject.setFecha(movimiento.getFecha());
        movimientoObject.setNumero_factura(movimiento.getNumero_factura());
        movimientoObject.setTerceroList(movimiento.getTerceroList());
    }

    private void initObject(){
        this.movimientoObject = new Movimiento();
    }

}
