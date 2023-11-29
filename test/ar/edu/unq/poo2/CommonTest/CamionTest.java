package ar.edu.unq.poo2.CommonTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unq.edu.poo2.Common.Camion;

public class CamionTest {
	
	@Test
    public void testGetPatente() {
     
        Camion camion = new Camion("ABC123");
        assertEquals("ABC123", camion.getPatente());
    }

    @Test
    public void testConstructor() {
        Camion camion = new Camion("XYZ789");
        assertEquals("XYZ789", camion.getPatente());
    }
}

