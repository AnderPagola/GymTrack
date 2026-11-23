package gui;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import domain.Recursos;

public class GestorEntrenamientos extends JFrame{
	
	//Creamos la lista donde guardaremos los registros
	private ArrayList<RegistroEntrenamiento> entrenamientos;
	
	public GestorEntrenamientos() {
		entrenamientos = new ArrayList<>();
		Recursos.configurarAtajoCerrar(this);
	}
	
	//Añadimos el entrenamiento a la lista
	public void agregarEntrenamiento(RegistroEntrenamiento registro) {
		entrenamientos.add(registro);
	}

	//Obtener todos los entrenamientos registrados
	public ArrayList<RegistroEntrenamiento> obtenerEntrenamientos(){
		return new ArrayList<>(entrenamientos);
	}
	
	//Consultar cuantos entrenamientos hay en la lista
	public int contarEntrenamientos() {
		return entrenamientos.size();
	}
	
	
}
