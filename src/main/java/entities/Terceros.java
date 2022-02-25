package entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "terceros")
public class Terceros implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "tipo_documento")
    private String tipo_documento;

    @NotNull
    @Column(name = "documento")
    private String documento;

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

    @NotNull
    @Column(name = "movimiento_id")
    private String movimiento_id;
}
