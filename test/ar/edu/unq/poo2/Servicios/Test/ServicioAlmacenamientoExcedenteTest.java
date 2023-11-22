package ar.edu.unq.poo2.Servicios.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.poo2.Servicios.ServicioAlmacenamientoExcedente;

public class ServicioAlmacenamientoExcedenteTest {
	LocalDate						fechaDeRetirada;
	LocalDate						fechaEnQueSeRetiro;
	double							costoDeAlmacenamientoPorDia;
	
   @Mock
   ServicioAlmacenamientoExcedente servicioAlmacenamientoExcedente = mock(ServicioAlmacenamientoExcedente.class);
   
   @BeforeEach
   void setUp() {
	   servicioAlmacenamientoExcedente = new ServicioAlmacenamientoExcedente(fechaDeRetirada, fechaEnQueSeRetiro, costoDeAlmacenamientoPorDia);
	   
	   when(servicioAlmacenamientoExcedente.getFechaDeRetirada()).thenReturn(LocalDate.of(2024, 12, 24));
	   
	    }
   
   
   @Test
   void calcularCostoAlmacenamientoTotal() {
	   assertEquals(7000, servicioAlmacenamientoExcedente.calcularPrecioDelServicio());
   }
   
}
