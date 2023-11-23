package ar.edu.unq.poo2.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

public class OrdenImportacion extends Orden{

	public OrdenImportacion(LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada, Cliente importador,
			Cliente exportador, Viaje viajeSeleccionado, ArrayList<Servicio> serviciosContratados,
			Camion camionAsignado, Conductor conductorAsignado, Container container) {
		super(fechaDeSalida, fechaDeLlegada, importador, exportador, viajeSeleccionado, serviciosContratados, camionAsignado,
				conductorAsignado, container);
		// TODO Auto-generated constructor stub
	}
	
}