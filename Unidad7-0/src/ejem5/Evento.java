package ejem5;

import java.io.Serializable;

public abstract class Evento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean pasado;

	public Evento(String nombre, boolean pasado) {
		this.nombre = nombre;
		this.pasado = pasado;
	}

	public String toString() {
		return "Evento [nombre=" + nombre + ", pasado=" + pasado + "]";
	}

	public boolean isPasado() {
		return pasado;
	}
}

