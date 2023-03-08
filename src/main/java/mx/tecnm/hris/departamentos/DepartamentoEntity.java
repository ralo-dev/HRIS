package mx.tecnm.hris.departamentos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.tecnm.hris.empleados.EmpleadoEntity;

import java.util.List;

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

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<EmpleadoEntity> empleados;

    @ManyToOne
    @JoinColumn(name = "jefe_departamento_id")
    @JsonBackReference
    private EmpleadoEntity jefeDepartamento;

    public DepartamentoEntity(String nombre) {
        this.nombre = nombre;
    }
}
