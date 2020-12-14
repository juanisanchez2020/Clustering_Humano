package Negocio;

import Modelo.Persistencia;

public class Negocio {
	
	Persona p;
	ConjuntoDePersonas personas;
	
	public Negocio () {
		this.personas = new ConjuntoDePersonas();
	}
	
	public void crearPersona(String nombre, int deporte, int musica, int espectaculo, int ciencia) {
		Persona p = new Persona (nombre, deporte, musica, espectaculo, ciencia);
		personas.agregar(p);		
	}
	
	public void exportar() {	
		Persistencia json = new Persistencia();
		json.guardar(personas);
	}
	
	public ConjuntoDePersonas importar() {
		Persistencia json = new Persistencia();
		personas = json.cargar();
		return personas;
	}
	
	public Grafo crearGrafo() {
		return new Grafo(personas);
	}
	
	public void eliminarPersona(int n) {
		personas.list().remove(n);
	}
	public ConjuntoDePersonas getPersonas() {
		return this.personas;
	}

	public boolean esGenerable() {		
		return personas.list().size() > 1;
	}
	
	
}
