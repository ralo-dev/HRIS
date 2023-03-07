package mx.tecnm.hris.puestos;

import mx.tecnm.hris.departamentos.DepartamentoEntity;
import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.puestos.enums.Categoria;
import mx.tecnm.hris.puestos.enums.TipoPlaza;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService {
    private final PuestoRepository puestoRepository;

    public PuestoService(PuestoRepository puestoRepository) {
        this.puestoRepository = puestoRepository;
    }

    public Optional<PuestoEntity> findByClavePresupuestal(String clavePresupuestal) {
        return puestoRepository.findByClavePresupuestal(clavePresupuestal);
    }

    public Streamable<PuestoEntity> findByEmpleado(EmpleadoEntity empleado) {
        return puestoRepository.findByEmpleado(empleado);
    }

    public Streamable<PuestoEntity> findByCategoria(Categoria categoria) {
        return puestoRepository.findByCategoria(categoria);
    }

    public Streamable<PuestoEntity> findByTipoPlaza(TipoPlaza tipoPlaza) {
        return puestoRepository.findByTipoPlaza(tipoPlaza);
    }

    public Streamable<PuestoEntity> findByActivo(boolean activo) {
        return puestoRepository.findByActivo(activo);
    }

    public Streamable<PuestoEntity> findActivosByDepartamento(DepartamentoEntity departamento) {
        return puestoRepository.findActivosByDepartamento(departamento);
    }

    public Streamable<PuestoEntity> findActivosByEmpleadoRfc(String rfc) {
        return puestoRepository.findActivosByEmpleadoRfc(rfc);
    }

    public Streamable<PuestoEntity> findActivosByCategoria(Categoria categoria) {
        return puestoRepository.findActivosByCategoria(categoria);
    }

    public List<PuestoEntity> findAll() {
        return puestoRepository.findAll();
    }

    public PuestoEntity save(PuestoEntity puestoEntity) {
        return puestoRepository.save(puestoEntity);
    }

    public void delete(PuestoEntity puestoEntity) {
        puestoRepository.delete(puestoEntity);
    }

    public void deleteById(Long id) {
        puestoRepository.deleteById(id);
    }

    public Optional<PuestoEntity> findById(Long id) {
        return puestoRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return puestoRepository.existsById(id);
    }

}
