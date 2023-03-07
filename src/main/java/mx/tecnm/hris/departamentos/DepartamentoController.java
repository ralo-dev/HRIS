package mx.tecnm.hris.departamentos;

import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.empleados.EmpleadoService;
import mx.tecnm.hris.utils.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoController {

    DepartamentoService departamentoService;
    EmpleadoService empleadoService;

    public DepartamentoController(DepartamentoService departamentoService, EmpleadoService empleadoService) {
        this.departamentoService = departamentoService;
        this.empleadoService = empleadoService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllDepartamentos() {
        List<DepartamentoEntity> departamentos = departamentoService.findAll();
        return CustomResponse.generateResponse("Se encontraron los departamentos", HttpStatus.OK, departamentos);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Object> getDepartamentoByNombre(@PathVariable String nombre) {
        DepartamentoEntity departamento = departamentoService.findByNombre(nombre);
        return CustomResponse.generateResponse("Se encontró el departamento", HttpStatus.OK, departamento);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getDepartamentoById(@PathVariable Long id) {
        DepartamentoEntity departamento = departamentoService.findById(id);
        return CustomResponse.generateResponse("Se encontró el departamento", HttpStatus.OK, departamento);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createDepartamento(@RequestBody DepartamentoEntity departamento) {
        DepartamentoEntity departamentoEntity = departamentoService.save(departamento);
        return CustomResponse.generateResponse("Se creó el departamento", HttpStatus.OK, departamentoEntity);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateDepartamento(@RequestBody DepartamentoEntity departamento) {
        DepartamentoEntity departamentoEntity = departamentoService.save(departamento);
        return CustomResponse.generateResponse("Se actualizó el departamento", HttpStatus.OK, departamentoEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteById(id);
        return CustomResponse.generateResponse("Se eliminó el departamento", HttpStatus.OK, null);
    }

    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<Object> deleteDepartamentoByNombre(@PathVariable String nombre) {
        departamentoService.deleteByNombre(nombre);
        return CustomResponse.generateResponse("Se eliminó el departamento", HttpStatus.OK, null);
    }
}
