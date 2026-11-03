package progreso;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class VentanaRegistro extends JFrame{

	private JTextField campoEjercicio;
	private JTextField campoPeso;
	private JTextField campoSeries;
	private JTextField campoRepes;
	private JTextField campoFecha;
	
	//Gestor que administra los entrenamientos
	private static GestorEntrenamientos gestor = new GestorEntrenamientos();
	
	public VentanaRegistro() {
		
		setTitle("GymTrack - Registrar entrenamiento");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Panel principal
		JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
		
		
		//titulo de la ventana
		JLabel titulo = new JLabel("Registrar entrenamiento", SwingConstants.CENTER); 
		
		titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
		panelPrincipal.add(titulo, BorderLayout.NORTH);
		
		
		//Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(5,2,10,15));
				
		panelFormulario.add(new Label("Ejercicio: "));
		campoEjercicio = new JTextField();
		panelFormulario.add(campoEjercicio);
		
		panelFormulario.add(new JLabel("Peso (kg): "));
		campoPeso = new JTextField();
		panelFormulario.add(campoPeso);
		
		panelFormulario.add(new JLabel("Series: "));
        campoSeries = new JTextField();
        panelFormulario.add(campoSeries);
        
        panelFormulario.add(new JLabel("Repeticiones: "));
        campoRepes = new JTextField();
        panelFormulario.add(campoRepes);
		
		panelFormulario.add(new JLabel("Fecha (AAAA-MM-DD): "));
		campoFecha = new JTextField();
		panelFormulario.add(campoFecha);
		
		panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
		
		
		
		//Panel de botones
		JPanel panelBotones = new JPanel(new FlowLayout());
		
		JButton botonGuardar = new JButton("Guardar entrenamiento");
		JButton botonCancelar = new JButton("Cancelar");
		
		panelBotones.add(botonGuardar);
		panelBotones.add(botonCancelar);
		
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
	
		
		//Accion Cancelar
		botonCancelar.addActionListener(e -> dispose()); //uso de chatgpt e -> dispose()
		
		//Boton Guardar
		botonGuardar.addActionListener(e -> guardarEntrenamiento());
		
		add(panelPrincipal);
		
		
		
	}
	
	
	
	
	private void guardarEntrenamiento() {
		
		try {
			
			String ejercicio = campoEjercicio.getText().trim();
			double peso = Double.parseDouble(campoPeso.getText());
			int series = Integer.parseInt(campoSeries.getText());
			int repeticiones = Integer.parseInt(campoRepes.getText());
			LocalDate fecha = LocalDate.parse(campoFecha.getText());
			
			
			//If creado con chatGPT
			if(ejercicio.isEmpty() || peso<0 || series <= 0 || repeticiones <= 0) {
				System.out.println("Comprueba que todos los campos sean correctos.");
				return;
			}
			
			//Creamos un objeto con los datos introducidos
			RegistroEntrenamiento nuevoRegistro = new RegistroEntrenamiento(ejercicio, peso, series, repeticiones, fecha);
			
			//Añadimos el entrenamiento al gestor
			gestor.agregarEntrenamiento(nuevoRegistro);
			
			//Mostramos mensaje de confirmacion
			System.out.println("Entrenamiento registrado correctamente");
			
		}catch (NumberFormatException e) {
			System.out.println("El peso, las series y las repeticiones deben ser números.");
		}catch (java.time.format.DateTimeParseException e) {
			System.out.println("La fecha debe tener el formato AAAA-MM-DD y no pasarse de sus limites");
		}
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			VentanaRegistro ventana = new VentanaRegistro();
			ventana.setVisible(true);
		});
	}
	
	
	public static GestorEntrenamientos getGestor() {
	    return gestor;
	}
	
	
}
