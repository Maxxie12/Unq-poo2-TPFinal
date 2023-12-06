package ar.edu.unq.poo2.CommonTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.CompaniaDeEmail;

class ClienteTest {
	
	private Cliente test;
	private CompaniaDeEmail mockCompania;

	@BeforeEach
	void setUp() throws Exception {
		
		mockCompania = mock(CompaniaDeEmail.class);
		test 		 = new Cliente(32132315, "Miguel Laiun", "LaiunMiguel@hotmail.com", mockCompania);
		
	}

	@Test
	void testUnCLientePuedeDevolverSuDniYNombre() {
		assertEquals(32132315, test.getDni());
		assertEquals("Miguel Laiun", test.getNombreCliente());
	}

	@Test
	void testUnCLientePuedeMandarUnEmail() {
		test.mandarEmail("Test", "contenido");
		verify(mockCompania, times(1)).enviarEmailA("LaiunMiguel@hotmail.com","Test", "contenido");
	}
}
