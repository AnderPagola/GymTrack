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
        
        // Panel principal
        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(FONDO);

        // Crear las diferentes partes
        crearCabecera();
        crearContenido();
        crearNavegacion();

        setContentPane(panelPrincipal);
        setVisible(true);
    }



	// CABECERA
    private void crearCabecera() {

        JPanel cabecera = new JPanel(new BorderLayout());
        cabecera.setBackground(BLANCO);
        cabecera.setBorder(
            BorderFactory.createEmptyBorder(15, 25, 15, 25)
        );

        JLabel titulo = new JLabel("Mis Rutinas");
        titulo.setFont(new Font("Arial", Font.BOLD, 25));

        JButton configuracion = new JButton("O");
        configuracion.setFont(new Font("Arial", Font.PLAIN, 20));

        cabecera.add(titulo, BorderLayout.WEST);
        cabecera.add(configuracion, BorderLayout.EAST);

        panelPrincipal.add(cabecera, BorderLayout.NORTH);
    }
    
    //CONTENIDO PRINCIPAL
    private void crearContenido() {
        JPanel contenido = new JPanel();

        contenido.setLayout(
            new BoxLayout(contenido, BoxLayout.Y_AXIS)
        );

        contenido.setBackground(FONDO);

        contenido.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        crearPanelRutinas();
        crearPanelEjercicios();

        panelRutinas.setPreferredSize(new Dimension(400, 150));
        panelRutinas.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));

        panelEjercicios.setPreferredSize(new Dimension(400, 350));

        contenido.add(panelRutinas);
        contenido.add(Box.createVerticalStrut(20));
        contenido.add(panelEjercicios);

        panelPrincipal.add(contenido, BorderLayout.CENTER);
		
	}
    //PANEL DE RUTINAS
	private void crearPanelRutinas() {
		// TODO Auto-generated method stub
		
	}


	//PANEL DE EJERCICIOS
	private void crearPanelEjercicios() {
		// TODO Auto-generated method stub
		
	}


	//NAVEGACION INFERIOR
	private void crearNavegacion() {
		// TODO Auto-generated method stub
		
	}

}

