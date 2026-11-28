package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.DayOfWeek;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import domain.Ejercicio;
import domain.GrupoMuscular;
import domain.PlanRutina;
import domain.Recursos;

public class Rutina extends JFrame {
    private static final long serialVersionUID = 1L;

    // Colores
    private final Color AZUL = new Color(65, 85, 220);
    private final Color FONDO = new Color(245, 246, 250);
    private final Color BLANCO = Color.WHITE;

    // Paneles principales
    private JPanel panelPrincipal;
    private JPanel panelRutinas;
    private JPanel panelEjercicios;

    // Lista de ejercicios del dominio
    private DefaultListModel<Ejercicio> modeloEjercicios;
    private JList<Ejercicio> listaEjercicios;

    // Rutinas del dominio
    private PlanRutina rutinaPierna;
    private PlanRutina rutinaTorso;
    private PlanRutina rutinaSeleccionada;
    
    //Hilos y temporizador
    private JLabel lblTiempo = new JLabel("02:30");
    private static Thread hiloDescanso;
    private static int segundos = 150;
    private static Rutina ventanaActual;
    private static boolean iniciado = false;
    
    private JButton iniciar = new JButton("Iniciar");
    private JButton parar = new JButton("Pausar");
    private JButton reiniciar = new JButton("Reiniciar");

    public Rutina() {
        setTitle("GYMTRACK - Gestión de rutinas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicialización de objetos PlanRutina y Ejercicio de domain
        rutinaPierna = new PlanRutina("Pierna y abdomen", "Entrenamiento de tren inferior", GrupoMuscular.PIERNA, DayOfWeek.MONDAY);
        rutinaPierna.agregarEjercicio(new Ejercicio("Prensa inclinada", GrupoMuscular.PIERNA, 4, 12, 120.0));
        rutinaPierna.agregarEjercicio(new Ejercicio("Extensión de cuádriceps", GrupoMuscular.PIERNA, 3, 15, 45.0));
        rutinaPierna.agregarEjercicio(new Ejercicio("Curl de pierna", GrupoMuscular.PIERNA, 3, 12, 40.0));

        rutinaTorso = new PlanRutina("Torso y brazos", "Entrenamiento de tren superior", GrupoMuscular.PECHO, DayOfWeek.WEDNESDAY);
        rutinaTorso.agregarEjercicio(new Ejercicio("Press banca", GrupoMuscular.PECHO, 4, 8, 80.0));
        rutinaTorso.agregarEjercicio(new Ejercicio("Jalón al pecho", GrupoMuscular.ESPALDA, 4, 10, 60.0));
        rutinaTorso.agregarEjercicio(new Ejercicio("Curl de bíceps", GrupoMuscular.BRAZOS, 3, 12, 15.0));

        rutinaSeleccionada = rutinaPierna;

        // Panel principal
        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(FONDO);

        crearCabecera();
        crearContenido();

        setContentPane(panelPrincipal);
        add(Recursos.crearPanelSur(this, "Mis Rutinas"), BorderLayout.SOUTH);
        Recursos.configurarAtajoCerrar(this);

        setVisible(true);
    }

    // CABECERA
    private void crearCabecera() {
        JPanel cabecera = new JPanel(new BorderLayout());
        cabecera.setBackground(BLANCO);
        cabecera.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        JLabel titulo = new JLabel("Mis Rutinas");
        titulo.setFont(new Font("Arial", Font.BOLD, 25));

        cabecera.add(titulo, BorderLayout.WEST);
        panelPrincipal.add(cabecera, BorderLayout.NORTH);
    }

    // CONTENIDO PRINCIPAL
    private void crearContenido() {
        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBackground(FONDO);
        contenido.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        crearPanelRutinas();
        crearPanelEjercicios();

        panelRutinas.setPreferredSize(new Dimension(400, 150));
        panelRutinas.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        panelEjercicios.setPreferredSize(new Dimension(400, 350));

        contenido.add(panelRutinas);
        contenido.add(Box.createVerticalStrut(20));
        contenido.add(panelEjercicios);

        panelPrincipal.add(contenido, BorderLayout.CENTER);
        
        //hilos
        contenido.add(Box.createVerticalStrut(10));
        contenido.add(crearPanelDescanso());
        
        panelPrincipal.add(contenido, BorderLayout.CENTER);
    }

    // PANEL DE RUTINAS
    private void crearPanelRutinas() {
        panelRutinas = new JPanel(new GridLayout(2, 1, 0, 10));
        panelRutinas.setBackground(FONDO);

        JButton pierna = crearBotonRutina(rutinaPierna.getNombre().toUpperCase(), "Seleccionar rutina");
        JButton torso = crearBotonRutina(rutinaTorso.getNombre().toUpperCase(), "Seleccionar rutina");

        pierna.addActionListener(e -> {
            rutinaSeleccionada = rutinaPierna;
            actualizarEjercicios();
        });

        torso.addActionListener(e -> {
            rutinaSeleccionada = rutinaTorso;
            actualizarEjercicios();
        });

        panelRutinas.add(pierna);
        panelRutinas.add(torso);
    }

    // ACTUALIZAR LA LISTA
    private void actualizarEjercicios() {
        modeloEjercicios.clear();
        for (Ejercicio ejercicio : rutinaSeleccionada.getEjercicios()) {
            modeloEjercicios.addElement(ejercicio);
        }
    }

    private JButton crearBotonRutina(String titulo, String texto) {
        JButton boton = new JButton(titulo + " - " + texto);
        boton.setFont(new Font("Arial", Font.PLAIN, 16));
        boton.setBackground(BLANCO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        return boton;
    }

    // PANEL DE EJERCICIOS
    private void crearPanelEjercicios() {
        panelEjercicios = new JPanel(new BorderLayout(10, 10));
        panelEjercicios.setBackground(BLANCO);
        panelEjercicios.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
            )
        );

        JLabel titulo = new JLabel("Ejercicios");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panelEjercicios.add(titulo, BorderLayout.NORTH);

        modeloEjercicios = new DefaultListModel<>();
        listaEjercicios = new JList<>(modeloEjercicios);
        listaEjercicios.setFont(new Font("Arial", Font.PLAIN, 16));
        listaEjercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(listaEjercicios);
        panelEjercicios.add(scroll, BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botones.setBackground(BLANCO);

        JButton anadir = new JButton("Añadir");
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");

        botones.add(anadir);
        botones.add(editar);
        botones.add(eliminar);

        panelEjercicios.add(botones, BorderLayout.SOUTH);

        anadir.addActionListener(e -> anadirEjercicio());
        editar.addActionListener(e -> editarEjercicio());
        eliminar.addActionListener(e -> eliminarEjercicio());

        actualizarEjercicios();
    }

    // AÑADIR EJERCICIO DEL DOMINIO
    private void anadirEjercicio() {
        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre del ejercicio:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            GrupoMuscular grupo = (GrupoMuscular) JOptionPane.showInputDialog(
                this,
                "Selecciona el grupo muscular:",
                "Grupo Muscular",
                JOptionPane.QUESTION_MESSAGE,
                null,
                GrupoMuscular.values(),
                rutinaSeleccionada.getGrupoPrincipal()
            );

            if (grupo != null) {
                Ejercicio nuevo = new Ejercicio(nombre.trim(), grupo, 3, 10, 20.0);
                rutinaSeleccionada.agregarEjercicio(nuevo);
                actualizarEjercicios();
            }
        }
    }

    // ELIMINAR EJERCICIO DEL DOMINIO
    private void eliminarEjercicio() {
        Ejercicio seleccionado = listaEjercicios.getSelectedValue();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un ejercicio primero.");
            return;
        }
        rutinaSeleccionada.eliminarEjercicio(seleccionado);
        actualizarEjercicios();
    }

    // EDITAR EJERCICIO DEL DOMINIO
    private void editarEjercicio() {
        Ejercicio seleccionado = listaEjercicios.getSelectedValue();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un ejercicio primero.");
            return;
        }

        String nombreNuevo = JOptionPane.showInputDialog(this, "Nuevo nombre:", seleccionado.getNombre());
        if (nombreNuevo != null && !nombreNuevo.trim().isEmpty()) {
            seleccionado.setNombre(nombreNuevo.trim());
            actualizarEjercicios();
        }
    }
    
    //=========================================================
    // IMPLEMENTACIÓN DE HILOS
    // Crear panel de descanso
	 private JPanel crearPanelDescanso() {
	     JPanel panel = new JPanel(new FlowLayout());
	
	     ventanaActual = this;
	
	     lblTiempo.setFont(new Font("Arial", Font.BOLD, 24));
	
	     panel.add(new JLabel("Descanso:"));
	     panel.add(lblTiempo);
	     panel.add(iniciar);
	     panel.add(parar);
	     panel.add(reiniciar);
	
	     iniciar.addActionListener(e -> {
	         iniciado = true;
	         iniciarDescanso();
	         actualizarTiempo();
	     });
	
	     parar.addActionListener(e -> {
	         if (hiloDescanso != null) {
	             pararDescanso();
	         } else {
	             iniciarDescanso();
	         }
	
	         actualizarTiempo();
	     });
	
	     reiniciar.addActionListener(e -> {
	         pararDescanso();
	         segundos = 150;
	         iniciado = false;
	         actualizarTiempo();
	     });
	
	     actualizarTiempo();
	
	     return panel;
	 }
	
	// Parte de función corregida con IA(chatGPT)
	// Iniciar descanso
	private void iniciarDescanso() {
	
	  if (hiloDescanso != null) {
	      return;
	  }
	
	  if (segundos == 0) {
	      segundos = 60;
	      actualizarTiempo();
	  }
	
	  hiloDescanso = new Thread(() -> {
	
	      Thread actual = Thread.currentThread();
	
	      while (!actual.isInterrupted()) {
	
	          try {
	              Thread.sleep(1000);
	          } catch (InterruptedException e) {
	              return;
	          }
	
	          SwingUtilities.invokeLater(() -> {
	
	              if (hiloDescanso == actual) {
	
	                  segundos--;
	
	                  if (segundos == 0){
	                	  pararDescanso();
	                      iniciado = false;
	                  }
	
	                  if (ventanaActual != null) {
	                      ventanaActual.actualizarTiempo();
	                  }
	              }
	          });
	      }
	  });
	
	  hiloDescanso.setDaemon(true);
	  hiloDescanso.start();
	}
	
	// Pausar el temporizador
	private static void pararDescanso() {
	    if (hiloDescanso != null) {
	        hiloDescanso.interrupt();
	        hiloDescanso = null;
	    }
	}
	// Función hecha con IA(chatGPT)
	// Actualizar los minutos y segundos del JLabel
	private void actualizarTiempo() {
	    lblTiempo.setText(String.format("%02d:%02d",
	            segundos / 60, segundos % 60));

	    iniciar.setEnabled(!iniciado);
	    parar.setEnabled(iniciado);

	    if (hiloDescanso != null) {
	        parar.setText("Pausar");
	    } else {
	        parar.setText("Continuar");
	    }

	    if (!iniciado) {
	        parar.setText("Pausar");
	    }
	}
	
	// Cerrar la ventana sin detener el temporizador
	@Override
	public void dispose() {
	    if (ventanaActual == this) {
	        ventanaActual = null;
	    }
	
	    super.dispose();
	  }
	}