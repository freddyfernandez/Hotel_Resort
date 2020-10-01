package guis;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Bungalow;
import clases.Hospedaje;
import clases.Ingreso;
import clases.Socio;
import libreria.Lib;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
//import javax.swing.ImageIcon;

public class DlgHospedajeActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCodigo;
	private JLabel lblCodigoIngreso;
	private JLabel lblNumeroBungalow;
	private JLabel lblFechaSalida;
	private JLabel lblHoraSalida;
	private JLabel lblCostoHospedaje;
	private JLabel lblEstado;
	private JComboBox<String> cboEstado;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JComboBox<String> cboCodigoIngreso;
	private JComboBox<String> cboNumeroBungalow;
	private JTextField txtCostoHospedaje;
	
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
					DlgHospedajeActividad dialog = new DlgHospedajeActividad();
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
	public DlgHospedajeActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 311, 368);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 11, 57, 20);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(160, 11, 135, 22);
		getContentPane().add(lblCodigo);
		
		lblCodigoIngreso = new JLabel("CODIGO INGRESO");
		lblCodigoIngreso.setBounds(10, 44, 114, 20);
		getContentPane().add(lblCodigoIngreso);
		
		lblNumeroBungalow = new JLabel();
		lblNumeroBungalow.setText("NUMERO BUNGALOW");
		lblNumeroBungalow.setBounds(10, 82, 135, 22);
		getContentPane().add(lblNumeroBungalow);
		
		lblFechaSalida = new JLabel("FECHA SALIDA");
		lblFechaSalida.setBounds(10, 118, 114, 20);
		getContentPane().add(lblFechaSalida);
		
		lblFechaSalida = new JLabel();
		lblFechaSalida.setBounds(160, 116, 135, 22);
		getContentPane().add(lblFechaSalida);
		
		lblHoraSalida = new JLabel("HORA SALIDA");
		lblHoraSalida.setBounds(10, 151, 114, 20);
		getContentPane().add(lblHoraSalida);
		
		lblHoraSalida = new JLabel();
		lblHoraSalida.setBounds(160, 149, 135, 22);
		getContentPane().add(lblHoraSalida);
		
		lblCostoHospedaje = new JLabel("COSTO HOSPEDAJE");
		lblCostoHospedaje.setBounds(10, 184, 135, 20);
		getContentPane().add(lblCostoHospedaje);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 219, 114, 20);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(160, 217, 135, 25);
		getContentPane().add(cboEstado);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 299, 135, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(160, 299, 135, 25);
		getContentPane().add(btnVolver);
		
		cboCodigoIngreso = new JComboBox<String>();
		cboCodigoIngreso.addActionListener(this);
		colocarIngresos();
		cboCodigoIngreso.setBounds(160, 44, 135, 25);
		getContentPane().add(cboCodigoIngreso);
		
		cboNumeroBungalow = new JComboBox<String>();
		cboNumeroBungalow.addActionListener(this);
		colocarBungalow();
		cboNumeroBungalow.setBounds(160, 81, 135, 25);
		getContentPane().add(cboNumeroBungalow);
		
		txtCostoHospedaje = new JTextField();
		txtCostoHospedaje.addActionListener(this);
		txtCostoHospedaje.addKeyListener(this);
		txtCostoHospedaje.setColumns(10);
		txtCostoHospedaje.setBounds(160, 182, 135, 25);
		getContentPane().add(txtCostoHospedaje);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtCostoHospedaje) {
			actionPerformedTxtCostoHospedaje(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedTxtCostoHospedaje(ActionEvent arg0) {
		adicionarModificarHospedaje(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:
				adicionarModificarHospedaje(true);
				break;
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
		if (arg0.getSource() == txtCostoHospedaje) {
			keyTypedTxtNumerosInvitados(arg0);
		}
	}
	protected void keyTypedTxtNumerosInvitados(KeyEvent arg0) {
		Lib.soloDecimales(arg0, txtCostoHospedaje, 8);
	}
	//  Adiciona o Modifica un nuevo hospedaje
	void adicionarModificarHospedaje(boolean adicionar) {
		try{
			try{
				double costoHospedaje = leerCostoHospedaje();
				if (adicionar){
					int ok = Lib.mensajeConfirmacion(this,obtenerDatosSocio()+"\n\n"+obtenerDatosBungalow(),"¿Desea Hospedarse?");
					if (ok == 0){
						Hospedaje nuevo = new Hospedaje(leerCodigo(), leerCodigoIngreso(), leerNumeroBungalow(), "",
														"", costoHospedaje, leerEstado());
						Proyecto_AED.ah.adicionar(nuevo);
						Proyecto_AED.ah.grabarHospedaje();
						Bungalow b = Proyecto_AED.ab.buscar(leerNumeroBungalow());
						b.setEstado(1);
						Proyecto_AED.ab.grabarBungalow();
						cboCodigoIngreso.removeItem(cboCodigoIngreso.getSelectedItem());
						cboNumeroBungalow.removeItem(cboNumeroBungalow.getSelectedItem());
						lblNumeroBungalow.setText("");
						Lib.mensaje(this,"Su Hospedaje ha sido adicionado");
					}
				}
				dispose();
			}
			catch(Exception e){
				Lib.mensajeError(this, "Ingrese COSTO de HOSPEDAJE", txtCostoHospedaje);
			}
		}
		catch(Exception e){
			Lib.mensaje(this,"Su Hospedaje ha sido adicionado");
			dispose();
		}
	}
	//  Métodos tipo void (sin parámetros)	
	void colocarIngresos() {
		Ingreso x;
		for (int i=0; i<Proyecto_AED.ai.tamaño(); i++) {
			x = Proyecto_AED.ai.obtener(i);
				if (Proyecto_AED.ah.procedeCodigoIngreso(x.getCodigoIngreso()))
					cboCodigoIngreso.addItem(String.valueOf(x.getCodigoIngreso()));
		}
	}
	void colocarBungalow() {
		Bungalow x;
		for (int i=0; i<Proyecto_AED.ab.tamaño(); i++) {
			x = Proyecto_AED.ab.obtener(i);
			if (x.getEstado() == 0)
				cboNumeroBungalow.addItem(String.valueOf(x.getNumeroBungalow()));
		}	
	}
	// Establece el tipo de operacion a efectuar
	void setTipoOperacion(int tipoOperacion){
		this.tipoOperacion = tipoOperacion;
	}
	// Configura el formulario para la operación a efectuar
	void configurarFormulario(){
		switch (tipoOperacion){
			case 0:
				mostrarCodigoCorrelativo();
				habilitarCajasDeTexto(true);
				break;
		}
	}
	// Muestra el codigo correlativo
	void mostrarCodigoCorrelativo(){
		lblCodigo.setText(String.valueOf(Proyecto_AED.ah.codigoCorrelativo()));
	}
	// Habilita o desabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino){
		cboCodigoIngreso.setEnabled(sino);
		cboNumeroBungalow.setEnabled(sino);
		txtCostoHospedaje.setEditable(sino);
	}
	// Metodos que retornan valor sin parametros
	String obtenerDatosSocio() {
	    Ingreso i = Proyecto_AED.ai.buscar(leerCodigoIngreso());
	    Socio s = Proyecto_AED.as.buscar(i.getCodigoSocio());
	    return "Nombres :  " + s.getNombres() + "\n" +
		       "Apellidos :  " + s.getApellidos();
	}
	String obtenerDatosBungalow() {
	    Bungalow b = Proyecto_AED.ab.buscar(leerNumeroBungalow());
	    return "Categoría :  " + Lib.tiposDeCategoria[b.getCategoria()] + "\n" +
		       "Precio por día :  " + b.getPrecioDia();
	}
	int leerCodigo(){
		return Integer.parseInt(lblCodigo.getText().trim());
	}
	int leerCodigoIngreso(){
		return Integer.parseInt(cboCodigoIngreso.getSelectedItem().toString());
	}
	int leerNumeroBungalow(){
		return Integer.parseInt(cboNumeroBungalow.getSelectedItem().toString());
	}
	String leerFechaSalida(){
		return lblFechaSalida.getText().trim();
	}
	String leerHoraSalida(){
		return lblHoraSalida.getText().trim();
	}
	Double leerCostoHospedaje(){
		return Double.parseDouble(txtCostoHospedaje.getText().trim());
	}
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
	// Metodos publicos que retornan valor
	int leerCantidadIngreso(){
		return cboCodigoIngreso.getSelectedIndex();
	}
	int leerCantidadBungalow(){
		return cboNumeroBungalow.getSelectedIndex();
	}
}