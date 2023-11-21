package ar.edu.unq.poo2.BuscadorDeViajes.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorPuertoDestino;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorPuertoDestinoTest {

	private BuscadorPuertoDestino buscadorPuertoDestino;
	private List<Viaje> viajesAFiltrar;
	
	@Mock
	  Viaje  viaje1 = mock(Viaje.class);
	  Viaje  viaje2 = mock(Viaje.class);
	  Viaje  viaje3 = mock(Viaje.class);
      Viaje  viaje4 = mock(Viaje.class);
      
	
	@BeforeEach
		public void setUp() {
		 viajesAFiltrar = new ArrayList<>();
    	 buscadorPuertoDestino = new BuscadorPuertoDestino();
    	 
		 when(viaje1.llegaA("MarDelPlata")).thenReturn(true);
		 when(viaje2.llegaA("Ushuaia")).thenReturn(true);
		 when(viaje3.llegaA("Cordoba")).thenReturn(false);
		 when(viaje4.llegaA("Rosario")).thenReturn(false);

		 viajesAFiltrar.add(viaje1);
		 viajesAFiltrar.add(viaje2);
		 viajesAFiltrar.add(viaje3);
		 viajesAFiltrar.add(viaje4);

	}
	
	@Test
	public void noContieneViaje3() {
		buscadorPuertoDestino.setPuertoABuscar("Cordoba");
		assertFalse(buscadorPuertoDestino.filtrar(viajesAFiltrar).contains(viaje3));
		
	}
	@Test
	public void ContieneViaje1() {
		buscadorPuertoDestino.setPuertoABuscar("Ushuaia");
		assertTrue(buscadorPuertoDestino.filtrar(viajesAFiltrar).contains(viaje3));

	}
	
}