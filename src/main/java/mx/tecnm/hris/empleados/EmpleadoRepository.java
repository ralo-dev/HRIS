package mx.tecnm.hris.empleados;

import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

    // Búsquedas de un único resultado
    Optional<EmpleadoEntity> findByRfc(String rfc);

    Optional<EmpleadoEntity> findByCurp(String curp);

    // Búsquedas de muchos resultados
    Streamable<EmpleadoEntity> findByDepartamento_IdDepartamento(Long departamentoId);

    Streamable<EmpleadoEntity> findByNombreContainingIgnoreCase(String nombre);

    Streamable<EmpleadoEntity> findByEstado(Estado estado);

    Streamable<EmpleadoEntity> findByNivelAcademico(NivelAcademico nivelAcademico);

    Streamable<EmpleadoEntity> findBySexo(Sexo sexo);

    Streamable<EmpleadoEntity> findByTipoContrato(TipoMovimiento tipoMovimiento);

    // Modificación
    @Modifying
    @Query("UPDATE EmpleadoEntity e SET e.estado = :estado WHERE e.rfc = :rfc")
    int actualizarEstadoPorRfc(@Param("rfc") String rfc, @Param("estado") Estado estado);

    @Modifying
    @Query("UPDATE EmpleadoEntity e SET e.estado = :estado WHERE e.curp = :curp")
    int actualizarEstadoPorCurp(@Param("curp") String curp, @Param("estado") Estado estado);

    @Modifying
    @Query("UPDATE EmpleadoEntity e SET e.estado = :estado WHERE e.id = :id")
    int actualizarEstadoPorId(@Param("id") Long id, @Param("estado") Estado estado);

    // Otras consultas
    Streamable<EmpleadoEntity> findByNivelAcademicoGreaterThanEqual(NivelAcademico nivelAcademico);
}

