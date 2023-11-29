package ar.edu.unq.poo2.Orden;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

public abstract class Orden {
	private LocalDate fechaDeSalida;
	private LocalDate fechaDeLlegada;
	private Cliente cliente;
	private Viaje viajeSeleccionado;
	private List <Servicio> serviciosContratados = new ArrayList <Servicio>();
	private Container container; 
	private Turno turno;
	private double costoDelViaje;
	
	
	public Orden(LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Cliente cliente,
			Viaje viajeSeleccionado, List<Servicio> serviciosContratados, Container container, Turno turno, Terminal terminalOrigen, Terminal terminalDestino) {
		super();
		this.fechaDeSalida = fechaDeSalida;
		this.fechaDeLlegada = fechaDeLlegada;
		this.cliente = cliente;
		this.viajeSeleccionado = viajeSeleccionado;
		this.serviciosContratados = serviciosContratados;
	
		this.container = container;
		this.turno     = turno;
		this.costoDelViaje = this.viajeSeleccionado.costoDelViajeEntre(terminalOrigen, terminalDestino);
	}
	


	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}


	public LocalDate getFechaDeLlegada() {
		return fechaDeLlegada;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public Viaje getViajeSeleccionado() {
		return viajeSeleccionado;
	}


	public List<Servicio> getServiciosContratados() {
		return serviciosContratados;
	}


	public Container getContainer() {
		return container;
	}
	public abstract boolean checkearTurno(Camion camionQueLlego, Conductor conductorDelCamion, LocalDateTime horaQueLlego);
	
	public abstract double calcularCostoDeOrden();
	
	public abstract void mandarEmailACliente();



	public Turno getTurno() {
		return turno;
	}



	public double getCostoDelViaje() {
		return costoDelViaje;
	} 
	
	public void addServicio(Servicio servicio) {
		this.serviciosContratados.add(servicio);
	}
	
}
