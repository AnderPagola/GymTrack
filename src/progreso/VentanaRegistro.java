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
	private JTextField camposeries;
	private JTextField campoRepeticiones;
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
		
		
		
	}
	
	
	
	
}
