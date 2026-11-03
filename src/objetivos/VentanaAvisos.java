package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaAvisos extends JFrame {

	private JButton btnEntrenamiento;
	private JButton btnAgua;
	private JButton btnDormir;
	private JButton btnRecord;

	public VentanaAvisos() {

		setTitle("Avisos");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		// Título
		JLabel lblTitulo = new JLabel("AVISOS", JLabel.CENTER);
		add(lblTitulo, BorderLayout.NORTH);

		// Panel central
		JPanel panelAvisos = new JPanel();
		panelAvisos.setLayout(new GridLayout(4, 1, 10, 10));

		btnEntrenamiento = new JButton("Proximo entrenamiento");
		btnAgua = new JButton("Beber agua");
		btnDormir = new JButton("Dormir 8 horas");
		btnRecord = new JButton("Nuevo record personal");

		panelAvisos.add(btnEntrenamiento);
		panelAvisos.add(btnAgua);
		panelAvisos.add(btnDormir);
		panelAvisos.add(btnRecord);

		add(panelAvisos, BorderLayout.CENTER);

		// Menú inferior
		JPanel panelInferior = new JPanel();

		JButton btnEntrenar = new JButton("Entrenar");
		JButton btnRutinas = new JButton("Rutinas");
		JButton btnProgreso = new JButton("Progreso");

		panelInferior.add(btnEntrenar);
		panelInferior.add(btnRutinas);
		panelInferior.add(btnProgreso);

		add(panelInferior, BorderLayout.SOUTH);

		// Eventos vacíos para implementar después
		btnEntrenamiento.addActionListener(e -> {

		});

		btnAgua.addActionListener(e -> {

		});

		btnDormir.addActionListener(e -> {

		});

		btnRecord.addActionListener(e -> {

		});

		setVisible(true);
	}
}