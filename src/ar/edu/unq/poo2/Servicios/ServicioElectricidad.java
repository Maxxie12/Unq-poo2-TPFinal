package ar.edu.unq.poo2.Servicios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.Container.ContainerReefer;

public class ServicioElectricidad implements Servicio {

	private LocalDateTime 	inicioDelServicio;
	private LocalDateTime 	finalDelServicio;
	private ContainerReefer	containerReefer;
	
	public ServicioElectricidad(LocalDateTime inicioDelServicio, LocalDateTime finalDelServicio, ContainerReefer containerReefer) {
		this.inicioDelServicio = inicioDelServicio;
		this.finalDelServicio  = finalDelServicio;
		this.containerReefer   = containerReefer;
		 
	}

	
	@Override
	public double calcularPrecioDelServicio() {
		
		return (ChronoUnit.HOURS.between(this.inicioDelServicio, this.finalDelServicio) * this.containerReefer.getConsumoPorHora());
	}


	

}