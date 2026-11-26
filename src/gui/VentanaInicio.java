package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.Colores;
import domain.Recursos;

public class VentanaInicio extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIniciarSesion;

    public VentanaInicio() {

        setTitle("Inicio de Sesión");
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        JPanel panelTodo = new JPanel();
        panelTodo.setLayout(new BorderLayout());
        panelTodo.setBackground(Colores.NEGRO_CARBON.getColor());
        add(panelTodo, BorderLayout.CENTER);

        // Título
        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Colores.BLANCO_CALIDO.getColor());


        // Panel central
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelFormulario.setBackground(Colores.NEGRO_CARBON.getColor());

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setForeground(Colores.BLANCO_CALIDO.getColor());
        panelFormulario.add(labelUsuario);
        txtUsuario = new JTextField();
        panelFormulario.add(txtUsuario);

        JLabel labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setForeground(Colores.BLANCO_CALIDO.getColor());
        panelFormulario.add(labelContraseña);
        txtContrasena = new JPasswordField();
        panelFormulario.add(txtContrasena);

        // Botón
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBackground(Colores.DORADO.getColor());

        // Organización
        panelTodo.add(lblTitulo, BorderLayout.NORTH);
        panelTodo.add(panelFormulario, BorderLayout.CENTER);
        panelTodo.add(btnIniciarSesion, BorderLayout.SOUTH);
        
        btnIniciarSesion.addActionListener(e-> {
        	
        	String usuario = txtUsuario.getText();
            String contra = String.valueOf(txtContrasena.getPassword());

            if (usuario.trim().isEmpty() || contra.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debes rellenar todos los campos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        	}else {
        		VentanaPrincipal v2=new VentanaPrincipal();
    			this.dispose();
    			v2.setVisible(true);
        	}
        });

        setVisible(true);
        Recursos.configurarAtajoCerrar(this);
    }
}