package ar.edu.unq.poo2.CommonTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Conductor;
import ar.unq.edu.poo2.Common.EmpresaTransportista;

public class EmpresaTransportistaTest {
	
	private EmpresaTransportista empresaTransportista = new EmpresaTransportista("empresaDeTransporte");
	
	
	@Mock
	Camion camion1 = mock(Camion.class);
	Camion camion2 = mock(Camion.class);
	Camion camion3 = mock(Camion.class);
	Conductor conductor1 = mock(Conductor.class);
	Conductor conductor2 = mock(Conductor.class);
	Conductor conductor3 = mock(Conductor.class);
	
	@Test
	public void seRegistranCamiones() {
		empresaTransportista.registrarCamion(camion1);
		empresaTransportista.registrarCamion(camion2);
		empresaTransportista.registrarCamion(camion3);
		int cantCamiones = empresaTransportista.getCamionesRegistrados().size();
		assertEquals(3, cantCamiones);
		
	}
	
	@Test
	public void seRegistranConductores() {
		empresaTransportista.registrarConductor(conductor1);
		empresaTransportista.registrarConductor(conductor2);
		empresaTransportista.registrarConductor(conductor3);
		int cantConductores = empresaTransportista.getConductoresRegistrados().size();
		assertEquals(3, cantConductores);
	}
	
	@Test
	public void elNombreDeLaEmpresaEs() {
		assertEquals("empresaDeTransporte", empresaTransportista.getNombreEmpresa());
	}
			
	
	@Test
	public void eliminarCamion() {
		empresaTransportista.registrarCamion(camion1);
		empresaTransportista.registrarCamion(camion2);
		empresaTransportista.registrarCamion(camion3);
	
		empresaTransportista.removeCamion(camion2);
		assertEquals(2, empresaTransportista.getCamionesRegistrados().size());
	}
	
	@Test
	public void eliminarConductor() {
		empresaTransportista.registrarConductor(conductor1);
		empresaTransportista.registrarConductor(conductor2);
		empresaTransportista.registrarConductor(conductor3);
		
		empresaTransportista.removeConductor(conductor1);
		assertEquals(2,empresaTransportista.getConductoresRegistrados().size());
	}
	
	
}
	