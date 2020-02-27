package ejem5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorEventos {
	private ArrayList<Evento> eventos;

	public GestorEventos() {
		eventos = new ArrayList<Evento>();
	}

	public void aniadirEvento(Evento e) {
		eventos.add(e);
	}

	public void ver() {
		Iterator<Evento> it = eventos.iterator();
		while (it.hasNext()) {
			Evento e = (Evento) it.next();
			System.out.println(e.toString());
		}
	}

	public void guardarEventos(String nomFich) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFich));
		for (Evento e : eventos) {
			oos.writeObject(e);
		}
		oos.writeObject(null); // Necesario para poder detectar fin de fichero
		oos.close();
	}

	public void leerEventos(String nomFich) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Carga arraylist con los eventos del fichero nomfich:
		// - Solo los no pasados
		// - Conferencias: duracion >0
		// - Conciertos: aforo > 0
		eventos.clear();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFich));
		Evento e = (Evento) ois.readObject();
		while (e != null) {
			if (!e.isPasado()) {
				if (e instanceof Conferencia) {
					Conferencia c = (Conferencia) e;
					if (c.getDuracion() > 0)
						eventos.add(c);
				}
				if (e instanceof Concierto) {
					Concierto c = (Concierto) e;
					if (c.getAforo() > 0)
						eventos.add(c);
				}
			}
			e = (Evento) ois.readObject();
		}
		ois.close();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		GestorEventos ge = new GestorEventos();
		/*
		 * ge.aniadirEvento(new Conferencia("conf1",false,"Juan Perez", -4));
		 * ge.aniadirEvento(new Conferencia("conf2",false,"Ana Perez", 10));
		 * ge.aniadirEvento(new Concierto("Conc1",false,"Queen",3000));
		 * ge.aniadirEvento(new Concierto("Conc dos",false,"Sting",10000));
		 * ge.guardarEventos("eventos.obj");
		 */
		ge.leerEventos("eventos.obj");
		ge.ver();
	}
}
