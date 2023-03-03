package mx.tecnm.hris.puesto;

import jakarta.persistence.*;
import lombok.*;
import mx.tecnm.hris.empleado.Empleado;
import mx.tecnm.hris.puesto.enums.Jornada;
import mx.tecnm.hris.puesto.enums.Nombramiento;
import mx.tecnm.hris.puesto.enums.TipoPlaza;

@Entity
@Table(name = "puesto")
@NoArgsConstructor
@Getter
@Setter
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuestoEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(nullable = false, length = 100)
    private String clavePresupuestal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Nombramiento nombramiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TipoPlaza tipoPlaza;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Jornada categoriaJornada;

    @Column(nullable = false)
    private int numeroHorasNombramiento;

}
