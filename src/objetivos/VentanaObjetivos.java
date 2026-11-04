package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import estadisticas.VentanaEstadisticas;
import historial.Historial;
import principal.VentanaPrincipal;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

public class VentanaObjetivos extends JFrame {

    private JButton btnActualizarFuerza;
    private JButton btnActualizarVolumen;
    private JButton btnActualizarPeso;

    private JButton btnAvisos;

    public VentanaObjetivos() {

        setTitle("Objetivos");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // PANEL SUPERIOR

        JPanel panelSuperior = new JPanel(new BorderLayout());

        JLabel lblTitulo = new JLabel("OBJETIVOS", JLabel.CENTER);

        btnAvisos = new JButton("Avisos");

        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        panelSuperior.add(btnAvisos, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);

        // PANEL CENTRAL

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 1, 10, 10));

        // FUERZA

        JPanel panelFuerza = new JPanel(new GridLayout(5, 2));

        panelFuerza.add(new JLabel("Valor objetivo:"));
        panelFuerza.add(new JTextField());

        panelFuerza.add(new JLabel("Valor actual:"));
        panelFuerza.add(new JTextField());

        panelFuerza.add(new JLabel("Progreso:"));

        JProgressBar barraFuerza = new JProgressBar(0, 100);
        barraFuerza.setStringPainted(true);
        panelFuerza.add(barraFuerza);

        panelFuerza.add(new JLabel("Estado:"));
        panelFuerza.add(new JLabel("Pendiente"));

        btnActualizarFuerza = new JButton("Actualizar");
        panelFuerza.add(btnActualizarFuerza);

        panelFuerza.add(new JLabel("FUERZA"));

        // VOLUMEN

        JPanel panelVolumen = new JPanel(new GridLayout(5, 2));

        panelVolumen.add(new JLabel("Valor objetivo:"));
        panelVolumen.add(new JTextField());

        panelVolumen.add(new JLabel("Valor actual:"));
        panelVolumen.add(new JTextField());

        panelVolumen.add(new JLabel("Progreso:"));

        JProgressBar barraVolumen = new JProgressBar(0, 100);
        barraVolumen.setStringPainted(true);
        panelVolumen.add(barraVolumen);

        panelVolumen.add(new JLabel("Estado:"));
        panelVolumen.add(new JLabel("Pendiente"));

        btnActualizarVolumen = new JButton("Actualizar");
        panelVolumen.add(btnActualizarVolumen);

        panelVolumen.add(new JLabel("VOLUMEN"));

        // PESO

        JPanel panelPeso = new JPanel(new GridLayout(5, 2));

        panelPeso.add(new JLabel("Valor objetivo:"));
        panelPeso.add(new JTextField());

        panelPeso.add(new JLabel("Valor actual:"));
        panelPeso.add(new JTextField());

        panelPeso.add(new JLabel("Progreso:"));

        JProgressBar barraPeso = new JProgressBar(0, 100);
        barraPeso.setStringPainted(true);
        panelPeso.add(barraPeso);

        panelPeso.add(new JLabel("Estado:"));
        panelPeso.add(new JLabel("Pendiente"));

        btnActualizarPeso = new JButton("Actualizar");
        panelPeso.add(btnActualizarPeso);

        panelPeso.add(new JLabel("PESO"));

        panelCentral.add(panelFuerza);
        panelCentral.add(panelVolumen);
        panelCentral.add(panelPeso);

        add(panelCentral, BorderLayout.CENTER);

        // PANEL INFERIOR

        JPanel panelInferior = new JPanel(new GridLayout(1,5));

        JButton btnProgreso = new JButton("Progreso");
        JButton btnRutinas = new JButton("Mis rutinas");
        JButton btnHistorial = new JButton("Historial");
        JButton btnEstadisticas = new JButton("Estadísticas");
        JButton btnObjetivos = new JButton("Objetivos");
        btnObjetivos.setEnabled(false);
        

        
        panelInferior.add(btnProgreso);
        panelInferior.add(btnRutinas);
        panelInferior.add(btnHistorial);
        panelInferior.add(btnEstadisticas);
        panelInferior.add(btnObjetivos);

        add(panelInferior, BorderLayout.SOUTH);

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

        btnAvisos.addActionListener(e -> {
            dispose();
            new VentanaAvisos();
        });

        setVisible(true);
    }
}