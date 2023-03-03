package mx.tecnm.hris.empleado.enums;

public enum NivelAcademico {
    SUBESPECIALIDAD_MEDICA("SUBESPECIALIDAD MÉDICA"),
    DOCTORADO("DOCTORADO"),
    ESPECIALIDAD_MEDICA("ESPECIALIDAD MÉDICA"),
    MAESTRIA("MAESTRÍA"),
    ESPECIALIDAD("ESPECIALIDAD"),
    LICENCIATURA("LICENCIATURA"),
    TECNICO("TÉCNICO SUPERIOR"),
    BACHILLERATO("BACHILLERATO"),
    PRIMARIA("PRIMARIA"),
    SECUNDARIA("SECUNDARIA");

    private String nivelAcademico;

    NivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }
}
