package ar.edu.unq.poo2.Ordenes.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
	private LocalDateTime horaTest;
	private Turno turnoTest;

	@BeforeEach
	void setUp() throws Exception {
		camionTest = mock(Camion.class);
		
		conductorTest = mock(Conductor.class);
		horaTest = LocalDateTime.now();
		
		turnoTest = new Turno(camionTest, conductorTest, horaTest);

		
	}

	@Test
	void testVerificarTurno() {
		assertTrue(turnoTest.verificarTurno(camionTest, conductorTest, horaTest, 3));
	}

	@Test
	void testVerificoLaTolerancia() {
		assertTrue(turnoTest.estaDentroDeLaTolerancia(horaTest, horaTest, 3));
	}
	
	@Test
	void testVerificarTurnoCasoFalso() {
		Camion camion = mock(Camion.class);
		assertFalse(turnoTest.verificarTurno(camion, conductorTest, horaTest, 3));
		Conductor conductor = mock(Conductor.class);
		assertFalse(turnoTest.verificarTurno(camionTest, conductor, horaTest, 3));
	}

	@Test
	void testVerificoLaToleranciaFalso() {
		Turno test = new Turno(camionTest, conductorTest, LocalDateTime.of(2023, 12, 10, 10, 30));
		assertFalse(turnoTest.verificarTurno(camionTest, conductorTest, LocalDateTime.of(2023, 12, 10, 14, 30), 3));
	}
	
	
}
	
	
	