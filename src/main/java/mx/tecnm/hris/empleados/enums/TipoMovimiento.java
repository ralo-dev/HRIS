package mx.tecnm.hris.empleados.enums;

public enum TipoMovimiento {
    BASE("BASE"),
    INTERINATO("INTERINATO"),
    PREJUBILACION("PREJUBILACIÓN");

    private final String nombre;

    TipoMovimiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
