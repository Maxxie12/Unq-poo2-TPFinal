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
		 LocalDate fechaDeLlegada = LocalDate.of(2024, 9, 1);
		 
		 when(viaje1.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(true);
		 when(viaje2.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(false);
		 when(viaje3.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(true);
		 when(viaje4.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(false);

		 viajesAFiltrar.add(viaje1);
		 viajesAFiltrar.add(viaje2);
		 viajesAFiltrar.add(viaje3);
		 viajesAFiltrar.add(viaje4);

	}
	
	@Test
	public void testFiltrarBuscadorDeFechaLlegada() {
		 List<Viaje> resultado = buscadorFechaDeLlegada.filtrar(viajesAFiltrar);
		    assertEquals(2, resultado.size());

	
	}
	@Test
	public void noContieneViaje2() {
		List<Viaje> resultado = buscadorFechaDeLlegada.filtrar(viajesAFiltrar);
			assertFalse(resultado.contains(viaje2));
		
	}
	@Test
	public void ContieneViaje1() {
		List<Viaje> resultado = buscadorFechaDeLlegada.filtrar(viajesAFiltrar);
		assertTrue(resultado.contains(viaje1));
		
	}

	
}
