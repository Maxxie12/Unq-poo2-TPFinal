package ar.edu.unq.poo2.TerminalGestionadaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.MejorCircuito.IMejorCircuito;
import ar.edu.unq.poo2.Orden.Orden;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;
import ar.unq.edu.poo2.Common.EmpresaTransportista;

class TerminalGestionadaTest {

	private TerminalGestionada 	terminalGestionadaTest;
	private Terminal		  	 terminal;
	private LineaNaviera	  	 lineaRegistrada;
	private LineaNaviera	  	 lineaRegistrada2;
	private LineaNaviera 	  	 lineaNavieraRegistrable;
	private Cliente 		   	 cliente1;
	private Cliente          	 cliente2;
	private Cliente           	 cliente3;
	private Cliente            	 clienteRegistrable;
	private Circuito			 circuitoUnoDeLineaNaviera1;
	private Circuito			 circuitoDosDeLineaNaviera1;
	private Circuito			 circuitoTresDeLineaNaviera1;
	private Circuito			 circuitoUnoDeLineaNaviera2;
	private Circuito			 circuitoDosDeLineaNaviera2;
	private Container 			 containerParaOrden;
	private Camion				 camionParaOrden;
	private Conductor			 conductorParaOrden;
	private Viaje			  	 viajeParaOrden;
	private Viaje			  	 viajeParaOrden2;
	private Buque 				 buqueParaOrden;
	private Buque 				 buqueParaOrden2;
	private EmpresaTransportista empresaTrasportista;
	private EmpresaTransportista empresaRegistrable;
	private List<LineaNaviera> 	 lineasNavierasRegistradas;
	private List<Cliente>	     clientesRegistrados;
	private List<Circuito> 		 circuitosLineaNaviera1;
	private List<Circuito> 		 circuitosLineaNaviera2;
	private List<EmpresaTransportista> empresasRegistradas;
	private List<Servicio>		 listaDeServiciosParaOrden;
	private LocalTime			 horaDelTurno;
	private LocalDate			 fechaDeLLegadaAlaTerminalGestionada;
	private LocalDate			 fechaDeLLegadaAlaTerminalDestino;
	private IMejorCircuito		 mejorCircuitoMock;
	
	@BeforeEach
	void setUp() throws Exception {
		terminal		   	     = mock(Terminal.class);
		lineaRegistrada     	 = mock(LineaNaviera.class);
		lineaRegistrada2   		 = mock(LineaNaviera.class);
		lineaNavieraRegistrable  = mock(LineaNaviera.class);
		
		cliente1		         = mock(Cliente.class);
		cliente2		    	 = mock(Cliente.class);
		cliente3		   	     = mock(Cliente.class);
		clienteRegistrable		 = mock(Cliente.class);
		
		circuitoUnoDeLineaNaviera1  = mock(Circuito.class);
		circuitoDosDeLineaNaviera1  = mock(Circuito.class);
		circuitoTresDeLineaNaviera1 = mock(Circuito.class);
		circuitoUnoDeLineaNaviera2  = mock(Circuito.class);
		circuitoDosDeLineaNaviera2  = mock(Circuito.class);
		
		
		viajeParaOrden			 = mock(Viaje.class);
		viajeParaOrden2			 = mock(Viaje.class);
		containerParaOrden		 = mock(Container.class);
		camionParaOrden			 = mock(Camion.class);
		conductorParaOrden		 = mock(Conductor.class);
		buqueParaOrden			 = mock(Buque.class);
		buqueParaOrden2			 = mock(Buque.class);
		horaDelTurno			 = LocalTime.of(12, 30);
		fechaDeLLegadaAlaTerminalGestionada = LocalDate.of(2023, 12, 10);
		fechaDeLLegadaAlaTerminalDestino = LocalDate.of(2023, 12, 25);
		
		
		empresaTrasportista 	 = mock(EmpresaTransportista.class);
		empresaRegistrable       = mock(EmpresaTransportista.class);
		
		mejorCircuitoMock		 = mock(IMejorCircuito.class);
		
		lineasNavierasRegistradas	= new ArrayList<LineaNaviera>();
		empresasRegistradas			= new ArrayList<EmpresaTransportista>();
		clientesRegistrados  	    = new ArrayList<Cliente>();
		circuitosLineaNaviera1		= new ArrayList<Circuito>();
		circuitosLineaNaviera2		= new ArrayList<Circuito>();
		listaDeServiciosParaOrden	= new ArrayList<Servicio>();
		
		lineasNavierasRegistradas.add(lineaRegistrada);lineasNavierasRegistradas.add(lineaRegistrada2);
		empresasRegistradas.add(empresaTrasportista);
		clientesRegistrados.add(cliente1);clientesRegistrados.add(cliente2);clientesRegistrados.add(cliente3);
		circuitosLineaNaviera1.add(circuitoUnoDeLineaNaviera1);circuitosLineaNaviera1.add(circuitoDosDeLineaNaviera1);circuitosLineaNaviera1.add(circuitoTresDeLineaNaviera1);
		circuitosLineaNaviera2.add(circuitoUnoDeLineaNaviera2);circuitosLineaNaviera2.add(circuitoDosDeLineaNaviera2);
		
		// comportamiento de las clases mock 
		
		when(lineaRegistrada.getCircuitosRegistrados()).thenReturn(circuitosLineaNaviera1);
		when(lineaRegistrada2.getCircuitosRegistrados()).thenReturn(circuitosLineaNaviera2);
		when(viajeParaOrden.getFechaDeLlegadaALaTerminalGestionada()).thenReturn(fechaDeLLegadaAlaTerminalGestionada);
		when(viajeParaOrden.getFechaDeLlegadaA(terminal)).thenReturn(fechaDeLLegadaAlaTerminalDestino);
		when(viajeParaOrden2.getFechaDeLlegadaALaTerminalGestionada()).thenReturn(fechaDeLLegadaAlaTerminalGestionada);
		when(viajeParaOrden2.getFechaDeLlegadaA(terminal)).thenReturn(fechaDeLLegadaAlaTerminalDestino);
		
		when(viajeParaOrden.getBuqueAsignado()).thenReturn(buqueParaOrden);
		when(viajeParaOrden2.getBuqueAsignado()).thenReturn(buqueParaOrden2);
		
		terminalGestionadaTest = new TerminalGestionada("Bs", 30, 60, lineasNavierasRegistradas, empresasRegistradas, clientesRegistrados);
		when(mejorCircuitoMock.mejorCircuito(terminalGestionadaTest.getTodosLosCircuito(), terminal)).thenReturn(circuitoDosDeLineaNaviera1);
	}

	@Test
	void testUnTerminalPuedeDevolverSuNombre() {
		assertEquals(terminalGestionadaTest.getNombre(), "Bs");
	}
	
	@Test
	void testUnTerminalPuedeDevolverSusLatiudYLongitud() {
		assertEquals(terminalGestionadaTest.getLatitud(), 30);
		assertEquals(terminalGestionadaTest.getLongitud(), 60);
	}
	
	
	@Test
	void testUnTerminalPuedeDevolverSusLineasNavierasRegistradas() {
		assertEquals(terminalGestionadaTest.getLineasNavierasRegistradas().size(), 2);
		assertEquals(terminalGestionadaTest.getLineasNavierasRegistradas(), lineasNavierasRegistradas);
	}
	
	@Test
	void testUnTerminalPuedeRegistrarUnaLineaNaviera() {
		assertEquals(terminalGestionadaTest.getLineasNavierasRegistradas().size(), 2);
		terminalGestionadaTest.registrarLineaNaviera(lineaNavieraRegistrable);
		assertEquals(terminalGestionadaTest.getLineasNavierasRegistradas().size(), 3);
	}
	
	@Test
	void testUnTerminalPuedeDevolverSusClientesRegistrados() {
		assertEquals(terminalGestionadaTest.getClientesRegistrados().size(), 3);
		assertEquals(terminalGestionadaTest.getClientesRegistrados(), clientesRegistrados);
	}
	
	@Test
	void testUnTerminalPuedeRegistrarUnCliente() {
		assertEquals(terminalGestionadaTest.getClientesRegistrados().size(), 3);
		terminalGestionadaTest.registrarCliente(clienteRegistrable);
		assertEquals(terminalGestionadaTest.getClientesRegistrados().size(), 4);
	}

	@Test
	void testUnTerminalPuedeDevolverSusEmpresasTrasnportistaRegistradas() {
		assertEquals(terminalGestionadaTest.getEmpresasRegistradas().size(), 1);
		assertEquals(terminalGestionadaTest.getEmpresasRegistradas(), empresasRegistradas);
	}
	
	@Test
	void testUnTerminalPuedeRegistrarUnaEmpresaTransportista() {
		assertEquals(terminalGestionadaTest.getEmpresasRegistradas().size(), 1);
		terminalGestionadaTest.registrarEmpresaTransportista(empresaRegistrable);
		assertEquals(terminalGestionadaTest.getEmpresasRegistradas().size(), 2);
	}
	
	@Test
	void testUnTerminalPuedeDevolverSusOrdenes() {
		assertEquals(terminalGestionadaTest.getOrdenesFinalizadas().size(), 0);
		
		assertEquals(terminalGestionadaTest.getOrdenesActivas().size(), 0);
	}
	
	@Test
	void testUnTerminalPuedeDevolverTodosSusCircuitos() {
		List<Circuito> test = terminalGestionadaTest.getTodosLosCircuito();
		List<Circuito> resultado = new ArrayList<Circuito>(circuitosLineaNaviera1);
		resultado.addAll(circuitosLineaNaviera2);
		assertEquals(test.size(), 5);
		assertEquals(test, resultado);
	}
	
	@Test
	void testUnTerminalPuedeDevolverTodosSusViajes() {
		List<Viaje> test = terminalGestionadaTest.getTodosLosViajes();
		assertEquals(test.size(),0);
	}
	
	@Test
	void testUnTerminalCrearUnaOrdenDeExportacion() {
		assertEquals(terminalGestionadaTest.getOrdenesActivas().size(),0);
		terminalGestionadaTest.crearOrdenExportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden, terminal, horaDelTurno);
		assertEquals(terminalGestionadaTest.getOrdenesActivas().size(),1);
	}
	
	@Test
	void testUnTerminalCrearUnaOrdenDeImportacion() {
		assertEquals(terminalGestionadaTest.getOrdenesActivas().size(),0);
		terminalGestionadaTest.crearOrdenImportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden, terminal, horaDelTurno);
		assertEquals(terminalGestionadaTest.getOrdenesActivas().size(),1);
	}
	
	@Test
	void testUnTerminalDevuelveLasOrdenesRelacionadasAUnCLiente() {
		assertEquals(terminalGestionadaTest.ordenesActualesRelacionadasAlCliente(cliente1).size(),0);
		terminalGestionadaTest.crearOrdenExportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden, terminal, horaDelTurno);
		terminalGestionadaTest.crearOrdenImportacion(cliente2, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden, terminal, horaDelTurno);
		assertEquals(terminalGestionadaTest.ordenesActualesRelacionadasAlCliente(cliente1).size(),1);
	}
	
	@Test
	void testUnTerminalPuedeDevolverElMejorCircuito() {
		terminalGestionadaTest.setMejorCircuito(mejorCircuitoMock);
		verify(mejorCircuitoMock, times(0)).mejorCircuito(terminalGestionadaTest.getTodosLosCircuito(), terminal);
    	assertEquals(terminalGestionadaTest.devolverMejorCircuitoA(terminal),circuitoDosDeLineaNaviera1);
    	verify(mejorCircuitoMock, times(1)).mejorCircuito(terminalGestionadaTest.getTodosLosCircuito(), terminal);
	}
	
	// Test De los estados de buque
	
	@Test
	void testUnTerminalPuedeDecirSiElBuqueEstaCerca() {
		when(buqueParaOrden.getLatitud()).thenReturn(50);
		when(buqueParaOrden.getLongitud()).thenReturn(30);
		assertTrue(terminalGestionadaTest.elBuqueEstaARangoCercanoDeLaTerminal(buqueParaOrden)); 
		
	}
	
	@Test
	void testUnTerminalPuedeDecirSiElBuqueNoEstaCerca() {
		when(buqueParaOrden.getLatitud()).thenReturn(80);
		when(buqueParaOrden.getLongitud()).thenReturn(40);
		assertFalse(terminalGestionadaTest.elBuqueEstaARangoCercanoDeLaTerminal(buqueParaOrden)); 
		
	}
	
	@Test
	void testUnTerminalPuedeDecirSiElBuqueEstaEnLaTermianal() {
		when(buqueParaOrden.getLatitud()).thenReturn(30);
		when(buqueParaOrden.getLongitud()).thenReturn(60);
		assertTrue(terminalGestionadaTest.elBuqueSeEncuentraEnLaTerminal(buqueParaOrden)); 
		
	}
	
	@Test
	void testUnTerminalPuedeDecirSiElBuqueNoEstaEnLaTermianal() {
		when(buqueParaOrden.getLatitud()).thenReturn(31);
		when(buqueParaOrden.getLongitud()).thenReturn(60);
		assertFalse(terminalGestionadaTest.elBuqueSeEncuentraEnLaTerminal(buqueParaOrden)); 
		
	}
	
	@Test
	void testUnTerminalPuedeDecirSiElBuqueSeEncunetraFueraDelRadioEnLaTermianal() {
		when(buqueParaOrden.getLatitud()).thenReturn(35);
		when(buqueParaOrden.getLongitud()).thenReturn(60);
		assertTrue(terminalGestionadaTest.elBuqueSeEncuentraFueraDelRangoDeLaTerminal(buqueParaOrden)); 
		
	}
	
	@Test
	void testUnTerminalPuedeDecirSiElBuqueNoEncunetraFueraDelRadioEnLaTermianal() {
		when(buqueParaOrden.getLatitud()).thenReturn(31);
		when(buqueParaOrden.getLongitud()).thenReturn(60);
		assertFalse(terminalGestionadaTest.elBuqueSeEncuentraFueraDelRangoDeLaTerminal(buqueParaOrden)); 
		
	}
	
	@Test
	void testUnaTerminalMandaALosBuquesQueInicienElTrabajo() {
		terminalGestionadaTest.crearOrdenExportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden, terminal, horaDelTurno);
		terminalGestionadaTest.crearOrdenExportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden2, terminal, horaDelTurno);
		when(buqueParaOrden.isEsperandoIniciarTrabajo()).thenReturn(true);
		when(buqueParaOrden2.isEsperandoIniciarTrabajo()).thenReturn(false);
		terminalGestionadaTest.habilitarIncioDeTrabajoDeTodosLosBuquesDisponibles(); 
		verify(buqueParaOrden, times(1)).iniciarTrabajo();
		verify(buqueParaOrden2, times(0)).iniciarTrabajo();
	}
	@Test
	void testUnaTerminalMandaALosBuquesQueDepartan() {
		terminalGestionadaTest.crearOrdenExportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden, terminal, horaDelTurno);
		terminalGestionadaTest.crearOrdenExportacion(cliente1, containerParaOrden, listaDeServiciosParaOrden, conductorParaOrden, camionParaOrden, viajeParaOrden2, terminal, horaDelTurno);
		when(buqueParaOrden.isEsperandoDepart()).thenReturn(true);
		when(buqueParaOrden2.isEsperandoDepart()).thenReturn(false);
		terminalGestionadaTest.habilitarDepartDeTodosLosBuquesDisponibles(); 
		verify(buqueParaOrden, times(1)).avisarDepart();
		verify(buqueParaOrden2, times(0)).avisarDepart();
	}
}
