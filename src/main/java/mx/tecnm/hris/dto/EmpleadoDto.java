package mx.tecnm.hris.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoMovimiento;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpleadoDto {
    private String rfc;

    private String nombre;

    private NivelAcademico nivelAcademico;

    private TipoMovimiento tipoMovimiento;
}
