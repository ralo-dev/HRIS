package mx.tecnm.hris.puestos;

import mx.tecnm.hris.departamentos.DepartamentoEntity;
import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.puestos.enums.Categoria;
import mx.tecnm.hris.puestos.enums.TipoPlaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;

import java.util.Optional;

public interface PuestoRepository extends JpaRepository<PuestoEntity, Long> {

    Optional<PuestoEntity> findByClavePresupuestal(String clavePresupuestal);
    Streamable<PuestoEntity> findByEmpleado(EmpleadoEntity empleado);
    Streamable<PuestoEntity> findByCategoria(Categoria categoria);
    Streamable<PuestoEntity> findByTipoPlaza(TipoPlaza tipoPlaza);
    Streamable<PuestoEntity> findByActivo(boolean activo);

    @Query("SELECT p FROM PuestoEntity p WHERE p.activo = true AND p.empleado.departamento = ?1")
    Streamable<PuestoEntity> findActivosByDepartamento(DepartamentoEntity departamento);

    //find by activo = true and empleado rfc
    @Query("SELECT p FROM PuestoEntity p WHERE p.activo = true AND p.empleado.rfc = ?1")
    Streamable<PuestoEntity> findActivosByEmpleadoRfc(String rfc);

    //find by activo = true and categoria
    @Query("SELECT p FROM PuestoEntity p WHERE p.activo = true AND p.categoria = ?1")
    Streamable<PuestoEntity> findActivosByCategoria(Categoria categoria);

}
