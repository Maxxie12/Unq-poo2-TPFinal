package ar.edu.unq.poo2.LineasNavierasTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;


class LineaNavieraTest {
	
	private TerminalGestionada terminalGestionda;
	private Terminal		   terminalDestino;
	private LineaNaviera 	   lineaTest;
	private Circuito 		   circuitoValido;
	private Circuito 		   circuitoValido2; 
	private Circuito 		   circuitoInvalido; 
	private Circuito 		   circuitoValidoNoRegistrado;
	private Buque 				buqueRegistrado;
	private Buque 				buqueRegistrado2;
	private Buque 				buqueNoRegistrado;
	private Viaje 			    viajeQueSePuedeRegistrar;
	private Viaje 				viajeQueElCirucuitoNoEstaRegistrado;
	private Viaje 				viajeQueSuBuqueNoEstaRegistrado;
	private List<Circuito>circuitos;
	private List<Buque>buques;
	private List<Viaje>viajes;
	private List<Viaje>masviajes;
	private Viaje valido1; private Viaje valido2; private Viaje valido3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//variable en donde mockeo las clases DOC:
		
				circuitoValido = mock(Circuito.class);
				circuitoValido2 = mock(Circuito.class);
				circuitoInvalido = mock(Circuito.class);
				circuitoValidoNoRegistrado = mock(Circuito.class);
				buqueRegistrado = mock(Buque.class);
				buqueRegistrado2 = mock(Buque.class);
				buqueNoRegistrado = mock(Buque.class);
				viajeQueSePuedeRegistrar = mock(Viaje.class);
				viajeQueElCirucuitoNoEstaRegistrado = mock(Viaje.class);
				viajeQueSuBuqueNoEstaRegistrado = mock(Viaje.class);
				terminalGestionda  = mock(TerminalGestionada.class);
				terminalDestino	   = mock(Terminal.class);
				
				//para el test de fecha
				valido1 = mock(Viaje.class);
				valido2 = mock(Viaje.class);
				valido3 = mock(Viaje.class);
		
	   
		
		
		//Comportamiento a las clases mockeadas 
		//Circuitos
		
		when(circuitoValido.esteCircuitoVaALaTerminal(terminalGestionda.getNombre())).thenReturn(true);
		when(circuitoValido2.esteCircuitoVaALaTerminal(terminalGestionda.getNombre())).thenReturn(true);
		when(circuitoInvalido.esteCircuitoVaALaTerminal(terminalGestionda.getNombre())).thenReturn(false);
		when(circuitoValidoNoRegistrado.esteCircuitoVaALaTerminal(terminalGestionda.getNombre())).thenReturn(true);
		
		//Viajes
		
		when(viajeQueSePuedeRegistrar.getCircuitoARecorrer()).thenReturn(circuitoValido);
		when(viajeQueSePuedeRegistrar.getBuqueAsignado()).thenReturn(buqueRegistrado2);
		
		when(viajeQueElCirucuitoNoEstaRegistrado.getCircuitoARecorrer()).thenReturn(circuitoInvalido);
		when(viajeQueElCirucuitoNoEstaRegistrado.getBuqueAsignado()).thenReturn(buqueRegistrado);
		
		when(viajeQueSuBuqueNoEstaRegistrado.getCircuitoARecorrer()).thenReturn(circuitoValido2);
		when(viajeQueSuBuqueNoEstaRegistrado.getBuqueAsignado()).thenReturn(buqueNoRegistrado);
		
		//ViajesExtra Validos
		when(terminalDestino.getNombre()).thenReturn("TerminalMock");
		when(valido1.getCircuitoARecorrer()).thenReturn(circuitoValido);
		when(valido2.getCircuitoARecorrer()).thenReturn(circuitoValido);
		when(valido3.getCircuitoARecorrer()).thenReturn(circuitoValido);
		when(valido1.getBuqueAsignado()).thenReturn(buqueRegistrado2);
		when(valido2.getBuqueAsignado()).thenReturn(buqueRegistrado2);
		when(valido3.getBuqueAsignado()).thenReturn(buqueRegistrado2);
		when(valido1.llegaA(terminalDestino.getNombre())).thenReturn(true);
		when(valido2.llegaA(terminalDestino.getNombre())).thenReturn(false);
		when(valido3.llegaA(terminalDestino.getNombre())).thenReturn(true);
		when(valido1.getFechaDeLlegadaALaTerminalGestionada()).thenReturn(LocalDate.of(2023, 12, 11));
		when(valido3.getFechaDeLlegadaALaTerminalGestionada()).thenReturn(LocalDate.of(2023, 12, 10));
		//este igual no deberia llegarle el mensaje ya que no va a la terminal que le pedimos
		when(valido2.getFechaDeLlegadaALaTerminalGestionada()).thenReturn(LocalDate.of(2023, 12, 9));
		
		
		
		//Las listas para crear la linea naviera 
		circuitos = new ArrayList<Circuito>();
		buques    = new ArrayList<Buque>();
		viajes 	  = new ArrayList<Viaje>();
		masviajes = new ArrayList<Viaje>();
		circuitos.add(circuitoValido);circuitos.add(circuitoValido2);circuitos.add(circuitoInvalido);
		buques.add(buqueRegistrado)  ;buques.add(buqueRegistrado2);
		viajes.add(viajeQueSePuedeRegistrar); 
		viajes.add(viajeQueElCirucuitoNoEstaRegistrado); 
		viajes.add(viajeQueSuBuqueNoEstaRegistrado);
		masviajes.add(valido1);masviajes.add(valido2);masviajes.add(valido3);
	
		// Aca creo la linea naviera			
		lineaTest = new LineaNaviera("COSCO", circuitos, buques, viajes,terminalGestionda);
	}

	@Test
	void testUnLineaNavieraBorraTodosLosCircuitosQueNoPasanPorLaTerminalGestionada() {
		//el circuito 3 no pasa por la terminal gestionada asi que no deberia estar en la lista de circuitos
		LineaNaviera test = new LineaNaviera("Evergreen", circuitos, buques, viajes, terminalGestionda);
		assertFalse(test.getCircuitosRegistrados().contains(circuitoInvalido));
		//pero debe contener el cir2 y cir1 ya que esos si pasa por la terminal
		assertTrue(test.getCircuitosRegistrados().contains(circuitoValido) && test.getCircuitosRegistrados().contains(circuitoValido2));
	}
	
	@Test
	void testUnLineaNavieraSeRegistraEnTodosLosBuquesAlCrearse() {
		//el circuito 3 no pasa por la terminal gestionada asi que no deberia estar en la lista de circuitos
		LineaNaviera test = new LineaNaviera("Evergreen", circuitos, buques, viajes, terminalGestionda);
		 verify(buqueRegistrado, times(1)).setLineaNaviera(test);
	     verify(buqueRegistrado, times(1)).setLineaNaviera(test);
	}	
	
	@Test
	void testUnLineaNavieraBorraTodosLosViajesDeLosCualesNoTengaRegistradosLosCircuitosOBuques() {
		//el viaje dos al tener el cir3 no pasa por la terminal por ende no se deberia registrarce
		LineaNaviera test = new LineaNaviera("Evergreen", circuitos, buques, viajes, terminalGestionda);
		assertFalse(test.getViajesDisponibles().contains(viajeQueElCirucuitoNoEstaRegistrado));
		//el viaje3 su buque no esta registrado en la linea naviera asi que no deberia estar 
		assertFalse(test.getViajesDisponibles().contains(viajeQueSuBuqueNoEstaRegistrado));
		//pero debe contener el viaje ya que pasa por cir1 y si pasa por la terminal
		assertTrue(test.getViajesDisponibles().contains(viajeQueSePuedeRegistrar));
	}
	
	@Test
	void testUnLineaNavieraPuedeRegistrarNuevosBuques() {
		//Al Principio da falso 
		assertFalse(lineaTest.getBuquesRegistrados().contains(buqueNoRegistrado));
		//Luego se registra y deberia dar verdadero
		lineaTest.registrarBuque(buqueNoRegistrado);
		assertTrue(lineaTest.getBuquesRegistrados().contains(buqueNoRegistrado));
	}
	
	@Test
	void testUnLineaNavieraPuedeRegistrarNuevosCircuitos() {
		//Al Principio da falso 
		assertFalse(lineaTest.getCircuitosRegistrados().contains(circuitoValidoNoRegistrado));
		//Luego se registra y deberia dar verdadero
		lineaTest.registrarCircuito(circuitoValidoNoRegistrado);
		assertTrue(lineaTest.getCircuitosRegistrados().contains(circuitoValidoNoRegistrado));
	}
	
	@Test
	void testUnLineaNavieraNoPuedeRegistrarUnCircuitoQueNoVaALaTerminal() {
		//El circuito 3 no va a la terminal por lo cual lanza una exepcion
		assertThrows(IllegalArgumentException.class, () -> {
	        lineaTest.registrarCircuito(circuitoInvalido);
	    });
	}
	
	@Test
	void testUnLineaNavieraPuedeCrearViajesValidos() {
		//Al Principio solo hay un viaje
		assertEquals(lineaTest.getViajesDisponibles().size(),1);
		//Luego se registra y deberia dar verdadero
		lineaTest.crearViaje(circuitoValido,buqueRegistrado,LocalDate.now());
		assertEquals(lineaTest.getViajesDisponibles().size(),2);
	}
	
	@Test
	void testUnLineaNavieraNoPuedeCrearViajesDeLosCualesNoTengaElCircuitoRegistrado() {
		assertThrows(IllegalArgumentException.class, () -> {
			lineaTest.crearViaje(circuitoInvalido, buqueRegistrado, LocalDate.now()); 
	    });
	}
	
	@Test
	void testUnLineaNavieraNoPuedeCrearViajesDeLosCualesNoTengaElBuqueRegistrado() {
		assertThrows(IllegalArgumentException.class, () -> {
			lineaTest.crearViaje(circuitoValido,  buqueNoRegistrado, LocalDate.now()); 
	    });
	}
	
	@Test
	void testUnLineaNavieraPuedeDevolverSuNombre() {
		assertEquals(lineaTest.getNombre(), "COSCO");
	}
	
	@Test
	void testUnLineaNavieraPuedeDevolverLaTerminalGestionda() {
		assertEquals(lineaTest.getTerminalGestionada(), terminalGestionda);
	}
	
	@Test
	void testUnLineaNavieraPuedeRemoverRegistros() {
		assertEquals(lineaTest.getBuquesRegistrados().size(), 2); 
		assertEquals(lineaTest.getCircuitosRegistrados().size(), 2);
		assertEquals(lineaTest.getViajesDisponibles().size(), 1);		
		lineaTest.removeBuque(buqueRegistrado);
		lineaTest.removeCircuito(circuitoValido);
		lineaTest.removeViaje(viajeQueSePuedeRegistrar);
		assertEquals(lineaTest.getBuquesRegistrados().size(), 1); 
		assertEquals(lineaTest.getCircuitosRegistrados().size(), 1);
		assertEquals(lineaTest.getViajesDisponibles().size(), 0);
	}
		
	@Test
	void testUnLineaNavieraSabeLaFechaDeSalidaDeUnViajeALaTerminalDestino() {
		LineaNaviera test = new LineaNaviera("test", circuitos, buques, masviajes, terminalGestionda);
		assertEquals(test.proximaSalidaA(terminalDestino), LocalDate.of(2023, 12, 10)); 
	}
	

	
}
