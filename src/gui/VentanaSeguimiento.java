package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import domain.Recursos;
import domain.RegistroPeso;

public class VentanaSeguimiento extends JFrame {
    private static final long serialVersionUID = 1L;

    // Lista de registros corporales usando la entidad de domain
    private static List<RegistroPeso> registrosPeso = new ArrayList<>();

    private JTextField txtPesoCorporal;
    private JTextField txtPorcentajeGrasa;
    private DefaultTableModel modeloPeso;

    public VentanaSeguimiento() {
        setTitle("GymTrack - Seguimiento del progreso");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cargar datos iniciales de ejemplo si la lista está vacía
        if (registrosPeso.isEmpty()) {
            registrosPeso.add(new RegistroPeso(LocalDate.now().minusWeeks(2), 80.2, 16.5));
            registrosPeso.add(new RegistroPeso(LocalDate.now().minusWeeks(1), 79.8, 16.1));
            registrosPeso.add(new RegistroPeso(LocalDate.now(), 79.5, 15.8));
        }

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // Título
        JLabel titulo = new JLabel("Seguimiento del progreso", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // Panel central dividido en accesos (izquierda) y registro corporal (derecha)
        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 20, 10));
        panelCentro.setBackground(new Color(245, 245, 245));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(15, 30, 20, 30));

        // 1. Panel izquierdo: Botones de entrenamiento
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 15, 15));
        panelBotones.setBackground(new Color(245, 245, 245));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Entrenamientos"));

        JButton botonRegistrar = new JButton("Registrar Entrenamiento");
        botonRegistrar.addActionListener(e -> {
            VentanaRegistro ventana = new VentanaRegistro();
            ventana.setVisible(true);
        });

        JButton botonHistorial = new JButton("Consultar Historial");
        botonHistorial.addActionListener(e -> {
            VentanaHistorial ventana = new VentanaHistorial();
            ventana.setVisible(true);
        });

        JButton botonProgreso = new JButton("Consultar Progreso");
        botonProgreso.addActionListener(e -> {
            VentanaProgreso ventana = new VentanaProgreso();
            ventana.setVisible(true);
        });

        panelBotones.add(botonRegistrar);
        panelBotones.add(botonHistorial);
        panelBotones.add(botonProgreso);

        // 2. Panel derecho: Registro corporal conectado a domain.RegistroPeso
        JPanel panelCorporal = new JPanel(new BorderLayout(10, 10));
        panelCorporal.setBackground(Color.WHITE);
        panelCorporal.setBorder(BorderFactory.createTitledBorder("Control de Peso Corporal"));

        JPanel formPeso = new JPanel(new GridLayout(3, 2, 8, 8));
        formPeso.setBackground(Color.WHITE);
        formPeso.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPeso.add(new JLabel("Peso corporal (kg):"));
        txtPesoCorporal = new JTextField();
        formPeso.add(txtPesoCorporal);

        formPeso.add(new JLabel("Porcentaje grasa (%):"));
        txtPorcentajeGrasa = new JTextField();
        formPeso.add(txtPorcentajeGrasa);

        JButton btnGuardarPeso = new JButton("Añadir Medición");
        btnGuardarPeso.addActionListener(e -> agregarRegistroPeso());
        formPeso.add(new JLabel());
        formPeso.add(btnGuardarPeso);

        String[] columnasPeso = {"Fecha", "Peso (kg)", "% Grasa"};
        modeloPeso = new DefaultTableModel(columnasPeso, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tablaPeso = new JTable(modeloPeso);
        JScrollPane scrollPeso = new JScrollPane(tablaPeso);

        panelCorporal.add(formPeso, BorderLayout.NORTH);
        panelCorporal.add(scrollPeso, BorderLayout.CENTER);

        actualizarTablaPeso();

        panelCentro.add(panelBotones);
        panelCentro.add(panelCorporal);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        add(panelPrincipal, BorderLayout.CENTER);

        // Barra inferior y atajo Ctrl + W desde domain.Recursos
        add(Recursos.crearPanelSur(this, "Progreso"), BorderLayout.SOUTH);
        Recursos.configurarAtajoCerrar(this);

        setVisible(true);
    }

    private void agregarRegistroPeso() {
        try {
            double peso = Double.parseDouble(txtPesoCorporal.getText().trim());
            double grasa = Double.parseDouble(txtPorcentajeGrasa.getText().trim());

            if (peso <= 0 || grasa < 0 || grasa > 100) {
                JOptionPane.showMessageDialog(this, "Introduce valores válidos para peso y grasa.");
                return;
            }

            RegistroPeso nuevo = new RegistroPeso(LocalDate.now(), peso, grasa);
            registrosPeso.add(nuevo);

            txtPesoCorporal.setText("");
            txtPorcentajeGrasa.setText("");
            actualizarTablaPeso();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El peso y el porcentaje de grasa deben ser numéricos.");
        }
    }

    private void actualizarTablaPeso() {
        modeloPeso.setRowCount(0);
        for (RegistroPeso rp : registrosPeso) {
            modeloPeso.addRow(new Object[]{
                rp.getFecha(),
                rp.getPesoCorporal(),
                rp.getPorcentajeGrasa()
            });
        }
    }

    public static List<RegistroPeso> getRegistrosPeso() {
        return new ArrayList<>(registrosPeso);
    }
}