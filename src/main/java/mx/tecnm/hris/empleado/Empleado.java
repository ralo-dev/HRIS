package mx.tecnm.hris.empleado;

import jakarta.persistence.*;
import lombok.*;
import mx.tecnm.hris.empleado.enums.*;

import java.util.Date;

@Entity
@Table(name = "Empleado")
@NoArgsConstructor
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @Column(name = "curp", nullable = false, length = 18, unique = true)
    private String curp;

    @Column(name = "rfc", nullable = false, length = 13, unique = true)
    private String rfc;

    @Column(name = "numero_tarjeta", nullable = false, length = 10, unique = true)
    private Integer numeroTarjeta;

    @Column(name = "correo_institucional", nullable = false, length = 100, unique = true)
    private String correoInstitucional;

    @Column(name = "nombres", nullable = false, length = 200)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_academico", nullable = false)
    private NivelAcademico nivelAcademico;

    @Column(name = "profesion", length = 100)
    private String profesion;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @Column(name = "fecha_ingreso", nullable = false)
    private Date fechaIngreso;

    @Column(name = "fecha_baja")
    private Date fechaBaja;

    @Column(name = "motivo_baja")
    private String motivoBaja;

    @Column()
    private String comentarios;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contrato", nullable = false)
    private TipoContrato tipoContrato;
}
