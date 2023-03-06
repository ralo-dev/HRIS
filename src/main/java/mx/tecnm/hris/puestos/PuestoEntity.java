package mx.tecnm.hris.puestos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.puestos.enums.Categoria;
import mx.tecnm.hris.puestos.enums.TipoPlaza;

@Entity
@Table(name = "puestos")
@NoArgsConstructor
@Getter
@Setter
public class PuestoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuestoEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntity empleado;

    @Column(nullable = false, length = 100)
    private String clavePresupuestal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TipoPlaza tipoPlaza;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Categoria categoria;

    @Column(nullable = false)
    private int numeroHorasNombramiento;

    @Column(nullable = false)
    private boolean activo;
}
