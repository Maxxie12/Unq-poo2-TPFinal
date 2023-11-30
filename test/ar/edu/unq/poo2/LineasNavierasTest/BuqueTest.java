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
import ar.unq.edu.poo2.Common.Coordenada;

class BuqueTest {
	
	private Buque buqueTest;
	private LineaNaviera lineaNavieraARegistrarse;
	private TerminalGestionada terminalMock;
	private Coordenada coorMock;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//DOC
		lineaNavieraARegistrarse 		      = mock(LineaNaviera.class);
		terminalMock             			  = mock(TerminalGestionada.class);
		coorMock						      = mock(Coordenada.class);
		
		
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
	void testUnBuqueNoPuedePuedeActualizarSusCordenadaSiNoEstaRegistrado() {
		assertThrows(IllegalArgumentException.class, () -> {
			buqueTest.setCoordenadaDelBuqueActual(coorMock);
	    });
	}	
	
	@Test
	void testUnBuquePuedeActualizarSusCordenadas() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		when(coorMock.getLatitud()).thenReturn(100.0);
		when(coorMock.getLongitud()).thenReturn(230.0);
		assertEquals(buqueTest.getCoordenda().getLatitud(), 100);
		assertEquals(buqueTest.getCoordenda().getLongitud(), 230);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseOutboundASuSiguiente() {
		TerminalGestionada terminalMockeo = lineaNavieraARegistrarse.getTerminalGestionada();
		when(terminalMockeo.elBuqueEstaARangoCercanoDeLaTerminal(coorMock)).thenReturn(true);
		
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
				
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Outbound.class);
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Inbound.class);
		//Tambien vemos que le haya llegado el mensaje a la terminal
		verify(terminalMock, times(1)).inminenteArriboDelBuque(buqueTest);
	}
	
	@Test
	void testUnBuqueNoAvanzaSiNoCumpleLosRequisitosDeFaseOutboundASuSiguiente() {
		TerminalGestionada terminalMockeo = lineaNavieraARegistrarse.getTerminalGestionada();
		when(terminalMockeo.elBuqueEstaARangoCercanoDeLaTerminal(coorMock)).thenReturn(false);
		
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
				
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Outbound.class);
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Outbound.class);
		
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseInboundASuSiguiente() {
		TerminalGestionada terminalMockeo = lineaNavieraARegistrarse.getTerminalGestionada();
		when(terminalMockeo.elBuqueSeEncuentraEnLaTerminal(coorMock)).thenReturn(true);
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		
		buqueTest.setFase(new Inbound());
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Arrived.class);
	}
	
	@Test
	void testUnBuqueNoPuedeAvanzarDeFaseInboundASuSiguienteSiNoCumpleLosRequisitos() {
		TerminalGestionada terminalMockeo = lineaNavieraARegistrarse.getTerminalGestionada();
		when(terminalMockeo.elBuqueSeEncuentraEnLaTerminal(coorMock)).thenReturn(false);
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		
		buqueTest.setFase(new Inbound());
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Inbound.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseArrivedASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Arrived());
		buqueTest.iniciarTrabajo();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Working.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseArrivedAunqueCambieDeCoordenada() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Arrived());
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Arrived.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseWorkingASuSiguiente() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Working());
		buqueTest.libertadDeDepart();
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Departing.class);
	}
	
	@Test
	void testUnBuquePuedeAvanzarDeFaseDepartingASuSiguiente() {
		TerminalGestionada terminalMockeo = lineaNavieraARegistrarse.getTerminalGestionada();
		when(terminalMockeo.elBuqueSeEncuentraFueraDelRangoDeLaTerminal(coorMock)).thenReturn(true);
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Departing());
		buqueTest.setCoordenadaDelBuqueActual(coorMock);
		assertEquals(buqueTest.getFaseDelBuqueActual().getClass(), Outbound.class);
		verify(terminalMock, times(1)).elBuqueAbandonoLasCercanias(buqueTest);
	}
	
	@Test
	void testUnBuquePuedeSaberSiEstaListoParaTrabajarOPartir() {
		buqueTest.setLineaNaviera(lineaNavieraARegistrarse);
		buqueTest.setFase(new Arrived());
		assertTrue(buqueTest.isEsperandoIniciarTrabajo());
		buqueTest.setFase(new Working());
		assertTrue(buqueTest.isEsperandoDepart());
		
	}

}
