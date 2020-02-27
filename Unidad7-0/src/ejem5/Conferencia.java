package ejem5;

public class Conferencia extends Evento {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ponente;
	private int duracion;

	public Conferencia(String nombre, boolean pasado, String ponente, int duracion) {
		super(nombre, pasado);
		this.ponente = ponente;
		this.duracion = duracion;
	}

	public String toString() {
		return "Conferencia [pone=" + ponente + ", dun=" + duracion+ ", toString()=" + super.toString() + "]";
	}

	public int getDuracion() {
		return duracion;
	}
}

