package guis;

import clases.Producto;
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

public class DlgProductoActividad extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblCodigo;
	private JLabel lblDetalle;
	private JTextField txtDetalle;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
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
					DlgProductoActividad dialog = new DlgProductoActividad();
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
	public DlgProductoActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 309, 256);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 13, 57, 20);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(91, 11, 200, 22);
		getContentPane().add(lblCodigo);
		
		lblDetalle = new JLabel("DETALLE");
		lblDetalle.setBounds(10, 49, 62, 20);
		getContentPane().add(lblDetalle);
		
		txtDetalle = new JTextField();
		txtDetalle.addActionListener(this);
		txtDetalle.addKeyListener(this);
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(91, 47, 200, 25);
		getContentPane().add(txtDetalle);
		
		lblStock = new JLabel("STOCK");
		lblStock.setBounds(10, 84, 71, 20);
		getContentPane().add(lblStock);
		
		txtStock = new JTextField();
		txtStock.addActionListener(this);
		txtStock.addKeyListener(this);
		txtStock.setColumns(10);
		txtStock.setBounds(91, 82, 200, 25);
		getContentPane().add(txtStock);
		
		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(10, 120, 46, 20);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.addActionListener(this);
		txtPrecio.addKeyListener(this);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(91, 118, 200, 25);
		getContentPane().add(txtPrecio);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 190, 135, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(155, 190, 135, 25);
		getContentPane().add(btnVolver);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtPrecio) {
			actionPerformedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtStock) {
			actionPerformedTxtStock(arg0);
		}
		if (arg0.getSource() == txtDetalle) {
			actionPerformedTxtDetalle(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedTxtDetalle(ActionEvent arg0) {
		txtStock.requestFocus();
	}
	protected void actionPerformedTxtStock(ActionEvent arg0) {
		txtPrecio.requestFocus();
	}
	protected void actionPerformedTxtPrecio(ActionEvent arg0) {
		adicionarModificarProducto(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:
				adicionarModificarProducto(true);
				break;
			case 1:
				consultarProducto();
				break;
			case 2:
				adicionarModificarProducto(false);
				break;
			default:
				eliminarProducto();
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
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtStock) {
			keyTypedTxtStock(arg0);
		}
		if (arg0.getSource() == txtDetalle) {
			keyTypedTxtDetalle(arg0);
		}
	}
	protected void keyTypedTxtDetalle(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtDetalle, 25);
	}
	protected void keyTypedTxtStock(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtStock, 4);
	}
	protected void keyTypedTxtPrecio(KeyEvent arg0) {
		Lib.soloDecimales(arg0, txtPrecio, 8);
	}
	// Adicionar o modificar un nuevo producto
	void adicionarModificarProducto(boolean adicionar){
		if (leerDetalle().length() == 0)
			Lib.mensajeError(this, "Ingrese DETALLE", txtDetalle);
		else
			try{
				leerStock();
				try {
					leerPrecio();
					if (adicionar){
						Producto nuevo = new Producto(leerCodigo(), leerDetalle(), leerStock(), leerPrecio());
						Proyecto_AED.ap.adicionar(nuevo);
						Lib.mensaje(this,"El Producto ha sido adicionado");
					}
					else {
						Producto x = Proyecto_AED.ap.buscar(leerCodigo());
						x.setDetalle(leerDetalle());
						x.setStock(leerStock());
						x.setPrecioUnitario(leerPrecio());
						Proyecto_AED.ap.actualizar();
						Lib.mensaje(this,"El Producto ha sido modificado");
					}
					dispose();
				}
				catch(Exception e){
					Lib.mensajeError(this, "Ingrese PRECIO", txtPrecio);
				}
			}
			catch(Exception e){
				Lib.mensajeError(this, "Ingrese STOCK", txtStock);
			}
	}
	// Consultar producto en curso
	void consultarProducto(){
		dispose();
	}
	// Eliminar el producto en curso
	void eliminarProducto(){
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Producto?");
		if (ok == 0){
			Producto x = Proyecto_AED.ap.buscar(leerCodigo());
			Proyecto_AED.ap.eliminar(x);
			Lib.mensaje(this,"El Producto ha sido eliminado");
			dispose();
		}
	}
	// Establece el tipo de operacion a efectuar
	void setTipoOperacion(int tipoOperacion){
		this.tipoOperacion = tipoOperacion;
	}
	// Cargar los datos de un Producto
	void cargarProducto(Producto x){
		lblCodigo.setText(String.valueOf(x.getCodigoProducto()));
		txtDetalle.setText(x.getDetalle());
		txtStock.setText(String.valueOf(x.getStock()));
		txtPrecio.setText(String.valueOf(x.getPrecioUnitario()));
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
		lblCodigo.setText(String.valueOf(Proyecto_AED.ap.codigoCorrelativo()));
	}
	// Habilita o desabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino){
		txtDetalle.setEditable(sino);
		txtStock.setEditable(sino);
		txtPrecio.setEditable(sino);
	}
	// Metodos que retornan valor sin parametros
	int leerCodigo(){
		return Integer.parseInt(lblCodigo.getText().trim());
	}
	String leerDetalle(){
		return txtDetalle.getText().trim();
	}
	int leerStock(){
		return Integer.parseInt(txtStock.getText().trim());
	}
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText().trim());
	}
}
