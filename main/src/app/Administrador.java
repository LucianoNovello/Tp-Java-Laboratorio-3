package app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import obclass.Aerolinea;
import obclass.ListadoAerolinea;


public class Administrador implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String contrasenia;
	HashMap<Integer,ListadoAerolinea> HMAdminAerolinea;

	
	//CONSTRUCTOR COMPLETO
	public Administrador(String nombre, String contrasenia) 
	{
		super();
		generarIdAdmin();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		HMAdminAerolinea = new HashMap<Integer, ListadoAerolinea>();
	}

	//CONSTRUCTOR COMPLETO
	public Administrador() 
	{
		super();	
		generarIdAdmin();
		nombre = "";
		contrasenia = "";
		HMAdminAerolinea = new HashMap<Integer, ListadoAerolinea>();
	}
	//CONSTRUCTOR DE COPIA
	public Administrador(Administrador nuevoAdm)
	{
		super();
		this.id = nuevoAdm.id;
		this.nombre = nuevoAdm.nombre;
		this.contrasenia = nuevoAdm.contrasenia;
		this.HMAdminAerolinea = nuevoAdm.HMAdminAerolinea;
		
	}
	
	//GETTERS && SETTERS
	public String getNombre() 
	{
		return nombre;
	}

	public Integer getIdAdmin() 
	{
		return id;
	}
	
	public String getContrasenia() 
	{
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia)
	{
		this.contrasenia = contrasenia;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}

	//METODOS
	
	/*
	 * generaIdRandomAdm
	 */
	public void generarIdAdmin() {
		int nRandom;
		nRandom=((int)(Math.random()*10000+1));
		setId(nRandom);	
		
	}
	
	@Override
	public String toString() {
		return "Administrador [id="+getIdAdmin() + ", nombre=" + getNombre() + ", contrasenia=" + getContrasenia() + ", ListadoAeroXid="
				+ listarAdminYListado() + "]";
	}

	

	
	/*
	 * Agrega aerolinea al Hashmap del admin
	 */

	public void asigarAerolineaAAdmin(Aerolinea aero)
	{
		ListadoAerolinea listaAAsignar;
		int id = getIdAdmin();
		if(HMAdminAerolinea.containsKey(id))
		{
			listaAAsignar = HMAdminAerolinea.get(id);
		}
		else
		{
			listaAAsignar = new ListadoAerolinea();
		}
		
		listaAAsignar.agregarAerolinea(aero);
		HMAdminAerolinea.put(id, listaAAsignar);
	
	}
	
	/*
	 * muestra el hashmap 
	 */
	public String listarAdminYListado()
	{
		StringBuilder buildi = new StringBuilder();
		
		Set<Entry<Integer, ListadoAerolinea>> conjunto = HMAdminAerolinea.entrySet();
		Iterator<Entry<Integer, ListadoAerolinea>> it = conjunto.iterator();
		
		while(it.hasNext()) 
		{
			Entry<Integer, ListadoAerolinea> entrada = it.next();
			buildi.append("Admin id : " +entrada.getKey()+"\n");
			ListadoAerolinea listadoAero = entrada.getValue();
			buildi.append("Listado Aerolineas: " + listadoAero.listarAerolineas());
		}
		
		return buildi.toString();
	}
	/*
	 * obtenemos el nombre de la aerolinea
	 */
	public ArrayList<String> obtenerNombresAerolineas(int idAdmin)
	{
		
		ArrayList<String> aux = new ArrayList<String>();
		
		Set<Entry<Integer, ListadoAerolinea>> conjunto = HMAdminAerolinea.entrySet();
		Iterator<Entry<Integer, ListadoAerolinea>> it = conjunto.iterator();
		
		while(it.hasNext())
		{	
				
				Entry<Integer, ListadoAerolinea> entrada = it.next();

				if(entrada.getKey() == idAdmin)
				{
					ListadoAerolinea auxi = (ListadoAerolinea) entrada.getValue();
					aux = auxi.retornaNombres();
				}
		}

		return aux;
	}

	/*
	 * retornamos una aerolinea buscada por parametro
	 */
	public Aerolinea obtenerAerolinea(int idAdmin, String aero)
	{
		Aerolinea aux = null;
		
		Set<Entry<Integer, ListadoAerolinea>> conjunto = HMAdminAerolinea.entrySet();
		Iterator<Entry<Integer, ListadoAerolinea>> it = conjunto.iterator();
		
		while(it.hasNext())
		{	
				
				Entry<Integer, ListadoAerolinea> entrada = it.next();

				if(entrada.getKey() == idAdmin)
				{
					ArrayList<Aerolinea> aeros =  entrada.getValue().getListadoAerolineas();
			        for(int i = 0; i<aeros.size(); i++)
		            {
			        	if(aeros.get(i).getNombre().equalsIgnoreCase(aero));
			        	{
			        		Aerolinea auxi2 = new Aerolinea(aeros.get(i));
			        		aux = auxi2;
			        	}
		            }
				}
		}

		return aux;
	}
	
	
	/*
	 * agregamos el avion a la aero
	 */
	/*
	public void agregarAvionAAero(int idAdmin, String aero, Avion avi)
	{		
		Set<Entry<Integer, ListadoAerolinea>> conjunto = HMAdminAerolinea.entrySet();
		Iterator<Entry<Integer, ListadoAerolinea>> it = conjunto.iterator();
		
		while(it.hasNext())
		{	
				
				Entry<Integer, ListadoAerolinea> entrada = it.next();

				if(entrada.getKey() == idAdmin)
				{
					ArrayList<Aerolinea> aeros =  entrada.getValue().getListadoAerolineas();
			        for(int i = 0; i<aeros.size(); i++)
		            {
			        	if(aeros.get(i).getNombre().equalsIgnoreCase(aero));
			        	{
			        		Aerolinea auxi2 = new Aerolinea(aeros.get(i));
			        		auxi2.agregarAvionAlListado(avi);
			        	}
		            }
				}
		}
	}
	*/
	/*
	 * verificamos si se encuentra la aerolinea buscada por parametro
	 */
	public boolean existeAero(int idAdmin, String aero)
	{
		boolean aux = false;
		
		Set<Entry<Integer, ListadoAerolinea>> conjunto = HMAdminAerolinea.entrySet();
		Iterator<Entry<Integer, ListadoAerolinea>> it = conjunto.iterator();
		
		while(it.hasNext())
		{	
				
				Entry<Integer, ListadoAerolinea> entrada = it.next();

				if(entrada.getKey() == idAdmin)
				{
					ArrayList<Aerolinea> aeros =  entrada.getValue().getListadoAerolineas();
			        for(int i = 0; i<aeros.size(); i++)
		            {
			        	if(aeros.get(i).getNombre().equalsIgnoreCase(aero));
			        	{
			        		aux = true;
			        	}
		            }
				}
		}

		return aux;
	}
	
	public HashMap<Integer, ListadoAerolinea> getListadoAeroXid() 
	{
		return HMAdminAerolinea;
	}
	
	public void setListadoAeroXid(HashMap<Integer, ListadoAerolinea> HMAdminAerolinea) 
	{
		this.HMAdminAerolinea = HMAdminAerolinea;
	}

}