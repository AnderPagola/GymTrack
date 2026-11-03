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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import estadisticas.VentanaEstadisticas;
import objetivos.VentanaObjetivos;
import perfil.VentanaPerfil;
import progreso.VentanaSeguimiento;
import rutinas.Rutina;

public class MisEntrenamientos extends JFrame {
	private JButton botonhistorial =new JButton("Entrenar");
	private JButton botonRutinas=new JButton("Mis rutinas");
	private JButton botonprogreso=new JButton("Progreso");
	private JButton botonperfil=new JButton("Perfil");
	private int diaI=8;
	private JTable tablaCalendario;
	private DefaultTableModel modeloTabla;
	
	public MisEntrenamientos() {
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
		panelcentro.setBackground(Color.black);
		JPanel panelsouth=new JPanel();
		panelsouth.setLayout(new GridLayout(1,4,20,20));
		formatoBoton(botonRutinas);
		formatoBoton(botonhistorial);
		formatoBoton(botonperfil);
		formatoBoton(botonprogreso);
		panelsouth.add(botonhistorial);
		panelsouth.add(botonRutinas);
		panelsouth.add(botonprogreso);
		panelsouth.add(botonperfil);
		
		botonprogreso.addActionListener(e-> {
			VentanaSeguimiento v2=new VentanaSeguimiento();
			this.dispose();
			v2.setVisible(true);
		});
		botonRutinas.addActionListener(e-> {
			Rutina v2=new Rutina();
			this.dispose();
			v2.setVisible(true);
		});
		botonhistorial.addActionListener(e-> {
			MisEntrenamientos v2=new MisEntrenamientos();
			this.dispose();
			v2.setVisible(true);
		});
		botonperfil.addActionListener(e-> {
			VentanaPerfil v2=new VentanaPerfil();
			this.dispose();
			v2.setVisible(true);
		});
		
		add(panelnorth, BorderLayout.NORTH);
		add(panelcentro, BorderLayout.CENTER);
		add(panelsouth, BorderLayout.SOUTH);
		
		
		
		
	}public void formatoBoton(JButton boton) {
		boton.setFont(new Font("Arial", Font.BOLD, 30));
		boton.setBackground(Color.CYAN);
//		boton.setOpaque(true);
//	    boton.setContentAreaFilled(true);
	    boton.setFocusPainted(false);
	    
	}
	private void actualizarSemana() {

	    for(int i = 0; i < 7; i++) {
	        modeloTabla.setValueAt(
	            String.valueOf(diaI + i),
	            0,
	            i
	        );
	    }
	}
}
