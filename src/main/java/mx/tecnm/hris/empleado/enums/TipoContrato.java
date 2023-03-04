package mx.tecnm.hris.empleado.enums;

public enum TipoContrato {
    BASE("BASE"),
    INTERINATO("INTERINATO"),
    PREJUBILACION("PREJUBILACIÓN");

    private final String nombre;

    TipoContrato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
