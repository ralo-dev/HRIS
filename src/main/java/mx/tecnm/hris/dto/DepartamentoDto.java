package mx.tecnm.hris.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoDto {
    private Long id;
    private String nombre;
    private List<EmpleadoDto> empleados;
    private EmpleadoDto jefeDepartamento;

    // Constructor, getters y setters
}
