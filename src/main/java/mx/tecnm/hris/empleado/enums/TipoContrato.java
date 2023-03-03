package mx.tecnm.hris.empleado.enums;

public enum TipoContrato {
    BASE("BASE"),
    INTERINATO("INTERINATO"),
    PREJUBILACION("PREJUBILACIÓN");

    private String tipoContrato;

    TipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

}
