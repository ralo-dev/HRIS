package mx.tecnm.hris.departamentos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {

    Optional<DepartamentoEntity> findByNombre(String nombre);

    void deleteByNombre(String nombre);

    //find all departamentos but return only the employees that are Estado.ACTIVO
    @Query("SELECT d FROM DepartamentoEntity d JOIN FETCH d.empleados e WHERE e.estado = mx.tecnm.hris.empleados.enums.Estado.ACTIVO")
    List<DepartamentoEntity> findAllWithActiveEmployees();

    //find departamento by nombre but return only the employees that are Estado.ACTIVO
    @Query("SELECT d FROM DepartamentoEntity d JOIN FETCH d.empleados e WHERE d.nombre = ?1 AND e.estado = mx.tecnm.hris.empleados.enums.Estado.ACTIVO")
    Optional<DepartamentoEntity> findByNombreWithActiveEmployees(String nombre);

    //find departamento by id but return only the employees that are Estado.ACTIVO
    @Query("SELECT d FROM DepartamentoEntity d JOIN FETCH d.empleados e WHERE d.idDepartamento = ?1 AND e.estado = mx.tecnm.hris.empleados.enums.Estado.ACTIVO")
    Optional<DepartamentoEntity> findByIdWithActiveEmployees(Long id);


}
