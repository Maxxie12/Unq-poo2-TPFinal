package ar.edu.unq.poo2.Servicios.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.Servicios.ServicioLavado;
import ar.edu.unq.poo2.Servicios.ServicioPesado;

public class ServicioPesadoTest {
	private double    precioDelServicio = 1000;
	
	   @Mock
	   ServicioPesado servicioPesado = mock(ServicioPesado.class);
	   
	   @BeforeEach
	   void setUp() {
		   servicioPesado = new ServicioPesado(precioDelServicio); 
		    }
	   
	   
	   @Test
	   void calcularCostoLavado() {
		   assertEquals(1000, servicioPesado.calcularPrecioDelServicio());
	   }


}
