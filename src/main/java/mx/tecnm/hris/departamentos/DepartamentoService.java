package mx.tecnm.hris.departamentos;

import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.empleados.enums.Estado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public DepartamentoEntity save(DepartamentoEntity departamentoEntity) {
        return departamentoRepository.save(departamentoEntity);
    }

    public DepartamentoEntity findById(Long id) {
        return departamentoRepository.findByIdWithActiveEmployees(id).orElse(null);
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }

    public List<DepartamentoEntity> findAll() {
        return departamentoRepository.findAllWithActiveEmployees();
    }

    public DepartamentoEntity findByNombre(String nombre) {
        return departamentoRepository.findByNombreWithActiveEmployees(nombre).orElse(null);
    }

    public void deleteByNombre(String nombre) {
        departamentoRepository.deleteByNombre(nombre);
    }

    public void updateJefeByDepartamento(EmpleadoEntity jefe, DepartamentoEntity departamento) {
        DepartamentoEntity ExistingDepartamento = departamentoRepository.findById(departamento.getIdDepartamento()).orElse(null);
        assert ExistingDepartamento != null;
        ExistingDepartamento.setJefeDepartamento(jefe);
        departamentoRepository.save(ExistingDepartamento);
    }
}
