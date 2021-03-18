package clases;

import java.io.Serializable;

import interfaces.IComercial;

public class VueloInternacional extends Comercial implements IComercial,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	//CONSTRUCTOR COMPLETO
	public VueloInternacional(String marca, String modelo, String origen, String destino, int cantidadAsientosDisponibles,
			double precio, double kilometrosARecorrer, double duracionVuelo) 
	{
		super(marca, modelo, origen, destino, cantidadAsientosDisponibles, precio, kilometrosARecorrer, duracionVuelo);
	}

	
	//CONSTRUCTOR VACIO
	public VueloInternacional() 
	{
		super();
	}

	//METODOS
	@Override
	public void calcularPrecio() 
	{
		double descuento = getPrecio() - calcularDescuento(); 
		setPrecio(descuento);
	}

	@Override
	public double calcularDescuento() 
	{
		double descuento = 0;
		
		if(getKilometrosARecorrer()<= 2000)
		{
			return descuento;
		}
		else if((getKilometrosARecorrer() >= 2000) && (getKilometrosARecorrer() <= 5000))
		{
			descuento = (getPrecio() * 5)/100;
		}
		else if((getKilometrosARecorrer() >= 5000) && (getKilometrosARecorrer() <= 10000))
		{
			descuento = (getPrecio() * 10)/100;
		}
		else
		{
			descuento = (getPrecio() * 15)/100;
		}
		return descuento;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
}
