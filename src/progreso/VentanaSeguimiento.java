package progreso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaSeguimiento extends JFrame {

    // Constructor de la ventana
    public VentanaSeguimiento() {

        setTitle("GymTrack - Seguimiento del progreso");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // Título
        JLabel titulo = new JLabel(
            "Seguimiento del progreso",
            SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(
            BorderFactory.createEmptyBorder(25, 10, 25, 10)
        );

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 15, 15));

        panelBotones.setBorder(
            BorderFactory.createEmptyBorder(50, 200, 50, 200)
        );

        JButton botonRegistrar =
            new JButton("Registrar Entrenamiento");

        JButton botonHistorial =
            new JButton("Consultar Historial");

        JButton botonProgreso =
            new JButton("Consultar Progreso");

        // Añadir botones
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonHistorial);
        panelBotones.add(botonProgreso);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Añadir panel a la ventana
        add(panelPrincipal);
    }

    // Método principal
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaSeguimiento ventana =
                new VentanaSeguimiento();

            ventana.setVisible(true);
        });
    }
}
