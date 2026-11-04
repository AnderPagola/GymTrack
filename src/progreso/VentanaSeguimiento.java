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

import estadisticas.VentanaEstadisticas;
import historial.Historial;
import objetivos.VentanaObjetivos;
import rutinas.Rutina;

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
        JLabel titulo = new JLabel("Seguimiento del progreso",SwingConstants.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 15, 15));

        panelBotones.setBorder(
            BorderFactory.createEmptyBorder(50, 200, 50, 200)
        );

        JButton botonRegistrar = new JButton("Registrar Entrenamiento");
        botonRegistrar.addActionListener(e-> {
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

        // Añadir botones
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonHistorial);
        panelBotones.add(botonProgreso);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        
        //Botones para accedes a otros apartados
        JButton progreso = new JButton("Progreso");
        JButton rutinas = new JButton("Rutinas");
        JButton historial = new JButton("Historial");
        JButton stats = new JButton("Estadísticas");
        JButton objetivos = new JButton("Objetivos");
        progreso.setEnabled(false);
        
        progreso.addActionListener(e-> {
			VentanaSeguimiento v2=new VentanaSeguimiento();
			this.dispose();
			v2.setVisible(true);
		});
		rutinas.addActionListener(e-> {
			Rutina v2=new Rutina();
			this.dispose();
			v2.setVisible(true);
		});
		historial.addActionListener(e-> {
			Historial v2=new Historial();

			this.dispose();
			v2.setVisible(true);
		});
		stats.addActionListener(e-> {
			VentanaEstadisticas v2=new VentanaEstadisticas();
			this.dispose();
			v2.setVisible(true);
		});
		objetivos.addActionListener(e-> {
			VentanaObjetivos v2=new VentanaObjetivos();
			this.dispose();
			v2.setVisible(true);
		});
		
		//Crear el panel del menú
		JPanel panelBotones2 = new JPanel();

		//Añadir los botones al panel
		panelBotones2.add(progreso);
		panelBotones2.add(rutinas);
		panelBotones2.add(historial);
		panelBotones2.add(stats);
		panelBotones2.add(objetivos);
		
		panelPrincipal.add(panelBotones2, BorderLayout.SOUTH);

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
