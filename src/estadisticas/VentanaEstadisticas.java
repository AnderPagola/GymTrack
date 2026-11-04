package estadisticas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import historial.Historial;
import objetivos.VentanaObjetivos;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

public class VentanaEstadisticas extends JFrame {
	
	private JPanel panelContenido = new JPanel();
	private JLabel label = new JLabel("");
	
	private JButton progreso = new JButton("Progreso");
	private JButton rutina = new JButton("Mis rutinas");
	private JButton historial = new JButton("Historial");
	private JButton stats = new JButton("Estadísticas");
	private JButton objetivos = new JButton("Objetivos");

	
	public VentanaEstadisticas() {
		setSize(400,600);
		setTitle("Mis rutinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		
		//Panel norte
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		panelNorte.setLayout(new GridLayout(1,1));
		panelNorte.setPreferredSize(new Dimension(400,100));
		JLabel texto = new JLabel("Estadísticas");
		panelNorte.add(texto);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setVerticalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("Arial", Font.BOLD, 50));
		texto.setForeground(Color.WHITE);
		add(panelNorte, BorderLayout.NORTH);
		
		//Panel menu
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(new GridLayout(1,5,5,5));
		progreso.setFocusPainted(false);
		rutina.setFocusPainted(false);
		historial.setFocusPainted(false);
		stats.setFocusPainted(false);
		objetivos.setFocusPainted(false);
		stats.setEnabled(false);
		panelMenu.add(progreso);
		panelMenu.add(rutina);
		panelMenu.add(historial);
		panelMenu.add(stats);
		panelMenu.add(objetivos);
		add(panelMenu, BorderLayout.SOUTH);
		
		progreso.addActionListener(e -> {
			VentanaSeguimiento v2=new VentanaSeguimiento();
			this.dispose();
			v2.setVisible(true);
		});
		rutina.addActionListener(e -> {
			Rutina v2=new Rutina();
			this.dispose();
			v2.setVisible(true);
		});
		historial.addActionListener(e -> {
			Historial v2=new Historial();
			this.dispose();
			v2.setVisible(true);
		});
		stats.addActionListener(e -> {
			VentanaEstadisticas v2 = new VentanaEstadisticas();
			v2.setVisible(true);
		});
		objetivos.addActionListener(e -> {
			VentanaObjetivos v2=new VentanaObjetivos();
			this.dispose();
			v2.setVisible(true);
		});
		
		
		//Panel contenido
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout());
		add(panelGeneral, BorderLayout.CENTER);
		
		panelContenido.setLayout(new BorderLayout());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panelContenido.add(label, BorderLayout.NORTH);
		panelGeneral.add(panelContenido, BorderLayout.CENTER);
		
		String[] stats = {
			"",
			"Volumen de la semana",
			"Tiempo entrenamiento",
			"Series y repeticiones",
			"Pesos",
			"Records",
			"Progreso por músculo",
		};
		JComboBox<String> box = new JComboBox<>(stats);
		panelGeneral.add(box, BorderLayout.NORTH);
		
		box.addActionListener(e -> {
			String seleccion = (String) box.getSelectedItem();
			panelContenido.removeAll();
			
//			if(seleccion.equals("")) {
//				label.setText("");
			if(seleccion.equals("Volumen de la semana")) {
				VolumenSemana();
//				label.setText("VOLUMEN DE LA SEMANA");
			} else if(seleccion.equals("Tiempo entrenamiento")) {
				TiempoEntrenamiento();
//				label.setText("TIEMPO ENTRENAMIENTO");
			} else if(seleccion.equals("Series y repeticiones")) {
				SeriesReps();
//				label.setText("SERIES Y REPETICIONES");
			} else if(seleccion.equals("Pesos")) {
				Pesos();
//				label.setText("PESOS");
			} else if(seleccion.equals("Records")) {
				Records();
//				label.setText("RECORDS");
			} else if(seleccion.equals("Progreso por músculo")) {
				ProgresoMusculo();
//				label.setText("PROGRESO POR MÚSCULO");
			}
			//Estas dos funciones las he sacado con la IA
			panelContenido.revalidate();
			panelContenido.repaint();
		});
	}
	
	//Contenido de cada elección
	private void VolumenSemana() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1,5,5));
		
		//1
		JLabel titulo = new JLabel("VOLUMEN DE LA SEMANA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		//2
		JPanel panelVolumen = new JPanel();
		panelVolumen.setBorder(BorderFactory.createTitledBorder("Volumen"));
		panelVolumen.setLayout(new GridLayout(1,2));
		
		JLabel volumen = new JLabel("Volumen total:");
		volumen.setHorizontalAlignment(SwingConstants.LEFT);
		volumen.setVerticalAlignment(SwingConstants.CENTER);
		panelVolumen.add(volumen);
		
		JLabel cant = new JLabel("12.500kg");
		cant.setFont(new Font("Arial", Font.BOLD, 20));
		panelVolumen.add(cant);
		
		//3
		JPanel panelCant = new JPanel();
		panelCant.setLayout(new GridLayout(1,3,5,5));
		panelCant.setBorder(BorderFactory.createTitledBorder("Progreso"));
		
		JLabel comparacion = new JLabel("Aumento de esta semana: ");
		comparacion.setHorizontalAlignment(SwingConstants.LEFT);
		comparacion.setVerticalAlignment(SwingConstants.CENTER);
		panelCant.add(comparacion);
		
		JLabel cantMas = new JLabel("500kg");
		cantMas.setFont(new Font("Arial", Font.BOLD, 20));
		panelCant.add(cantMas);
		
		JLabel cantPor = new JLabel("+4%");
		cantPor.setFont(new Font("Arial", Font.BOLD, 20));
		panelCant.add(cantPor);
		
		panel.add(titulo);
		panel.add(panelVolumen);
		panel.add(panelCant);
		
		panelContenido.add(panel);
	}
	
	private void TiempoEntrenamiento() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1,5,5));
		//1
		
	}
	
	private void SeriesReps() {
		
	}
	
	private void Pesos() {
		
	}
	
	private void Records() {
		
	}
	
	private void ProgresoMusculo() {
		
	}

}
