package estadisticas;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaEstadisticas extends JFrame {
	
	public VentanaEstadisticas() {
		setSize(400,600);
		setTitle("Mis rutinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
	}

}
