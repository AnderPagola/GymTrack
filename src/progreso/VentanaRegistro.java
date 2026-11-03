package progreso;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class VentanaRegistro extends JFrame{

	private JTextField campoEjercicio;
	private JTextField campoPeso;
	private JTextField campoSeries;
	private JTextField campoRepes;
	private JTextField campoFecha;
	
	
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
		
	
	}
	
	
	
	
}
