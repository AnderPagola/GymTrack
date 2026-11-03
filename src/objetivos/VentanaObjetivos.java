package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaObjetivos extends JFrame {

	private JButton btnFuerza;
	private JButton btnVolumen;
	private JButton btnPeso;

	public VentanaObjetivos() {

		setTitle("Objetivos");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		// Título
		JLabel lblTitulo = new JLabel("OBJETIVOS", JLabel.CENTER);
		add(lblTitulo, BorderLayout.NORTH);

		// Centro
		JPanel panelObjetivos = new JPanel();
		panelObjetivos.setLayout(new GridLayout(3, 1, 10, 10));

		btnFuerza = new JButton("Meta Fuerza");
		btnVolumen = new JButton("Meta Volumen");
		btnPeso = new JButton("Meta Peso");

		panelObjetivos.add(btnFuerza);
		panelObjetivos.add(btnVolumen);
		panelObjetivos.add(btnPeso);

		add(panelObjetivos, BorderLayout.CENTER);

		// Menú inferior
		JPanel panelInferior = new JPanel();

		JButton btnEntrenar = new JButton("Entrenar");
		JButton btnRutinas = new JButton("Rutinas");
		JButton btnProgreso = new JButton("Progreso");

		panelInferior.add(btnEntrenar);
		panelInferior.add(btnRutinas);
		panelInferior.add(btnProgreso);

		add(panelInferior, BorderLayout.SOUTH);

		// Eventos vacíos para el futuro
		btnFuerza.addActionListener(e -> {

		});

		btnVolumen.addActionListener(e -> {

		});

		btnPeso.addActionListener(e -> {

		});

		setVisible(true);
	}
}