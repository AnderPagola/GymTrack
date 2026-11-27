package domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class PlanRutina {
    private String nombre;
    private String descripcion;
    private GrupoMuscular grupoPrincipal;
    private DayOfWeek diaAsignado;
    private List<Ejercicio> ejercicios;

    public PlanRutina(String nombre, String descripcion, GrupoMuscular grupoPrincipal, DayOfWeek diaAsignado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupoPrincipal = grupoPrincipal;
        this.diaAsignado = diaAsignado;
        this.ejercicios = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        this.ejercicios.add(ejercicio);
    }

    public void eliminarEjercicio(Ejercicio ejercicio) {
        this.ejercicios.remove(ejercicio);
    }

    public double calcularVolumenTotal() {
        double total = 0;
        for (Ejercicio e : ejercicios) {
            total += e.calcularVolumen();
        }
        return total;
    }

    

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public GrupoMuscular getGrupoPrincipal() {
		return grupoPrincipal;
	}

	public void setGrupoPrincipal(GrupoMuscular grupoPrincipal) {
		this.grupoPrincipal = grupoPrincipal;
	}

	public DayOfWeek getDiaAsignado() {
		return diaAsignado;
	}

	public void setDiaAsignado(DayOfWeek diaAsignado) {
		this.diaAsignado = diaAsignado;
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	@Override
    public String toString() {
        return nombre + " - " + grupoPrincipal + " (" + ejercicios.size() + " ejercicios)";
    }
}