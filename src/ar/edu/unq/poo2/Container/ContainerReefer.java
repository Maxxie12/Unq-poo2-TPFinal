package ar.edu.unq.poo2.Container;

public class ContainerReefer extends Container{
	
	private double consumo;

	public ContainerReefer(double ancho, double largo, double altura, String tipoContainer, int id, double consumo) {
		super(ancho, largo, altura, tipoContainer, id);
		this.consumo = consumo;
	}
	
	

}
