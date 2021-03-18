package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Aeropuerto;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.TextField;

public class Consulta extends JFrame 
{

	private JPanel contentPane;

	public Consulta() 
	{
		
		Aeropuerto aeropuerto = new Aeropuerto("Ezeiza", "Argentina", "Buenos Aires");
		
		aeropuerto.importarDesdeArchivoUsuariosCreados(Aeropuerto.Clientes);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textField = new TextField();
		textField.setText(aeropuerto.recorrerYMostrarClientes());
		textField.setBounds(10, 10, 399, 141);
		contentPane.add(textField);
		
				

	}
}
