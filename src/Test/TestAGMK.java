package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Negocio.Arista;
import Negocio.ConjuntoDePersonas;
import Negocio.Grafo;
import Negocio.Persona;

public class TestAGMK {

	Persona p1;
    Persona p2;
    Persona p3;
    Persona p4;
    Persona p5;
    ConjuntoDePersonas personasList = new ConjuntoDePersonas();
    Grafo grafo;
    Grafo grafoCompleto;
    Grafo AGMK;
    
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
        
        grafoCompleto = grafo.generarGrafoCompleto();
    	AGMK = grafoCompleto.generarAGMKuskal();
    	
    	
    }
    
    @Test
    public void separarGrafoTest() {
    	setUp();
    	ArrayList<Grafo> grafos = AGMK.separarGrafoEnDos();
    	assertEquals(grafos.size(),2);
    }
    
    @Test
    public void alcanzablesTest() {	 
    	setUp();
    	ConjuntoDePersonas cp1 = new ConjuntoDePersonas();
    	ConjuntoDePersonas cp2 = new ConjuntoDePersonas();
    	ArrayList<Grafo> grafos = AGMK.separarGrafoEnDos();
    	Grafo compConexa1 = grafos.get(0);
    	Grafo compConexa2 = grafos.get(1);
    	cp1.agregar(p3);
    	cp1.agregar(p4);
    	cp2.agregar(p1);
    	cp2.agregar(p2);
    	cp2.agregar(p5);
    	assertTrue(compConexa1.getVertices().equals(cp1) && compConexa2.getVertices().equals(cp2));
    }
    
    @Test
    public void AristaMasPesadaEnAGMKTest() {	
    	setUp();
    	Arista esperado = new Arista(p3,p5);
    	Arista aristaMasPesada = AGMK.aristaMasPesada();
    	assertTrue(esperado.equals(aristaMasPesada));
    }
}


