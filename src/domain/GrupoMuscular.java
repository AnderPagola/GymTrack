package domain;

public enum GrupoMuscular {
    PIERNA("Pierna"),
    PECHO("Pecho"),
    ESPALDA("Espalda"),
    HOMBRO("Hombro"),
    BRAZOS("Brazos"),
    CARDIO("Cardio"),
    DESCANSO("Descanso");

    private final String etiqueta;

    GrupoMuscular(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}