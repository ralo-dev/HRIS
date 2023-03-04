package mx.tecnm.hris.empleado;

import mx.tecnm.hris.empleado.enums.Estado;
import mx.tecnm.hris.empleado.enums.NivelAcademico;
import mx.tecnm.hris.empleado.enums.Sexo;
import mx.tecnm.hris.empleado.enums.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    Streamable<EmpleadoEntity> findByTipoContrato(TipoContrato tipoContrato);

    // Modificación
    @Modifying
    @Query("UPDATE EmpleadoEntity e SET e.estado = :estado WHERE e.rfc = :rfc")
    void actualizarEstadoPorRfc(@Param("rfc") String rfc, @Param("estado") Estado estado);

    @Modifying
    @Query("UPDATE EmpleadoEntity e SET e.estado = :estado WHERE e.curp = :curp")
    void actualizarEstadoPorCurp(@Param("curp") String curp, @Param("estado") Estado estado);

    @Modifying
    @Query("UPDATE EmpleadoEntity e SET e.estado = :estado WHERE e.id = :id")
    void actualizarEstadoPorId(@Param("id") Long id, @Param("estado") Estado estado);

    // Otras consultas
    Streamable<EmpleadoEntity> findByNombreAndSexo(String nombre, Sexo sexo);

    Streamable<EmpleadoEntity> findByNivelAcademicoGreaterThanEqual(NivelAcademico nivelAcademico);

    Streamable<EmpleadoEntity> findByFechaIngresoBeforeAndEstadoEquals(LocalDate fecha, Estado estado);
}

