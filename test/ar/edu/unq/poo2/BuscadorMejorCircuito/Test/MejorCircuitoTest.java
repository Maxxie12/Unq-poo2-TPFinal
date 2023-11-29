package ar.edu.unq.poo2.BuscadorMejorCircuito.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.MejorCircuito.MenorCantParadas;
import ar.edu.unq.poo2.MejorCircuito.MenorPrecio;
import ar.edu.unq.poo2.MejorCircuito.MenorTiempo;
import ar.edu.unq.poo2.Terminal.Terminal;

class MejorCircuitoTest {
	private Circuito circuitoTest1;
	private Circuito circuitoTest2;
	private Circuito circuitoTest3;
	private Terminal terminalDestino;
	private ArrayList <Circuito> listaDeCircuitos = new ArrayList<Circuito>();
	private MenorTiempo menorTiempo;
	private MenorCantParadas menosParadas;	
	private MenorPrecio menorPrecio;
	
	@BeforeEach
	void setUp() throws Exception {
	
		circuitoTest1= mock(Circuito.class);
		circuitoTest2= mock(Circuito.class);
		circuitoTest3= mock(Circuito.class);
		terminalDestino= mock(Terminal.class);
		
		menorTiempo  =  new MenorTiempo();
		menosParadas =  new MenorCantParadas();
		menorPrecio  =  new MenorPrecio();
		

		listaDeCircuitos= new ArrayList<Circuito>();
		listaDeCircuitos.add(circuitoTest1);listaDeCircuitos.add(circuitoTest2);listaDeCircuitos.add(circuitoTest3);
	
		when(circuitoTest1.getDiasHastaTerminal(terminalDestino)).thenReturn(54);
		when(circuitoTest2.getDiasHastaTerminal(terminalDestino)).thenReturn(34);
		when(circuitoTest3.getDiasHastaTerminal(terminalDestino)).thenReturn(12); 
		
		
		when(circuitoTest1.getCostoADestino(terminalDestino)).thenReturn(50.5);
		when(circuitoTest2.getCostoADestino(terminalDestino)).thenReturn(34.0);
		when(circuitoTest3.getCostoADestino(terminalDestino)).thenReturn(13.23);
		
		
		when(circuitoTest1.getTramosDelCircuitoHastaTerminal(terminalDestino)).thenReturn(50);
		when(circuitoTest2.getTramosDelCircuitoHastaTerminal(terminalDestino)).thenReturn(21);
		when(circuitoTest3.getTramosDelCircuitoHastaTerminal(terminalDestino)).thenReturn(13);
		 
		
		


	}
	@Test
		void testVerificoElmejorCircuitoPorTiempo(){
			 assertEquals(circuitoTest3, menorTiempo.mejorCircuito(listaDeCircuitos, terminalDestino) );
	}
	
	@Test
		void testVerificoQueUnCircuitoNoEsElMejorPorTiempo(){
		 	assertFalse(circuitoTest1.equals(menorTiempo.mejorCircuito(listaDeCircuitos, terminalDestino)));
	}
	
	@Test
	void testVerificoElmejorCircuitoPorCosto(){
		 assertEquals(circuitoTest3, menorPrecio.mejorCircuito(listaDeCircuitos, terminalDestino));
	}
	
	@Test
		void testVerificoQueUnCircuitoNoEsElMejorPorCosto(){
	 	assertFalse(circuitoTest1.equals(menorPrecio.mejorCircuito(listaDeCircuitos, terminalDestino)));
	}
	
	@Test
	void testVerificoQueUnCircuitoEsElMejorPorMenosParadas(){
		 assertEquals(circuitoTest3, menosParadas.mejorCircuito(listaDeCircuitos, terminalDestino));
	}
	
	@Test
	void testVerificoQueUnCircuitoNoEsElMejorPorCantDeParadas(){
 		assertFalse(circuitoTest1.equals(menosParadas.mejorCircuito(listaDeCircuitos, terminalDestino)));
	}
}
