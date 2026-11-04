package historial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import estadisticas.VentanaEstadisticas;
import objetivos.VentanaObjetivos;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

public class Historial extends JFrame {
	private JButton historial =new JButton("Historial");
	private JButton Rutinas=new JButton("Mis rutinas");
	private JButton progreso=new JButton("Progreso");
	private JButton stats=new JButton("Estadisticas");
	private JButton objetivos=new JButton("Obejtivos");
	private int diaI=8;
	private JTable tablaCalendario;
	private DefaultTableModel modeloTabla;
	private JTextArea trabajoDia=new JTextArea();
	
	public Historial() {
		// TODO Auto-generated constructor stub
		
		setTitle("Historial y evolucion");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		 	
		JPanel panelnorth= new JPanel();
		panelnorth.setBorder(BorderFactory.createTitledBorder("Mis Entrenamientos"));
		panelnorth.setBackground(Color.gray);
		panelnorth.setPreferredSize(new Dimension(0,120));
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
//**PARTE DE LA TABLA AYUDADA CON IA
		modeloTabla = new DefaultTableModel(datos, columnas) {
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
		tablaCalendario.setSelectionMode(
			    javax.swing.ListSelectionModel.SINGLE_SELECTION
			);

		JScrollPane scroll = new JScrollPane(tablaCalendario);

		panelnorth.add(scroll, BorderLayout.CENTER);
		JButton botonantes=new JButton("Semana pasada");
		JButton botonactual=new JButton("Semana actual");
		JButton botondespues=new JButton("Semana siguente");
		
		botonantes.addActionListener(e->{
			    diaI -= 7;
			    if(diaI<1) {
					JOptionPane.showMessageDialog(
						    this,
						    "No puedes retroceder más",
						    "Error",
						    JOptionPane.ERROR_MESSAGE
						);//Mensaje creado con IA
				}else {
					actualizarSemana();
				}
			    
			    
		});
		
		botondespues.addActionListener(e->{
			diaI+=7;
			if(diaI>22) {
				JOptionPane.showMessageDialog(
					    this,
					    "No puedes avanzar más",
					    "Error",
					    JOptionPane.ERROR_MESSAGE
					);
			}else {
				actualizarSemana();
			}
		});
		botonactual.addActionListener(e->{
			diaI=8;
			actualizarSemana();
		});
		JPanel panelsur2=new JPanel();
		panelsur2.setLayout(new GridLayout(1,3,20,20));
		panelsur2.add(botonantes);
		panelsur2.add(botonactual);
		panelsur2.add(botondespues);
		panelnorth.add(panelsur2,BorderLayout.SOUTH);
	
		
		JPanel panelcentro=new JPanel();
		
		trabajoDia.setEditable(false);
		trabajoDia.setFont(new Font("Arial",Font.PLAIN,16));
		panelcentro.setLayout(new BorderLayout());
		panelcentro.add(trabajoDia,BorderLayout.CENTER);
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

		JPanel panelsouth=new JPanel();
		panelsouth.setLayout(new GridLayout(1,5,20,20));

		panelsouth.add(progreso);
		panelsouth.add(Rutinas);
		panelsouth.add(historial);
		panelsouth.add(stats);
		panelsouth.add(objetivos);
		historial.setEnabled(false);
		
		progreso.addActionListener(e-> {
			VentanaSeguimiento v2=new VentanaSeguimiento();
			this.dispose();
			v2.setVisible(true);
		});
		Rutinas.addActionListener(e-> {
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
		
		
		add(panelnorth, BorderLayout.NORTH);
		add(panelcentro, BorderLayout.CENTER);
		add(panelsouth, BorderLayout.SOUTH);
		
	}
	private void actualizarSemana() {

	    for(int i = 0; i < 7; i++) {
	        modeloTabla.setValueAt(
	            String.valueOf(diaI + i),
	            0,
	            i
	        );
	    }
	}private void mostrarEntrenamiento(int columna3) {

	    switch (columna3) {

	        case 0: 
	            trabajoDia.setText(
	                "Entrenamiento Pierna\n\n" +
	                "✓ Sentadillas\n" +
	                "✓ Prensa\n" +
	                "✓ Extensiones\n\n" +
	                "✓ Mejor que última sesión"
	            );
	            break;

	        case 1: 
	            trabajoDia.setText(
	                "Entrenamiento Pecho\n\n" +
	                "✓ Press banca\n" +
	                "✓ Press inclinado\n" +
	                "✓ Aperturas"
	            );
	            break;

	        case 2: // Miércoles
	            trabajoDia.setText(
	            		"Entrenamiento Espalda\n\n"+
	            		"✓ Dominadas\n" +
	            		"✓ Remo superior\n" +
	    	            "✓ Remo en polea"
	            );
	            break;

	        case 3: 
	            trabajoDia.setText(
	                "Entrenamiento Hombro\n\n"+
	                	"Press frances\n"+
	                		"Laterales"
	            );
	            break;

	        case 4: 
	            trabajoDia.setText(
	                "Entrenamiento Brazos\n\n"+
	                "Curl predicador\n"+
	                		"Curl Martillo\n"+
	                "Frances\n"+
	                		"Extensiones en polea"
	            );
	            break;

	        case 5: 
	            trabajoDia.setText(
	                "Cardio\n\n"+"Correr"
	            );
	            break;

	            
	        case 6: 
	            trabajoDia.setText(
	                "Descanso"
	            );
	            break;
	            
	    }
	}
}
