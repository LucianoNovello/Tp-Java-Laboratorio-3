package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import app.Cliente;
import clases.Aeropuerto;
import recursos.manejoDeArchivos;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class RegistroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNyA;
	private JTextField textDNI;
	private JTextField textUser;
	private JTextField textPass;
	private JTextField textEmail;

	/**
	 * Create the frame.
	 */
	public RegistroUsuario() {
		
		Scanner scan = new Scanner (System.in);
		Cliente cliente= new Cliente ();
		
		String[] Arrobas = {"@hotmail.com", "@gmail.com", "@outlook.com.ar"} ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registrarse");
		lblRegistro.setBounds(5, 5, 424, 20);
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblRegistro);
		
		JLabel lblNewLabel = new JLabel("Nomb y Ape. :");
		lblNewLabel.setBounds(15, 36, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI :");
		lblNewLabel_1.setBounds(30, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(211, 36, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(211, 60, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setBounds(30, 86, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textNyA = new JTextField();
		textNyA.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textNyA.getText().equals("NyA"))
				{
					textNyA.setText("");
				}
				else
				{
					textNyA.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textNyA.getText().equals(""))
					textNyA.setText("NyA");
			}
		});
		textNyA.setBounds(112, 33, 72, 20);
		textNyA.setText("NyA");
		contentPane.add(textNyA);
		textNyA.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textDNI.getText().equals("DNI"))
				{
					textDNI.setText("");
				}
				else
				{
					textDNI.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textDNI.getText().equals(""))
					textDNI.setText("DNI");
			}
		});
		textDNI.setBounds(112, 57, 72, 20);
		textDNI.setText("DNI");
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textUser = new JTextField();
		textUser.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textUser.getText().equals("User"))
				{
					textUser.setText("");
				}
				else
				{
					textUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textUser.getText().equals(""))
					textUser.setText("User");
			}
		});
		textUser.setBounds(280, 33, 72, 20);
		textUser.setText("User");
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setBounds(280, 57, 72, 20);
		textPass.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textPass.getText().equals("Password"))
				{
					((JPasswordField) textPass).setEchoChar('●');
					textPass.setText("");
				}
				else
				{
					textPass.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textPass.getText().equals(""))
				{
					textPass.setText("Password");
					((JPasswordField) textPass).setEchoChar((char)0);
				}
			}
		});
		textPass.setText("Password");
		((JPasswordField) textPass).setEchoChar((char)0);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textEmail.getText().equals("Email"))
				{
					textEmail.setText("");
				}
				else
				{
					textEmail.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textEmail.getText().equals(""))
					textEmail.setText("Email");
			}
		});
		textEmail.setBounds(112, 83, 72, 20);
		textEmail.setText("Email");
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JComboBox comboBox = new JComboBox(Arrobas);

		comboBox.setBounds(185, 83, 93, 20);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				
				if(textNyA.getText().equalsIgnoreCase("Nya") || (textUser.getText().equalsIgnoreCase("User")) || (textPass.getText().equalsIgnoreCase("Pass")) || (textDNI.getText().equalsIgnoreCase("DNI")) || (textEmail.getText().equalsIgnoreCase("Email")))
				{
					EventQueue.invokeLater(new Runnable() 
					{
						public void run()
						{
							try 
							{
								MsgError frame = new MsgError();
								frame.setVisible(true);
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					});
				}
				else
				{
					cliente.setNombreApellido(textNyA.getText());
	
					cliente.setDNI(textDNI.getText());
	
					cliente.setUsuario(textUser.getText());
	
					cliente.setContraseña(textPass.getText());
	
					cliente.setEmail(textEmail.getText()+ comboBox.getSelectedItem());
					manejoDeArchivos.agregarObjectSinRep(Aeropuerto.Clientes , cliente);
					LogginScreen.aeropuerto.importarDesdeArchivoUsuariosCreados(Aeropuerto.Clientes);
					app.Main.viewSwitcher("login");
				}
			}
		});
		btnAceptar.setBounds(112, 127, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				app.Main.viewSwitcher("login");
			}
		});
		btnCancelar.setBounds(213, 127, 89, 23);
		contentPane.add(btnCancelar);
		
	}
}
