package mx.tecnm.hris;

import mx.tecnm.hris.departamentos.DepartamentoEntity;
import mx.tecnm.hris.departamentos.DepartamentoService;
import mx.tecnm.hris.empleados.EmpleadoEntity;
import mx.tecnm.hris.empleados.EmpleadoService;
import mx.tecnm.hris.empleados.enums.Estado;
import mx.tecnm.hris.empleados.enums.NivelAcademico;
import mx.tecnm.hris.empleados.enums.Sexo;
import mx.tecnm.hris.empleados.enums.TipoMovimiento;
import mx.tecnm.hris.puestos.PuestoEntity;
import mx.tecnm.hris.puestos.PuestoService;
import mx.tecnm.hris.puestos.enums.Categoria;
import mx.tecnm.hris.puestos.enums.TipoPlaza;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final DepartamentoService departamentoService;
    private final EmpleadoService empleadoService;
    private final PuestoService puestoService;

    public DataLoader(DepartamentoService departamentoService, EmpleadoService empleadoService, PuestoService puestoService) {
        this.departamentoService = departamentoService;
        this.empleadoService = empleadoService;
        this.puestoService = puestoService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create some departments
        DepartamentoEntity departamento1 = (new DepartamentoEntity("Sistemas y Computación"));
        DepartamentoEntity departamento2 = (new DepartamentoEntity("Electrica"));
        DepartamentoEntity departamento3 = (new DepartamentoEntity("Electronica"));
        DepartamentoEntity departamento4 = (new DepartamentoEntity("Recursos Humanos"));
        DepartamentoEntity departamento5 = (new DepartamentoEntity("Servicios Escolares"));
        departamentoService.save(departamento1);
        departamentoService.save(departamento2);
        departamentoService.save(departamento3);
        departamentoService.save(departamento4);
        departamentoService.save(departamento5);
        // Create some employees
        EmpleadoEntity empleado1 = (new EmpleadoEntity("RFC1", "CURP1", "correo1@institucional.com", "Empleado1", NivelAcademico.LICENCIATURA, "Profesión1", Sexo.MASCULINO, LocalDate.of(2022, 1, 1), null, null, Estado.ACTIVO, null, TipoMovimiento.BASE, departamento1));
        EmpleadoEntity empleado2 = (new EmpleadoEntity("RFC2", "CURP2", "correo2@institucional.com", "Empleado2", NivelAcademico.LICENCIATURA, "Profesión2", Sexo.FEMENINO, LocalDate.of(2022, 1, 2), null, null, Estado.ACTIVO, null, TipoMovimiento.INTERINATO, departamento1));
        EmpleadoEntity empleado3 = (new EmpleadoEntity("RFC3", "CURP3", "correo3@institucional.com", "Empleado3", NivelAcademico.DOCTORADO, "Profesión3", Sexo.MASCULINO, LocalDate.of(2022, 1, 3), null, null, Estado.ACTIVO, null, TipoMovimiento.BASE, departamento2));
        EmpleadoEntity empleado4 = (new EmpleadoEntity("RFC4", "CURP4", "correo4@institucional.com", "Empleado4", NivelAcademico.DOCTORADO, "Profesión4", Sexo.FEMENINO, LocalDate.of(2022, 1, 4), null, null, Estado.ACTIVO, "Comentarios4", TipoMovimiento.BASE, departamento2));
        EmpleadoEntity empleado5 = (new EmpleadoEntity("RFC5", "CURP5", "correo5@institucional.com", "Empleado5", NivelAcademico.DOCTORADO, "Profesión5", Sexo.MASCULINO, LocalDate.of(2022, 1, 5), null, null, Estado.ACTIVO, "Comentarios5", TipoMovimiento.BASE, departamento3));
        EmpleadoEntity empleado6 = (new EmpleadoEntity("RFC6", "CURP6", "correo6@institucional.com", "Empleado6", NivelAcademico.MAESTRIA, "Profesión6", Sexo.FEMENINO, LocalDate.of(2022, 1, 6), null, null, Estado.ACTIVO, null, TipoMovimiento.INTERINATO, departamento3));
        EmpleadoEntity empleado7 = (new EmpleadoEntity("RFC7", "CURP7", "correo7@institucional.com", "Empleado7", NivelAcademico.MAESTRIA, "Profesión7", Sexo.MASCULINO, LocalDate.of(2022, 1, 7), null, null, Estado.ACTIVO, null, TipoMovimiento.BASE, departamento4));
        EmpleadoEntity empleado8 = (new EmpleadoEntity("RFC8", "CURP8", "correo8@institucional.com", "Empleado8", NivelAcademico.MAESTRIA, "Profesión8", Sexo.FEMENINO, LocalDate.of(2022, 1, 8), null, null, Estado.ACTIVO, null, TipoMovimiento.INTERINATO, departamento4));
        EmpleadoEntity empleado9 = (new EmpleadoEntity("RFC9", "CURP9", "correo9@institucional.com", "Empleado9", NivelAcademico.LICENCIATURA, "Profesión9", Sexo.MASCULINO, LocalDate.of(2022, 1, 9), null, null, Estado.ACTIVO, "Comentarios9", TipoMovimiento.BASE, departamento5));
        EmpleadoEntity empleado10 = (new EmpleadoEntity("RFC10", "CURP10", "correo10@institucional.com", "Empleado10", NivelAcademico.LICENCIATURA, "Profesión10", Sexo.FEMENINO, LocalDate.of(2022, 1, 10), null, null, Estado.ACTIVO, "Comentarios10", TipoMovimiento.BASE, departamento5));
        empleadoService.save(empleado1);
        empleadoService.save(empleado2);
        empleadoService.save(empleado3);
        empleadoService.save(empleado4);
        empleadoService.save(empleado5);
        empleadoService.save(empleado6);
        empleadoService.save(empleado7);
        empleadoService.save(empleado8);
        empleadoService.save(empleado9);
        empleadoService.save(empleado10);
        // Set the department boss
        departamentoService.updateJefeByDepartamento(empleado1, departamento1);
        departamentoService.updateJefeByDepartamento(empleado3, departamento2);
        departamentoService.updateJefeByDepartamento(empleado5, departamento3);
        departamentoService.updateJefeByDepartamento(empleado7, departamento4);
        departamentoService.updateJefeByDepartamento(empleado9, departamento5);
        // Create some positions
        PuestoEntity puesto1 = (new PuestoEntity(1L, empleado1, "CP-001", TipoPlaza.E3813, Categoria.TIEMPO_COMPLETO, 40, true));
        PuestoEntity puesto2 = (new PuestoEntity(2L, empleado2, "CP-002", TipoPlaza.E3613, Categoria.MEDIO_TIEMPO, 40, true));
        PuestoEntity puesto3 = (new PuestoEntity(3L, empleado3, "CP-003", TipoPlaza.E3813, Categoria.TIEMPO_COMPLETO, 40, true));
        PuestoEntity puesto4 = (new PuestoEntity(4L, empleado4, "CP-004", TipoPlaza.E3613, Categoria.MEDIO_TIEMPO, 40, true));
        PuestoEntity puesto5 = (new PuestoEntity(5L, empleado5, "CP-005", TipoPlaza.E3813, Categoria.TIEMPO_COMPLETO, 40, true));
        PuestoEntity puesto6 = (new PuestoEntity(6L, empleado6, "CP-006", TipoPlaza.E3613, Categoria.MEDIO_TIEMPO, 40, true));
        PuestoEntity puesto7 = (new PuestoEntity(7L, empleado7, "CP-007", TipoPlaza.E3813, Categoria.TIEMPO_COMPLETO, 40, true));
        PuestoEntity puesto8 = (new PuestoEntity(8L, empleado8, "CP-008", TipoPlaza.E3709, Categoria.TRES_CUARTOS, 40, true));
        PuestoEntity puesto9 = (new PuestoEntity(9L, empleado9, "CP-009", TipoPlaza.E3709, Categoria.TIEMPO_COMPLETO, 40, true));
        PuestoEntity puesto10 = (new PuestoEntity(10L, empleado10, "CP-010", TipoPlaza.E3709, Categoria.TRES_CUARTOS, 40, true));
        puestoService.save(puesto1);
        puestoService.save(puesto2);
        puestoService.save(puesto3);
        puestoService.save(puesto4);
        puestoService.save(puesto5);
        puestoService.save(puesto6);
        puestoService.save(puesto7);
        puestoService.save(puesto8);
        puestoService.save(puesto9);
        puestoService.save(puesto10);
    }
}