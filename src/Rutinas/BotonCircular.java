package Rutinas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

public class BotonCircular extends JButton{
	
	public BotonCircular(String texto) {
		super(texto);
        setContentAreaFilled(true);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setBackground(Color.CYAN);
        setFont(new Font("Arial", Font.BOLD, 30));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillOval(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

}
