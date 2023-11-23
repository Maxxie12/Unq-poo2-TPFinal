package ar.edu.unq.poo2.BuscadorDeViajes.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
	String						 puertoDestino;
	LocalDate					 fechaDeLlegada;
	

 
	
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

	    
	    when(viaje1.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 11, 20))).thenReturn(false);	  
		when(viaje2.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 07, 18))).thenReturn(false);
        when(viaje3.llegaAUnPuertoEnEstaFecha(LocalDate.of(2024, 12, 24))).thenReturn(true);
        
        when(viaje1.llegaA("MarDelPlata")).thenReturn(true);
        when(viaje2.llegaA("Rosario")).thenReturn(false);
        when(viaje3.llegaA("Cordoba")).thenReturn(true);
       
		
		viajesAFiltrar.add(viaje1);
		viajesAFiltrar.add(viaje2);
		viajesAFiltrar.add(viaje3);
		
	
	}
	
	@Test
	void buscadorAndNoContieneMarDelPlata() {
		buscadorPuertoDestino.setPuertoABuscar("MarDelPlata");
		buscadorFechaDeLlegada.setfechaDeLlegada(LocalDate.of(2024, 11, 20));
		assertFalse(buscadorAnd.filtrar(viajesAFiltrar).contains(viaje1));
		
		
	}
	
	@Test
	void buscadorAndContieneCordoba() {
		buscadorPuertoDestino.setPuertoABuscar("Cordoba");
		buscadorFechaDeLlegada.setfechaDeLlegada(LocalDate.of(2024, 12, 24));
		assertTrue(buscadorAnd.filtrar(viajesAFiltrar).contains(viaje3));
	}
	

}



