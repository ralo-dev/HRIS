package mx.tecnm.hris.empleados;

import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoContrato;
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

    public Optional<EmpleadoEntity> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Optional<EmpleadoEntity> findByNumeroTarjeta(Long id) {
        return findById(id);
    }

    public Optional<EmpleadoEntity> findByRfc(String rfc) {
        return empleadoRepository.findByRfc(rfc);
    }

    public Optional<EmpleadoEntity> findByCurp(String curp) {
        return empleadoRepository.findByCurp(curp);
    }

    public List<EmpleadoEntity> findAll(){
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

    public List<EmpleadoEntity> findByTipoContrato(TipoContrato tipoContrato) {
        return empleadoRepository.findByTipoContrato(tipoContrato).stream().collect(Collectors.toList());
    }

    public void updateStatusByRfc(String rfc, Estado estado) {
        empleadoRepository.actualizarEstadoPorRfc(rfc, estado);
    }

    public void updateStatusByCurp(String curp, Estado estado) {
        empleadoRepository.actualizarEstadoPorCurp(curp, estado);
    }

    public void updateStatusById(Long id, Estado estado) {
        empleadoRepository.actualizarEstadoPorId(id, estado);
    }

    public List<EmpleadoEntity> findByNombreYSexo(String nombre, Sexo sexo) {
        return empleadoRepository.findByNombreAndSexo(nombre, sexo).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findByNivelAcademicoMayorIgual(NivelAcademico nivelAcademico) {
        return empleadoRepository.findByNivelAcademicoGreaterThanEqual(nivelAcademico).stream().collect(Collectors.toList());
    }

    public List<EmpleadoEntity> findByFechaIngresoBeforeAndEstadoEquals(LocalDate fecha, Estado estado) {
        return empleadoRepository.findByFechaIngresoBeforeAndEstadoEquals(fecha, estado).stream().collect(Collectors.toList());
    }

    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<EmpleadoEntity> saveAll(List<EmpleadoEntity> empleados) {
        return empleadoRepository.saveAll(empleados);
    }

    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}

