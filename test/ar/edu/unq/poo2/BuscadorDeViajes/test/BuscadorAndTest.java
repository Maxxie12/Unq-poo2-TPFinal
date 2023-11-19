package ar.edu.unq.poo2.BuscadorDeViajes.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorAnd;
import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorFechaDeLlegada;
import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorPuertoDestino;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

class BuscadorAndTest {

	List<Viaje> viajesAFiltrar = new ArrayList<Viaje>();
	BuscadorAnd					 buscadorAnd;
	BuscadorPuertoDestino 		 buscadorPuertoDestino;
	BuscadorFechaDeLlegada		 buscadorFechaDeLlegada;
	

 
	
	@Mock
	Viaje  viaje1 = mock(Viaje.class);
	Viaje  viaje2 = mock(Viaje.class);
	Viaje  viaje3 = mock(Viaje.class);
    Viaje  viaje4 = mock(Viaje.class);
   
    
	
	@BeforeEach
	void setUp() {
		buscadorPuertoDestino = new BuscadorPuertoDestino();
		buscadorFechaDeLlegada = new BuscadorFechaDeLlegada();
		buscadorAnd = new BuscadorAnd(buscadorPuertoDestino, buscadorFechaDeLlegada);
		viajesAFiltrar = new ArrayList<>();

	    
	    when(viaje1.getFechaDeFin()).thenReturn();	  
		when(viaje2.getFechaDeFin()).thenReturn();
        when(viaje3.getFechaDeFin()).thenReturn();
        
        when(viaje1.getPuertoDestino()).thenReturn();
        when(viaje2.getPuertoDestino()).thenReturn();
        when(viaje3.getPuertoDestino()).thenReturn();
       
		
		viajesAFiltrar.add(viaje1);
		viajesAFiltrar.add(viaje2);
		viajesAFiltrar.add(viaje3);
		viajesAFiltrar.add(viaje4);
	
	}
	
	@Test
	void buscadorAndNoContiene() {
		
		
		assertFalse(buscadorAnd.filtrar(viajesAFiltrar).contains(viaje1));
		
		
	}
	
	@Test
	void buscadorAnd() {
		
		assertTrue(buscadorAnd.filtrar(viajesAFiltrar).contains(viaje3));
	}
	

}



