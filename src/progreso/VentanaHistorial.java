package progreso;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
		
	}
}
