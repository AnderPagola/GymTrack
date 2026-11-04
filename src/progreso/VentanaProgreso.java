package progreso;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VentanaProgreso extends JFrame{
	
	private JComboBox<String> selectorEjericio;
	private JTable tablaProgreso;
	private DefaultTableModel modeloTabla;
	
	public VentanaProgreso() {
		setTitle("Consultar Progreso");
		setSize(650,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Cracion del panel Principal
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("Consulta Tu Progreso", SwingConstants.CENTER);
		
		//Panel superior
		JPanel panelSeleccion = new JPanel(new FlowLayout());
		JLabel etiquetaEjercicio = new JLabel("Selecciona un ejercicio:");
		
		selectorEjericio = new JComboBox<>();
		
		JButton botonConsultar = new JButton("Consultar");
		
		panelSeleccion.add(etiquetaEjercicio);
		panelSeleccion.add(selectorEjericio);
		panelSeleccion.add(botonConsultar);
		
		//Tabla de progreso
		String[] columnas = {"Fecha", "Ejercicio", "Peso (Kg)", "Series", "Repeticiones"};
		
		modeloTabla = new DefaultTableModel(columnas, 0);
		
		tablaProgreso = new JTable(modeloTabla);
		
		JScrollPane desplazamiento = new JScrollPane(tablaProgreso);
		
		
	
	}

}
