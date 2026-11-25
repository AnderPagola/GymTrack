package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import estadisticas.VentanaEstadisticas;
import historial.Historial;
import principal.VentanaPrincipal;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

public class VentanaAvisos extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnEntrenamiento;
    private JButton btnAgua;
    private JButton btnDormir;
    private JButton btnRecord;

    public VentanaAvisos() {

        setTitle("Avisos y Recordatorios");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());
        
        // ICONOS
        ImageIcon iconoCompletadoOriginal = new ImageIcon("resources/cara_sonriente.jpg");
        ImageIcon iconoNoCompletadoOriginal = new ImageIcon("resources/cara_triste_roja.png");
        
        ImageIcon iconoCompletado = new ImageIcon(iconoCompletadoOriginal.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH));
        ImageIcon iconoNoCompletado = new ImageIcon(iconoNoCompletadoOriginal.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH));

        JLabel lblTitulo = new JLabel("AVISOS Y RECORDATORIOS", JLabel.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelAvisos = new JPanel();
        panelAvisos.setLayout(new GridLayout(4, 2, 10, 10));

        panelAvisos.add(new JLabel("Próximo entrenamiento: Mañana"));
        btnEntrenamiento = new JButton("No completado");
        btnEntrenamiento.setIcon(iconoNoCompletado);
        panelAvisos.add(btnEntrenamiento);

        panelAvisos.add(new JLabel("Beber al menos 2 litros de agua"));
        btnAgua = new JButton("No completado");
        btnAgua.setIcon(iconoNoCompletado);
        panelAvisos.add(btnAgua);

        panelAvisos.add(new JLabel("Dormir 8 horas"));
        btnDormir = new JButton("No completado");
        btnDormir.setIcon(iconoNoCompletado);
        panelAvisos.add(btnDormir);

        panelAvisos.add(new JLabel("Nuevo récord personal"));
        btnRecord = new JButton("No completado");
        btnRecord.setIcon(iconoNoCompletado);
        panelAvisos.add(btnRecord);

        add(panelAvisos, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();

    
        JButton btnProgreso = new JButton("Progreso");
        JButton btnRutinas = new JButton("Mis rutinas");
        JButton btnHistorial = new JButton("Historial");
        JButton btnEstadisticas = new JButton("Estadísticas");
        JButton btnObjetivo = new JButton("Objetivos");

        panelInferior.add(btnProgreso);
        panelInferior.add(btnRutinas);
        panelInferior.add(btnHistorial);
        panelInferior.add(btnEstadisticas);
        panelInferior.add(btnObjetivo);

        add(panelInferior, BorderLayout.SOUTH);

        // CAMBIAR ESTADO

        btnEntrenamiento.addActionListener(e -> {
            if (btnEntrenamiento.getText().equals("No completado")) {
                btnEntrenamiento.setText("Completado");
                btnEntrenamiento.setIcon(iconoCompletado);
            } else {
                btnEntrenamiento.setText("No completado");
                btnEntrenamiento.setIcon(iconoNoCompletado);
            }
        });

        btnAgua.addActionListener(e -> {
            if (btnAgua.getText().equals("No completado")) {
                btnAgua.setText("Completado");
                btnAgua.setIcon(iconoCompletado);
            } else {
                btnAgua.setText("No completado");
                btnAgua.setIcon(iconoNoCompletado);
            }
        });

        btnDormir.addActionListener(e -> {
            if (btnDormir.getText().equals("No completado")) {
                btnDormir.setText("Completado");
                btnDormir.setIcon(iconoCompletado);
            } else {
                btnDormir.setText("No completado");
                btnDormir.setIcon(iconoNoCompletado);
            }
        });

        btnRecord.addActionListener(e -> {
            if (btnRecord.getText().equals("No completado")) {
                btnRecord.setText("Completado");
                btnRecord.setIcon(iconoCompletado);
            } else {
                btnRecord.setText("No completado");
                btnRecord.setIcon(iconoNoCompletado);
            }
        });

        // EVENTOS
        btnProgreso.addActionListener(e -> {
            dispose();
            new VentanaSeguimiento();
        });
        
        btnRutinas.addActionListener(e -> {
            dispose();
            new Rutina();
        });
        
        btnHistorial.addActionListener(e -> {
            dispose();
            new Historial();
        });
        
        btnEstadisticas.addActionListener(e -> {
            dispose();
            new VentanaEstadisticas();
        });
        
        btnObjetivo.addActionListener(e -> {
            dispose();
            new VentanaObjetivos();
        });

        setVisible(true);
    }
}