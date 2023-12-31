package ar.edu.unq.poo2.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

public abstract class Orden {
	private LocalDateTime fechaDeSalida;
	private LocalDateTime fechaDeLlegada;
	private Cliente importador;
	private Cliente exportador;
	private Viaje viajeSeleccionado;
	private ArrayList <Servicio> serviciosContratados = new ArrayList <Servicio>();
	private Camion camionAsignado;
	private Conductor conductorAsignado;
	private Container container; 
	
	
	public Orden(LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada, Cliente importador, Cliente exportador,
			Viaje viajeSeleccionado, ArrayList<Servicio> serviciosContratados, Camion camionAsignado,
			Conductor conductorAsignado, Container container) {
		super();
		this.fechaDeSalida = fechaDeSalida;
		this.fechaDeLlegada = fechaDeLlegada;
		this.importador = importador;
		this.exportador = exportador;
		this.viajeSeleccionado = viajeSeleccionado;
		this.serviciosContratados = serviciosContratados;
		this.camionAsignado = camionAsignado;
		this.conductorAsignado = conductorAsignado;
		this.container = container;
	}
	


	public LocalDateTime getFechaDeSalida() {
		return fechaDeSalida;
	}


	public LocalDateTime getFechaDeLlegada() {
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


	public Camion getCamionAsignado() {
		return camionAsignado;
	}


	public Conductor getConductorAsignado() {
		return conductorAsignado;
	}

	public Container getContainer() {
		return container;
	}

}
