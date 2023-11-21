package ar.edu.unq.poo2.LineasNavierasTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.LineaNaviera.Tramo;
import ar.edu.unq.poo2.Terminal.Terminal;

class TramoTest {

	
	private Tramo tramoTest;
	private Terminal terminalInicio;
	private Terminal terminalFinal;
	private LocalDate fechaDeIncio;
	private LocalDate fechaDeFinalDeRecorrido;
	
	@BeforeEach
	void setUp() throws Exception {
		//variable en donde mockeo las clases DOC:
		
		terminalInicio = mock(Terminal.class);
		terminalFinal  = mock(Terminal.class);
		
		
		//Comportamiento a las clases mockeadas 
		when(terminalInicio.getNombre()).thenReturn("Inicio");
		
		//Fechas
		fechaDeIncio 			=LocalDate.of(2023, 12, 10);
		fechaDeFinalDeRecorrido =LocalDate.of(2023, 12, 20); 
		
		//Creo el Tramo
		tramoTest  = new Tramo(100, 10, terminalInicio, terminalFinal);
	}

	@Test
	void testUnTramoNoSePuedeCrearConLaMismaTerminalDeInicioYFinal() {
		assertThrows(IllegalArgumentException.class, () -> {
	        new Tramo(100, 10, terminalInicio, terminalInicio);
	    });
	}
	
	@Test
	void testUnTramoPuedeDevolverElPrecio() {
		assertEquals(tramoTest.getPrecio(),100);
	}
	
	@Test
	void testUnTramoPuedeDevolverElTiempoEnDiasQueTardaEnRecorrer() {
		assertEquals(tramoTest.getTiempoQueTardaEnRecorrer(),10);
	}
	
	@Test
	void testUnTramoPuedeDevolverSuTerminalFinal() {
		assertEquals(tramoTest.getTerminalDestino(),terminalFinal);
	}
	
	@Test
	void testUnTramoPuedeDevolverSuTerminalDeInicio(){
		assertEquals(tramoTest.getTerminalInicio(),terminalInicio);
	}
	
	@Test
	void testUnTramoPuedeDevolverElDiaQueLLegariaASuTerminalFinalSaliendoHoy(){
		assertEquals(tramoTest.calcularFechaDeLLegadaSaliendoAhora(),LocalDate.now().plusDays(10));
	}
	
	@Test
	void testUnTramoPuedeDevolverElDiaQueLLegariaASuTerminalFinalSaliendoDesdeLaFechaDada(){
		assertEquals(tramoTest.calcularFechaDeLLegadaSaliendoElDia(fechaDeIncio),fechaDeFinalDeRecorrido);
	}
	
	
	
}
