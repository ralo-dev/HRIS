package mx.tecnm.hris.empleados;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.tecnm.hris.departamentos.DepartamentoEntity;
import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoMovimiento;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rfc", nullable = false)
    private String rfc;

    @Column(name = "curp", nullable = false)
    private String curp;

    @Email(message = "El correo institucional debe ser un correo válido")
    @Column(name = "correo_institucional", nullable = false)
    private String correoInstitucional;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nivel_academico", nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelAcademico nivelAcademico;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

    @Column(name = "motivo_baja")
    private String motivoBaja;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "tipo_movimiento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id", nullable = false)
    @JsonManagedReference
    private DepartamentoEntity departamento;

    public EmpleadoEntity(String rfc, String curp, String correoInstitucional, String nombre, NivelAcademico nivelAcademico, String profesion, Sexo sexo, LocalDate fechaIngreso, LocalDate fechaBaja, String motivoBaja, Estado estado, String comentarios, TipoMovimiento tipoMovimiento, DepartamentoEntity departamento) {
        this.rfc = rfc;
        this.curp = curp;
        this.correoInstitucional = correoInstitucional;
        this.nombre = nombre;
        this.nivelAcademico = nivelAcademico;
        this.profesion = profesion;
        this.sexo = sexo;
        this.fechaIngreso = fechaIngreso;
        this.fechaBaja = fechaBaja;
        this.motivoBaja = motivoBaja;
        this.estado = estado;
        this.comentarios = comentarios;
        this.tipoMovimiento = tipoMovimiento;
        this.departamento = departamento;
    }
}
