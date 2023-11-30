package ar.edu.unq.poo2.CommonTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unq.edu.poo2.Common.Conductor;

public class ConductorTest {

	    @Test
	    public void testGetDni() {
	        Conductor conductor = new Conductor(123456789, "Juan Pérez");
	        assertEquals(123456789, conductor.getDni());
	    }

	    @Test
	    public void testGetNombre() {
	        Conductor conductor = new Conductor(987654321, "María González");
	        assertEquals("María González", conductor.getNombre());
	    }

	    @Test
	    public void testConstructor() {
	        Conductor conductor = new Conductor(111222333, "Carlos Rodríguez");
	        assertEquals(111222333, conductor.getDni());
	        assertEquals("Carlos Rodríguez", conductor.getNombre());
	    }
}
