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

public class OrdenExportacion extends Orden{

	public OrdenExportacion(LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Cliente cliente,
			 Viaje viajeSeleccionado, List<Servicio> serviciosContratados, Container container, Turno turno, Terminal terminalOrigen, Terminal terminalDestino) {
		super(fechaDeSalida, fechaDeLlegada, cliente, viajeSeleccionado, serviciosContratados, container, turno, terminalOrigen, terminalDestino);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mandarEmailACliente() {
		getCliente().mandarEmail("Partida de Buque", "El Buque que lleva su carga ya partido de la terminal llevando su carga");
	}
	
	public boolean checkearTurno(Camion camionQueLlego, Conductor conductorDelCamion, LocalDateTime horaQueLlego) {
		return this.getTurno().verificarTurno(camionQueLlego, conductorDelCamion, horaQueLlego, 3);
	}

	

	@Override
	public double calcularCostoDeOrden() {
		double result = 0.0;
		
		result= this.getServiciosContratados().stream()
				.mapToDouble(s->s.calcularPrecioDelServicio())
				.sum();
		
		return result;
	}

	

}
