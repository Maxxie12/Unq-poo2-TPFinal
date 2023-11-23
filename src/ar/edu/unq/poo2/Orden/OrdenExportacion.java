package ar.edu.unq.poo2.Orden;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;

public class OrdenExportacion extends Orden{

	public OrdenExportacion(LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Cliente importador,
			Cliente exportador, Viaje viajeSeleccionado, List<Servicio> serviciosContratados, Container container, Turno turno) {
		super(fechaDeSalida, fechaDeLlegada, importador, exportador, viajeSeleccionado, serviciosContratados, container, turno);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mandarEmailACliente() {
		
	}

}
