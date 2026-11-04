package principal;


import objetivos.VentanaObjetivos;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

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

import estadisticas.VentanaEstadisticas;
import historial.Historial;

public class VentanaPrincipal extends JFrame {
	
	private JButton progreso = new JButton("Progreso");
	private JButton rutinas = new JButton("Mis rutinas");
	private JButton historial = new JButton("Historial");
	private JButton stats = new JButton("Estadísticas");
	private JButton objetivos = new JButton("Objetivos");
	
	
	public VentanaPrincipal() {
		setSize(400,600);
		setTitle("GymTrack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(5,1,5,5));
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
		formatoBoton(progreso);
		formatoBoton(rutinas);
		formatoBoton(historial);
		formatoBoton(stats);
		formatoBoton(objetivos);


		panelPrincipal.add(progreso);
		panelPrincipal.add(rutinas);
		panelPrincipal.add(historial);
		panelPrincipal.add(stats);
		panelPrincipal.add(objetivos);
		
		progreso.addActionListener(e-> {
			VentanaSeguimiento v2=new VentanaSeguimiento();
			this.dispose();
			v2.setVisible(true);
		});
		rutinas.addActionListener(e-> {
			Rutina v2=new Rutina();
			this.dispose();
			v2.setVisible(true);
		});
		historial.addActionListener(e-> {
			Historial v2=new Historial();
			this.dispose();
			v2.setVisible(true);
		});
		stats.addActionListener(e-> {
			VentanaEstadisticas v2=new VentanaEstadisticas();
			this.dispose();
			v2.setVisible(true);
		});
		objetivos.addActionListener(e-> {
			VentanaObjetivos v2=new VentanaObjetivos();
			this.dispose();
			v2.setVisible(true);
		});
	}
	
	public void formatoBoton(JButton boton) {
		boton.setFont(new Font("Arial", Font.BOLD, 30));
		boton.setBackground(Color.CYAN);
//		boton.setOpaque(true);
//	    boton.setContentAreaFilled(true);
	    boton.setFocusPainted(false);
	}
}
