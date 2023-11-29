package ar.edu.unq.poo2.TerminalGestionadaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Orden.Orden;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;
import ar.unq.edu.poo2.Common.Cliente;
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
	private Viaje			  	 viajeParaOrden;
	private EmpresaTransportista empresaTrasportista;
	private EmpresaTransportista empresaRegistrable;
	private List<LineaNaviera> 	 lineasNavierasRegistradas;
	private List<Cliente>	     clientesRegistrados;
	private List<Circuito> 		 circuitosLineaNaviera1;
	private List<Circuito> 		 circuitosLineaNaviera2;
	private List<EmpresaTransportista> empresasRegistradas;
	
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
		
		empresaTrasportista 	 = mock(EmpresaTransportista.class);
		empresaRegistrable       = mock(EmpresaTransportista.class);
		
		
		
		lineasNavierasRegistradas	= new ArrayList<LineaNaviera>();
		empresasRegistradas			= new ArrayList<EmpresaTransportista>();
		clientesRegistrados  	    = new ArrayList<Cliente>();
		circuitosLineaNaviera1		= new ArrayList<Circuito>();
		circuitosLineaNaviera2		= new ArrayList<Circuito>();
		
		lineasNavierasRegistradas.add(lineaRegistrada);lineasNavierasRegistradas.add(lineaRegistrada2);
		empresasRegistradas.add(empresaTrasportista);
		clientesRegistrados.add(cliente1);clientesRegistrados.add(cliente2);clientesRegistrados.add(cliente3);
		circuitosLineaNaviera1.add(circuitoUnoDeLineaNaviera1);circuitosLineaNaviera1.add(circuitoDosDeLineaNaviera1);circuitosLineaNaviera1.add(circuitoTresDeLineaNaviera1);
		circuitosLineaNaviera2.add(circuitoUnoDeLineaNaviera2);circuitosLineaNaviera2.add(circuitoDosDeLineaNaviera2);
		
		// comportamiento de las clases mock 
		
		when(lineaRegistrada.getCircuitosRegistrados()).thenReturn(circuitosLineaNaviera1);
		when(lineaRegistrada2.getCircuitosRegistrados()).thenReturn(circuitosLineaNaviera2);
		
		terminalGestionadaTest = new TerminalGestionada("Bs", lineasNavierasRegistradas, empresasRegistradas, clientesRegistrados);
	}

	@Test
	void testUnTerminalPuedeDevolverSuNombre() {
		assertEquals(terminalGestionadaTest.getNombre(), "Bs");
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
	
	
}
