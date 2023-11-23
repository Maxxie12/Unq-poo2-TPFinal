package ar.edu.unq.poo2.Orden;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

public abstract class Orden {
	private LocalDate fechaDeSalida;
	private LocalDate fechaDeLlegada;
	private Cliente importador;
	private Cliente exportador;
	private Viaje viajeSeleccionado;
	private ArrayList <Servicio> serviciosContratados = new ArrayList <Servicio>();

	private Container container; 
	private Turno turno;
	
	
	public Orden(LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Cliente importador, Cliente exportador,
			Viaje viajeSeleccionado, ArrayList<Servicio> serviciosContratados, Container container, Turno turno) {
		super();
		this.fechaDeSalida = fechaDeSalida;
		this.fechaDeLlegada = fechaDeLlegada;
		this.importador = importador;
		this.exportador = exportador;
		this.viajeSeleccionado = viajeSeleccionado;
		this.serviciosContratados = serviciosContratados;
	
		this.container = container;
		this.turno=turno;
	}
	


	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}


	public LocalDate getFechaDeLlegada() {
		return fechaDeLlegada;
	}


	public Cliente getImportador() {
		return importador;
	}


	public Cliente getExportador() {
		return exportador;
	}


	public Viaje getViajeSeleccionado() {
		return viajeSeleccionado;
	}


	public ArrayList<Servicio> getServiciosContratados() {
		return serviciosContratados;
	}


	public Container getContainer() {
		return container;
	}
	public abstract void mandarEmailACliente(); 
}
