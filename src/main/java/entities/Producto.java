package entities;


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

}
