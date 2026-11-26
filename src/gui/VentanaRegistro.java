package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import domain.Ejercicio;
import domain.Entrenamiento;
import domain.GrupoMuscular;
import domain.Recursos;

public class VentanaRegistro extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField campoEjercicio;
    private JComboBox<GrupoMuscular> comboGrupo;
    private JTextField campoPeso;
    private JTextField campoSeries;
    private JTextField campoRepes;
    private JTextField campoFecha;

    // Lista que almacena los entrenamientos usando el modelo de domain
    private static List<Entrenamiento> entrenamientos = new ArrayList<>();

    public VentanaRegistro() {
        setTitle("GymTrack - Registrar entrenamiento");
        setSize(500, 430);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("Registrar entrenamiento", SwingConstants.CENTER);
        titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 15));

        panelFormulario.add(new Label("Ejercicio: "));
        campoEjercicio = new JTextField();
        panelFormulario.add(campoEjercicio);

        panelFormulario.add(new JLabel("Grupo Muscular: "));
        comboGrupo = new JComboBox<>(GrupoMuscular.values());
        panelFormulario.add(comboGrupo);

        panelFormulario.add(new JLabel("Peso (kg): "));
        campoPeso = new JTextField();
        panelFormulario.add(campoPeso);

        panelFormulario.add(new JLabel("Series: "));
        campoSeries = new JTextField();
        panelFormulario.add(campoSeries);

        panelFormulario.add(new JLabel("Repeticiones: "));
        campoRepes = new JTextField();
        panelFormulario.add(campoRepes);

        panelFormulario.add(new JLabel("Fecha (AAAA-MM-DD): "));
        campoFecha = new JTextField(LocalDate.now().toString());
        panelFormulario.add(campoFecha);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonGuardar = new JButton("Guardar entrenamiento");
        JButton botonCancelar = new JButton("Cancelar");

        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        botonCancelar.addActionListener(e -> dispose());
        botonGuardar.addActionListener(e -> guardarEntrenamiento());

        add(panelPrincipal);
        Recursos.configurarAtajoCerrar(this);
    }

    private void guardarEntrenamiento() {
        try {
            String nombreEjercicio = campoEjercicio.getText().trim();
            GrupoMuscular grupo = (GrupoMuscular) comboGrupo.getSelectedItem();
            double peso = Double.parseDouble(campoPeso.getText());
            int series = Integer.parseInt(campoSeries.getText());
            int repeticiones = Integer.parseInt(campoRepes.getText());
            LocalDate fecha = LocalDate.parse(campoFecha.getText());

            if (nombreEjercicio.isEmpty() || peso < 0 || series <= 0 || repeticiones <= 0) {
                JOptionPane.showMessageDialog(this, "Comprueba que todos los campos sean correctos.");
                return;
            }

            // Crear entidades de domain
            Ejercicio nuevoEjercicio = new Ejercicio(nombreEjercicio, grupo, series, repeticiones, peso);
            nuevoEjercicio.setCompletado(true);

            Entrenamiento nuevoEntrenamiento = new Entrenamiento(fecha, nombreEjercicio, grupo, 60, true);
            nuevoEntrenamiento.agregarEjercicio(nuevoEjercicio);

            entrenamientos.add(nuevoEntrenamiento);

            JOptionPane.showMessageDialog(this, "Entrenamiento registrado correctamente");
            campoEjercicio.setText("");
            campoPeso.setText("");
            campoSeries.setText("");
            campoRepes.setText("");
            campoFecha.setText(LocalDate.now().toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El peso, las series y las repeticiones deben ser números.");
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener el formato AAAA-MM-DD y no pasarse de sus límites.");
        }
    }

    public static List<Entrenamiento> obtenerEntrenamientos() {
        return new ArrayList<>(entrenamientos);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaRegistro ventana = new VentanaRegistro();
            ventana.setVisible(true);
        });
    }
}