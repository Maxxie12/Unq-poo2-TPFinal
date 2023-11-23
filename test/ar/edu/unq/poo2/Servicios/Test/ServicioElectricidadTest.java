package ar.edu.unq.poo2.Servicios.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.Container.ContainerReefer;
import ar.edu.unq.poo2.Servicios.ServicioElectricidad;

public class ServicioElectricidadTest {
	

	ServicioElectricidad servicioElectricidad; 
	
	
	
	@Mock
	ContainerReefer	 containerReefer = mock(ContainerReefer.class);


	@BeforeEach
 void	setUp(){
	servicioElectricidad = new ServicioElectricidad((LocalDateTime.of(2023, 11, 15, 12, 0)),(LocalDateTime.of(2023, 11, 16, 12, 0)), containerReefer);
    when(containerReefer.getConsumoPorHora()).thenReturn(80.0);
	   
	}
	
	
	@Test
	void calcularCostoDeServicioDeElectricidad()  {
		assertEquals(1920.0, servicioElectricidad.calcularPrecioDelServicio());
	}
	
	
	
	
	
	
	

}
