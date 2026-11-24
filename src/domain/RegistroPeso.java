package domain;

import java.time.LocalDate;

public class RegistroPeso {
    private LocalDate fecha;
    private double pesoCorporal;
    private double porcentajeGrasa;

    public RegistroPeso(LocalDate fecha, double pesoCorporal, double porcentajeGrasa) {
        this.fecha = fecha;
        this.pesoCorporal = pesoCorporal;
        this.porcentajeGrasa = porcentajeGrasa;
    }

    
    public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public double getPesoCorporal() {
		return pesoCorporal;
	}


	public void setPesoCorporal(double pesoCorporal) {
		this.pesoCorporal = pesoCorporal;
	}


	public double getPorcentajeGrasa() {
		return porcentajeGrasa;
	}


	public void setPorcentajeGrasa(double porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}


	@Override
    public String toString() {
        return fecha + " -> " + pesoCorporal + " kg (" + porcentajeGrasa + "% grasa)";
    }
	
}