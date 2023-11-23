package ar.edu.unq.poo2.LineasNavierasTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.EstadoBuque.IFaseBuque;
import ar.edu.unq.poo2.EstadoBuque.Inbound;
import ar.edu.unq.poo2.EstadoBuque.Outbound;
import ar.edu.unq.poo2.EstadoBuque.Arrived;
import ar.edu.unq.poo2.EstadoBuque.Working;
import ar.edu.unq.poo2.EstadoBuque.Departing;
import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

class BuqueTest {
	
	private Buque buqueTest;
	private LineaNaviera lineaNavieraARegistrarse;
	private TerminalGestionada terminalMock;
	private IFaseBuque faseActual;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//DOC
		lineaNavieraARegistrarse = mock(LineaNaviera.class);
		terminalMock             = mock(TerminalGestionada.class);
		
		//mockeo 
		when(lineaNavieraARegistrarse.getTerminalGestionada()).thenReturn(terminalMock);
		
		//Creo el buque
		
		buqueTest = new Buque("XT310");
	}

	@Test
	void testUnBuquePuedeDevolverSuPatente() {
		assertEquals(buqueTest.getPatenteDeBuque(), "XT310");
	}
	
	@Test
	void testUnBuquePuedeDevolverSuFaseActual() {
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Outbound.class);
	}
	
	@Test
	void testUnBuqueNOPuedeDevolverLaLineaNavieraSiNoEstaRegistradoAUna() {
		assertThrows(IllegalArgumentException.class, () -> {
	        buqueTest.getLineaNaviera();
	    });
	}
	
	@Test
	void testUnBuquePuedeRegistrarseAUnaLineaNaviera() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		assertEquals(buqueTest.getLineaNaviera(), lineaNavieraARegistrarse);
	}
	
	
	@Test
	void testUnBuqueNPPuedeAvanzarDeFaseSiNoEstaRegistrado() {
		assertThrows(IllegalArgumentException.class, () -> {
	        buqueTest.actualizarEstado();
	    });
	}	
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseOutboundASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.actualizarEstado();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Inbound.class);
		//Tambien vemos que le haya llegado el mensaje a la terminal
		verify(terminalMock, times(1)).inminenteArriboDelBuque(buqueTest);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseInboundASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Inbound());
		buqueTest.actualizarEstado();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Arrived.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseArrivedASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Arrived());
		buqueTest.actualizarEstado();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Working.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseWorkingASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Working());
		buqueTest.actualizarEstado();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Departing.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseDepartingASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Departing());
		buqueTest.actualizarEstado();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Outbound.class);
		verify(terminalMock, times(1)).elBuqueAbandonoLasCercanias(buqueTest);
	}
	
	

}
