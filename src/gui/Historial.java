package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import domain.Ejercicio;
import domain.Entrenamiento;
import domain.GrupoMuscular;
import domain.Recursos;

public class Historial extends JFrame {
    private static final long serialVersionUID = 1L;

    private int diaI = 8;
    private JTable tablaCalendario;
    private DefaultTableModel modeloTabla;
    private JTextArea trabajoDia = new JTextArea();
    private List<Entrenamiento> listaEntrenamientos = new ArrayList<>();

    public Historial() {
        setTitle("Historial y evolucion");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cargarEntrenamientos();

        JPanel panelnorth = new JPanel();
        panelnorth.setBorder(BorderFactory.createTitledBorder("Mis Entrenamientos"));
        panelnorth.setBackground(Color.gray);
        panelnorth.setPreferredSize(new Dimension(0, 120));
        panelnorth.setLayout(new BorderLayout());

        String[] columnas = {"L", "M", "M", "J", "V", "S", "D"};

        Object[][] datos = {
            {
                String.valueOf(diaI),
                String.valueOf(diaI + 1),
                String.valueOf(diaI + 2),
                String.valueOf(diaI + 3),
                String.valueOf(diaI + 4),
                String.valueOf(diaI + 5),
                String.valueOf(diaI + 6)
            }
        };

        modeloTabla = new DefaultTableModel(datos, columnas) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaCalendario = new JTable(modeloTabla);
        tablaCalendario.setRowHeight(40);
        tablaCalendario.setFont(new Font("Arial", Font.BOLD, 16));

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tablaCalendario.getColumnCount(); i++) {
            tablaCalendario.getColumnModel()
                           .getColumn(i)
                           .setCellRenderer(centrado);
        }

        ((DefaultTableCellRenderer) tablaCalendario.getTableHeader()
                .getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        tablaCalendario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tablaCalendario);
        panelnorth.add(scroll, BorderLayout.CENTER);

        JButton botonantes = new JButton("Semana pasada");
        JButton botonactual = new JButton("Semana actual");
        JButton botondespues = new JButton("Semana siguente");

        botonantes.addActionListener(e -> {
            diaI -= 7;
            if (diaI < 1) {
                diaI += 7;
                JOptionPane.showMessageDialog(
                    this,
                    "No puedes retroceder más",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                actualizarSemana();
            }
        });

        botondespues.addActionListener(e -> {
            diaI += 7;
            if (diaI > 22) {
                diaI -= 7;
                JOptionPane.showMessageDialog(
                    this,
                    "No puedes avanzar más",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                actualizarSemana();
            }
        });

        botonactual.addActionListener(e -> {
            diaI = 8;
            actualizarSemana();
        });

        JPanel panelsur2 = new JPanel();
        panelsur2.setLayout(new GridLayout(1, 3, 20, 20));
        panelsur2.add(botonantes);
        panelsur2.add(botonactual);
        panelsur2.add(botondespues);
        panelnorth.add(panelsur2, BorderLayout.SOUTH);

        JPanel panelcentro = new JPanel();
        panelcentro.setBackground(Color.white);

        trabajoDia.setEditable(false);
        trabajoDia.setFont(new Font("Arial", Font.PLAIN, 16));
        panelcentro.setLayout(new BorderLayout());
        panelcentro.add(trabajoDia, BorderLayout.NORTH);
        tablaCalendario.setRowSelectionAllowed(true);
        tablaCalendario.setColumnSelectionAllowed(true);
        tablaCalendario.setCellSelectionEnabled(true);

        mostrarEntrenamiento(0);

        tablaCalendario.getColumnModel()
                       .getSelectionModel()
                       .addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int columna = tablaCalendario.getSelectedColumn();
                if (columna != -1) {
                    mostrarEntrenamiento(columna);
                }
            }
        });

        add(panelnorth, BorderLayout.NORTH);
        add(panelcentro, BorderLayout.CENTER);
        add(Recursos.crearPanelSur(this, "Historial"), BorderLayout.SOUTH);
        Recursos.configurarAtajoCerrar(this);
        setVisible(true);
        
    }

    private void cargarEntrenamientos() {
        Entrenamiento lunes = new Entrenamiento(LocalDate.of(2026, 11, 8), "Entrenamiento Pierna", GrupoMuscular.PIERNA, 65, false);
        lunes.agregarEjercicio(new Ejercicio("Sentadillas", GrupoMuscular.PIERNA, false));
        lunes.agregarEjercicio(new Ejercicio("Prensa", GrupoMuscular.PIERNA, false));
        lunes.agregarEjercicio(new Ejercicio("Extensiones", GrupoMuscular.PIERNA, true));
        listaEntrenamientos.add(lunes);

        Entrenamiento martes = new Entrenamiento(LocalDate.of(2026, 11, 9), "Entrenamiento Pecho", GrupoMuscular.PECHO, 55, false);
        martes.agregarEjercicio(new Ejercicio("Press banca", GrupoMuscular.PECHO, false));
        martes.agregarEjercicio(new Ejercicio("Press inclinado", GrupoMuscular.PECHO, true));
        martes.agregarEjercicio(new Ejercicio("Aperturas", GrupoMuscular.PECHO, true));
        listaEntrenamientos.add(martes);

        Entrenamiento miercoles = new Entrenamiento(LocalDate.of(2026, 11, 10), "Entrenamiento Espalda", GrupoMuscular.ESPALDA, 60, true);
        miercoles.agregarEjercicio(new Ejercicio("Dominadas", GrupoMuscular.ESPALDA, true));
        miercoles.agregarEjercicio(new Ejercicio("Remo superior", GrupoMuscular.ESPALDA, true));
        miercoles.agregarEjercicio(new Ejercicio("Remo en polea", GrupoMuscular.ESPALDA, true));
        listaEntrenamientos.add(miercoles);

        Entrenamiento jueves = new Entrenamiento(LocalDate.of(2026, 11, 11), "Entrenamiento Hombro", GrupoMuscular.HOMBRO, 50, true);
        jueves.agregarEjercicio(new Ejercicio("Press francés", GrupoMuscular.HOMBRO, true));
        jueves.agregarEjercicio(new Ejercicio("Laterales", GrupoMuscular.HOMBRO, true));
        listaEntrenamientos.add(jueves);

        Entrenamiento viernes = new Entrenamiento(LocalDate.of(2026, 11, 12), "Entrenamiento Brazos", GrupoMuscular.BRAZOS, 45, false);
        viernes.agregarEjercicio(new Ejercicio("Curl predicador", GrupoMuscular.BRAZOS, true));
        viernes.agregarEjercicio(new Ejercicio("Curl Martillo", GrupoMuscular.BRAZOS, true));
        viernes.agregarEjercicio(new Ejercicio("Francés", GrupoMuscular.BRAZOS, true));
        viernes.agregarEjercicio(new Ejercicio("Extensiones en polea", GrupoMuscular.BRAZOS, true));
        listaEntrenamientos.add(viernes);

        Entrenamiento sabado = new Entrenamiento(LocalDate.of(2026, 11, 13), "Cardio", GrupoMuscular.CARDIO, 40, true);
        sabado.agregarEjercicio(new Ejercicio("Correr", GrupoMuscular.CARDIO, true));
        sabado.agregarEjercicio(new Ejercicio("Andar en cuesta", GrupoMuscular.CARDIO, true));
        listaEntrenamientos.add(sabado);

        Entrenamiento domingo = new Entrenamiento(LocalDate.of(2026, 11, 14), "Descanso", GrupoMuscular.DESCANSO, 0, true);
        listaEntrenamientos.add(domingo);
    }

    private void actualizarSemana() {
        for (int i = 0; i < 7; i++) {
            modeloTabla.setValueAt(
                String.valueOf(diaI + i),
                0,
                i
            );
        }
        int columna = tablaCalendario.getSelectedColumn();
        mostrarEntrenamiento(columna != -1 ? columna : 0);
    }

    private void mostrarEntrenamiento(int columna) {
        int diaSeleccionado = diaI + columna;
        Entrenamiento encontrado = null;

        for (Entrenamiento e : listaEntrenamientos) {
            if (e.getFecha().getDayOfMonth() == diaSeleccionado) {
                encontrado = e;
                break;
            }
        }

        if (encontrado != null) {
            trabajoDia.setText(encontrado.generarResumen());
        } else {
            trabajoDia.setText("Día " + diaSeleccionado + "\n\nSin entrenamiento registrado.");
        }
    }
}