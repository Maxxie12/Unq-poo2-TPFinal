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
      Viaje  viaje5 = mock(Viaje.class);
      
	
	@BeforeEach
		public void setUp() {
		 viajesAFiltrar = new ArrayList<>();
    	 buscadorFechaDeSalida = new BuscadorFechaDeSalida();
		 
		 when(viaje1.saleDeLaTerminalGestionadaEn(LocalDate.of(2024, 11, 20))).thenReturn(false);	  
		 when(viaje2.saleDeLaTerminalGestionadaEn(LocalDate.of(2024, 07, 18))).thenReturn(false);
	     when(viaje3.saleDeLaTerminalGestionadaEn(LocalDate.of(2024, 12, 24))).thenReturn(true);
	     when(viaje4.saleDeLaTerminalGestionadaEn(LocalDate.of(2024, 12, 10))).thenReturn(true);
	     when(viaje5.saleDeLaTerminalGestionadaEn(LocalDate.of(2024, 12, 10))).thenReturn(true);
	     

		 viajesAFiltrar.add(viaje1);
		 viajesAFiltrar.add(viaje2);
		 viajesAFiltrar.add(viaje3);
		 viajesAFiltrar.add(viaje4);
		 viajesAFiltrar.add(viaje5);

	}
	
	@Test
	public void testFiltrarBuscadorDeFechaDeSalida() {
		buscadorFechaDeSalida.setfechaDeSalida((LocalDate.of(2024, 12, 10)));
		assertEquals(2, buscadorFechaDeSalida.filtrar(viajesAFiltrar).size());
    }
	@Test
	public void noContieneViaje1() {
		buscadorFechaDeSalida.setfechaDeSalida((LocalDate.of(2024, 11, 20)));
		 
		assertFalse(buscadorFechaDeSalida.filtrar(viajesAFiltrar).contains(viaje1));
		
	}
	@Test
	public void ContieneViaje3() {
		buscadorFechaDeSalida.setfechaDeSalida(LocalDate.of(2024, 12, 24));
		assertTrue(buscadorFechaDeSalida.filtrar(viajesAFiltrar).contains(viaje3));
		
	}

}
