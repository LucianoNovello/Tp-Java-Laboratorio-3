package app;

import java.awt.EventQueue;

import graphic.LogginScreen;
import graphic.MsgError;
import graphic.RegistroAdmin;
import graphic.RegistroUsuario;
import java.io.*;
public class Main 
{
	
	static String activeView = "login";
    static final LogginScreen frame1 = new LogginScreen();
	static final RegistroUsuario frame2 = new RegistroUsuario();
	static final RegistroAdmin frame3 = new RegistroAdmin();
	static final MsgError frame4 = new MsgError();

	public static void main(String[] args) 
	{
		 launchApp();
		
		
	}
	
	public static void viewsCleanup()
	{
//		frame1.setVisible(false);
//		frame2.setVisible(false);
		frame1.dispose();
		frame2.dispose();
		frame3.setVisible(false);
		frame4.dispose();

	}
	
	public static void viewSwitcher(String viewName)
	{
		
		viewsCleanup();
		activeView = viewName;
		
		try {
			Thread.sleep(200);
			launchApp();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp()
	{
		/*
		/**
		 * Launch the application.
		 */	
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					switch(activeView)
					{
						case "registroCliente":
							frame2.setVisible(true);
							break;
						case "registroAdmin":
							frame3.setVisible(true);
						break;
						case "error":
							frame4.setVisible(true);
						break;
						default:
							frame1.setVisible(true);
							break;
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}

