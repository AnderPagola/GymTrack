package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import domain.Entrenamiento;
import domain.Recursos;

public class GestorEntrenamientos extends JFrame {
    private static final long serialVersionUID = 1L;

    // Lista donde guardamos los entrenamientos del dominio
    private ArrayList<Entrenamiento> entrenamientos;

    public GestorEntrenamientos() {
        entrenamientos = new ArrayList<>();
        Recursos.configurarAtajoCerrar(this);
    }

    // Añadimos el entrenamiento a la lista
    public void agregarEntrenamiento(Entrenamiento entrenamiento) {
        entrenamientos.add(entrenamiento);
    }

    // Obtener todos los entrenamientos registrados
    public ArrayList<Entrenamiento> obtenerEntrenamientos() {
        return new ArrayList<>(entrenamientos);
    }

    // Consultar cuántos entrenamientos hay en la lista
    public int contarEntrenamientos() {
        return entrenamientos.size();
    }
}