package ar.edu.unq.poo2.Ordenes.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.MejorCircuito.MenorCantParadas;
import ar.edu.unq.poo2.MejorCircuito.MenorPrecio;
import ar.edu.unq.poo2.MejorCircuito.MenorTiempo;
import ar.edu.unq.poo2.Orden.Orden;
import ar.edu.unq.poo2.Orden.OrdenExportacion;
import ar.edu.unq.poo2.Orden.OrdenImportacion;
import ar.edu.unq.poo2.Orden.Turno;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

class OrdenesTest {

	private Servicio servicioTest1;
	private Servicio servicioTest2;
	private Servicio servicioTest3;
	private Servicio servicioTest4;

	private ArrayList <Servicio> listaDeServicios = new ArrayList<Servicio>();
	
	private Camion camionTest;
	private Conductor conductorTest;
	private LocalDate horaTest;
	private Cliente clienteTest;
	private Viaje viajeTest;
	private Container containerTest;
	private Terminal terminalOrigen;
	private Terminal terminalDestino;
	private OrdenImportacion ordenImportacionTest;
	private OrdenExportacion ordenExportacionTest;
	private Turno turnoTest;
	private Buque buqueTest;
	
	//private MenorTiempo menorTiempo;
	//private MenorCantParadas menosParadas;	
	//private MenorPrecio menorPrecio;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		clienteTest= mock(Cliente.class);
		viajeTest= mock(Viaje.class);
		servicioTest1= mock(Servicio.class);
		servicioTest2 = mock(Servicio.class);
		servicioTest3= mock(Servicio.class);
		servicioTest4= mock(Servicio.class);
		camionTest = mock(Camion.class);
		turnoTest = mock(Turno.class);
		terminalOrigen = mock (Terminal.class);
		terminalDestino = mock (Terminal.class);
		buqueTest = mock (Buque.class);
		containerTest = mock(Container.class);

		

		
		
		listaDeServicios= new ArrayList<Servicio>();
		listaDeServicios.add(servicioTest1);listaDeServicios.add(servicioTest2);listaDeServicios.add(servicioTest3);
		ordenImportacionTest = new OrdenImportacion(horaTest, horaTest, clienteTest, viajeTest, listaDeServicios, containerTest, turnoTest, terminalOrigen, terminalDestino);
		ordenExportacionTest = new OrdenExportacion(horaTest, horaTest, clienteTest, viajeTest, listaDeServicios, containerTest, turnoTest, terminalDestino, terminalDestino);
		
		//camionTest  =  new Camion("1234");
		//horaTest  =  new MenorPrecio();

	}
	@Test
		void testCheckeoQueElTurnoEsta(){//importacion
			LocalDateTime horaLLegadaTest =LocalDateTime.now() ;
			when(turnoTest.verificarTurno(camionTest, conductorTest, horaLLegadaTest , 3)).thenReturn(true);
			assertTrue(ordenImportacionTest.checkearTurno(camionTest, conductorTest,horaLLegadaTest ));
	}
	
	 
	
	@Test
	void testCheckeoQueElTurnoNoEsta(){ //importacion
		when(turnoTest.verificarTurno(camionTest, conductorTest, LocalDateTime.now(), 3)).thenReturn(false);
		assertFalse(ordenImportacionTest.checkearTurno(camionTest, conductorTest, LocalDateTime.now()));
	}
	@Test
	void testCheckeoElCostoDeLaOrdenDeImportacion(){
		when(servicioTest1.calcularPrecioDelServicio()).thenReturn(40.0);
		when(servicioTest2.calcularPrecioDelServicio()).thenReturn(30.50);
		when(servicioTest3.calcularPrecioDelServicio()).thenReturn(10.70);
		
		assertEquals(ordenImportacionTest.calcularCostoDeOrden(),81.20);
		

	}
	
	@Test
	void testCheckeoElCostoDeLaOrdenDeExportacion(){
		when(servicioTest1.calcularPrecioDelServicio()).thenReturn(50.0);
		when(servicioTest2.calcularPrecioDelServicio()).thenReturn(30.50);
		when(servicioTest3.calcularPrecioDelServicio()).thenReturn(10.70);
		
		assertEquals(ordenExportacionTest.calcularCostoDeOrden(),91.20);
	
	} 
	@Test
	void testAgregoServicio() {
		ordenImportacionTest.addServicio(servicioTest4);
		assertTrue(ordenImportacionTest.getServiciosContratados().contains(servicioTest4));
	}
	@Test
	void testRelacionadaABueque() {
		
		when(ordenImportacionTest.getViajeSeleccionado().getBuqueAsignado()).thenReturn(buqueTest);
		assertTrue(ordenImportacionTest.RelacionadaA(buqueTest));
	}
	@Test
	void testGetContainer() {
		//when(ordenImportacionTest.getContainer()).thenReturn(containerTest);
		assertEquals(ordenImportacionTest.getContainer(), containerTest);
	}
	
}