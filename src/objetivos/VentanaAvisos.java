package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import principal.VentanaPrincipal;

public class VentanaAvisos extends JFrame {

    private JButton btnEntrenamiento;
    private JButton btnAgua;
    private JButton btnDormir;
    private JButton btnRecord;

    private JButton btnMenuPrincipal;

    public VentanaAvisos() {

        setTitle("Avisos y Recordatorios");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // Título
        JLabel lblTitulo = new JLabel("AVISOS Y RECORDATORIOS", JLabel.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        // Panel central
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

        // Panel inferior
        JPanel panelInferior = new JPanel();

        btnMenuPrincipal = new JButton("Menú Principal");

        panelInferior.add(btnMenuPrincipal);

        add(panelInferior, BorderLayout.SOUTH);

        // Cambiar estado al pulsar

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

        // Volver al menú principal

        btnMenuPrincipal.addActionListener(e -> {

            dispose();
            new VentanaPrincipal();

        });

        setVisible(true);
    }
}