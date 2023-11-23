package ar.edu.unq.poo2.BuscadorMejorCircuito.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.Tramo;
import ar.edu.unq.poo2.MejorCircuito.MenorTiempo;
import ar.edu.unq.poo2.Terminal.Terminal;

import org.junit.jupiter.api.Test;

class MenorTiempoTest {
	private Circuito circuitoTest1;
	private Circuito circuitoTest2;
	private Circuito circuitoTest3;
	private Terminal terminalDestino;
	private ArrayList <Circuito> listaDeCircuitos = new ArrayList<Circuito>();
	private MenorTiempo menorTiempo;

	@BeforeEach
	void setUp() throws Exception {
	
		circuitoTest1= mock(Circuito.class);
		circuitoTest2= mock(Circuito.class);
		circuitoTest3= mock(Circuito.class);
		terminalDestino= mock(Terminal.class);
		menorTiempo = mock (MenorTiempo.class);
		

		listaDeCircuitos= new ArrayList<Circuito>();
		listaDeCircuitos.add(circuitoTest1);listaDeCircuitos.add(circuitoTest2);listaDeCircuitos.add(circuitoTest3);
	
		when(circuitoTest1.getDiasHastaTerminal(terminalDestino)).thenReturn(5);
		when(circuitoTest2.getDiasHastaTerminal(terminalDestino)).thenReturn(34);
		when(circuitoTest3.getDiasHastaTerminal(terminalDestino)).thenReturn(12);


	}
	@Test
		void testVerificoQueElMejor(){
			 assertEquals(circuitoTest1, menorTiempo.mejorCircuito(listaDeCircuitos, terminalDestino) );
	}

}
