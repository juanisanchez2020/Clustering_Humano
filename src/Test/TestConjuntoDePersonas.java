package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Negocio.ConjuntoDePersonas;
import Negocio.Grafo;
import Negocio.Persona;

public class TestConjuntoDePersonas {
	
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
    }
    
    @Test
    public void containsTest() {
    	setUp();
    	assertTrue(personasList.contiene(new Persona("Fer",3,2,5,3)));
    }
    
    @Test
    public void containsTest2() {
    	setUp();
    	assertFalse(personasList.contiene(new Persona("Fernando",3,2,5,3)));
    }
    
    @Test
    public void agregarTest() {
    	setUp();
    	assertTrue(personasList.agregar(new Persona("Fernando",3,2,5,3)));
    }
    
    @Test
    public void agregarTest2() {
    	setUp();
    	assertFalse(personasList.agregar(new Persona("Fer",3,2,5,3)));
    }
    
    @Test
    public void agregarPersonasTest() {
    	setUp();
    	ConjuntoDePersonas cp = new ConjuntoDePersonas();
    	Persona p6 = new Persona("Maria",2,1,3,2);
    	Persona p7 = new Persona("Juana",4,2,5,1);
    	Persona p8 = new Persona("Virgilio",2,4,4,4);
        cp.agregar(p6);
        cp.agregar(p7);
        cp.agregar(p8);
        
        personasList.agregarPersonas(cp);
    	
        assertEquals(personasList.tamanio(),8);
    }
    
    @Test
    public void tamanioTest() {
    	setUp();
    	assertEquals(personasList.tamanio(),5);
    }

    @Test
    public void obtenerTest() {
    	setUp();
    	assertEquals(personasList.obtener(4),new Persona("Fer",3,2,5,3));
    }
}
