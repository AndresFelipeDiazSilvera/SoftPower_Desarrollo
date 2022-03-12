package com.softpower.entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "tipo_movimiento")
    private String tipo_movimiento;

    @NotNull
    @Column(name = "numero_factura")
    private String numero_factura;

    @NotNull
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @NotNull
    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name= "producto_id")
    private Producto producto;

    @OneToMany(mappedBy = "id")
    private List<Tercero> terceroList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }
}

