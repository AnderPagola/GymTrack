package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Rutinas.VentanaRutinas;

public class VentanaPrincipal extends JFrame {
	
	private JButton rutinas = new JButton("Mis rutinas");
	private JButton progreso = new JButton("Progreso");
	private JButton perfil = new JButton("Perfil");
	
	public VentanaPrincipal() {
		setSize(400,600);
		setTitle("GymTrack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(3,1,5,5));
		//Mis rutinas, Progreso, Perfil
		panelPrincipal.setBackground(Color.ORANGE);
		add(panelPrincipal, BorderLayout.CENTER);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		panelNorte.setLayout(new GridLayout(1,1));
		panelNorte.setPreferredSize(new Dimension(400,100));
		JLabel texto = new JLabel("GymTrack");
		panelNorte.add(texto);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setVerticalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("Arial", Font.BOLD, 50));
		texto.setForeground(Color.WHITE);
		add(panelNorte, BorderLayout.NORTH);
		
		//Botones
		formatoBoton(rutinas);
		formatoBoton(progreso);
		formatoBoton(perfil);

		panelPrincipal.add(rutinas);
		panelPrincipal.add(progreso);
		panelPrincipal.add(perfil);
		
//		rutinas.addActionListener(abrirRutinas());
//		progreso.addActionListener(null);
//		perfil.addActionListener(null);
	}
	// QUE PASOOOOOOOOOOdsddsd
	// HOLAAAAAAAAAAAAAAAA
	//WAZAAAAAAAAAAAAAAAAa
	public void formatoBoton(JButton boton) {
		boton.setFont(new Font("Arial", Font.BOLD, 30));
		boton.setBackground(Color.CYAN);
//		boton.setOpaque(true);
//	    boton.setContentAreaFilled(true);
	    boton.setFocusPainted(false);
	}
	
	public void abrirRutinas() {
		
	}

}
