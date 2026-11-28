package domain;

import java.awt.Color;

public enum Colores {
	NEGRO_CARBON("#111315"),
	GRIS_OSCURO("#24282C"),
	DORADO("#D4AF70"),
	BLANCO_CALIDO("#F4F2ED"),
	GRIS_PLATA("#92999F"),
	PLATA("#C0C0C0");
	
	private final Color color;
	
	Colores(String hexadecimal) {
		this.color = Color.decode(hexadecimal);
	}
	
	public Color getColor() {
		return color;
	}
}
