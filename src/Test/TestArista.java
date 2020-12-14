package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Negocio.*;

class TestArista {
	
	Persona p1;
    Persona p2;
    Arista arista;

    @Before
    public void setUp() {
    	p1 = new Persona("Juan",2,3,1,5);
        p2 = new Persona("Pedro",5,5,1,1);
        arista=new Arista(p1,p2);
    }
    
    @Test
    public void calcularParecidoTest() {
    	setUp();
    	assertEquals(arista.getPeso(),9);
    }
    
    @Test
    public void equalsTest() {
    	setUp();
    	Arista arista2 = new Arista(p2,p1);
    	assertEquals(arista, arista2);
    }

    @Test
    public void personaEstaTest() {
    	setUp();
    	Persona p1bis = new Persona("Juan",2,3,1,5);
    	assertTrue(arista.personaEsta(p1bis));
    }
}
