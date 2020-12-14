package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Negocio.Persona;

class TestPersona {
	
	Persona p1;
    Persona p2;
    Persona p3;

    @Before
    public void setUp() {
    	p1 = new Persona("Juan",2,3,1,5);
        p2 = new Persona("Pedro",5,5,1,1);
        p3 = new Persona("Lucia",5,5,1,1);
    }

    @Test //(expected = IllegalArgumentException.class) FALTA TERMINAR
    public void valoresIncorrectosTest() {
    	p1 = new Persona(null,-1,8,-1,12);
    }
    
    @Test
    public void equalsTest() {
    	setUp();
    	Persona p1Bis = new Persona("Juan",2,3,1,5);
    	assertTrue(p1.equals(p1Bis));
    }
    @Test
    public void equalsTest2() {
    	setUp();
    	assertFalse(p2.equals(p3));
    }
}
