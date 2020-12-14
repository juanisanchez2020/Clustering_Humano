package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import Negocio.*;

class TestGrafo {
	
	Persona p1;
    Persona p2;
    Persona p3;
    Persona p4;
    Persona p5;
    ConjuntoDePersonas personasList = new ConjuntoDePersonas();
    Grafo grafo;


    @Before
    public void setUp() {
    	p1 = new Persona("Juan",2,1,3,2);
        p2 = new Persona("Maxi",4,2,5,1);
        p3 = new Persona("Martin",2,4,4,4);
        p4 = new Persona("Ale",1,5,5,5);
        p5 = new Persona("Fer",3,2,5,3);
        personasList.agregar(p1);
        personasList.agregar(p2);
        personasList.agregar(p3);
        personasList.agregar(p4);
        personasList.agregar(p5);
        grafo = new Grafo(personasList);  
    }
    
    @Test
    public void getVecinosTest() { 
    	setUp();
    	assertEquals(grafo.getVecinos(p1).tamanio(),0);
        Grafo completo = grafo.generarGrafoCompleto();
        assertEquals(completo.getVecinos(p1).tamanio(),4);    	
    }

    @Test
    public void agregarPersonaTest() {
    	setUp();
    	assertEquals(personasList.tamanio(), 5);
    }
    	
    @Test
    public void buscarAristaMasPesadaTest() {	
    	setUp();
    	Arista esperado = new Arista(p2,p4);
    	Grafo completo = grafo.generarGrafoCompleto();
    	Arista aristaMasPesada = completo.aristaMasPesada();
    	assertTrue(esperado.equals(aristaMasPesada));
    }
    
    @Test
    public void eliminarAristaTest() {
    	setUp();
    	Arista arista = new Arista (p2,p4);
        Grafo completo = grafo.generarGrafoCompleto();
        assertTrue(completo.existeArista(arista));
        completo.eliminarArista(arista);
        assertFalse(completo.existeArista(arista));
    }
    
    @Test
    public void existeAristaTest() {
    	setUp();
    	Arista arista = new Arista (p1,p4);
    	assertFalse(grafo.existeArista(arista));
        Grafo completo = grafo.generarGrafoCompleto();
        assertTrue(completo.existeArista(arista));
    }
    
    @Test
    public void grafoCompletoTest() {
    	setUp();
    	assertFalse(grafo.esCompleto());
    	Grafo completo = grafo.generarGrafoCompleto();
    	assertTrue(completo.esCompleto());
    	System.out.print(completo.toString());
    	
    }
}
