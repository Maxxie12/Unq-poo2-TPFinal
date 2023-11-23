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

	private double    precioDelServicio = 1000.0;
	ServicioLavado	  servicioLavado1;
	ServicioLavado	  servicioLavado2;
	ServicioLavado	  servicioLavado3;
	
   @Mock
   Container 	  container1 	 = mock(Container.class);
   Container 	  container2	 = mock(Container.class);
   Container 	  container3 	 = mock(Container.class);
   
   @BeforeEach
   void setUp() {
	   servicioLavado1 = new ServicioLavado(precioDelServicio, container1); 
	   servicioLavado2 = new ServicioLavado(precioDelServicio, container2);
	   servicioLavado3 = new ServicioLavado(precioDelServicio, container3);
	   
	   
	   when(container1.getCapacidad()).thenReturn(80.0);
	   when(container2.getCapacidad()).thenReturn(70.0);
	   when(container3.getCapacidad()).thenReturn(60.0);
	   
	    }
   
   
   
   @Test
   void calcularCostoLavadoConCapacidadMayorA70() {
	  
	   assertEquals(1800.0, servicioLavado1.calcularPrecioDelServicio());
   }
   
   @Test
   void calcularCostoLavadoConCapacidadMenorA70() {
	  
	   assertEquals(400.0, servicioLavado3.calcularPrecioDelServicio());
   }
   
   @Test
   void calcularCostoLavadoConCapacidadIgualA70() {
	  
	   assertEquals(1000.0, servicioLavado2.calcularPrecioDelServicio());
   }
   
   
}
