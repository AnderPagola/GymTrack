package domain;

import java.time.LocalDate;

public class Objetivo {
    private String descripcion;
    private String tipo;
    private double valorInicial;
    private double valorObjetivo;
    private double valorActual;
    private LocalDate fechaLimite;
    private EstadoObjetivo estado;

    public Objetivo(String descripcion, String tipo, double valorInicial, double valorObjetivo, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valorInicial = valorInicial;
        this.valorObjetivo = valorObjetivo;
        this.valorActual = valorInicial;
        this.fechaLimite = fechaLimite;
        this.estado = LocalDate.now().isAfter(fechaLimite) ? EstadoObjetivo.VENCIDO : EstadoObjetivo.EN_PROGRESO;
    }

    public void actualizarProgreso(double nuevoValor) {
        this.valorActual = nuevoValor;
        boolean alcanzado = (valorObjetivo >= valorInicial && valorActual >= valorObjetivo)
                         || (valorObjetivo < valorInicial && valorActual <= valorObjetivo);

        if (alcanzado) {
            this.estado = EstadoObjetivo.CUMPLIDO;
        } else if (LocalDate.now().isAfter(fechaLimite)) {
            this.estado = EstadoObjetivo.VENCIDO;
        } else {
            this.estado = EstadoObjetivo.EN_PROGRESO;
        }
    }

    public EstadoObjetivo getEstado() {
        if (estado == EstadoObjetivo.EN_PROGRESO && LocalDate.now().isAfter(fechaLimite)) {
            estado = EstadoObjetivo.VENCIDO;
        }
        return estado;
    }

    public double getPorcentajeProgreso() {
        if (getEstado() == EstadoObjetivo.CUMPLIDO) return 100.0;
        double rangoTotal = Math.abs(valorObjetivo - valorInicial);
        if (rangoTotal == 0) return 0.0;
        double avance = Math.abs(valorActual - valorInicial);
        return Math.min(100.0, Math.max(0.0, (avance / rangoTotal) * 100.0));
    }

   

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public double getValorObjetivo() {
		return valorObjetivo;
	}

	public void setValorObjetivo(double valorObjetivo) {
		this.valorObjetivo = valorObjetivo;
	}

	public double getValorActual() {
		return valorActual;
	}

	public void setValorActual(double valorActual) {
		this.valorActual = valorActual;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public void setEstado(EstadoObjetivo estado) {
		this.estado = estado;
	}

	@Override
    public String toString() {
        return descripcion + " [" + getEstado() + " - " + String.format("%.1f", getPorcentajeProgreso()) + "%]";
    }
}