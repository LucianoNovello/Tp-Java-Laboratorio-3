package obclass;

import java.io.Serializable;
import java.util.ArrayList;

public class listadoAviones<A extends Avion> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<A> listadoAviones;
	
	//CONSTRUCTOR COMPLETO
	public listadoAviones()
	{
		listadoAviones = new ArrayList<A>();
	}
	
	/*
	 * agregaUnElem(si es mayor a 4500km, no acepta vuelos de cabotaje)
	 */
	public boolean agregarAvion(A elem)
	{
		boolean agregado = false;
		if(elem instanceof VueloDeCabotaje)
		{
			VueloDeCabotaje aux = (VueloDeCabotaje) elem;
			if(aux.getKilometrosARecorrer() >= 4500)
			{
				return agregado;
			}
			else
			{

				((VueloDeCabotaje) elem).calcularPrecio();
				listadoAviones.add(elem);
				agregado = true;
			}
		}
		else if(elem instanceof VueloInternacional)
		{
			((VueloInternacional) elem).calcularPrecio();
			listadoAviones.add(elem);
			agregado = true;
		}
		else
		{
			listadoAviones.add(elem);
			agregado = true;
		}
		return agregado;
	}


	/*
	 * retornaElListado
	 */
	public ArrayList<A> getListadoAviones()
	{
		return listadoAviones;
	}
	
	/*
	 * retornaElTama�oDelListado
	 */
	public int getTama�oLista()
	{
		return listadoAviones.size();
	}
	
	/*
	 * retornaSiEstaVacia
	 */
	
	public boolean estaVacia()
	{
		if (getTama�oLista() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * eliminarDelListadoDeAviones
	 */
	
	public boolean eliminarAvion(A elem)
	{
		if(!estaVacia())
		{
			return listadoAviones.remove(elem);
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * mostrarListado
	 */
	
	public String listarAviones()
	{
		StringBuilder buildi = new StringBuilder();
		
		for (A elem : listadoAviones) 
		{
			buildi.append(elem.toString()+"\n");
		}
	
		return buildi.toString();
	}	
}
