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

class TurnoTest {

	
	private Camion camionTest;
	private Conductor conductorTest;
	private LocalDate horaTest;
	private Turno turnoTest;
	
	
	//private MenorTiempo menorTiempo;
	//private MenorCantParadas menosParadas;	
	//private MenorPrecio menorPrecio;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
	
		camionTest = mock(Camion.class);
		conductorTest = mock(Conductor.class);
		LocalDateTime horaLLegadaTest =LocalDateTime.now() ;
		
		Turno turnoTest = new Turno(camionTest, conductorTest, horaLLegadaTest);

		

		
		
		
		//camionTest  =  new Camion("1234");
		//horaTest  =  new MenorPrecio();

	}
	
	///estos dos falla y no se por que
	@Test
		void testVerificoLaTolerancia(){//importacion
			LocalDateTime horaLLegadaTest =LocalDateTime.now();
			Turno turnoTest = new Turno(camionTest, conductorTest, horaLLegadaTest);

			when(turnoTest.verificarTurno(camionTest, conductorTest, horaLLegadaTest , 3)).thenReturn(true);
			assertTrue(turnoTest.verificarTurno(camionTest, conductorTest, horaLLegadaTest, 3) );
	}
	@Test
		void testVerificarTurno() {
		LocalDateTime horaLLegadaTest =LocalDateTime.now();
		Turno turnoTest = new Turno(camionTest, conductorTest, horaLLegadaTest);
		

	}
}
	
	
	