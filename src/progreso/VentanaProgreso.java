package progreso;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
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
		
		
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		
	}
	
	

}
