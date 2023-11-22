package ar.edu.unq.poo2.Servicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.poo2.Container.Container;

public class ServicioAlmacenamientoExcedente implements Servicio{
 
	private LocalDate fechaDeRetirada;
	private LocalDate fechaEnQueSeRetiro;
	private double	  costoDeAlmacenamientoPorDia;
	
	
	public ServicioAlmacenamientoExcedente(LocalDate fechaDeRetirada, LocalDate fechaEnQueSeRetiro, double costoDeAlmacenamientoPorDia) {
		this.fechaDeRetirada 	 = fechaDeRetirada;
		this.fechaEnQueSeRetiro  = fechaEnQueSeRetiro;
		this.costoDeAlmacenamientoPorDia = costoDeAlmacenamientoPorDia;
	}

	@Override
	public double calcularPrecioDelServicio() {
		
		return (ChronoUnit.DAYS.between(this.fechaDeRetirada, this.fechaEnQueSeRetiro) * this.costoDeAlmacenamientoPorDia);
	}
	
	
	

}
