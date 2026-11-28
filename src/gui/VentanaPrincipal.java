package gui;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Colores;
import domain.Recursos;

public class VentanaPrincipal extends JFrame {
	
	public static final long serialVersionUID = 1L;
	
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
		setLayout(new BorderLayout());
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(5,1,5,5));
		//Mis rutinas, Progreso, Perfil
		panelPrincipal.setBackground(Colores.NEGRO_CARBON.getColor());
		add(panelPrincipal, BorderLayout.CENTER);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Colores.NEGRO_CARBON.getColor());
		panelNorte.setLayout(new GridLayout(1,1));
		panelNorte.setPreferredSize(new Dimension(400,100));
		JLabel texto = new JLabel("GymTrack");
		panelNorte.add(texto);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setVerticalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("Arial", Font.BOLD, 50));
		texto.setForeground(Colores.BLANCO_CALIDO.getColor());
		add(panelNorte, BorderLayout.NORTH);
				
		//Botones
		formatoBoton(progreso, "resources/icono_progreso.png", 40, 40);
		formatoBoton(rutinas, "resources/icono_rutinas.png", 40, 40);
		formatoBoton(historial, "resources/icono_historial.png", 40, 40);
		formatoBoton(stats, "resources/icono_stats.png", 40, 40);
		formatoBoton(objetivos, "resources/icono_objetivos.png", 40, 40);


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
		
        Recursos.configurarAtajoCerrar(this);
        
		setVisible(true);
	}
	
	public void formatoBoton(JButton boton, String ruta, int ancho, int alto) {
		//Color dorado = Color.decode("#D4AF70");
		boton.setFont(new Font("Arial", Font.BOLD, 30));
		boton.setBackground(Colores.DORADO.getColor());
		boton.setForeground(Colores.BLANCO_CALIDO.getColor());
		
		ImageIcon icono = new ImageIcon(ruta);
		Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		boton.setIcon(new ImageIcon(imagen));

		boton.setHorizontalTextPosition(SwingConstants.LEFT);
		boton.setVerticalTextPosition(SwingConstants.CENTER);
	    boton.setIconTextGap(20);
	    
		boton.setOpaque(true);
	    boton.setContentAreaFilled(true);
	    boton.setFocusPainted(false);
	}
}