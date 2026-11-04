package progreso;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VentanaHistorial extends JFrame{

	private JTable tablaEntrenamientos;
	private DefaultTableModel modeloTabla;
	
	public VentanaHistorial() {
		
		setTitle("GymTrack - Historial de entrenamientos");
		setSize(800,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Creamos el panel principal
		JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));
		
		//Creamos el titulo
		JLabel titulo = new JLabel("Historial de entrenamientos", SwingConstants.CENTER);
		titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
		
		panelPrincipal.add(titulo, BorderLayout.NORTH);
	
		
		//Configuramos las columnas de la tabla
		String[] columnas = {"Ejercicio", "Peso (kg)", "Series", "Repeticiones", "Fecha"};
		
		//Creamos el modelo de la tabla
		modeloTabla = new DefaultTableModel(columnas, 0) {
			
			//Evitar que el usuario modifique los datos directamente.
			//Hecho con ChatGPT
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		
		//Creamos la tabla utilizando el modelo
		tablaEntrenamientos = new JTable(modeloTabla);
		
		
		//Añadimos barra para poder desplazar la ventana
		JScrollPane desplazamiento = new JScrollPane(tablaEntrenamientos);
		
		panelPrincipal.add(desplazamiento, BorderLayout.CENTER);
		
		//Cargamos los entrenamientos
		cargarEntrenamientos();
		
		add(panelPrincipal);
		
		
	}

	private void cargarEntrenamientos() {
		// TODO Auto-generated method stub
		ArrayList<RegistroEntrenamiento> lista = VentanaRegistro.getGestor().obtenerEntrenamientos();
		
		for(RegistroEntrenamiento registro : lista) {
			Object[] fila = {
					registro.getEjercicio(),
					registro.getPeso(),
					registro.getSeries(),
					registro.getRepeticiones(),
					registro.getFecha()
			};
			
			modeloTabla.addRow(fila);
		}
		
		
	}
}
