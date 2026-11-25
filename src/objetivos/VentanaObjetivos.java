package objetivos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import estadisticas.VentanaEstadisticas;
import historial.Historial;
import principal.VentanaPrincipal;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

public class VentanaObjetivos extends JFrame {

	// VARIABLES
    private JButton btnActualizarFuerza;
    private JButton btnActualizarVolumen;
    private JButton btnActualizarPeso;
    private JButton btnAvisos;
    
    private JTextField txtObjetivoFuerza;
    private JTextField txtActualFuerza;

    private JTextField txtObjetivoVolumen;
    private JTextField txtActualVolumen;

    private JTextField txtObjetivoPeso;
    private JTextField txtActualPeso;

    private JProgressBar barraFuerza;
    private JProgressBar barraVolumen;
    private JProgressBar barraPeso;

    private JLabel lblEstadoFuerza;
    private JLabel lblEstadoVolumen;
    private JLabel lblEstadoPeso;

    public VentanaObjetivos() {

        setTitle("Objetivos");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        
        
        // PANEL SUPERIOR

        JPanel panelSuperior = new JPanel(new BorderLayout());

        JLabel lblTitulo = new JLabel("OBJETIVOS", JLabel.CENTER);

        btnAvisos = new JButton("Avisos");

        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        panelSuperior.add(btnAvisos, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);

        // PANEL CENTRAL

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 1, 10, 10));

        // FUERZA

        JPanel panelFuerza = new JPanel(new GridLayout(5, 2));

        panelFuerza.add(new JLabel("Valor objetivo:"));
        txtObjetivoFuerza = new JTextField();
        panelFuerza.add(txtObjetivoFuerza);

        panelFuerza.add(new JLabel("Valor actual:"));
        txtActualFuerza = new JTextField();
        panelFuerza.add(txtActualFuerza);

        panelFuerza.add(new JLabel("Progreso:"));

        barraFuerza = new JProgressBar(0, 100);
        barraFuerza.setStringPainted(true);
        panelFuerza.add(barraFuerza);

        panelFuerza.add(new JLabel("Estado:"));
        lblEstadoFuerza = new JLabel("Pendiente");
        panelFuerza.add(lblEstadoFuerza);

        btnActualizarFuerza = new JButton("Actualizar");
        panelFuerza.add(btnActualizarFuerza);

        panelFuerza.add(new JLabel("FUERZA"));

        // VOLUMEN

        JPanel panelVolumen = new JPanel(new GridLayout(5, 2));

        panelVolumen.add(new JLabel("Valor objetivo:"));
        txtObjetivoVolumen = new JTextField();
        panelVolumen.add(txtObjetivoVolumen);

        panelVolumen.add(new JLabel("Valor actual:"));
        txtActualVolumen = new JTextField();
        panelVolumen.add(txtActualVolumen);

        panelVolumen.add(new JLabel("Progreso:"));

        barraVolumen = new JProgressBar(0, 100);
        barraVolumen.setStringPainted(true);
        panelVolumen.add(barraVolumen);

        panelVolumen.add(new JLabel("Estado:"));
        lblEstadoVolumen = new JLabel("Pendiente");
        panelVolumen.add(lblEstadoVolumen);

        btnActualizarVolumen = new JButton("Actualizar");
        panelVolumen.add(btnActualizarVolumen);

        panelVolumen.add(new JLabel("VOLUMEN"));

        // PESO

        JPanel panelPeso = new JPanel(new GridLayout(5, 2));

        panelPeso.add(new JLabel("Valor objetivo:"));
        txtObjetivoPeso = new JTextField();
        panelPeso.add(txtObjetivoPeso);

        panelPeso.add(new JLabel("Valor actual:"));
        txtActualPeso = new JTextField();
        panelPeso.add(txtActualPeso);

        panelPeso.add(new JLabel("Progreso:"));

        barraPeso = new JProgressBar(0, 100);
        barraPeso.setStringPainted(true);
        panelPeso.add(barraPeso);

        panelPeso.add(new JLabel("Estado:"));
        lblEstadoPeso = new JLabel("Pendiente");
        panelPeso.add(lblEstadoPeso);

        btnActualizarPeso = new JButton("Actualizar");
        panelPeso.add(btnActualizarPeso);

        panelPeso.add(new JLabel("PESO"));
        
        //AÑADIR A PANEL 
        panelCentral.add(panelFuerza);
        panelCentral.add(panelVolumen);
        panelCentral.add(panelPeso);

        add(panelCentral, BorderLayout.CENTER);

        // PANEL INFERIOR

        JPanel panelInferior = new JPanel(new GridLayout(1,5));

        JButton btnProgreso = new JButton("Progreso");
        JButton btnRutinas = new JButton("Mis rutinas");
        JButton btnHistorial = new JButton("Historial");
        JButton btnEstadisticas = new JButton("Estadísticas");
        JButton btnObjetivos = new JButton("Objetivos");
        btnObjetivos.setEnabled(false);
        

        
        panelInferior.add(btnProgreso);
        panelInferior.add(btnRutinas);
        panelInferior.add(btnHistorial);
        panelInferior.add(btnEstadisticas);
        panelInferior.add(btnObjetivos);

        add(panelInferior, BorderLayout.SOUTH);

        // EVENTOS

        btnProgreso.addActionListener(e -> {
            dispose();
            new VentanaSeguimiento();
        });
        
        btnRutinas.addActionListener(e -> {
            dispose();
            new Rutina();
        });
        
        btnHistorial.addActionListener(e -> {
            dispose();
            new Historial();
        });
        
        btnEstadisticas.addActionListener(e -> {
            dispose();
            new VentanaEstadisticas();
        });

        btnAvisos.addActionListener(e -> {
            dispose();
            new VentanaAvisos();
        });
        
        // BOTONES DE ACTUALIZAR (ACTION LISTENERS)
        btnActualizarFuerza.addActionListener(e -> {

            actualizarObjetivo(
                    txtObjetivoFuerza,
                    txtActualFuerza,
                    barraFuerza,
                    lblEstadoFuerza);
        });

        btnActualizarVolumen.addActionListener(e -> {

            actualizarObjetivo(
                    txtObjetivoVolumen,
                    txtActualVolumen,
                    barraVolumen,
                    lblEstadoVolumen);
        });

        btnActualizarPeso.addActionListener(e -> {

            actualizarObjetivo(
                    txtObjetivoPeso,
                    txtActualPeso,
                    barraPeso,
                    lblEstadoPeso);
        });
        

        setVisible(true);
    }
    
    private void actualizarObjetivo(JTextField txtObjetivo,
            JTextField txtActual,
            JProgressBar barra,
            JLabel estado) {

    	try {
    		
    		int objetivo = Integer.parseInt(txtObjetivo.getText());
    		int actual = Integer.parseInt(txtActual.getText());
    		
    		if (objetivo <= 0) {
    			
    			JOptionPane.showMessageDialog(this, "El objetivo debe ser mayor que 0");
    			return;
    		}
    		
    		int porcentaje = (actual * 100) / objetivo;
    		
    		if (porcentaje > 100) {
    			porcentaje = 100;
    		}
    		
    		final int destino = porcentaje;
    		
    		Thread hilo = new Thread(() -> {
    			
    			int inicio = barra.getValue();
    			
    			if (inicio < destino) {
    				
    				for (int i = inicio; i <= destino; i++) {
    					
    					barra.setValue(i);
    					
    					try {
    						Thread.sleep(15);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
    				}
    				
    			} else {
    				
    				for (int i = inicio; i >= destino; i--) {
    					
    					barra.setValue(i);
    					
    					try {
    						Thread.sleep(15);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
    				}
    			}
    			
    			if (destino >= 100) {
    				
    				estado.setText("Completado");
    				
    			} else {
    				
    				estado.setText(destino + "%");
    			}
    		});

    		hilo.start();
    		
    	} catch (NumberFormatException e) {
    		
    		JOptionPane.showMessageDialog(this, "Introduce valores numéricos válidos");
    	}
    }
}


