package mx.tecnm.hris.departamentos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.tecnm.hris.empleados.EmpleadoEntity;

@Entity
@Table(name = "departamentos")
@NoArgsConstructor
@Getter
@Setter
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jefe_departamento")
    private EmpleadoEntity jefeDepartamento;

    public DepartamentoEntity(String nombre) {
        this.nombre = nombre;
    }
}
