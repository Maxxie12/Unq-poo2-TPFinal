package ar.edu.unq.poo2.LineasNavierasTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.LineaNaviera.Viaje;


class LineaNavieraTest {

	private LineaNaviera lineaTest;
	private Circuito cir1;
	private Circuito cir2; 
	private Circuito cir3; 
	private Buque buque;
	private Buque buque2;
	private Viaje viaje;
	private List<Circuito>circuitos;
	private List<Buque>buques;
	private List<Viaje>viajes;
	
	@BeforeEach
	void setUp() throws Exception {
		//variable en donde mockeo las clases DOC:
		
				cir1 = mock(Circuito.class);
				cir2 = mock(Circuito.class);
				cir3 = mock(Circuito.class);
				buque = mock(Buque.class);
				buque2 = mock(Buque.class);
				viaje = mock(Viaje.class);
		
	   //Las listas para crear la linea naviera 
				circuitos = new ArrayList<Circuito>();
				buques = new ArrayList<Buque>();
				viajes = new ArrayList<Viaje>();
				circuitos.add(cir1);circuitos.add(cir2);circuitos.add(cir3);
				buques.add(buque)  ;buques.add(buque2);
				viajes.add(viaje);
			
		// Aca creo la linea naviera			
		lineaTest = new LineaNaviera("COSCO ", circuitos, buques, viajes);
	}

	@Test
	void testUnLineaNavieraNoPodriaCrearceS() {
		fail("Not yet implemented");
	}

}
