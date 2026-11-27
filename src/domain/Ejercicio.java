package domain;

public class Ejercicio {
    private String nombre;
    private GrupoMuscular grupoMuscular;
    private int series;
    private int repeticiones;
    private double pesoKg;
    private boolean completado;

    public Ejercicio(String nombre, GrupoMuscular grupoMuscular, int series, int repeticiones, double pesoKg) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticiones = repeticiones;
        this.pesoKg = pesoKg;
        this.completado = false;
    }

    public Ejercicio(String nombre, GrupoMuscular grupoMuscular, boolean completado) {
        this(nombre, grupoMuscular, 0, 0, 0.0);
        this.completado = completado;
    }

    public double calcularVolumen() {
        return series * repeticiones * pesoKg;
    }

   

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	@Override
    public String toString() {
        if (series > 0 && repeticiones > 0) {
            return nombre + " [" + grupoMuscular + "] (" + series + "x" + repeticiones + " - " + pesoKg + " kg)";
        }
        return nombre + " [" + grupoMuscular + "]";
    }
}