package com.softpower.controllers;

import com.softpower.entities.Producto;
import com.softpower.entities.Producto;
import com.softpower.models.services.IproductoService;
import com.softpower.models.services.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("producto")
public class ProductoController {

    private final IproductoService iproductoService;
    public Producto productoObject;

    public ProductoController(IproductoService iproductoService) {
        this.iproductoService = iproductoService;
        this.initObject();
    }

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
        setParameters(producto);
        iproductoService.save(productoObject);
        return "redirect:/producto/listarProducto";
    }

    @RequestMapping(value = "/producto/eliminarProducto/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            iproductoService.remove(id);
            flash.addFlashAttribute("succes", "Producto eliminado con éxito");
        }
        return "redirect:/producto/listarProducto";
    }

    @RequestMapping(value = "/editarProducto/{id}")
    public String editar(@PathVariable Long id, Model model) throws Exception{
        productoObject = iproductoService.findById(id);
        model.addAttribute("producto", productoObject);
        model.addAttribute("titulo", "Actualizar Producto");

        return "producto/crearProducto";
    }

    private void setParameters(Producto producto){
        productoObject.setCantidad_maxima(producto.getCantidad_maxima());
        productoObject.setCantidad_minima(producto.getCantidad_minima());
        productoObject.setNombre(producto.getNombre());
        productoObject.setDescripcion(producto.getDescripcion());
        productoObject.setIva(producto.getIva());
        productoObject.setPrecio(producto.getPrecio());
    }

    private void initObject(){
        this.productoObject = new Producto();
    }
}
