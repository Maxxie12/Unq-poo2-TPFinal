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
	ServicioAlmacenamientoExcedente servicioAlmacenamientoExcedente;
	
 
   
   @BeforeEach
   void setUp() {
	   servicioAlmacenamientoExcedente = new ServicioAlmacenamientoExcedente(LocalDate.of(2024, 12, 24), (LocalDate.of(2024, 12, 31)), 1000.0);
	   
	    }
   
   
   @Test
   void calcularCostoAlmacenamientoTotal() {
	   assertEquals(7000.0, servicioAlmacenamientoExcedente.calcularPrecioDelServicio());
   }
   
}
