package domain;

public enum EstadoObjetivo {
    EN_PROGRESO("En progreso"),
    CUMPLIDO("Cumplido"),
    VENCIDO("Vencido");

    private final String etiqueta;

    EstadoObjetivo(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}