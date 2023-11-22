package ar.edu.unq.poo2.Servicios.Test;

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
	
	private LocalDateTime 	inicioDelServicio;
	private LocalDateTime 	finalDelServicio;
	
	
	
	@Mock
	ServicioElectricidad servicioElectricidad = mock(ServicioElectricidad.class);
	ContainerReefer		 containerReefer	  = mock(ContainerReefer.class);


	@BeforeEach
 void	setUp(){
	ServicioElectricidad servicioElectricidad = new ServicioElectricidad(inicioDelServicio, finalDelServicio, containerReefer);
	
	
	when(servicioElectricidad.getInicioDelServicio()).thenReturn(LocalDateTime.of(2023, 11, 15, 12, 0));
	when(servicioElectricidad.getFinalDelServicio()).thenReturn(LocalDateTime.of(2023, 11, 16, 12, 0));
    when(servicioElectricidad.getContainerReefer()).getConsumoPorHora().thenReturn(80);
	   
	}
	
	
	@Test
	void calcularCostoDeServicioDeElectricidad  {
		assetEquals(1920, servicioElectricidad.calcularPrecioDelServicio());
	}
	
	
	
	
	
	
	

}
