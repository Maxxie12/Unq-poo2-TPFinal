package ar.edu.unq.poo2.LineasNavierasTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.Tramo;
import ar.edu.unq.poo2.Terminal.Terminal;

class CircuitoTest {
	
	
	private Circuito circuitoTest;
	private Tramo    tramo1;
	private Tramo    tramo2;
	private Tramo    tramo3;
	private Tramo    tramoIncompatible;
	private Tramo    tramoCompatible;
	private Terminal terminalInicial;
	private Terminal terminalSegunda;
	private Terminal terminalSegundaFinal;
	private Terminal terminalFinalTemporal;
	private Terminal terminalFinalExtendida;
	private Terminal terminalNoCompatible;
	private List<Tramo> listaDeTramos;
	private List<Tramo> listaDeTramosInvalida;
	private LocalDate fechaDeInicio;
	private LocalDate fechaEnLaQueNoParaEnAlgunaTerminal;
	private LocalDate fechaEnLaQueParaEnAlgunaTerminal;

	
	
	@BeforeEach
	void setUp() throws Exception {
		//variable en donde mockeo las clases DOC:
		
				tramo1     			   = mock(Tramo.class);
				tramo2     			   = mock(Tramo.class);
				tramo3    			   = mock(Tramo.class);
				tramoIncompatible      = mock(Tramo.class);
				tramoCompatible        = mock(Tramo.class);
				terminalInicial        = mock(Terminal.class);
				terminalFinalTemporal  = mock(Terminal.class);
				terminalFinalExtendida = mock(Terminal.class);
			    terminalNoCompatible   = mock(Terminal.class);
			    terminalSegunda		   = mock(Terminal.class);
			    terminalSegundaFinal   = mock(Terminal.class);
			    fechaDeInicio    						     = LocalDate.of(2023, 12, 10);
				fechaEnLaQueNoParaEnAlgunaTerminal           = LocalDate.of(2023, 12, 11);
				fechaEnLaQueParaEnAlgunaTerminal             = LocalDate.of(2023, 12, 20);
			    
			    
			    
				
				listaDeTramos = new ArrayList<Tramo>();
				listaDeTramosInvalida = new ArrayList<Tramo>();
				
				listaDeTramos.add(tramo1);listaDeTramos.add(tramo2);listaDeTramos.add(tramo3);
				listaDeTramosInvalida.add(tramo1);listaDeTramosInvalida.add(tramo2);
				listaDeTramosInvalida.add(tramo3);listaDeTramosInvalida.add(tramoIncompatible);
		
				//Comportamiento a las clases mockeadas 
				//Tramos
				when(tramo1.getTerminalInicio()).thenReturn(terminalInicial); 
				when(tramo1.getTerminalDestino()).thenReturn(terminalSegunda);
				when(tramo1.getPrecio()).thenReturn(20.0);
				when(tramo1.getTiempoQueTardaEnRecorrer()).thenReturn(10);
				
				when(tramo2.getTerminalInicio()).thenReturn(terminalSegunda); 
				when(tramo2.getTerminalDestino()).thenReturn(terminalSegundaFinal);
				when(tramo2.getPrecio()).thenReturn(35.0);
				when(tramo2.getTiempoQueTardaEnRecorrer()).thenReturn(20);
				
				
				when(tramo3.getTerminalInicio()).thenReturn(terminalSegundaFinal); 
				when(tramo3.getTerminalDestino()).thenReturn(terminalFinalTemporal);
				when(tramo3.getPrecio()).thenReturn(45.0);
				when(tramo3.getTiempoQueTardaEnRecorrer()).thenReturn(30);
				
				when(tramoIncompatible.getTerminalInicio()).thenReturn(terminalNoCompatible); 
				when(tramoIncompatible.getTerminalDestino()).thenReturn(terminalFinalExtendida);
				
				when(tramoCompatible.getTerminalInicio()).thenReturn(terminalFinalTemporal); 
				when(tramoCompatible.getTerminalDestino()).thenReturn(terminalFinalExtendida);
				
				//Terminal
				when(terminalInicial.getNombre()).thenReturn("Incial");
				when(terminalSegunda.getNombre()).thenReturn("Segunda");
				when(terminalSegundaFinal.getNombre()).thenReturn("Tercera");
				when(terminalFinalTemporal.getNombre()).thenReturn("FinalDelCircuito");
				when(terminalNoCompatible.getNombre()).thenReturn("NoCompatible");
				when(terminalFinalExtendida.getNombre()).thenReturn("ExtensionParaFinal");
				
				
		//creacion de circuito
			    circuitoTest = new Circuito(listaDeTramos);	
				
	}

	@Test
	void testUnCircuitoNoSePuedeCrearConUnaListaDeTramosInvalidas(){
		 assertThrows(IllegalArgumentException.class, () -> {
		        new Circuito(listaDeTramosInvalida);
	});
	}
	
	@Test
	void testUnCircuitoNoSePuedeCrearConUnaListaDeTramosVacia(){
		 assertThrows(IllegalArgumentException.class, () -> {
		        new Circuito(new ArrayList<Tramo>());
	});
	}
	
	@Test
	void testUnCircuitoSeLePuedePedirSuTerminalDeInicio(){
		 assertEquals(circuitoTest.getTerminalIncio() , terminalInicial);
	}
	@Test
	void testUnCircuitoLanzaUnaExpepcionAlAgregarUnTramoNoCompatible(){
		assertThrows(IllegalArgumentException.class, () -> {
	        circuitoTest.agregarTramo(tramoIncompatible);
	    });
	}
	@Test
	void testUnCircuitoSeLePuedePedirSuTerminalFinal(){
		 assertEquals(circuitoTest.getTerminalFinal() , terminalFinalTemporal);
	}
	@Test
	void testUnCircuitoSeLePuedePedirSuListaDeTramos(){
		 assertEquals(circuitoTest.getTramosDelCircuito() , listaDeTramos);
	}
	@Test
	void testUnCircuitoSeLePuedePedirElCostoDelRecorridoEnSuTotalidad(){
		 assertEquals(circuitoTest.getCostoTotal() , 100);
	}
	
	@Test
	void testUnCircuitoSeLePuedePedirCualEsElSiguienteTramo(){
		 assertEquals(circuitoTest.siguienteTramoA(tramo2) , tramo3);	 
	}
	@Test
	void testUnCircuitoLanzaUnaExepcionCuandoNoHaySiguienteTramo(){
		assertThrows(IllegalArgumentException.class, () -> {
	        circuitoTest.siguienteTramoA(tramo3);
	    });
	}
	@Test
	void testUnCircuitoPuedeAgregarUnTramoCompatible(){
		assertEquals(circuitoTest.getTramosDelCircuito().size(), 3);
		circuitoTest.agregarTramo(tramoCompatible);
		assertEquals(circuitoTest.getTramosDelCircuito().size(), 4);
	}
	
	@Test
	void testUnCircuitoRespondeSiVaALaTerminalSolicitada(){
		// a esta terminal va 
		assertTrue(circuitoTest.esteCircuitoVaALaTerminal(terminalFinalTemporal.getNombre()));
		// y a esta no va
		assertFalse(circuitoTest.esteCircuitoVaALaTerminal(terminalFinalExtendida.getNombre()));
	}
	
	@Test
	void testUnCircuitoRespondeSiLlegaAUnaTerminalLaFechaSolicitadaSolicitada(){
		//el circuito llega a alguna terminal en la fecha dada 
		assertTrue(circuitoTest.llegaAUnPuertoEstaFecha(fechaDeInicio,fechaEnLaQueParaEnAlgunaTerminal));
		//el circuito no llega a alguna terminal en la fecha dada
		assertFalse(circuitoTest.llegaAUnPuertoEstaFecha(fechaDeInicio,fechaEnLaQueNoParaEnAlgunaTerminal));
	}
	
	@Test
	void testUnCircuitoDiceLaFechaEnLaQueLlegaAUnaTermianalDadaDandoUnaFechaDeInicio(){
		//la fecha que el circuito llega a la terminal dada 
		assertEquals(circuitoTest.fechaDeLLegadaA(terminalFinalTemporal,fechaDeInicio),fechaDeInicio.plusDays(60));
		assertEquals(circuitoTest.fechaDeLLegadaA(terminalSegundaFinal,fechaDeInicio),fechaDeInicio.plusDays(30));
		assertEquals(circuitoTest.fechaDeLLegadaA(terminalSegunda,fechaDeInicio),fechaDeInicio.plusDays(10));
	}
	
	@Test
	void testUnCircuitoDevuelveLaMismaFechaSiElCircuitoSaleDeEsaTerminalElMismoDia(){
		
		assertEquals(circuitoTest.fechaDeLLegadaA(terminalInicial, fechaDeInicio), fechaDeInicio);
		}
	
	@Test 
	void testUnCircuitoLanzaUnaExepcionSinNoTieneLaTerminalSeleccionada(){
			assertThrows(IllegalArgumentException.class, () -> {
		        circuitoTest.fechaDeLLegadaA(terminalFinalExtendida, fechaDeInicio);
		    });
		}
	
	@Test
	void testUnCircuitoSabeLaFechaFinalDelRecorridoSiEmpezaraEnLaFechaPasada(){
			assertEquals(circuitoTest.fechaFinDelCircuitoAPartir(LocalDate.now()), LocalDate.now().plusDays(60));
		}
	
	
	
	
	
}
