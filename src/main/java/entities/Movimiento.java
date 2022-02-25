package entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String total;

    @NotNull
    @Column(name = "producto_id")
    private String producto_id;
}
