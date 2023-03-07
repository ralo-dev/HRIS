package mx.tecnm.hris.departamentos;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {
    DepartamentoEntity findByNombre(String nombre);

    void deleteByNombre(String nombre);
}
