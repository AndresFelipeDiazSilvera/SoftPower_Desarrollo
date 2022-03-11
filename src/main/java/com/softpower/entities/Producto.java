package com.softpower.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "precio")
    private String precio;

    @NotNull
    @Column(name = "iva")
    private String iva;

    @Column(name = "cantidad_maxima")
    private String cantidad_maxima;

    @Column(name = "cantidad_minima")
    private String cantidad_minima;

    @NotNull
    @Column(name = "marca_id")
    private String marca_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(String marca_id) {
        this.marca_id = marca_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(String cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    public String getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(String cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }
}
