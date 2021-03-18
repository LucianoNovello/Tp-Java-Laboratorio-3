package obclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import app.Administrador;
import resources.manejoDeArchivos;

public class Aerolinea implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String cuit;
	listadoAviones<Avion> listadoAviones;
	ListadoBoletosDeAvion boletosDisponibles;
	
	//CONSTRUCTOR COMPLETO
	public Aerolinea(String nombre, String cuit)
	{
		this.nombre = nombre;
		this.cuit = cuit;
		listadoAviones = new listadoAviones<Avion>();
		boletosDisponibles = new ListadoBoletosDeAvion();
	}
	
	
	//CONSTRUCTOR VACIO
	public Aerolinea()
	{
		nombre = "";
		cuit = "";
		listadoAviones = new listadoAviones<Avion>();
		boletosDisponibles = new ListadoBoletosDeAvion();
	}


	//CONSTRUCTOR DE COPIA
	public Aerolinea(Aerolinea nuevaAerolinea)
	{
		this.nombre = nuevaAerolinea.nombre;
		this.cuit = nuevaAerolinea.cuit;
		this.listadoAviones = nuevaAerolinea.listadoAviones;
		this.boletosDisponibles = nuevaAerolinea.boletosDisponibles;
	}
	
	//CONSTRUCTOR QUE A SU VEZ SETEA AVIONES
	/*
	 * la utilizariamos en el caso de setear  un avion Comercial
	 */
	public Aerolinea(Aerolinea nuevaAerolinea, Avion avi)
	{
		this.nombre = nuevaAerolinea.nombre;
		this.cuit = nuevaAerolinea.cuit;
		this.listadoAviones = nuevaAerolinea.listadoAviones;
		this.boletosDisponibles = nuevaAerolinea.boletosDisponibles;
		agregarAvionAlListado(avi);
		datosABoletoDeAvion(avi);
	}
	
	//GETTERS && SETTERS
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getCuit() 
	{
		return cuit;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setCuit(String cuit)
	{
		this.cuit = cuit;
	}
	
	public listadoAviones<Avion> getListadoAviones() 
	{
		return listadoAviones;
	}


	public void setListadoAviones(listadoAviones<Avion> listadoAviones)
	{
		this.listadoAviones = listadoAviones;
	}


	public ListadoBoletosDeAvion getBoletosDisponibles() 
	{
		return boletosDisponibles;
	}


	public void setBoletosDisponibles(ListadoBoletosDeAvion boletosDisponibles) 
	{
		this.boletosDisponibles = boletosDisponibles;
	}

	//METODOS

	/*
	 * agrega aviones al Listado Generico
	 * 
	 */
	public void agregarAvionAlListado(Avion avi)
	{
		listadoAviones.agregarAvion(avi);
	}
	
	/*
	 * adquirimos de los aviones instanciados, los datos que nos permiten crear nuestro boleto de avion
	 */
	public void datosABoletoDeAvion(Avion avi)
    {
 
        if(avi instanceof Comercial)
        {
            Comercial elem = (Comercial) avi;
            int i =0;
            while (i< elem.getCantidadAsientosDisponibles()) 
            {
	            BoletoDeAvion nuevoBoleto = new BoletoDeAvion( elem.getOrigen(), elem.getDestino(), elem.getPrecio(), elem.getDuracionVuelo(),true);
	            boletosDisponibles.agregarBoletoAvion(nuevoBoleto);
	            manejoDeArchivos.agregarObjectSinRep(Aeropuerto.Boleto, nuevoBoleto);
	            i++;
            }
          }
    }
	/*
	 * recorre y muestra Aviones Comerciales
	 */
	public String recorrerYMostrarAvionesComerciales()
	{
		return listadoAviones.listarAviones();
	}
	
	/*
	 * recorre y muestra nuestro Listado de boletos
	 * 
	 */
	
	public String recorrerYMostrarBoletosDeAvion()
	{
		return boletosDisponibles.listarBoletosDeAvion();
	}




	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", cuit=" + cuit + ", listadoAviones=" + recorrerYMostrarAvionesComerciales()
				+ ", boletosDisponibles=" + recorrerYMostrarBoletosDeAvion() + "]";
	}


	/*
	 * a utilizar para no guardar dos Aerolineas del mismo nombre en su respectivo listado
	 */
	@Override
	public boolean equals(Object obj) 
	{
		boolean rta = false;
		
		if(obj!= null)
		{
			if(obj instanceof Aerolinea)
			{
				Aerolinea aux = (Aerolinea) obj;
				if(getNombre().equals(aux.getNombre()))
				{
					rta = true;
				}
			}
		}
		return rta;
	}
	
	@Override
	public int hashCode() 
	{
		return 1;
	}

}

