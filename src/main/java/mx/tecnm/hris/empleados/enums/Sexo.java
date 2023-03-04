package mx.tecnm.hris.empleados.enums;

public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMENINO("FEMENINO");

    private final String nombre;

    Sexo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
