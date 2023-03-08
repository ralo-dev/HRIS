package mx.tecnm.hris.departamentos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jefe_departamento")
    @JsonManagedReference
    private EmpleadoEntity jefeDepartamento;

    public DepartamentoEntity(String nombre) {
        this.nombre = nombre;
    }
}
