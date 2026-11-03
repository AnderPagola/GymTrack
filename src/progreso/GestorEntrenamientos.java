package progreso;

import java.util.ArrayList;

public class GestorEntrenamientos {
	
	//Creamos la lista donde guardaremos los registros
	private ArrayList<RegistroEntrenamiento> entrenamientos;
	
	public GestorEntrenamientos() {
		entrenamientos = new ArrayList<>();
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
