package domain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Historial;
import gui.Rutina;
import gui.VentanaEstadisticas;
import gui.VentanaObjetivos;
import gui.VentanaSeguimiento;

public class Recursos extends JFrame {
	public static JPanel crearPanelSur(JFrame ventanaActual, String pantallaActual) {
        JPanel panelSur = new JPanel(new GridLayout(1, 5));

        JButton btnProgreso = new JButton("Progreso");
        JButton btnRutinas = new JButton("Mis Rutinas");
        JButton btnHistorial = new JButton("Historial");
        JButton btnStats = new JButton("Estadísticas");
        JButton btnObjetivos = new JButton("Objetivos");

        // Deshabilitar el botón correspondiente a la ventana actual
        switch (pantallaActual) {
            case "Progreso":
                btnProgreso.setEnabled(false);
                break;
            case "Mis Rutinas":
                btnRutinas.setEnabled(false);
                break;
            case "Historial":
                btnHistorial.setEnabled(false);
                break;
            case "Estadísticas":
                btnStats.setEnabled(false);
                break;
            case "Objetivos":
                btnObjetivos.setEnabled(false);
                break;
        }

        // Configurar los listeners para navegar y cerrar la ventana actual
        btnProgreso.addActionListener(e -> {
            new VentanaSeguimiento().setVisible(true);
            ventanaActual.dispose();
        });

        btnRutinas.addActionListener(e -> {
            new Rutina().setVisible(true);
            ventanaActual.dispose();
        });

        btnHistorial.addActionListener(e -> {
            new Historial().setVisible(true);
            ventanaActual.dispose();
        });

        btnStats.addActionListener(e -> {
            new VentanaEstadisticas().setVisible(true);
            ventanaActual.dispose();
        });

        btnObjetivos.addActionListener(e -> {
            new VentanaObjetivos().setVisible(true);
            ventanaActual.dispose();
        });

        // Añadir botones al panel
        panelSur.add(btnProgreso);
        panelSur.add(btnRutinas);
        panelSur.add(btnHistorial);
        panelSur.add(btnStats);
        panelSur.add(btnObjetivos);

        return panelSur;
    }
}
