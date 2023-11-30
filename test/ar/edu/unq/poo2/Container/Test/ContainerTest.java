package ar.edu.unq.poo2.Container.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import ar.edu.unq.poo2.Container.ContainerDry;
import ar.edu.unq.poo2.Container.ContainerReefer;
import ar.edu.unq.poo2.Container.ContainerTanque;

public class ContainerTest {
	
	 @Test
	    public void testContainerDry() {
	        ContainerDry containerDry = new ContainerDry(5.0, 10.0, 3.0, 150.0, 1);

	       
	        assertEquals(5.0, containerDry.getAncho(), 0.01);
	        assertEquals(10.0, containerDry.getLargo(), 0.01);
	        assertEquals(3.0, containerDry.getAltura(), 0.01);
	        assertEquals(150.0, containerDry.getCapacidad(), 0.01);
	        assertEquals(1, containerDry.getId());

	        
	    }
	 
	
	 @Test
	    public void testContainerReefer() {
	      
	        ContainerReefer containerReefer = new ContainerReefer(5.0, 10.0, 3.0, 150.0, 1, 20.0);

	       
	        assertEquals(5.0, containerReefer.getAncho(), 0.01);
	        assertEquals(10.0, containerReefer.getLargo(), 0.01);
	        assertEquals(3.0, containerReefer.getAltura(), 0.01);
	        assertEquals(150.0, containerReefer.getCapacidad(), 0.01);      
	        assertEquals(1, containerReefer.getId());
	        assertEquals(20.0, containerReefer.getConsumoPorHora(), 0.01);


	 }
	 
	 @Test
	    public void testContainerTanque() {
	       
	        ContainerTanque containerTanque = new ContainerTanque(8.0, 12.0, 4.0, 300.0, 2);

	       
	        assertEquals(8.0, containerTanque.getAncho(), 0.01);
	        assertEquals(12.0, containerTanque.getLargo(), 0.01);
	        assertEquals(4.0, containerTanque.getAltura(), 0.01);
	        assertEquals(300.0, containerTanque.getCapacidad(), 0.01);
	        assertEquals(2, containerTanque.getId());

	    } 
	
	 
}

