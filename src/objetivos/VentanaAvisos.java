package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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

        JLabel lblTitulo = new JLabel("AVISOS Y RECORDATORIOS", JLabel.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelAvisos = new JPanel();
        panelAvisos.setLayout(new GridLayout(4, 2, 10, 10));

        panelAvisos.add(new JLabel("Próximo entrenamiento: Mañana"));
        btnEntrenamiento = new JButton("No completado");
        panelAvisos.add(btnEntrenamiento);

        panelAvisos.add(new JLabel("Beber al menos 2 litros de agua"));
        btnAgua = new JButton("No completado");
        panelAvisos.add(btnAgua);

        panelAvisos.add(new JLabel("Dormir 8 horas"));
        btnDormir = new JButton("No completado");
        panelAvisos.add(btnDormir);

        panelAvisos.add(new JLabel("Nuevo récord personal"));
        btnRecord = new JButton("No completado");
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
            } else {
                btnEntrenamiento.setText("No completado");
            }
        });

        btnAgua.addActionListener(e -> {
            if (btnAgua.getText().equals("No completado")) {
                btnAgua.setText("Completado");
            } else {
                btnAgua.setText("No completado");
            }
        });

        btnDormir.addActionListener(e -> {
            if (btnDormir.getText().equals("No completado")) {
                btnDormir.setText("Completado");
            } else {
                btnDormir.setText("No completado");
            }
        });

        btnRecord.addActionListener(e -> {
            if (btnRecord.getText().equals("No completado")) {
                btnRecord.setText("Completado");
            } else {
                btnRecord.setText("No completado");
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