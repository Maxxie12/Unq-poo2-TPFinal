package ar.edu.unq.poo2.Servicio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.Container.ContainerReefer;

public class ServicioElectricidad extends Servicio {

	private LocalDateTime inicioDelServicio;
	private LocalDateTime finalDelServicio;
	
	
	public ServicioElectricidad(double precioDeServicio, Container container, LocalDateTime inicioDelServicio, LocalDateTime finalDelServicio) {
		super(precioDeServicio, container);
		if(!container.getClass().equals(ContainerReefer.class)) {throw new IllegalArgumentException("No es un container Reefer.");}
		this.inicioDelServicio = inicioDelServicio;
		this.finalDelServicio  = finalDelServicio;
		 
	}

	
	@Override
	public double calcularPrecioDelServicio() {
		
		return (ChronoUnit.HOURS.between(this.inicioDelServicio, this.finalDelServicio) * this.getContainer().get());
	}

	

}
