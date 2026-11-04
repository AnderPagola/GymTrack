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
		
        panelRutinas = new JPanel(new GridLayout(2, 1, 0, 10));
        panelRutinas.setBackground(FONDO);

        JButton pierna = crearBotonRutina(
            "PIERNA Y ABDOMEN",
            "Seleccionar rutina"
        );

        JButton torso = crearBotonRutina(
            "TORSO Y BRAZOS",
            "Seleccionar rutina"
        );

        pierna.addActionListener(e -> {
            rutinaSeleccionada = "Pierna y abdomen";
            actualizarEjercicios();
        });

        torso.addActionListener(e -> {
            rutinaSeleccionada = "Torso y brazos";
            actualizarEjercicios();
        });

        panelRutinas.add(pierna);
        panelRutinas.add(torso);
	}

	//ACTUALIZAR LA LISTA
	private void actualizarEjercicios() {
        modeloEjercicios.clear();

        ArrayList<String> ejercicios;

        if (rutinaSeleccionada.equals("Pierna y abdomen")) {
            ejercicios = ejerciciosPierna;
        } else {
            ejercicios = ejerciciosTorso;
        }

        for (String ejercicio : ejercicios) {
            modeloEjercicios.addElement(ejercicio);
        }
	}


	
	private JButton crearBotonRutina(String titulo, String texto) {
		JButton boton = new JButton(titulo + " - " + texto);
		boton.setFont(new Font("Arial", Font.PLAIN, 16));
		boton.setBackground(BLANCO);
		boton.setFocusPainted(false);
		boton.setBorder(
		BorderFactory.createLineBorder(new Color(220, 220, 220))
		);
		return boton;
	}



	//PANEL DE EJERCICIOS
	private void crearPanelEjercicios() {
        panelEjercicios = new JPanel(new BorderLayout(10, 10));
        panelEjercicios.setBackground(BLANCO);
        panelEjercicios.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(220, 220, 220)
                ),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
            )
        );

        // Título
        JLabel titulo = new JLabel("Ejercicios");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        panelEjercicios.add(titulo, BorderLayout.NORTH);

        // Lista
        modeloEjercicios = new DefaultListModel<>();
        listaEjercicios = new JList<>(modeloEjercicios);

        listaEjercicios.setFont(new Font("Arial", Font.PLAIN, 16));
        listaEjercicios.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scroll = new JScrollPane(listaEjercicios);

        panelEjercicios.add(scroll, BorderLayout.CENTER);

        // Botones
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botones.setBackground(BLANCO);

        JButton anadir = new JButton("Añadir");
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");

        botones.add(anadir);
        botones.add(editar);
        botones.add(eliminar);

        panelEjercicios.add(botones, BorderLayout.SOUTH);

        // Acciones
        anadir.addActionListener(e -> anadirEjercicio());

        editar.addActionListener(e -> editarEjercicio());

        eliminar.addActionListener(e -> eliminarEjercicio());

        actualizarEjercicios();
		
	}
	
	 //AÑADIR EJERCICIO                 FUNCION HECHA CON IA(CHATGPT)
	private void anadirEjercicio() {
        String nombre = JOptionPane.showInputDialog(
                this,
                "Introduce el nombre del ejercicio:"
            );

            if (nombre != null && !nombre.trim().isEmpty()) {

                obtenerEjercicios().add(nombre.trim());

                actualizarEjercicios();
            }
	}

	//DEVOLVER LA LISTA DE LOS EJERCICIOS SELECCIONADOS
	   private ArrayList<String> obtenerEjercicios() {

	        if (rutinaSeleccionada.equals("Pierna y abdomen")) {
	            return ejerciciosPierna;
	        } else {
	            return ejerciciosTorso;
	        }
	    }

	//ELIMINAR EJERCICIO
	private void eliminarEjercicio() {
	      int posicion = listaEjercicios.getSelectedIndex();

	        if (posicion == -1) {
	            JOptionPane.showMessageDialog(
	                this,
	                "Selecciona un ejercicio primero."
	            );
	            return;
	        }

	        obtenerEjercicios().remove(posicion);

	        actualizarEjercicios();
	}


	//EDITAR EJERCICIO
	private void editarEjercicio() {
        int posicion = listaEjercicios.getSelectedIndex();

        if (posicion == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Selecciona un ejercicio primero."
            );
            return;
        }

        String nombreAnterior = listaEjercicios.getSelectedValue();

        String nombreNuevo = JOptionPane.showInputDialog(
            this,
            "Nuevo nombre:",
            nombreAnterior
        );

        if (nombreNuevo != null && !nombreNuevo.trim().isEmpty()) {

            obtenerEjercicios().set(posicion, nombreNuevo.trim());

            actualizarEjercicios();
        }
		
	}


	//NAVEGACION INFERIOR
	private void crearNavegacion() {
	       JPanel navegacion = new JPanel(new GridLayout(1, 4));
	        navegacion.setBackground(BLANCO);
	        navegacion.setBorder(
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)
	        );

	        JButton entrenar = new JButton("Entrenar");
	        JButton rutinas = new JButton("Mis Rutinas");
	        JButton progreso = new JButton("Progreso");
	        JButton perfil = new JButton("Perfil");

	        rutinas.setForeground(AZUL);

	        navegacion.add(entrenar);
	        navegacion.add(rutinas);
	        navegacion.add(progreso);
	        navegacion.add(perfil);

	        panelPrincipal.add(navegacion, BorderLayout.SOUTH);
		
	}

}

