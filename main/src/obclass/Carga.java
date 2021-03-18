package obclass;

import java.io.Serializable;

public class Carga extends Avion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private double pesoMinimo;
	private double pesoMaximo;
	
	//CONSTRUCTOR COMPLETO
	public Carga(String marca, String modelo, String origen, String destino, double pesoMinimo, double pesoMaximo) 
	{
		super(marca, modelo, origen, destino);
		this.pesoMinimo = pesoMinimo;
		this.pesoMaximo = pesoMaximo;
	}
	
	//CONSTRUCTOR VACIO
	public Carga()
	{
		super();
		this.pesoMinimo = 0;
		this.pesoMaximo = 0;
	}
	
	//GETTERS && SETTERS
	public double getPesoMinimo()
	{
		return pesoMinimo;
	}
	
	public double getPesoMaximo()
	{
		return pesoMaximo;
	}
	
	public void setPesoMinimo(double pesoMinimo)
	{
		this.pesoMinimo = pesoMinimo;
	}
	
	public void setPesoMaximo(double pesoMaximo)
	{
		this.pesoMaximo = pesoMaximo;
	}
	

	//METODOS
	@Override
	public String toString() 
	{
		return super.toString()+"Carga [pesoMinimo=" + getPesoMinimo() + ", pesoMaximo=" + getPesoMaximo() + "]";
	}
}
	