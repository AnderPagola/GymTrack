package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Ejercicio;
import domain.Entrenamiento;
import domain.Recursos;

public class VentanaProgreso extends JFrame {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> selectorEjercicio;
    private JLabel etiquetaPesoInicial;
    private JLabel etiquetaPesoMaximo;
    private JLabel etiquetaMejora;
    private GraficaProgreso grafica;

    // Estructura auxiliar para vincular la fecha del Entrenamiento con el peso del Ejercicio
    private static class DatoGrafica {
        final LocalDate fecha;
        final double peso;

        DatoGrafica(LocalDate fecha, double peso) {
            this.fecha = fecha;
            this.peso = peso;
        }
    }

    public VentanaProgreso() {
        setTitle("Consultar Progreso");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 15));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("CONSULTA TU PROGRESO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        selectorEjercicio = new JComboBox<>();
        JButton botonConsultar = new JButton("Consultar progreso");

        JPanel panelSeleccion = new JPanel(new FlowLayout());
        panelSeleccion.add(new JLabel("Selecciona un ejercicio:"));
        panelSeleccion.add(selectorEjercicio);
        panelSeleccion.add(botonConsultar);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(titulo, BorderLayout.NORTH);
        panelSuperior.add(panelSeleccion, BorderLayout.SOUTH);

        etiquetaPesoInicial = new JLabel("Peso inicial: --");
        etiquetaPesoMaximo = new JLabel("Peso máximo: --");
        etiquetaMejora = new JLabel("Mejora: --");

        etiquetaPesoInicial.setFont(new Font("Arial", Font.BOLD, 15));
        etiquetaPesoMaximo.setFont(new Font("Arial", Font.BOLD, 15));
        etiquetaMejora.setFont(new Font("Arial", Font.BOLD, 15));

        JPanel panelEstadisticas = new JPanel(new GridLayout(1, 3, 15, 0));
        panelEstadisticas.add(etiquetaPesoInicial);
        panelEstadisticas.add(etiquetaPesoMaximo);
        panelEstadisticas.add(etiquetaMejora);

        grafica = new GraficaProgreso();

        JPanel panelCentro = new JPanel(new BorderLayout(10, 15));
        panelCentro.add(panelEstadisticas, BorderLayout.NORTH);
        panelCentro.add(grafica, BorderLayout.CENTER);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        add(panelPrincipal);

        cargarEjercicios();
        botonConsultar.addActionListener(e -> consultarProgreso());

        if (selectorEjercicio.getItemCount() > 0) {
            consultarProgreso();
        }
        Recursos.configurarAtajoCerrar(this);
    }

    private void cargarEjercicios() {
        List<Entrenamiento> lista = VentanaRegistro.obtenerEntrenamientos();
        LinkedHashSet<String> ejercicios = new LinkedHashSet<>();

        for (Entrenamiento entrenamiento : lista) {
            for (Ejercicio ejercicio : entrenamiento.getEjerciciosRealizados()) {
                ejercicios.add(ejercicio.getNombre());
            }
        }

        selectorEjercicio.removeAllItems();
        for (String ejercicio : ejercicios) {
            selectorEjercicio.addItem(ejercicio);
        }
    }

    private void consultarProgreso() {
        String ejercicioSeleccionado = (String) selectorEjercicio.getSelectedItem();

        if (ejercicioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "No hay ejercicios registrados.");
            return;
        }

        List<Entrenamiento> lista = VentanaRegistro.obtenerEntrenamientos();
        ArrayList<DatoGrafica> registrosEjercicio = new ArrayList<>();

        for (Entrenamiento entrenamiento : lista) {
            for (Ejercicio ejercicio : entrenamiento.getEjerciciosRealizados()) {
                if (ejercicio.getNombre().equalsIgnoreCase(ejercicioSeleccionado)) {
                    registrosEjercicio.add(new DatoGrafica(entrenamiento.getFecha(), ejercicio.getPesoKg()));
                }
            }
        }

        if (registrosEjercicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay registros para este ejercicio.");
            return;
        }

        registrosEjercicio.sort(Comparator.comparing(d -> d.fecha));

        double pesoInicial = registrosEjercicio.get(0).peso;
        double pesoMaximo = pesoInicial;

        for (DatoGrafica dato : registrosEjercicio) {
            if (dato.peso > pesoMaximo) {
                pesoMaximo = dato.peso;
            }
        }

        double mejora = pesoMaximo - pesoInicial;

        etiquetaPesoInicial.setText(String.format("Peso inicial: %.2f kg", pesoInicial));
        etiquetaPesoMaximo.setText(String.format("Peso máximo: %.2f kg", pesoMaximo));
        etiquetaMejora.setText(String.format("Mejora: %+.2f kg", mejora));

        grafica.actualizarDatos(registrosEjercicio);
    }

    private static class GraficaProgreso extends JPanel {
        private static final long serialVersionUID = 1L;
        private ArrayList<DatoGrafica> registros = new ArrayList<>();

        public GraficaProgreso() {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createTitledBorder("Evolución del peso"));
        }

        public void actualizarDatos(ArrayList<DatoGrafica> nuevosRegistros) {
            registros = new ArrayList<>(nuevosRegistros);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (registros.isEmpty()) {
                return;
            }

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int ancho = getWidth();
            int alto = getHeight();
            int margenIzquierdo = 65;
            int margenDerecho = 25;
            int margenSuperior = 35;
            int margenInferior = 55;

            int anchoGrafica = ancho - margenIzquierdo - margenDerecho;
            int altoGrafica = alto - margenSuperior - margenInferior;

            if (anchoGrafica <= 0 || altoGrafica <= 0) {
                g2.dispose();
                return;
            }

            double pesoMinimo = registros.get(0).peso;
            double pesoMaximo = pesoMinimo;

            for (DatoGrafica registro : registros) {
                pesoMinimo = Math.min(pesoMinimo, registro.peso);
                pesoMaximo = Math.max(pesoMaximo, registro.peso);
            }

            if (pesoMinimo == pesoMaximo) {
                pesoMinimo -= 5;
                pesoMaximo += 5;
            } else {
                double margen = (pesoMaximo - pesoMinimo) * 0.15;
                pesoMinimo -= margen;
                pesoMaximo += margen;
            }

            g2.setColor(new Color(220, 220, 220));
            for (int i = 0; i <= 5; i++) {
                int y = margenSuperior + i * altoGrafica / 5;
                g2.drawLine(margenIzquierdo, y, ancho - margenDerecho, y);

                double valor = pesoMaximo - i * (pesoMaximo - pesoMinimo) / 5;
                g2.setColor(Color.DARK_GRAY);
                g2.drawString(String.format("%.1f", valor), 10, y + 5);
                g2.setColor(new Color(220, 220, 220));
            }

            g2.setColor(Color.BLACK);
            g2.drawLine(margenIzquierdo, margenSuperior, margenIzquierdo, alto - margenInferior);
            g2.drawLine(margenIzquierdo, alto - margenInferior, ancho - margenDerecho, alto - margenInferior);

            g2.setColor(new Color(40, 110, 200));
            g2.setStroke(new BasicStroke(3));

            Point2D.Double puntoAnterior = null;

            for (int i = 0; i < registros.size(); i++) {
                double x;
                if (registros.size() == 1) {
                    x = margenIzquierdo + anchoGrafica / 2.0;
                } else {
                    x = margenIzquierdo + i * anchoGrafica / (double) (registros.size() - 1);
                }

                double peso = registros.get(i).peso;
                double y = margenSuperior + (pesoMaximo - peso) / (pesoMaximo - pesoMinimo) * altoGrafica;

                Point2D.Double puntoActual = new Point2D.Double(x, y);

                if (puntoAnterior != null) {
                    g2.drawLine((int) puntoAnterior.x, (int) puntoAnterior.y, (int) puntoActual.x, (int) puntoActual.y);
                }

                g2.fillOval((int) x - 5, (int) y - 5, 10, 10);

                if (i == 0 || i == registros.size() - 1 || i == registros.size() / 2) {
                    String fecha = registros.get(i).fecha.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
                    g2.setColor(Color.DARK_GRAY);
                    g2.drawString(fecha, (int) x - 25, alto - margenInferior + 20);
                    g2.setColor(new Color(40, 110, 200));
                }

                puntoAnterior = puntoActual;
            }

            g2.dispose();
        }
    }
}