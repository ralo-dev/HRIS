package mx.tecnm.hris.empleados;

import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoMovimiento;
import mx.tecnm.hris.utils.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    Logger logger = Logger.getLogger(EmpleadoController.class.getName());

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    private static ResponseEntity<Object> getResponse(Optional<EmpleadoEntity> empleado) {
        if (empleado.isPresent())
            return CustomResponse.generateResponse("Se encontró el empleado", HttpStatus.OK, empleado.get());
        return CustomResponse.generateResponse("No se encontró, verifique los datos", HttpStatus.OK, null);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findAll();
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<EmpleadoEntity> empleado = empleadoService.findById(id);
        return getResponse(empleado);
    }

    @GetMapping("/rfc/{rfc}")
    public ResponseEntity<Object> findByRfc(@PathVariable String rfc) {
        Optional<EmpleadoEntity> empleado = empleadoService.findByRfc(rfc);
        return getResponse(empleado);
    }

    @GetMapping("/curp/{curp}")
    public ResponseEntity<Object> findByCurp(@PathVariable String curp) {
        Optional<EmpleadoEntity> empleado = empleadoService.findByCurp(curp);
        return getResponse(empleado);
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<Object> findByDepartamento(@PathVariable Long departamentoId) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findByDepartamento(departamentoId);
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Object> findByNombre(@PathVariable String nombre) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findByNombre(nombre);
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<Object> findByEstado(@PathVariable String estado) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findByEstado(Estado.valueOf(estado));
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/nivelAcademico/{nivelAcademico}")
    public ResponseEntity<Object> findByNivelAcademico(@PathVariable String nivelAcademico) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findByNivelAcademico(NivelAcademico.valueOf(nivelAcademico));
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<Object> findBySexo(@PathVariable String sexo) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findBySexo(Sexo.valueOf(sexo));
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/nivelAcademico/minimo/{nivelAcademico}")
    public ResponseEntity<Object> findByNivelAcademicoMayorIgual(@PathVariable String nivelAcademico) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findByNivelAcademicoMayorIgual(NivelAcademico.valueOf(nivelAcademico));
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @GetMapping("/tipoContrato/{tipoContrato}")
    public ResponseEntity<Object> findByTipoContrato(@PathVariable String tipoContrato) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.findByTipoContrato(TipoMovimiento.valueOf(tipoContrato));
        return CustomResponse.generateResponse(listaEmpleados.size() + " empleados encontrados", HttpStatus.OK, listaEmpleados);
    }

    @PutMapping("/estado/rfc/{rfc}")
    public ResponseEntity<Object> updateEstadoByRfc(@PathVariable String rfc, @RequestBody String estado) {
        int registrosActualizados = empleadoService.updateEstadoByRfc(rfc, Estado.valueOf(estado));
        return CustomResponse.generateResponse(registrosActualizados + " registros actualizados", HttpStatus.NO_CONTENT, null);
    }

    @PutMapping("/estado/id/{id}")
    public ResponseEntity<Object> updateEstadoById(@PathVariable Long id, @RequestBody String estado) {
        int registrosActualizados = empleadoService.updateEstadoById(id, Estado.valueOf(estado));
        return CustomResponse.generateResponse(registrosActualizados + " registros actualizados", HttpStatus.NO_CONTENT, null);
    }

    @PutMapping("/estado/curp/{curp}")
    public ResponseEntity<Object> updateEstadoByCurp(@PathVariable String curp, @RequestBody String estado) {
        int registrosActualizados = empleadoService.updateEstadoByCurp(curp, Estado.valueOf(estado));
        return CustomResponse.generateResponse(registrosActualizados + " registros actualizados", HttpStatus.NO_CONTENT, null);
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody EmpleadoEntity empleado) {
        if (empleadoIsValid(empleado)) {
            EmpleadoEntity empleadoGuardado = empleadoService.save(empleado);
            return CustomResponse.generateResponse("Empleado guardado", HttpStatus.CREATED, empleadoGuardado);
        }
        return CustomResponse.generateResponse("Datos incompletos", HttpStatus.BAD_REQUEST, null);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        boolean registroEliminado = empleadoService.deleteById(id);
        if (registroEliminado)
            return CustomResponse.generateResponse("Registro eliminado", HttpStatus.NO_CONTENT, null);
        return CustomResponse.generateResponse("No se encontró el registro", HttpStatus.NOT_FOUND, null);
    }

    private boolean empleadoIsValid(EmpleadoEntity empleado) {
        return empleado.getRfc() != null && !empleado.getRfc().isEmpty()
                && empleado.getCurp() != null && !empleado.getCurp().isEmpty()
                && empleado.getCorreoInstitucional() != null && !empleado.getCorreoInstitucional().isEmpty()
                && empleado.getNombre() != null && !empleado.getNombre().isEmpty()
                && empleado.getNivelAcademico() != null
                && empleado.getSexo() != null
                && empleado.getFechaIngreso() != null
                && empleado.getEstado() != null
                && empleado.getTipoMovimiento() != null
                && empleado.getDepartamento() != null;
    }
}
