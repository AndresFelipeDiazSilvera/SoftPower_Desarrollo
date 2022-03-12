package com.softpower.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "terceros")
public class Tercero implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "tipo_documento")
    private String tipo_documento;

    @NotNull
    @Column(name = "documento")
    private float documento;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "genero")
    private String genero;

    @Column(name = "tipo_tercero")
    private String tipo_tercero;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private Movimiento movimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public float getDocumento() {
        return documento;
    }

    public void setDocumento(float documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo_tercero() {
        return tipo_tercero;
    }

    public void setTipo_tercero(String tipo_tercero) {
        this.tipo_tercero = tipo_tercero;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
}
