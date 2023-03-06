package mx.tecnm.hris.puestos.enums;

public enum Categoria {
    TIEMPO_COMPLETO("TIEMPO COMPLETO"),
    TRES_CUARTOS("TRES CUARTOS DE TIEMPO"),
    MEDIO_TIEMPO("MEDIO TIEMPO"),
    HORAS_ASIGNATURA("HORAS DE ASIGNATURA");

    private final String categoria;

    private Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getJornada() {
        return categoria;
    }
}
