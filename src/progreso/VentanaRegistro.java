package progreso;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame{

	private JTextField campoEjercicio;
	private JTextField campoPeso;
	private JTextField camposeries;
	private JTextField campoRepeticiones;
	private JTextField campoFecha;
	
	
	public VentanaRegistro() {
		
		setTitle("GymTrack - Registrar entrenamiento");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	
	
}
