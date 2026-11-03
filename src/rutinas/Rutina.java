package rutinas;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Rutina extends JFrame {

    // Colores
    private final Color AZUL = new Color(65, 85, 220);
    private final Color FONDO = new Color(245, 246, 250);
    private final Color BLANCO = Color.WHITE;

    // Paneles principales
    private JPanel panelPrincipal;
    private JPanel panelRutinas;
    private JPanel panelEjercicios;

    // Lista de ejercicios
    private DefaultListModel<String> modeloEjercicios;
    private JList<String> listaEjercicios;

    // Rutina seleccionada
    private String rutinaSeleccionada = "Pierna y abdomen";

    // Datos de ejemplo
    private ArrayList<String> ejerciciosPierna = new ArrayList<>();
    private ArrayList<String> ejerciciosTorso = new ArrayList<>();

    public Rutina() {

        setTitle("GYMTRACK - Gestión de rutinas");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Datos iniciales
        ejerciciosPierna.add("Prensa inclinada");
        ejerciciosPierna.add("Extension de cuadriceps");
        ejerciciosPierna.add("Curl de pierna");

        ejerciciosTorso.add("Press banca");
        ejerciciosTorso.add("Jalón al pecho");
        ejerciciosTorso.add("Curl de bíceps");

    }
}
