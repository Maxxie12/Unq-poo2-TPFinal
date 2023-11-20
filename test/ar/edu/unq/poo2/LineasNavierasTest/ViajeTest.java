package ar.edu.unq.poo2.LineasNavierasTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

class ViajeTest {


	private TerminalGestionada terminalGestionda;
	private Terminal           terminalPorLaQuePasa;
	private Terminal           terminalPorLaQueNoPasa;
	private Viaje viajeTest;
	private Circuito circuitoValido;
	private Circuito circuitoValido2;
	private Buque buqueRegistrado;
	private LocalDate fechaDeInicioDeViaje;
	private LocalDate fechaEnLaQueElViajeNoParaEnAlgunaTerminal;
	private LocalDate fechaEnLaQueElViajeParaEnAlgunaTerminal;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//variable en donde mockeo las clases DOC:
		
				circuitoValido  	= mock(Circuito.class);
				circuitoValido2 	= mock(Circuito.class);
				
				buqueRegistrado 	= mock(Buque.class);
								
				terminalGestionda   	= mock(TerminalGestionada.class);
				terminalPorLaQuePasa    = mock(Terminal.class);
				terminalPorLaQueNoPasa  = mock(Terminal.class);
				
				fechaDeInicioDeViaje     					 = LocalDate.of(2023, 12, 10);
				fechaEnLaQueElViajeNoParaEnAlgunaTerminal    = LocalDate.of(2023, 12, 11);
				fechaEnLaQueElViajeParaEnAlgunaTerminal      = LocalDate.of(2024, 2, 20);
	   
		
		
		//Comportamiento a las clases mockeadas 
		//Circuitos
		
		when(circuitoValido.esteCircuitoVaALaTerminal(terminalPorLaQuePasa.getNombre())).thenReturn(true);
		when(circuitoValido2.esteCircuitoVaALaTerminal(terminalPorLaQueNoPasa.getNombre())).thenReturn(false);
		
		when(circuitoValido.fechaDeLLegadaA(terminalGestionda, fechaDeInicioDeViaje)).thenReturn(fechaDeInicioDeViaje.plusDays(45));
		
		when(circuitoValido.fechaFinDelCircuitoAPartir(fechaDeInicioDeViaje)).thenReturn(fechaDeInicioDeViaje.plusDays(100));
		
		when(circuitoValido.llegaAUnPuertoEstaFecha(fechaDeInicioDeViaje,fechaEnLaQueElViajeNoParaEnAlgunaTerminal))
		.thenReturn(false);
		
		when(circuitoValido.llegaAUnPuertoEstaFecha(fechaDeInicioDeViaje,fechaEnLaQueElViajeParaEnAlgunaTerminal))
		.thenReturn(true);
		
		
		// Aca creo el viaje			
		viajeTest = new Viaje(circuitoValido, buqueRegistrado, fechaDeInicioDeViaje, terminalGestionda);
	}


	@Test
	void testUnViajePuedeDevolverSuFechaDeInicio() {
		//El Viaje deberia devolver correctamente la fecha con la que fue creado
		assertEquals(fechaDeInicioDeViaje, viajeTest.getFechaDeInicio());
	}
	
	@Test
	void testUnViajePuedeDevolverSuCircuito() {
		//El Viaje deberia devolver correctamente el circuito con el que fue creado
		assertEquals(circuitoValido, viajeTest.getCircuitoARecorrer());
	}
	
	@Test
	void testUnViajePuedeDevolverSuBuque() {
		//El Viaje deberia devolver correctamente el buque con el que fue creado
		assertEquals(buqueRegistrado, viajeTest.getBuqueAsignado());
	}
	
	@Test
	void testUnViajePuedeDevolverLaFechaEnElQueFinalizariaElRecorrido() {
		//El Viaje sabe que fecha finaliza de recorrer su circuito actual
		LocalDate fechaFin = LocalDate.of(2024, 3, 19);
		assertEquals(fechaFin, viajeTest.getFechaDeFin());
	}
	
	@Test
	void testUnViajePuedeDevolverLaFechaAlaQueLlegariaALaTerminalGestionada() {
		//El viaje sabe en que fecha llega a la terminal gestionada ya que es lo mas importante de estos viajes	
		LocalDate fechaDeLLegadaAlaTerminal = LocalDate.of(2024, 1, 24);
		assertEquals(fechaDeLLegadaAlaTerminal, viajeTest.getFechaDeLlegadaALaTerminalGestionada());
	}
	
	@Test
	void testUnViajeSabeResponderSiVaAPasarPorAlgunaTermianlEnUnaFechaDada() {
		//Por cuestiones los clientes nesecitan saber si el viaje va a pasar por alguna terminal en una fecha dada
		//Aca tiene que dar falso porque no pasa en ninguna terminal el dia 11/12/2023
		assertFalse(viajeTest.llegaAUnPuertoEnEstaFecha(fechaEnLaQueElViajeNoParaEnAlgunaTerminal));
		//Aca tiene que dar verdadero porque pasa por una terminal el 20/2/2024
		assertTrue(viajeTest.llegaAUnPuertoEnEstaFecha(fechaEnLaQueElViajeParaEnAlgunaTerminal));
	}
	
	@Test
	void testUnViajeSabeResponderSiVaASalirDeLaTerminalGestionadaEnDadaFecha() {
		//Por cuestiones los clientes nesecitan saber si el viaje va a pasar por alguna terminal en una fecha dada
		//Aca tiene que dar falso porque no sale de la terminalGestionada el dia 11/12/2023
		assertFalse(viajeTest.saleDeLaTerminalGestionadaEn(fechaEnLaQueElViajeNoParaEnAlgunaTerminal));
		//Aca tiene que dar verdadero porque sale de la terminal el dia 24/1/2024
		assertTrue(viajeTest.saleDeLaTerminalGestionadaEn(LocalDate.of(2024, 1, 24)));
	}
	
	@Test
	void testUnViajeSabeResponderSiPasaPorLaTerminalDada() {
		//Por cuestiones los clientes nesecitan saber si el viaje va a pasar por la terminal dada
				//Aca tiene que dar verdadero porque pasa por la terminal
		assertTrue(viajeTest.llegaA(terminalPorLaQuePasa.getNombre()));
	}
	
	@Test
	void testUnViajeSabeResponderSiPasaPorLaTerminalDadaCasoFalso() {
		//Por cuestiones los clientes nesecitan saber si el viaje va a pasar por la terminal dada
		//Aca tiene que dar falso porque no pasa por esa terminal
		Viaje test = new Viaje (circuitoValido2,buqueRegistrado,LocalDate.now(), terminalGestionda);
		assertFalse(test.llegaA(terminalPorLaQueNoPasa.getNombre()));
		
	}
	
}
