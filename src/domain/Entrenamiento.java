package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {
    private LocalDate fecha;
    private String titulo;
    private GrupoMuscular grupo;
    private int duracionMinutos;
    private List<Ejercicio> ejerciciosRealizados;
    private boolean superoMarcaAnterior;

    public Entrenamiento(LocalDate fecha, String titulo, GrupoMuscular grupo, int duracionMinutos, boolean superoMarcaAnterior) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.grupo = grupo;
        this.duracionMinutos = duracionMinutos;
        this.ejerciciosRealizados = new ArrayList<>();
        this.superoMarcaAnterior = superoMarcaAnterior;
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        this.ejerciciosRealizados.add(ejercicio);
    }
    //funcionas hechas con IA
    public double getPorcentajeCompletado() {
        if (grupo == GrupoMuscular.DESCANSO || ejerciciosRealizados.isEmpty()) return 100.0;
        long completados = ejerciciosRealizados.stream().filter(Ejercicio::isCompletado).count();
        return (completados * 100.0) / ejerciciosRealizados.size();
    }

    public String generarResumen() {
        if (grupo == GrupoMuscular.DESCANSO || ejerciciosRealizados.isEmpty()) {
            return titulo;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(titulo).append("\n\n");
        for (Ejercicio e : ejerciciosRealizados) {
            sb.append(e.isCompletado() ? "✓ " : "✕ ")
              .append(e.getNombre()).append("\n");
        }
        sb.append("\n")
          .append(superoMarcaAnterior ? "✓ " : "✕ ")
          .append("Mejor que último entrenamiento");
        return sb.toString();
    }
//Hasta aqui
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public GrupoMuscular getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoMuscular grupo) {
		this.grupo = grupo;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public List<Ejercicio> getEjerciciosRealizados() {
		return ejerciciosRealizados;
	}

	public void setEjerciciosRealizados(List<Ejercicio> ejerciciosRealizados) {
		this.ejerciciosRealizados = ejerciciosRealizados;
	}

	public boolean isSuperoMarcaAnterior() {
		return superoMarcaAnterior;
	}

	public void setSuperoMarcaAnterior(boolean superoMarcaAnterior) {
		this.superoMarcaAnterior = superoMarcaAnterior;
	}
    
}