package clases;

import java.io.Serializable;

public class Militar extends Avion implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	//CONSTRUCTOR COMPLETO
	public Militar(String marca, String modelo, String origen, String destino)
	{
		super(marca, modelo, origen, destino);
	}
	
	//CONSTRUCTOR VACIO
	public Militar() 
	{
		super();
	}
	
	//METODOS
	@Override
	public String toString() 
	{
		return super.toString();
	}
	
}
