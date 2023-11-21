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

import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorFechaDeSalida;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorFechaDeSalidaTest {
	
	private BuscadorFechaDeSalida buscadorFechaDeSalida;
	private List<Viaje> viajesAFiltrar;
	
	@Mock
	  Viaje  viaje1 = mock(Viaje.class);
	  Viaje  viaje2 = mock(Viaje.class);
	  Viaje  viaje3 = mock(Viaje.class);
      Viaje  viaje4 = mock(Viaje.class);
      
	
	@BeforeEach
		public void setUp() {
		 viajesAFiltrar = new ArrayList<>();
    	 buscadorFechaDeSalida = new BuscadorFechaDeSalida();
		 LocalDate fechaDeLlegada = LocalDate.of(2024, 8, 16);
		 
		 when(viaje1.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(false);
		 when(viaje2.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(true);
		 when(viaje3.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(false);
		 when(viaje4.llegaAUnPuertoEnEstaFecha(fechaDeLlegada)).thenReturn(true);

		 viajesAFiltrar.add(viaje1);
		 viajesAFiltrar.add(viaje2);
		 viajesAFiltrar.add(viaje3);
		 viajesAFiltrar.add(viaje4);

	}
	
	@Test
	public void testFiltrarBuscadorDeFechaLlegada() {
		 List<Viaje> resultado = buscadorFechaDeSalida.filtrar(viajesAFiltrar);
		    assertEquals(2, resultado.size());

	
	}
	@Test
	public void noContieneViaje1() {
		List<Viaje> resultado = buscadorFechaDeSalida.filtrar(viajesAFiltrar);
			assertFalse(resultado.contains(viaje2));
		
	}
	@Test
	public void ContieneViaje2() {
		List<Viaje> resultado = buscadorFechaDeSalida.filtrar(viajesAFiltrar);
		assertTrue(resultado.contains(viaje1));
		
	}

}
