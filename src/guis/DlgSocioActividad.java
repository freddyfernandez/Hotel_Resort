package guis;

import clases.Socio;
import libreria.Lib;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
//import javax.swing.ImageIcon;
//import java.awt.Font;

public class DlgSocioActividad extends JDialog implements ActionListener,  KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton btnAceptar;
	private JButton btnVolver;

	// Atributos privados
	private int tipoOperacion;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgSocioActividad dialog = new DlgSocioActividad();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgSocioActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 317, 300);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 13, 57, 20);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(91, 11, 200, 22);
		getContentPane().add(lblCodigo);
		
		lblNombres = new JLabel("NOMBRES");
		lblNombres.setBounds(10, 49, 62, 20);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.addActionListener(this);
		txtNombres.addKeyListener(this);
		txtNombres.setBounds(91, 47, 200, 25);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(10, 84, 71, 20);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.addActionListener(this);
		txtApellidos.addKeyListener(this);
		txtApellidos.setBounds(91, 82, 200, 25);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 120, 46, 20);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.addActionListener(this);
		txtDni.addKeyListener(this);
		txtDni.setBounds(91, 118, 200, 25);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(10, 156, 79, 20);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.addActionListener(this);
		txtTelefono.addKeyListener(this);
		txtTelefono.setBounds(91, 154, 200, 25);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 226, 135, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(156, 226, 135, 25);
		getContentPane().add(btnVolver);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtTelefono) {
			actionPerformedTxtTelefono(arg0);
		}
		if (arg0.getSource() == txtDni) {
			actionPerformedTxtDni(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			actionPerformedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			actionPerformedTxtNombres(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}	
	}
	protected void actionPerformedTxtNombres(ActionEvent arg0) {
		txtApellidos.requestFocus();
	}
	protected void actionPerformedTxtApellidos(ActionEvent arg0) {
		txtDni.requestFocus();
	}
	protected void actionPerformedTxtDni(ActionEvent arg0) {
		txtTelefono.requestFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent arg0) {
		adicionarModificarSocio(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:
				adicionarModificarSocio(true);
				break;
			case 1:
				consultarSocio();
				break;
			case 2:
				adicionarModificarSocio(false);
				break;
			default:
				eliminarSocio();
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtTelefono) {
			keyTypedTxtTelefono(arg0);
		}
		if (arg0.getSource() == txtDni) {
			keyTypedTxtDni(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			keyTypedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			keyTypedTxtNombres(arg0);
		}
	}
	protected void keyTypedTxtNombres(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtNombres, 25);
	}
	protected void keyTypedTxtApellidos(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtApellidos, 25);
	}
	protected void keyTypedTxtDni(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtDni, 8);
	}
	protected void keyTypedTxtTelefono(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtTelefono, 9);
	}
	// Adicionar o modificar un nuevo socio
	void adicionarModificarSocio(boolean adicionar){
		if (leerNombres().length() == 0)
			Lib.mensajeError(this, "Ingrese NOMBRE", txtNombres);
		else
			if (leerApellidos().length() == 0)
				Lib.mensajeError(this, "Ingrese APELLIDOS", txtApellidos);
			else
				if (leerDni().length() == 0)
					Lib.mensajeError(this, "Ingrese DNI", txtDni);
				else
					if (leerTelefono().length() == 0)
						Lib.mensajeError(this, "Ingrese TELEFONO", txtTelefono);
					else {
						if (adicionar){
							Socio nuevo = new Socio(leerCodigo(), leerNombres(), leerApellidos(), leerDni(), leerTelefono());
							Proyecto_AED.as.adicionar(nuevo);
							Lib.mensaje(this,"El Socio ha sido adicionado");
						}
						else {
							Socio x = Proyecto_AED.as.buscar(leerCodigo());
							x.setNombres(leerNombres());
							x.setApellidos(leerApellidos());
							x.setDni(leerDni());
							x.setTelefono(leerTelefono());
							Proyecto_AED.as.actualizar();
							Lib.mensaje(this,"El Socio ha sido modificado");
						}
						dispose();
					}
	}
	// Consultar socio en curso
	void consultarSocio(){
		dispose();
	}
	// Eliminar el socio en curso
	void eliminarSocio(){
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Socio?");
		if (ok == 0){
			Socio x = Proyecto_AED.as.buscar(leerCodigo());
			Proyecto_AED.as.eliminar(x);
			Lib.mensaje(this,"El Socio ha sido eliminado");
			dispose();
		}
	}
	// Establece el tipo de operacion a efectuar
	void setTipoOperacion(int tipoOperacion){
		this.tipoOperacion = tipoOperacion;
	}
	// Cargar los datos de un socio
	void cargarSocio(Socio x){
		lblCodigo.setText(String.valueOf(x.getCodigoSocio()));
		txtNombres.setText(x.getNombres());
		txtApellidos.setText(x.getApellidos());
		txtDni.setText(x.getDni());
		txtTelefono.setText(x.getTelefono());
	}
	// Configura el formulario para la operación a efectuar
	void configurarFormulario(){
		switch (tipoOperacion){
			case 0:
				mostrarCodigoCorrelativo();
				habilitarCajasDeTexto(true);
				break;
			case 1:
				btnVolver.setVisible(false);
				habilitarCajasDeTexto(false);
				break;
			case 2:
				habilitarCajasDeTexto(true);
				break;
			default:
				habilitarCajasDeTexto(false);
		}
	}
	// Muestra el codigo correlativo
	void mostrarCodigoCorrelativo(){
		lblCodigo.setText(String.valueOf(Proyecto_AED.as.codigoCorrelativo()));
	}
	// Habilita o desabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino){
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtDni.setEditable(sino);
		txtTelefono.setEditable(sino);
	}
	// Metodos que retornan valor sin parametros
	int leerCodigo(){
		return Integer.parseInt(lblCodigo.getText().trim());
	}
	String leerNombres(){
		return txtNombres.getText().trim();
	}
	String leerApellidos(){
		return txtApellidos.getText().trim();
	}
	String leerDni(){
		return txtDni.getText().trim();
	}
	String leerTelefono(){
		return txtTelefono.getText().trim();
	}
}