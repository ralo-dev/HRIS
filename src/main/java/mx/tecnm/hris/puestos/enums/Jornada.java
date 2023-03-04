package mx.tecnm.hris.puestos.enums;

public enum Jornada {
    TIEMPO_COMPLETO("TIEMPO COMPLETO"),
    TRES_CUARTOS("TRES CUARTOS DE TIEMPO"),
    MEDIO_TIEMPO("MEDIO TIEMPO"),
    HORAS_ASIGNATURA("HORAS DE ASIGNATURA");

    private String jornada;

    private Jornada(String jornada) {
        this.jornada = jornada;
    }

    public String getJornada() {
        return jornada;
    }
}
