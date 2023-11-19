package ar.edu.unq.poo2.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;
import ar.edu.unq.poo2.Servicio.Servicio;

public abstract class Orden {
	private LocalDateTime fechaDeSalida;
	private LocalDateTime fechaDeLlegada;
	private Cliente importador;
	private Cliente exportador;
	private Viaje viajeSeleccionado;
	private ArrayList <Servicio> serviciosContratados = new ArrayList <Servicio>();
	private Camion camionAsignado;
	private Conductor conductorAsignado;
	private Container datosDeLaCarga; /// no deberia ser container y datos de la carga un metodo???
	
	
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
		this.datosDeLaCarga = container;
	}
	
	
}
