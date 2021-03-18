package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Administrador;
import clases.Aerolinea;
import clases.Aeropuerto;
import clases.Carga;
import clases.Comercial;
import clases.Militar;
import clases.VueloInternacional;
import recursos.manejoDeArchivos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarAviCarga extends JFrame {

	private JPanel contentPane;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textOrigen;
	private JTextField textDestino;
	private JTextField textPesoMinimo;
	private JTextField textPesoMaximo;
	private JButton btnAgregar;

	public AgregarAviCarga(int idAdmin, Aerolinea aero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(30, 22, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(30, 65, 55, 14);
		contentPane.add(lblModelo);
		
		JLabel lblOrigen = new JLabel("Origen :");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrigen.setBounds(215, 22, 55, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDestino.setBounds(215, 65, 55, 14);
		contentPane.add(lblDestino);

	
		textMarca = new JTextField();
		textMarca.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textMarca.getText().equals("Marca"))
				{
					textMarca.setText("");
				}
				else
				{
					textMarca.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textMarca.getText().equals(""))
					textMarca.setText("Marca");
			}
		});
		textMarca.setText("Marca");
		textMarca.setBounds(102, 21, 86, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textModelo.getText().equals("Modelo"))
				{
					textModelo.setText("");
				}
				else
				{
					textModelo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textModelo.getText().equals(""))
					textModelo.setText("Modelo");
			}
		});
		textModelo.setText("Modelo");
		textModelo.setBounds(102, 64, 86, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
		textOrigen = new JTextField();
		textOrigen.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textOrigen.getText().equals("Origen"))
				{
					textOrigen.setText("");
				}
				else
				{
					textOrigen.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textOrigen.getText().equals(""))
					textOrigen.setText("Origen");
			}
		});
		textOrigen.setText("Origen");
		textOrigen.setBounds(285, 21, 86, 20);
		contentPane.add(textOrigen);
		textOrigen.setColumns(10);
		
		textDestino = new JTextField();
		textDestino.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textDestino.getText().equals("Destino"))
				{
					textDestino.setText("");
				}
				else
				{
					textDestino.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textDestino.getText().equals(""))
					textDestino.setText("Destino");
			}
		});
		textDestino.setText("Destino");
		textDestino.setBounds(285, 64, 86, 20);
		contentPane.add(textDestino);
		textDestino.setColumns(10);

		
		JLabel lblPesoMinimo = new JLabel("Peso Minimo :");
		lblPesoMinimo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPesoMinimo.setBounds(30, 103, 90, 14);
		contentPane.add(lblPesoMinimo);
		
		JLabel lblPesoMaximo = new JLabel("Peso Maximo :");
		lblPesoMaximo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPesoMaximo.setBounds(30, 136, 90, 14);
		contentPane.add(lblPesoMaximo);
		
		textPesoMinimo = new JTextField();
		textPesoMinimo.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textPesoMinimo.getText().equals("Minimo"))
				{
					textPesoMinimo.setText("");
				}
				else
				{
					textPesoMinimo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textPesoMinimo.getText().equals(""))
					textPesoMinimo.setText("Minimo");
			}
		});
		textPesoMinimo.setText("Minimo");	
		textPesoMinimo.setColumns(10);
		textPesoMinimo.setBounds(135, 102, 86, 20);
		contentPane.add(textPesoMinimo);
		
		textPesoMaximo = new JTextField();
		textPesoMaximo.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textPesoMaximo.getText().equals("Maximo"))
				{
					textPesoMaximo.setText("");
				}
				else
				{
					textPesoMaximo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textPesoMaximo.getText().equals(""))
					textPesoMaximo.setText("Maximo");
			}
		});
		textPesoMaximo.setText("Maximo");		
		textPesoMaximo.setColumns(10);
		textPesoMaximo.setBounds(135, 134, 86, 20);
		contentPane.add(textPesoMaximo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(335, 115, 89, 23);
		contentPane.add(btnCancelar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textMarca.getText().equalsIgnoreCase("Marca") || (textModelo.getText().equalsIgnoreCase("Modelo")) || (textOrigen.getText().equalsIgnoreCase("Origen")) || (textDestino.getText().equalsIgnoreCase("Destino"))|| (textPesoMaximo.getText().equalsIgnoreCase("Maximo")) || (textPesoMinimo.getText().equalsIgnoreCase("Minimo")))
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
					Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
					
					double pesoMaximo = Double.parseDouble(textPesoMaximo.getText().toString());
					double pesoMinimo = Double.parseDouble(textPesoMinimo.getText().toString());
					Carga nuevoAvion = new Carga(textMarca.getText(), textModelo.getText(), textOrigen.getText(), textDestino.getText(), pesoMinimo, pesoMaximo);

					Aerolinea aAgregar = new Aerolinea(aero, nuevoAvion);
					
					manejoDeArchivos.agregarObjectRep(Aeropuerto.CARGA,nuevoAvion);
					manejoDeArchivos.agregarObjectRep(Aeropuerto.Aerolineas, aAgregar);

					manejoDeArchivos.agregarObjectRep(Aeropuerto.Admins, aux);
					app.Main.viewSwitcher("login");
					dispose();
				}
			}
		});

		btnAgregar.setBounds(236, 115, 89, 23);
		contentPane.add(btnAgregar);
		

	}
}
