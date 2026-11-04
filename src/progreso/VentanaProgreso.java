package progreso;

// 1. Importaciones necesarias
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Comparator;

// 2. Clase principal de la ventana
public class VentanaProgreso extends JFrame {

    // 3. Componentes de la ventana
    private JComboBox<String> selectorEjercicio;

    private JLabel etiquetaPesoInicial;
    private JLabel etiquetaPesoMaximo;
    private JLabel etiquetaMejora;

    private GraficaProgreso grafica;

    // 4. Constructor
    public VentanaProgreso() {

        setTitle("Consultar Progreso");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 5. Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 15));
        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // 6. Título
        JLabel titulo = new JLabel(
            "CONSULTA TU PROGRESO",
            SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        // 7. Selector de ejercicios
        selectorEjercicio = new JComboBox<>();

        JButton botonConsultar = new JButton("Consultar progreso");

        JPanel panelSeleccion = new JPanel(new FlowLayout());

        panelSeleccion.add(new JLabel("Selecciona un ejercicio:"));
        panelSeleccion.add(selectorEjercicio);
        panelSeleccion.add(botonConsultar);

        // 8. Panel superior con título y selector
        JPanel panelSuperior = new JPanel(new BorderLayout());

        panelSuperior.add(titulo, BorderLayout.NORTH);
        panelSuperior.add(panelSeleccion, BorderLayout.SOUTH);

        // 9. Etiquetas para mostrar las estadísticas
        etiquetaPesoInicial = new JLabel("Peso inicial: --");
        etiquetaPesoMaximo = new JLabel("Peso máximo: --");
        etiquetaMejora = new JLabel("Mejora: --");

        etiquetaPesoInicial.setFont(new Font("Arial", Font.BOLD, 15));
        etiquetaPesoMaximo.setFont(new Font("Arial", Font.BOLD, 15));
        etiquetaMejora.setFont(new Font("Arial", Font.BOLD, 15));

        // 10. Panel de estadísticas
        JPanel panelEstadisticas = new JPanel(new GridLayout(1, 3, 15, 0));

        panelEstadisticas.add(etiquetaPesoInicial);
        panelEstadisticas.add(etiquetaPesoMaximo);
        panelEstadisticas.add(etiquetaMejora);

        // 11. Gráfica de evolución
        grafica = new GraficaProgreso();

        JPanel panelCentro = new JPanel(new BorderLayout(10, 15));

        panelCentro.add(panelEstadisticas, BorderLayout.NORTH);
        panelCentro.add(grafica, BorderLayout.CENTER);

        // 12. Añadir los paneles a la ventana
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        add(panelPrincipal);

        // 13. Cargar los ejercicios registrados
        cargarEjercicios();

        // 14. Acción del botón consultar
        botonConsultar.addActionListener(e -> consultarProgreso());

        // 15. Mostrar automáticamente el primer ejercicio si existe
        if (selectorEjercicio.getItemCount() > 0) {
            consultarProgreso();
        }
    }

    // 16. Método para cargar los ejercicios en el desplegable
    private void cargarEjercicios() {

        ArrayList<RegistroEntrenamiento> lista =
            VentanaRegistro.getGestor().obtenerEntrenamientos();

        LinkedHashSet<String> ejercicios = new LinkedHashSet<>();

        for (RegistroEntrenamiento registro : lista) {
            ejercicios.add(registro.getEjercicio());
        }

        selectorEjercicio.removeAllItems();

        for (String ejercicio : ejercicios) {
            selectorEjercicio.addItem(ejercicio);
        }
    }

    // 17. Método para consultar la evolución de un ejercicio
    private void consultarProgreso() {

        String ejercicioSeleccionado =
            (String) selectorEjercicio.getSelectedItem();

        if (ejercicioSeleccionado == null) {

            JOptionPane.showMessageDialog(this,
                "No hay ejercicios registrados.");

            return;
        }

        ArrayList<RegistroEntrenamiento> lista =
            VentanaRegistro.getGestor().obtenerEntrenamientos();

        // 18. Obtener los registros del ejercicio seleccionado
        ArrayList<RegistroEntrenamiento> registrosEjercicio =
            new ArrayList<>();

        for (RegistroEntrenamiento registro : lista) {

            if (registro.getEjercicio().equalsIgnoreCase(
                    ejercicioSeleccionado)) {

                registrosEjercicio.add(registro);
            }
        }

        if (registrosEjercicio.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                "No hay registros para este ejercicio.");

            return;
        }

        // 19. Ordenar los registros por fecha
        registrosEjercicio.sort(
            Comparator.comparing(RegistroEntrenamiento::getFecha)
        );

        // 20. Obtener el peso inicial
        double pesoInicial =
            registrosEjercicio.get(0).getPeso();

        // 21. Calcular el peso máximo
        double pesoMaximo = pesoInicial;

        for (RegistroEntrenamiento registro : registrosEjercicio) {

            if (registro.getPeso() > pesoMaximo) {
                pesoMaximo = registro.getPeso();
            }
        }

        // 22. Calcular la mejora
        double mejora = pesoMaximo - pesoInicial;

        // 23. Actualizar las estadísticas
        etiquetaPesoInicial.setText(
            String.format("Peso inicial: %.2f kg", pesoInicial)
        );

        etiquetaPesoMaximo.setText(
            String.format("Peso máximo: %.2f kg", pesoMaximo)
        );

        etiquetaMejora.setText(
            String.format("Mejora: %+.2f kg", mejora)
        );

        // 24. Actualizar la gráfica
        grafica.actualizarDatos(registrosEjercicio);
    }

    // 25. Clase encargada de dibujar la gráfica
    private static class GraficaProgreso extends JPanel {

        private ArrayList<RegistroEntrenamiento> registros =
            new ArrayList<>();

        public GraficaProgreso() {

            setBackground(Color.WHITE);
            setBorder(
                BorderFactory.createTitledBorder("Evolución del peso")
            );
        }

        // 26. Recibir los registros y actualizar la gráfica
        public void actualizarDatos(
            ArrayList<RegistroEntrenamiento> nuevosRegistros) {

            registros = new ArrayList<>(nuevosRegistros);

            repaint();
        }

        // 27. Dibujar la gráfica
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            if (registros.isEmpty()) {
                return;
            }

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            int ancho = getWidth();
            int alto = getHeight();

            int margenIzquierdo = 65;
            int margenDerecho = 25;
            int margenSuperior = 35;
            int margenInferior = 55;

            int anchoGrafica =
                ancho - margenIzquierdo - margenDerecho;

            int altoGrafica =
                alto - margenSuperior - margenInferior;

            if (anchoGrafica <= 0 || altoGrafica <= 0) {
                g2.dispose();
                return;
            }

            // 28. Calcular el peso mínimo y máximo
            double pesoMinimo = registros.get(0).getPeso();
            double pesoMaximo = pesoMinimo;

            for (RegistroEntrenamiento registro : registros) {

                pesoMinimo = Math.min(
                    pesoMinimo, registro.getPeso()
                );

                pesoMaximo = Math.max(
                    pesoMaximo, registro.getPeso()
                );
            }

            // Evitar que la gráfica tenga una escala de cero
            if (pesoMinimo == pesoMaximo) {
                pesoMinimo -= 5;
                pesoMaximo += 5;
            } else {
                double margen = (pesoMaximo - pesoMinimo) * 0.15;
                pesoMinimo -= margen;
                pesoMaximo += margen;
            }

            // 29. Dibujar las líneas horizontales
            g2.setColor(new Color(220, 220, 220));

            for (int i = 0; i <= 5; i++) {

                int y = margenSuperior + i * altoGrafica / 5;

                g2.drawLine(
                    margenIzquierdo,
                    y,
                    ancho - margenDerecho,
                    y
                );

                double valor =
                    pesoMaximo - i * (pesoMaximo - pesoMinimo) / 5;

                g2.setColor(Color.DARK_GRAY);

                g2.drawString(
                    String.format("%.1f", valor),
                    10,
                    y + 5
                );

                g2.setColor(new Color(220, 220, 220));
            }

            // 30. Dibujar los ejes
            g2.setColor(Color.BLACK);

            g2.drawLine(
                margenIzquierdo,
                margenSuperior,
                margenIzquierdo,
                alto - margenInferior
            );

            g2.drawLine(
                margenIzquierdo,
                alto - margenInferior,
                ancho - margenDerecho,
                alto - margenInferior
            );

            // 31. Dibujar la línea de evolución
            g2.setColor(new Color(40, 110, 200));
            g2.setStroke(new BasicStroke(3));

            Point2D.Double puntoAnterior = null;

            for (int i = 0; i < registros.size(); i++) {

                double x;

                if (registros.size() == 1) {
                    x = margenIzquierdo + anchoGrafica / 2.0;
                } else {
                    x = margenIzquierdo
                        + i * anchoGrafica / (double) (registros.size() - 1);
                }

                double peso = registros.get(i).getPeso();

                double y = margenSuperior
                    + (pesoMaximo - peso)
                    / (pesoMaximo - pesoMinimo) * altoGrafica;

                Point2D.Double puntoActual =
                    new Point2D.Double(x, y);

                if (puntoAnterior != null) {
                    g2.drawLine(
                        (int) puntoAnterior.x,
                        (int) puntoAnterior.y,
                        (int) puntoActual.x,
                        (int) puntoActual.y
                    );
                }

                // Dibujar el punto de cada sesión
                g2.fillOval(
                    (int) x - 5,
                    (int) y - 5,
                    10,
                    10
                );

                // Mostrar la fecha debajo del eje
                if (i == 0 || i == registros.size() - 1
                        || i == registros.size() / 2) {

                    String fecha = registros.get(i).getFecha()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yy"));

                    g2.setColor(Color.DARK_GRAY);

                    g2.drawString(
                        fecha,
                        (int) x - 25,
                        alto - margenInferior + 20
                    );

                    g2.setColor(new Color(40, 110, 200));
                }

                puntoAnterior = puntoActual;
            }

            g2.dispose();
        }
    }
}
