package ar.edu.unq.poo2.BuscadorDeViajes.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorFechaDeLlegada;
import ar.edu.unq.poo2.LineaNaviera.Viaje;



public class BuscadorFechaDeLlegadaTest {


	private BuscadorFechaDeLlegada buscadorFechaDeLlegada;
	private List<Viaje> viajesAFiltrar;
	
	@Mock
	  Viaje  viaje1 = mock(Viaje.class);
	  Viaje  viaje2 = mock(Viaje.class);
	  Viaje  viaje3 = mock(Viaje.class);
      Viaje  viaje4 = mock(Viaje.class);
      
	
	@BeforeEach
		public void setUp() {
		 viajesAFiltrar = new ArrayList<>();
    	 buscadorFechaDeLlegada = new BuscadorFechaDeLlegada();
		 
		 when(viaje1.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 9, 1))).thenReturn(true);
		 when(viaje2.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 10, 11))).thenReturn(false);
		 when(viaje3.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 11, 12))).thenReturn(true);
		 when(viaje4.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 11, 12))).thenReturn(true);

		 viajesAFiltrar.add(viaje1);
		 viajesAFiltrar.add(viaje2);
		 viajesAFiltrar.add(viaje3);
		 viajesAFiltrar.add(viaje4);

	}
	
	@Test
	public void testFiltrarBuscadorDeFechaLlegada() {
		buscadorFechaDeLlegada.setfechaDeLlegada(LocalDate.of(2024, 11, 12));
		assertEquals(2, buscadorFechaDeLlegada.filtrar(viajesAFiltrar).size());

	
	}
	@Test
	public void noContieneViaje2() {
		buscadorFechaDeLlegada.setfechaDeLlegada(LocalDate.of(2024, 10, 11));
		assertFalse(buscadorFechaDeLlegada.filtrar(viajesAFiltrar).contains(viaje2));
		
	}
	@Test
	public void ContieneViaje1() {
		buscadorFechaDeLlegada.setfechaDeLlegada(LocalDate.of(2024, 9, 1));
		assertTrue(buscadorFechaDeLlegada.filtrar(viajesAFiltrar).contains(viaje1));
		
	}

	
}
