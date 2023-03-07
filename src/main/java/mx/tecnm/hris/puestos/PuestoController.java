package mx.tecnm.hris.puestos;

import mx.tecnm.hris.departamentos.DepartamentoEntity;
import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.empleados.EmpleadoService;
import mx.tecnm.hris.puestos.enums.Categoria;
import mx.tecnm.hris.puestos.enums.TipoPlaza;
import mx.tecnm.hris.utils.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puestos")
public class PuestoController {
    private final PuestoService puestoService;
    private final EmpleadoService empleadoService;

    public PuestoController(PuestoService puestoService, EmpleadoService empleadoService) {
        this.puestoService = puestoService;
        this.empleadoService = empleadoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPuestoById(@PathVariable Long id) {
        Optional<PuestoEntity> puesto = puestoService.findById(id);
        if (puesto.isPresent()) {
            return CustomResponse.generateResponse("Se encontró el puesto", HttpStatus.OK, puesto.get());
        } else {
            return CustomResponse.generateResponse("No se encontró, verifique los datos", HttpStatus.OK, null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createPuesto(@RequestBody PuestoEntity puesto) {
        PuestoEntity createdPuesto = puestoService.save(puesto);
        return CustomResponse.generateResponse("Puesto creado", HttpStatus.CREATED, createdPuesto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePuesto(@PathVariable Long id, @RequestBody PuestoEntity updatedPuesto) {
        Optional<PuestoEntity> currentPuesto = puestoService.findById(id);
        if (currentPuesto.isPresent()) {
            updatedPuesto.setIdPuestoEmpleado(id);
            PuestoEntity savedPuesto = puestoService.save(updatedPuesto);
            return CustomResponse.generateResponse("Puesto actualizado", HttpStatus.OK, savedPuesto);
        } else {
            return CustomResponse.generateResponse("No se encontró, verifique los datos", HttpStatus.OK, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePuesto(@PathVariable Long id) {
        Optional<PuestoEntity> puesto = puestoService.findById(id);
        if (puesto.isPresent()) {
            puestoService.delete(puesto.get());
            return CustomResponse.generateResponse("Puesto eliminado", HttpStatus.OK, null);
        } else {
            return CustomResponse.generateResponse("No se encontró, verifique los datos", HttpStatus.OK, null);
        }
    }

    @GetMapping("/activos")
    public ResponseEntity<Object> getActivos() {
        List<PuestoEntity> activos = puestoService.findByActivo(true).toList();
        return CustomResponse.generateResponse("Se encontraron los puestos activos", HttpStatus.OK, activos);
    }

    @GetMapping("/clave/{clave}")
    public ResponseEntity<Object> getByClavePresupuestal(@PathVariable String clave) {
        Optional<PuestoEntity> puestos = puestoService.findByClavePresupuestal(clave);
        if (puestos.isPresent()) {
            return CustomResponse.generateResponse("Se encontró el puesto", HttpStatus.OK, puestos.get());
        } else {
            return CustomResponse.generateResponse("No se encontró, verifique los datos", HttpStatus.OK, null);
        }
    }

    @GetMapping("/activos/departamento/{departamento}")
    public ResponseEntity<Object> getActivosByDepartamento(@PathVariable DepartamentoEntity departamento) {
        List<PuestoEntity> activos = puestoService.findActivosByDepartamento(departamento).toList();
        return CustomResponse.generateResponse("Se encontraron los puestos activos", HttpStatus.OK, activos);
    }

    @GetMapping("/activos/empleado/{rfc}")
    public ResponseEntity<Object> getActivosByEmpleadoRfc(@PathVariable String rfc) {
        List<PuestoEntity> activos = puestoService.findActivosByEmpleadoRfc(rfc).toList();
        return CustomResponse.generateResponse("Se encontraron los puestos activos", HttpStatus.OK, activos);
    }

    @GetMapping("/activos/categoria/{categoria}")
    public ResponseEntity<Object> getActivosByCategoria(@PathVariable Categoria categoria) {
        List<PuestoEntity> activos = puestoService.findActivosByCategoria(categoria).toList();
        return CustomResponse.generateResponse("Se encontraron los puestos activos", HttpStatus.OK, activos);
    }

    @GetMapping("/empleado/{rfc}")
    public ResponseEntity<Object> getByEmpleadoRfc(@PathVariable String rfc) {
        Optional<EmpleadoEntity> empleado = empleadoService.findByRfc(rfc);
        if (empleado.isPresent()) {
            List<PuestoEntity> puestos = puestoService.findByEmpleado(empleado.get()).toList();
            return CustomResponse.generateResponse("Se encontraron los puestos", HttpStatus.OK, puestos);
        } else {
            return CustomResponse.generateResponse("No se encontró, verifique los datos", HttpStatus.OK, null);
        }
    }

    @GetMapping("/categorias/{categoria}")
    public ResponseEntity<Object> getByCategoria(@PathVariable Categoria categoria) {
        List<PuestoEntity> puestos = puestoService.findByCategoria(categoria).toList();
        return CustomResponse.generateResponse("Se encontraron los puestos", HttpStatus.OK, puestos);
    }

    @GetMapping("/tipos/{tipoPlaza}")
    public ResponseEntity<Object> getByTipoPlaza(@PathVariable TipoPlaza tipoPlaza) {
        List<PuestoEntity> puestos = puestoService.findByTipoPlaza(tipoPlaza).toList();
        return CustomResponse.generateResponse("Se encontraron los puestos", HttpStatus.OK, puestos);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        List<PuestoEntity> puestos = puestoService.findAll();
        return CustomResponse.generateResponse("Se encontraron los puestos", HttpStatus.OK, puestos);
    }
}
