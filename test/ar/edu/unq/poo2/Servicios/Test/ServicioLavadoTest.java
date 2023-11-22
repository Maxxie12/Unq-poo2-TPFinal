package ar.edu.unq.poo2.Servicios.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.Container.Container;

import ar.edu.unq.poo2.Servicios.ServicioLavado;

public class ServicioLavadoTest {

	private double    precioDelServicio = 1000;
	
   @Mock
   ServicioLavado servicioLavado = mock(ServicioLavado.class);
   Container 	  container 	 = mock(Container.class);
   
   @BeforeEach
   void setUp() {
	   servicioLavado = new ServicioLavado(precioDelServicio, container); 
	    }
   
   
   @Test
   void calcularCostoLavado() {
	   container.setCapacidad(80);
	   assertEquals(8000, servicioLavado.calcularPrecioDelServicio());
   }
}
