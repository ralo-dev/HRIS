package mx.tecnm.hris.empleado;

import mx.tecnm.hris.empleado.enums.Estado;
import mx.tecnm.hris.empleado.enums.NivelAcademico;
import mx.tecnm.hris.empleado.enums.Sexo;
import mx.tecnm.hris.empleado.enums.TipoContrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Optional<EmpleadoEntity> buscarPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    public Optional<EmpleadoEntity> buscarPorRfc(String rfc) {
        return empleadoRepository.findByRfc(rfc);
    }

    public Optional<EmpleadoEntity> buscarPorCurp(String curp) {
        return empleadoRepository.findByCurp(curp);
    }

    public List<EmpleadoEntity> buscarPorDepartamento(Long departamentoId) {
        return empleadoRepository.findByDepartamento_IdDepartamento(departamentoId).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorNombre(String nombre) {
        return empleadoRepository.findByNombreContainingIgnoreCase(nombre).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorEstado(Estado estado) {
        return empleadoRepository.findByEstado(estado).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorNivelAcademico(NivelAcademico nivelAcademico) {
        return empleadoRepository.findByNivelAcademico(nivelAcademico).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorSexo(Sexo sexo) {
        return empleadoRepository.findBySexo(sexo).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorTipoContrato(TipoContrato tipoContrato) {
        return empleadoRepository.findByTipoContrato(tipoContrato).stream().collect(Collectors.toList());
    }

    public void actualizarEstadoPorRfc(String rfc, Estado estado) {
        empleadoRepository.actualizarEstadoPorRfc(rfc, estado);
    }

    public void actualizarEstadoPorCurp(String curp, Estado estado) {
        empleadoRepository.actualizarEstadoPorCurp(curp, estado);
    }

    public void actualizarEstadoPorId(Long id, Estado estado) {
        empleadoRepository.actualizarEstadoPorId(id, estado);
    }

    public List<EmpleadoEntity> buscarPorNombreYSexo(String nombre, Sexo sexo) {
        return empleadoRepository.findByNombreAndSexo(nombre, sexo).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorNivelAcademicoMayorOIgualA(NivelAcademico nivelAcademico) {
        return empleadoRepository.findByNivelAcademicoGreaterThanEqual(nivelAcademico).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> buscarPorFechaIngresoAntesDeYEstadoIgualA(LocalDate fecha, Estado estado) {
        return empleadoRepository.findByFechaIngresoBeforeAndEstadoEquals(fecha, estado).stream().collect(Collectors.toList());
    }

    public EmpleadoEntity guardar(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<EmpleadoEntity> guardarTodos(List<EmpleadoEntity> empleados) {
        return empleadoRepository.saveAll(empleados);
    }

    public void eliminarPorId(Long id) {
        empleadoRepository.deleteById(id);
    }
}

