package Negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

	protected ConjuntoDePersonas vertices;
	protected ArrayList<Arista> aristas;

	public Grafo(ConjuntoDePersonas cp) {
		this.setVertices(cp);
		this.setAristas(new ArrayList<Arista>());
	}

	private Grafo(ConjuntoDePersonas vertices, ArrayList<Arista> aristas) { // Se utiliza en eliminarAristaMasPesada()		
		this.setVertices(vertices);
		this.setAristas(aristas);
	}

	public Grafo generarAGMKuskal() {
		// ordenar aristas por peso de menor a mayor
		ArrayList<Arista> aristasOrdenadas = this.getAristas();
		aristasOrdenadas.sort((a1, a2) -> a1.getPeso().compareTo(a2.getPeso()));
		// creo un grafo con los mismos vertices que el que entra por parametro
		Grafo arbolGM = new Grafo(this.getVertices());
		// agrego la primer arista (es la de menor peso)		
		arbolGM.agregarArista(aristasOrdenadas.get(0));
		aristasOrdenadas.remove(0);
		// for each de aristas
		for (Arista arista : aristasOrdenadas) // omito la primer arista porque ya la agregue
		{
			//// verificar si al agregar una arista se genera un ciclo (bfs)
			// si a partir de un arbol selecciono un vertice de la arista que quiero
			//// agregar, y llego al otro
			// vertice de la arista, significa que ya hay un camino y agregar la arista
			//// forma un ciclo
			if (!arbolGM.alcanzables(arista.getPersona1()).contiene(arista.getPersona2()))
				//// si no se genera, agregar arista
				arbolGM.agregarArista(arista);
			//// si se genera, no agregao la arista
		}
		// al finalizar tengo un AGM de kruskal
		return arbolGM;
	}

	public ConjuntoDePersonas alcanzables(Persona persona) {
		ConjuntoDePersonas visitados = new ConjuntoDePersonas();
		ConjuntoDePersonas vecinos = new ConjuntoDePersonas();
		Queue<Persona> cola = new LinkedList<Persona>();
		// Start by putting any one of the graph's vertices at the back of a queue.
		cola.add(persona);
		// Keep repeating until the queue is empty.
		while (cola.size() > 0) {
			// Take the front item of the queue and add it to the visited list.
			Persona esVisitado = cola.poll();
			visitados.agregar(esVisitado);
			// Create a list of that vertex's adjacent nodes.
			vecinos = getVecinos(esVisitado);
			// Add the ones which aren't in the visited list to the back of the queue.
			for (Persona p : vecinos.list())
				if (!visitados.list().contains(p))
					cola.add(p);
		}
		return visitados;
	}

	public ArrayList<Grafo> separarGrafoEnDos() {
		ArrayList<Grafo> ret = new ArrayList<Grafo>();

		Arista aristaMasPesada = this.eliminarAristaMasPesada();

		ConjuntoDePersonas personas1 = alcanzables(aristaMasPesada.getPersona1());
		ConjuntoDePersonas personas2 = alcanzables(aristaMasPesada.getPersona2());
		ArrayList<Arista> aristas1 = restaurarAristas(personas1);
		ArrayList<Arista> aristas2 = restaurarAristas(personas2);

		Grafo grafo1 = new Grafo(personas1, aristas1);
		Grafo grafo2 = new Grafo(personas2, aristas2);

		ret.add(grafo1);
		ret.add(grafo2);

		return ret;
	}

	public Arista eliminarAristaMasPesada() {
		Arista ret = aristaMasPesada();
		eliminarArista(ret);
		return ret;
	}

	public Arista aristaMasPesada() {
		ArrayList<Arista> aristasOrdenadas = ordenarAristasDesc(getAristas());
		return aristasOrdenadas.get(aristasOrdenadas.size() - 1);
	}

	private ArrayList<Arista> ordenarAristasDesc(ArrayList<Arista> aristas) {
		aristas.sort((a1, a2) -> a1.getPeso().compareTo(a2.getPeso()));
		return aristas;
	}

	public ArrayList<Arista> restaurarAristas2(ConjuntoDePersonas personas) {
		ArrayList<Arista> ret = new ArrayList<Arista>();
		return ret;
	}

	private ArrayList<Arista> restaurarAristas(ConjuntoDePersonas personas) {
		ArrayList<Arista> ret = new ArrayList<Arista>();
		for (Persona persona : personas.list())
			if (!ret.contains(restaurarAristas(persona)) && restaurarAristas(persona) != null)
				ret.add(restaurarAristas(persona));
		return ret;
	}

	private Arista restaurarAristas(Persona vertice) {
		Arista ret = null;
		for (Arista arista : this.getAristas())
			if (arista.personaEsta(vertice))
				return ret = new Arista(arista.getPersona1(), arista.getPersona2());
		return ret;
	}

	public boolean esConexo() {
		if (getAristas() == null || getVertices() == null)
			throw new IllegalArgumentException("El grafo es null");
		if (getVertices().tamanio() == 0)
			return true;
		return alcanzables(getVertices().obtener(0)).tamanio() == getVertices().tamanio();
	}

	public Grafo generarGrafoCompleto() {
		Grafo ret = new Grafo(getVertices());
		for (int i = 0; i <= ret.getVertices().tamanio(); i++)
			for (int j = i + 1; j < ret.getVertices().tamanio(); j++)
				ret.agregarArista(new Arista(ret.getVertices().obtener(i), ret.getVertices().obtener(j)));
		return ret;
	}

	public void agregarArista(Arista arista) {
		if (!existeArista(arista))
			aristas.add(arista);
	}

	public void eliminarArista(Arista arista) {
		if (existeArista(arista))
			aristas.remove(arista);
	}

	public boolean existeArista(Arista arista) {
		for (int i = 0; i < this.getAristas().size(); i++) {
			Arista aristaGrafo = this.getAristas().get(i);
			if (aristaGrafo.equals(arista))
				return true;
		}
		return false;
	}

	public ConjuntoDePersonas getVecinos(Persona vertice) {
		ConjuntoDePersonas vecinos = new ConjuntoDePersonas();
		for (Arista arista : getAristas()) {
			if (vertice.equals(arista.getPersona1()))
				vecinos.agregar(arista.getPersona2());
			else if (vertice.equals(arista.getPersona2()))
				vecinos.agregar(arista.getPersona1());
		}
		return vecinos;
	}

	///////////////////////////////////////////////////////////////////PROMEDIOS
	public double promedioDeporte() {
		double ret = 0;
		for (Persona p : this.getVertices().list()) {
			ret = ret + p.getDeportes();
		}
		return promedio(ret);
		
	}

	public double promedioMusica() {
		double ret = 0;
		for (Persona p : this.getVertices().list()) {
			ret = ret + p.getMusica();
		}
		return promedio(ret);
	}

	public double promedioEspectaculos() {
		
		double ret = 0;
		for (Persona p : this.getVertices().list()) {
			ret = ret + p.getEspectaculos();
		}
		return promedio(ret);
	}

	public double promedioCiencia() {
		double ret = 0;
		for (Persona p : this.getVertices().list()) {
			ret = ret + p.getCiencia();
		}
		return promedio(ret);
	}

	public int promedioPesoAristas() {
		int ret = 0;
		for (Arista a : this.getAristas()) {
			ret = ret + a.getPeso();
		}
		return ret / (this.getAristas().size());
	}
	
	private double promedio(double n) {
		return (double)Math.round((n/this.getVertices().tamanio())*100d)/100;
	}

	public static <T> Iterable<T> skipFirst(final Iterable<T> c) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				Iterator<T> i = c.iterator();
				i.next();
				return i;
			}
		};
	}
	
	public boolean esCompleto() { 						//se usa??
		for (int i = 0; i < getVertices().tamanio(); i++) {
			for (int j = i + 1; j < getVertices().tamanio(); j++) {
				if (!existeArista(new Arista(vertices.obtener(i), vertices.obtener(j)))) {
					return false;
				}
			}
		}
		return true;
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("-Vertices \n");
		for (int i = 0; i < vertices.tamanio(); i++) {
			s.append(vertices.obtener(i).toString());
		}
		s.append("-Aristas \n");
		for (int j = 0; j < aristas.size(); j++) {
			s.append(aristas.get(j).toString());
		}
		return s.toString();
	}

////////////////////////////////////////////////////////////GETTERS & SETTERS

	public ConjuntoDePersonas getVertices() { return vertices; }

	public ArrayList<Arista> getAristas() { return aristas; }

	public void setVertices(ConjuntoDePersonas vertices) { this.vertices = vertices; }

	public void setAristas(ArrayList<Arista> aristas) { this.aristas = aristas; }
}
