package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import principal.VentanaPrincipal;

public class VentanaObjetivos extends JFrame {

    private JButton btnActualizarFuerza;
    private JButton btnActualizarVolumen;
    private JButton btnActualizarPeso;
    private JButton btnAvisos;

    private JButton btnMenuPrincipal;

    public VentanaObjetivos() {

        setTitle("Objetivos");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // TÍTULO
        JLabel lblTitulo = new JLabel("OBJETIVOS", JLabel.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        // PANEL CENTRAL
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 1, 10, 10));

        // ================= FUERZA =================

        JPanel panelFuerza = new JPanel(new GridLayout(5, 2, 5, 5));

        panelFuerza.add(new JLabel("Valor objetivo:"));
        JTextField txtObjetivoFuerza = new JTextField();
        panelFuerza.add(txtObjetivoFuerza);

        panelFuerza.add(new JLabel("Valor actual:"));
        JTextField txtActualFuerza = new JTextField();
        panelFuerza.add(txtActualFuerza);

        panelFuerza.add(new JLabel("Progreso:"));
        JProgressBar barraFuerza = new JProgressBar(0, 100);
        barraFuerza.setValue(0);
        barraFuerza.setStringPainted(true);
        panelFuerza.add(barraFuerza);

        panelFuerza.add(new JLabel("Estado:"));
        JLabel lblEstadoFuerza = new JLabel("Pendiente");
        panelFuerza.add(lblEstadoFuerza);

        btnActualizarFuerza = new JButton("Actualizar");
        panelFuerza.add(btnActualizarFuerza);

        panelFuerza.add(new JLabel("FUERZA"));

        // ================= VOLUMEN =================

        JPanel panelVolumen = new JPanel(new GridLayout(5, 2, 5, 5));

        panelVolumen.add(new JLabel("Valor objetivo:"));
        JTextField txtObjetivoVolumen = new JTextField();
        panelVolumen.add(txtObjetivoVolumen);

        panelVolumen.add(new JLabel("Valor actual:"));
        JTextField txtActualVolumen = new JTextField();
        panelVolumen.add(txtActualVolumen);

        panelVolumen.add(new JLabel("Progreso:"));
        JProgressBar barraVolumen = new JProgressBar(0, 100);
        barraVolumen.setValue(0);
        barraVolumen.setStringPainted(true);
        panelVolumen.add(barraVolumen);

        panelVolumen.add(new JLabel("Estado:"));
        JLabel lblEstadoVolumen = new JLabel("Pendiente");
        panelVolumen.add(lblEstadoVolumen);

        btnActualizarVolumen = new JButton("Actualizar");
        panelVolumen.add(btnActualizarVolumen);

        panelVolumen.add(new JLabel("VOLUMEN"));

        // ================= PESO =================

        JPanel panelPeso = new JPanel(new GridLayout(5, 2, 5, 5));

        panelPeso.add(new JLabel("Valor objetivo:"));
        JTextField txtObjetivoPeso = new JTextField();
        panelPeso.add(txtObjetivoPeso);

        panelPeso.add(new JLabel("Valor actual:"));
        JTextField txtActualPeso = new JTextField();
        panelPeso.add(txtActualPeso);

        panelPeso.add(new JLabel("Progreso:"));
        JProgressBar barraPeso = new JProgressBar(0, 100);
        barraPeso.setValue(0);
        barraPeso.setStringPainted(true);
        panelPeso.add(barraPeso);

        panelPeso.add(new JLabel("Estado:"));
        JLabel lblEstadoPeso = new JLabel("Pendiente");
        panelPeso.add(lblEstadoPeso);

        btnActualizarPeso = new JButton("Actualizar");
        panelPeso.add(btnActualizarPeso);

        panelPeso.add(new JLabel("PESO"));

        panelCentral.add(panelFuerza);
        panelCentral.add(panelVolumen);
        panelCentral.add(panelPeso);

        add(panelCentral, BorderLayout.CENTER);

        // PANEL INFERIOR

        JPanel panelInferior = new JPanel();

        btnMenuPrincipal = new JButton("Menú Principal");
        btnAvisos = new JButton("Avisos");

        panelInferior.add(btnMenuPrincipal);
        panelInferior.add(btnAvisos);
        
        add(panelInferior, BorderLayout.SOUTH);

        // ACTION LISTENERS VACÍOS

        btnActualizarFuerza.addActionListener(e -> {

        });
        

        btnActualizarVolumen.addActionListener(e -> {

        });

        btnActualizarPeso.addActionListener(e -> {

        });

        btnMenuPrincipal.addActionListener(e -> {
        	dispose();
        	new VentanaPrincipal();
        });
        
        btnAvisos.addActionListener(e -> {
        	dispose();
            new VentanaAvisos();

        });

        setVisible(true);
    }
}