package mx.tecnm.hris.empleado.enums;

public enum Estado {
    ACTIVO("ACTIVO"),
    INACTIVO("INACTIVO"),
    BAJA("BAJA");

    private final String nombre;

    Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
