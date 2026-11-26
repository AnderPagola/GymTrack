package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import domain.Ejercicio;
import domain.Entrenamiento;
import domain.Recursos;

public class VentanaHistorial extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTable tablaEntrenamientos;
    private DefaultTableModel modeloTabla;

    public VentanaHistorial() {
        setTitle("GymTrack - Historial de entrenamientos");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Historial de entrenamientos", SwingConstants.CENTER);
        titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"Ejercicio", "Grupo Muscular", "Peso (kg)", "Series", "Repeticiones", "Fecha"};

        modeloTabla = new DefaultTableModel(columnas, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaEntrenamientos = new JTable(modeloTabla);
        JScrollPane desplazamiento = new JScrollPane(tablaEntrenamientos);
        panelPrincipal.add(desplazamiento, BorderLayout.CENTER);

        cargarEntrenamientos();

        add(panelPrincipal);
        Recursos.configurarAtajoCerrar(this);
    }

    private void cargarEntrenamientos() {
        List<Entrenamiento> lista = VentanaRegistro.obtenerEntrenamientos();

        for (Entrenamiento entrenamiento : lista) {
            for (Ejercicio ejercicio : entrenamiento.getEjerciciosRealizados()) {
                Object[] fila = {
                    ejercicio.getNombre(),
                    ejercicio.getGrupoMuscular(),
                    ejercicio.getPesoKg(),
                    ejercicio.getSeries(),
                    ejercicio.getRepeticiones(),
                    entrenamiento.getFecha()
                };
                modeloTabla.addRow(fila);
            }
        }
    }
}