package rutinas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaRutinas extends JFrame {
	
	public VentanaRutinas() {
		setSize(400,600);
		setTitle("Mis rutinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		panelNorte.setLayout(new GridLayout(1,1));
		panelNorte.setPreferredSize(new Dimension(400,100));
		JLabel texto = new JLabel("Mis rutinas");
		panelNorte.add(texto);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setVerticalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("Arial", Font.BOLD, 50));
		texto.setForeground(Color.WHITE);
		add(panelNorte, BorderLayout.NORTH);
		
//		JButton añadir = new JButton("+");
//		añadir.setPreferredSize(new Dimension(50,50));
//		añadir.setFont(new Font("Arial", Font.BOLD, 30));
//		añadir.setForeground(Color.WHITE);
//		añadir.setBackground(Color.CYAN);
//		
//		añadir.setFocusPainted(false);
//		añadir.setOpaque(true);
//		añadir.setContentAreaFilled(true);
//		añadir.setBorderPainted(false);
		BotonCircular añadir = new BotonCircular("+");
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelSur.add(añadir);

		add(panelSur, BorderLayout.SOUTH);
		//Macar
		
	}

}
