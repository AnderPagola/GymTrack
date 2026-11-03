package misEntrenamiento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MisEntrenamientos extends JFrame {
	private JButton botonentrenar =new JButton("Entrenar");
	private JButton botonRutinas=new JButton("Mis rutinas");
	private JButton botonprogreso=new JButton("Progreso");
	private JButton botonperfil=new JButton("Perfil");
	public MisEntrenamientos() {
		// TODO Auto-generated constructor stub
		
		setTitle("Historial y evolucion");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		 	
		JPanel panelnorth= new JPanel();
		panelnorth.setBorder(BorderFactory.createTitledBorder("Mis Entrenamientos"));
		panelnorth.setBackground(Color.gray);
		panelnorth.setPreferredSize(new Dimension(0,200));
		panelnorth.setLayout(new BorderLayout());
		
		JPanel panelcolumnas=new JPanel();
		panelcolumnas.setLayout(new GridLayout(1,7,5,5));
		JPanel panelcolumnas2=new JPanel();
		panelcolumnas.setLayout(new GridLayout(1,14,5,5));
		String[] columnas= {"L","M","M","J","V","S","D"};
		int[] dias= {12,13,14,15,16,17,18};
		for(String c:columnas) {
			
			panelcolumnas.add(new JLabel(c,SwingConstants.CENTER));
		}
		for(int i: dias) {
			JButton bot=new JButton(String.valueOf(i));
			bot.setPreferredSize(new Dimension(50,40));
			panelcolumnas2.add(bot);
			JLabel lblvacio=new JLabel();//Hueco para dejar entre boton y boton, no consigo modificando el grid
			lblvacio.setPreferredSize(new Dimension(25,20));
			panelcolumnas2.add(lblvacio);
		}
		
		
		
		panelnorth.add(panelcolumnas, BorderLayout.NORTH);
		panelnorth.add(panelcolumnas2,BorderLayout.CENTER);
		
		
		
		JPanel panelcentro=new JPanel();
		panelcentro.setBackground(Color.black);
		JPanel panelsouth=new JPanel();
		panelsouth.setLayout(new GridLayout(1,4,20,20));
		formatoBoton(botonRutinas);
		formatoBoton(botonentrenar);
		formatoBoton(botonperfil);
		formatoBoton(botonprogreso);
		panelsouth.add(botonentrenar);
		panelsouth.add(botonRutinas);
		panelsouth.add(botonprogreso);
		panelsouth.add(botonperfil);
		
		add(panelnorth, BorderLayout.NORTH);
		add(panelcentro, BorderLayout.CENTER);
		add(panelsouth, BorderLayout.SOUTH);
		
		
		
		
	}public void formatoBoton(JButton boton) {
		boton.setFont(new Font("Arial", Font.BOLD, 30));
		boton.setBackground(Color.CYAN);
//		boton.setOpaque(true);
//	    boton.setContentAreaFilled(true);
	    boton.setFocusPainted(false);
	    
	}
}
