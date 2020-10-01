package guis;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import clases.Ingreso;
import clases.Socio;
import clases.Boleta;
import libreria.Fecha;
import libreria.Lib;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import javax.swing.ImageIcon;
//import java.awt.Font;

public class DlgIngresoActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnVolver;
	private JButton btnAceptar;
	private JLabel lblEstado;
	private JComboBox<String> cboEstado;
	private JLabel lblCostoIngreso;
	private JLabel lblNumeroInvitados;
	private JTextField txtNumerosInvitados;
	private JLabel lblHoraIngreso;
	private JLabel lblFechaIngreso;
	private JLabel lblNombreSocio;
	private JLabel lblCodigoSocio;
	private JComboBox<String> cboCodigoSocio;
	private JLabel lblCodigo;
	private JLabel lblCodigoBoleta;
	
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
					DlgIngresoActividad dialog = new DlgIngresoActividad();
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
	public DlgIngresoActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 311, 396);
		getContentPane().setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(160, 328, 135, 25);
		getContentPane().add(btnVolver);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 328, 135, 25);
		getContentPane().add(btnAceptar);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 251, 114, 20);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(160, 249, 135, 25);
		getContentPane().add(cboEstado);
		
		lblCostoIngreso = new JLabel("COSTO INGRESO");
		lblCostoIngreso.setBounds(10, 217, 114, 20);
		getContentPane().add(lblCostoIngreso);
		
		lblCostoIngreso = new JLabel();
		lblCostoIngreso.setText("0");
		lblCostoIngreso.setBounds(160, 216, 135, 22);
		getContentPane().add(lblCostoIngreso);
		
		lblNumeroInvitados = new JLabel("NUMERO INVITADOS");
		lblNumeroInvitados.setBounds(10, 182, 135, 20);
		getContentPane().add(lblNumeroInvitados);
		
		txtNumerosInvitados = new JTextField();
		txtNumerosInvitados.addActionListener(this);
		txtNumerosInvitados.addKeyListener(this);
		txtNumerosInvitados.setColumns(10);
		txtNumerosInvitados.setBounds(160, 180, 135, 25);
		getContentPane().add(txtNumerosInvitados);
		
		lblHoraIngreso = new JLabel("HORA INGRESO");
		lblHoraIngreso.setBounds(10, 149, 114, 20);
		getContentPane().add(lblHoraIngreso);
		
		lblHoraIngreso = new JLabel();
		lblHoraIngreso.setBounds(160, 147, 135, 22);
		getContentPane().add(lblHoraIngreso);
		
		lblFechaIngreso = new JLabel("FECHA INGRESO");
		lblFechaIngreso.setBounds(10, 114, 114, 20);
		getContentPane().add(lblFechaIngreso);
		
		lblFechaIngreso = new JLabel();
		lblFechaIngreso.setBounds(160, 114, 135, 22);
		getContentPane().add(lblFechaIngreso);
		
		lblNombreSocio = new JLabel("NOMBRE SOCIO");
		lblNombreSocio.setBounds(10, 83, 114, 20);
		getContentPane().add(lblNombreSocio);
		
		lblNombreSocio = new JLabel();
		lblNombreSocio.setBounds(160, 81, 135, 22);
		getContentPane().add(lblNombreSocio);
		
		lblCodigoSocio = new JLabel("CODIGO SOCIO");
		lblCodigoSocio.setBounds(10, 47, 114, 20);
		getContentPane().add(lblCodigoSocio);
		
		cboCodigoSocio = new JComboBox<String>();
		cboCodigoSocio.addActionListener(this);
		colocarSocios();
		cboCodigoSocio.setBounds(160, 45, 135, 25);
		getContentPane().add(cboCodigoSocio);
		
		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 11, 57, 20);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(160, 11, 135, 22);
		getContentPane().add(lblCodigo);
		
		lblCodigoSocio = new JLabel();
		lblCodigoSocio.setBounds(160, 47, 135, 22);
		getContentPane().add(lblCodigoSocio);
		
		lblCodigoBoleta = new JLabel();
		lblCodigoBoleta.setBounds(160, 249, 135, 22);
		getContentPane().add(lblCodigoBoleta);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtNumerosInvitados) {
			actionPerformedTextField(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == cboCodigoSocio) {
			actionPerformedComboBox_1(arg0);
		}
	}
	protected void actionPerformedComboBox_1(ActionEvent arg0) {
		if (cboCodigoSocio.getSelectedIndex() >=0)
			mostrarNombreSocio();
	}
	protected void actionPerformedTextField(ActionEvent arg0) {
		mostrarPrecio();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:
				adicionarModificarIngreso(true);
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
		if (arg0.getSource() == txtNumerosInvitados) {
			keyTypedTxtNumerosInvitados(arg0);
		}
	}
	protected void keyTypedTxtNumerosInvitados(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtNumerosInvitados, 3);
	}
	//  Adiciona o Modifica un nuevo ingreso
	void adicionarModificarIngreso(boolean adicionar) {
		try{
			int numeroInvitados =  leerNumeroInvitados();
			if (adicionar){
				mostrarPrecio();
				Ingreso nuevo = new Ingreso(leerCodigo(), leerCodigoSocio(), leerFechaIngreso(), leerHoraIngreso(),
											numeroInvitados, leerCostoIngreso(), leerEstado(), leerCodigoBoleta());
				Proyecto_AED.ai.adicionar(nuevo);
				cboCodigoSocio.removeItem(cboCodigoSocio.getSelectedItem());
				Boleta nueva = new Boleta(leerCodigoBoleta(), leerCodigo(), 0, leerCostoIngreso(), 0);
				Proyecto_AED.bo.adicionar(nueva);
				Lib.mensaje(this,"Su Ingreso ha sido adicionado");
			}
			dispose();
		}
		catch(Exception e){
			Lib.mensajeError(this, "Ingrese NUMERO de INVITADOS", txtNumerosInvitados);
		}
	}
	//  Métodos tipo void (sin parámetros)	
	void colocarSocios() {
		Socio x;
		for (int i=0; i<Proyecto_AED.as.tamaño(); i++) {
			x = Proyecto_AED.as.obtener(i);
				if (Proyecto_AED.ai.procedeCodigoSocio(x.getCodigoSocio()))
					cboCodigoSocio.addItem(String.valueOf(x.getCodigoSocio()));
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
				mostrarHoraFecha();
				mostrarNombreSocio();
				habilitarCajasDeTexto(true);
				break;
		}
	}
	// Muestra el codigo correlativo
	void mostrarCodigoCorrelativo(){
		lblCodigo.setText(String.valueOf(Proyecto_AED.ai.codigoCorrelativo()));
		lblCodigoBoleta.setText(String.valueOf(Proyecto_AED.bo.codigoCorrelativo()));
	}
	// Muestra la hora y la fecha
	void mostrarHoraFecha(){
		lblFechaIngreso.setText(Fecha.leerFechaActual());
		lblHoraIngreso.setText(Fecha.leerHoraActual());
	}
	// Muestra el precio
	void mostrarPrecio(){
		lblCostoIngreso.setText(String.valueOf(leerNumeroInvitados()*25));
	}
	// Muestra el Nombre del Socio
	void mostrarNombreSocio(){
		lblNombreSocio.setText(Proyecto_AED.as.buscar(leerCodigoSocio()).getNombres());
	}
	// Habilita o desabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino){
		cboCodigoSocio.setEnabled(sino);
		txtNumerosInvitados.setEditable(sino);
	}
	// Metodos que retornan valor sin parametros
	int leerCodigo(){
		return Integer.parseInt(lblCodigo.getText().trim());
	}
	int leerCodigoSocio(){
		return Integer.parseInt(cboCodigoSocio.getSelectedItem().toString());
	}
	String leerFechaIngreso(){
		return lblFechaIngreso.getText().trim();
	}
	String leerHoraIngreso(){
		return lblHoraIngreso.getText().trim();
	}
	int leerNumeroInvitados(){
		return Integer.parseInt(txtNumerosInvitados.getText().trim());
	}
	Double leerCostoIngreso(){
		return Double.parseDouble(lblCostoIngreso.getText().trim());
	}
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
	// Boleta
	int leerCodigoBoleta(){
		return Integer.parseInt(lblCodigoBoleta.getText().trim());
	}
}