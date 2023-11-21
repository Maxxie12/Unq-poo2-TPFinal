package ar.edu.unq.poo2.Servicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.poo2.Container.Container;

public class ServicioAlmacenamientoExcedente extends Servicio{

	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private double	  costoDeAlmacenamientoPorDia;
	
	public ServicioAlmacenamientoExcedente(double precioDeServicio, Container container,LocalDate fechaInicio, LocalDate fechaFinal, double costoDeAlmacenamientoPorDia) {
		super(precioDeServicio, container);
		this.fechaInicio = fechaInicio;
		this.fechaFinal  = fechaFinal;
		this.costoDeAlmacenamientoPorDia = costoDeAlmacenamientoPorDia;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularPrecioDelServicio() {
		
		return (ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFinal) * this.costoDeAlmacenamientoPorDia);
	}
	
	
	

}
