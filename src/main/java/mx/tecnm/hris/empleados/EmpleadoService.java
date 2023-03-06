package mx.tecnm.hris.empleados;

import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoMovimiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Optional<EmpleadoEntity> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Optional<EmpleadoEntity> findByRfc(String rfc) {
        return empleadoRepository.findByRfc(rfc);
    }

    public Optional<EmpleadoEntity> findByCurp(String curp) {
        return empleadoRepository.findByCurp(curp);
    }

    public List<EmpleadoEntity> findAll() {
        return empleadoRepository.findAll();
    }

    public List<EmpleadoEntity> findByDepartamento(Long departamentoId) {
        return empleadoRepository.findByDepartamento_IdDepartamento(departamentoId).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findByNombre(String nombre) {
        return empleadoRepository.findByNombreContainingIgnoreCase(nombre).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findByEstado(Estado estado) {
        return empleadoRepository.findByEstado(estado).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findByNivelAcademico(NivelAcademico nivelAcademico) {
        return empleadoRepository.findByNivelAcademico(nivelAcademico).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findBySexo(Sexo sexo) {
        return empleadoRepository.findBySexo(sexo).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findByTipoContrato(TipoMovimiento tipoMovimiento) {
        return empleadoRepository.findByTipoContrato(tipoMovimiento).stream().collect(Collectors.toList());
    }

    public int updateEstadoByRfc(String rfc, Estado estado) {
        return empleadoRepository.actualizarEstadoPorRfc(rfc, estado);
    }

    public int updateEstadoByCurp(String curp, Estado estado) {
        return empleadoRepository.actualizarEstadoPorCurp(curp, estado);
    }

    public int updateEstadoById(Long id, Estado estado) {
        return empleadoRepository.actualizarEstadoPorId(id, estado);
    }

    public List<EmpleadoEntity> findByNivelAcademicoMayorIgual(NivelAcademico nivelAcademico) {
        return empleadoRepository.findByNivelAcademicoGreaterThanEqual(nivelAcademico).stream().collect(Collectors.toList());
    }

    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    public boolean deleteById(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

