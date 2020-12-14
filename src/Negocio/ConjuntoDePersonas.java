package Negocio;

import java.io.Serializable;
import java.util.ArrayList;

public class ConjuntoDePersonas implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personas;

	public ConjuntoDePersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ConjuntoDePersonas() {
		this.personas = new ArrayList<Persona>();
	}

	public ArrayList<Persona> list() {
		return personas;
	}

	public void list(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public boolean agregar(Persona p) {
		if (!personas.contains(p)) {
			personas.add(p);
			return true;
		}
		return false;	
	}

	public void remover(Persona p) {
		personas.remove(p);
	}

	public void agregarPersonas(ConjuntoDePersonas cp) {
		for (Persona p : cp.list())
			this.agregar(p);
	}

	public boolean contiene(Persona p) {
		return list().contains(p);
	}

	public int tamanio() {
		return list().size();
	}

	public Persona obtener(int i) {
		return list().get(i);
	}
	
	public boolean equals(ConjuntoDePersonas cp) {
		if (cp.tamanio() != this.tamanio()) {
			return false;
		}
		for (Persona p : cp.list()) {
			if (!this.contiene(p)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() { //REVISAR
		StringBuilder ret = new StringBuilder();
		for(Persona p : this.personas)
			ret.append(p.toString());
		
		return ret.toString();
	}
}
