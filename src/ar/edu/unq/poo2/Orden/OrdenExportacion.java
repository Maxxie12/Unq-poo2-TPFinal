package ar.edu.unq.poo2.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Servicio.Servicio;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

public class OrdenExportacion extends Orden{

	public OrdenExportacion(LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada, Cliente importador,
			Cliente exportador, Viaje viajeSeleccionado, ArrayList<Servicio> serviciosContratados,
			Camion camionAsignado, Conductor conductorAsignado) {
		super(fechaDeSalida, fechaDeLlegada, importador, exportador, viajeSeleccionado, serviciosContratados, camionAsignado,
				conductorAsignado);
		// TODO Auto-generated constructor stub
	}

}
