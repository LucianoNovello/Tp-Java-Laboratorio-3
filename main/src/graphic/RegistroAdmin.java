package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import resources.manejoDeArchivos;

import app.Administrador;
import obclass.Aeropuerto;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField txtContrasenia;
	Administrador admin = new Administrador();

	public RegistroAdmin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/resources/Avion.png")).getImage());

		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoAdmin = new JLabel("Nuevo Administrador");
		lblNuevoAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNuevoAdmin.setBounds(100, 28, 200, 14);
		contentPane.add(lblNuevoAdmin);
		
		textUsuario = new JTextField();
		textUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textUsuario.getText().equals("Usuario"))
				{
					textUsuario.setText("");
				}
				else
				{
					textUsuario.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textUsuario.getText().equals(""))
					textUsuario.setText("Usuario");
			}
		});
		textUsuario.setBounds(162, 74, 86, 20);
		textUsuario.setText("Usuario");
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(txtContrasenia.getText().equals("Password"))
				{
					((JPasswordField) txtContrasenia).setEchoChar('●');
					txtContrasenia.setText("");
				}
				else
				{
					txtContrasenia.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtContrasenia.getText().equals(""))
				{
					txtContrasenia.setText("Password");
					((JPasswordField) txtContrasenia).setEchoChar((char)0);
				}
			}
		});
		txtContrasenia.setText("Password");
		((JPasswordField) txtContrasenia).setEchoChar((char)0);
		contentPane.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario : ");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(71, 77, 60, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a :");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContraseña.setBounds(71, 118, 105, 14);
		contentPane.add(lblContraseña);


		txtContrasenia.setBounds(163, 117, 85, 20);
		contentPane.add(txtContrasenia);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(textUsuario.getText().equalsIgnoreCase("Usuario") || (txtContrasenia.getText().equalsIgnoreCase("Password")))
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
					admin.setNombre(textUsuario.getText());
					admin.setContrasenia(txtContrasenia.getText());
					manejoDeArchivos.agregarObjectSinRep(Aeropuerto.Admins, admin);
					dispose();
					app.Main.viewSwitcher("login");
				}
			}
		});
		btnAgregar.setBounds(288, 74, 89, 23);
		contentPane.add(btnAgregar);
		
		

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		btnCancelar.setBounds(288, 114, 89, 23);
		contentPane.add(btnCancelar);
		
	}
}
