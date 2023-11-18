package ar.edu.unq.poo2.BuscadorDeViajes;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorCompuesto implements IBuscadorViajes {
	
	private List<IBuscadorViajes> buscadoresDeViajes = new ArrayList<>();

	@Override
	public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {
		// TODO Auto-generated method stub
		return null;
	}

}
