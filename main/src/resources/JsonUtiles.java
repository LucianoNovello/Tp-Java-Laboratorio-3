package resources;

import java.nio.file.Files;
import org.json.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
	


	public class JsonUtiles //TODO
	{

		
		public static void grabar(JSONArray array) 
		{
			try {
				FileWriter file = new FileWriter("test1.json");
				file.write(array.toString());
				file.flush();
				file.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				
			}
		}
	
		public static String leer() 
		{
			String contenido = "";
			try 
			{
				contenido = new String(Files.readAllBytes(Paths.get("test.json")));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return contenido;
		}
	}
	
	
	
