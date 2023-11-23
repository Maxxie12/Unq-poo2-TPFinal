package ar.edu.unq.poo2.BuscadorDeViajes.Test;

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
import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorOr;
import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorPuertoDestino;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorOrTest {

	List<Viaje> viajesAFiltrar = new ArrayList<Viaje>();
	BuscadorOr					 buscadorOr;
	BuscadorPuertoDestino 		 buscadorPuertoDestino1;
	BuscadorPuertoDestino 		 buscadorPuertoDestino2;
	BuscadorFechaDeSalida		 buscadorFechaDeSalida;
	String						 puertoDestino;
	LocalDate					 fechaDeLlegada;
		

	 
		
	@Mock
	Viaje  viaje1 = mock(Viaje.class);
	Viaje  viaje2 = mock(Viaje.class);
	Viaje  viaje3 = mock(Viaje.class);
	Viaje  viaje4 = mock(Viaje.class);
	   
	    
		
	@BeforeEach
	void setUp() {
		buscadorPuertoDestino1 = new BuscadorPuertoDestino();
		buscadorPuertoDestino2 = new BuscadorPuertoDestino();
		buscadorFechaDeSalida  = new BuscadorFechaDeSalida();
		buscadorOr = new BuscadorOr(buscadorPuertoDestino1, buscadorPuertoDestino2);
		viajesAFiltrar = new ArrayList<>();

		    
		when(viaje1.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 11, 20))).thenReturn(false);	  
		when(viaje2.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 07, 18))).thenReturn(false);
		when(viaje3.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 12, 24))).thenReturn(false);
		
		when(viaje1.llegaA("MarDelPlata")).thenReturn(true);
		when(viaje1.llegaA("Rosario")).thenReturn(false);
		when(viaje3.llegaA("Cordoba")).thenReturn(true);
	       
			
		viajesAFiltrar.add(viaje1);
		viajesAFiltrar.add(viaje2);
		viajesAFiltrar.add(viaje3);
			
		
	}
		
	@Test
	void buscadorOrContieneMarDelPlata() {
		buscadorPuertoDestino1.setPuertoABuscar("MarDelPlata");
		buscadorPuertoDestino2.setPuertoABuscar("Rosario");
		assertTrue(buscadorOr.filtrar(viajesAFiltrar).contains(viaje1));
			
			
	}
		
	@Test
	void buscadorOr() {
		buscadorPuertoDestino1.setPuertoABuscar("Cordoba");
		buscadorFechaDeSalida.setfechaDeSalida(LocalDate.of(2024, 12, 24));
		assertTrue(buscadorOr.filtrar(viajesAFiltrar).contains(viaje3));
	}
		

	
}
