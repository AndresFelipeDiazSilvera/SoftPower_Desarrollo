package entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marca")
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais_origen")
    private String pais_origen;

    @Column(name = "web")
    private String web;

}
