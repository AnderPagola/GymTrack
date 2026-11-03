package misEntrenamiento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		panelnorth.setBorder(BorderFactory.createTitledBorder("Calendario"));
		panelnorth.setBackground(Color.red);
		
		
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
