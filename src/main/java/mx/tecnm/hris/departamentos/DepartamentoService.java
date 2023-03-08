package mx.tecnm.hris.departamentos;

import mx.tecnm.hris.empleados.EmpleadoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return departamentoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }

    public List<DepartamentoEntity> findAll() {
        return departamentoRepository.findAll();
    }

    public DepartamentoEntity findByNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
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
