package progreso;

import java.time.LocalDate;


public class RegistroEntrenamiento {
	
	private String ejercicio;
	private double peso;
	private int series;
	private int repeticiones;
	private LocalDate fecha;
	
	public RegistroEntrenamiento(String ejercicio, double peso, int series, int repeticiones, LocalDate fecha) {
		
		this.ejercicio = ejercicio;
		this.peso = peso;
		this.series = series;
		this.repeticiones = repeticiones;
		this.fecha = fecha;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public double getPeso() {
		return peso;
	}

	public int getSeries() {
		return series;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
	
	

}
