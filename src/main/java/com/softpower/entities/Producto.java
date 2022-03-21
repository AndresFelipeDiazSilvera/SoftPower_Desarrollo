package com.softpower.entities;


import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private float precio;

    @NotNull
    @Column(name = "iva")
    private float iva;

    @Column(name = "cantidad_maxima")
    private int cantidad_maxima;

    @Column(name = "cantidad_minima")
    private int cantidad_minima;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name= "marca_id")
    private Marca marca;

    @OneToMany(mappedBy = "id")
    private List<Producto> productoList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public int getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(int cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}

