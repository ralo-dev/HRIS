package mx.tecnm.hris.empleados;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.tecnm.hris.departamentos.DepartamentoEntity;
import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoContrato;

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

    @NotBlank(message = "El campo rfc no puede estar vacío")
    @Column(name = "rfc", nullable = false)
    private String rfc;

    @NotBlank(message = "El campo curp no puede estar vacío")
    @Column(name = "curp", nullable = false)
    private String curp;

    @NotBlank(message = "El campo correo institucional no puede estar vacío")
    @Email(message = "El correo institucional debe ser un correo válido")
    @Column(name = "correo_institucional", nullable = false)
    private String correoInstitucional;

    @NotBlank(message = "El campo correo personal no puede estar vacío")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El campo apellido paterno no puede estar vacío")
    @Column(name = "nivel_academico", nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelAcademico nivelAcademico;

    @Column(name = "profesion")
    private String profesion;

    @NotBlank(message = "El campo sexo no puede estar vacío")
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotBlank(message = "El campo fecha de ingreso no puede estar vacío")
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

    @Column(name = "motivo_baja")
    private String motivoBaja;

    @NotBlank(message = "El campo estado no puede estar vacío")
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "comentarios")
    private String comentarios;

    @NotBlank(message = "El campo tipo de contrato no puede estar vacío")
    @Column(name = "tipo_contrato", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;

    @NotBlank(message = "El campo departamentos no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id", nullable = false)
    private DepartamentoEntity departamento;
}
