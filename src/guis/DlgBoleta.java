package guis;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import clases.*;
import libreria.Fecha;
import libreria.Lib;

import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloConsumo;
import java.awt.Color;

public class DlgBoleta extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTextArea txtRuc;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNombreSocio_1;
	private JLabel lblNombreSocio;
	private JLabel lblApellidoSocio;
	private JLabel lblTelefono;
	private JLabel lblTelef;
	private JLabel lblD;
	private JLabel lblDni;
	private JTextField txtCostoIngreso;
	private JScrollPane scrollPane_1;
	private JTable tblConsumo;
	private DefaultTableModel modelo;
	private JTextField txtCostoConsumo;
	private JLabel lblCostoIngresoY;
	private JLabel lblCostoIngresoS;
	private JLabel lblHospedaje;
	private JLabel lblIngresoYConsumos;
	private JLabel lblBungalow;
	private JTextField txtBungalow;
	private JLabel lblCategoria;
	private JTextField txtCategoria;
	private JTextField txtIngreso;
	private JLabel lblIngreso;
	private JLabel lblSalida;
	private JTextField txtSalida;
	private JTextField txtCostoHospedaje;
	private JLabel lblCostoHospedaje;
	private JLabel lblPrecioPorDia;
	private JTextField txtPrecioDia;
	private JLabel lblDiasTranscurridos;
	private JTextField txtDiaTranscurridos;
	private JLabel lblTotalCostoHospedaje;
	private JTextField txtTotalHospedaje;
	private JLabel lblTotalAPagar;
	private JTextField txtTotalPagar;
	
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
					DlgBoleta dialog = new DlgBoleta();
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
	public DlgBoleta() {
		getContentPane().setBackground(new Color(250, 235, 215));
		setResizable(false);
		setBounds(100, 100, 497, 763);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.setBounds(10, 701, 150, 25);
		btnAceptar.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 11, 143, 72);
		getContentPane().add(scrollPane);
		
		txtRuc = new JTextArea();
		txtRuc.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtRuc.setEditable(false);
		scrollPane.setViewportView(txtRuc);
		
		lblNewLabel = new JLabel("Hotel \"Misti Resort\"");
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(39, 11, 256, 31);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Calle San Pedro 139 \u2013 Cercado, Arequipa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(49, 53, 245, 14);
		getContentPane().add(lblNewLabel_1);
		
		label = new JLabel("(054) 288081");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(127, 69, 94, 14);
		getContentPane().add(label);
		
		lblNombreSocio_1 = new JLabel("NOMBRE SOCIO :");
		lblNombreSocio_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNombreSocio_1.setBounds(10, 129, 135, 25);
		getContentPane().add(lblNombreSocio_1);
		
		lblNombreSocio = new JLabel();
		lblNombreSocio.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNombreSocio.setBounds(137, 129, 150, 22);
		getContentPane().add(lblNombreSocio);
		
		lblApellidoSocio = new JLabel();
		lblApellidoSocio.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblApellidoSocio.setBounds(297, 129, 150, 22);
		getContentPane().add(lblApellidoSocio);
		
		lblTelefono = new JLabel();
		lblTelefono.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblTelefono.setBounds(108, 158, 135, 22);
		getContentPane().add(lblTelefono);
		
		lblTelef = new JLabel("TELEFONO :");
		lblTelef.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblTelef.setBounds(10, 160, 114, 25);
		getContentPane().add(lblTelef);
		
		lblD = new JLabel("DNI :");
		lblD.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblD.setBounds(251, 160, 66, 25);
		getContentPane().add(lblD);
		
		lblDni = new JLabel();
		lblDni.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblDni.setBounds(308, 160, 135, 22);
		getContentPane().add(lblDni);
		
		txtCostoIngreso = new JTextField();
		txtCostoIngreso.setEditable(false);
		txtCostoIngreso.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtCostoIngreso.setBounds(193, 191, 135, 25);
		getContentPane().add(txtCostoIngreso);
		txtCostoIngreso.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 227, 471, 125);
		getContentPane().add(scrollPane_1);
		
		tblConsumo = new JTable();
		tblConsumo.setEnabled(false);
		tblConsumo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblConsumo.setFillsViewportHeight(true);
		tblConsumo.getSelectionModel().setSelectionInterval(0, 0);
		
		scrollPane_1.setViewportView(tblConsumo);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Unitario");
		modelo.addColumn("Importe");
		tblConsumo.setModel(modelo);
		
		txtCostoConsumo = new JTextField();
		txtCostoConsumo.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtCostoConsumo.setEditable(false);
		txtCostoConsumo.setBounds(297, 363, 135, 25);
		getContentPane().add(txtCostoConsumo);
		txtCostoConsumo.setColumns(10);
		
		lblCostoIngresoY = new JLabel("COSTO INGRESO Y CONSUMOS :  S/");
		lblCostoIngresoY.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblCostoIngresoY.setBounds(10, 363, 273, 25);
		getContentPane().add(lblCostoIngresoY);
		
		lblCostoIngresoS = new JLabel("COSTO INGRESO :  S/");
		lblCostoIngresoS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblCostoIngresoS.setBounds(10, 193, 176, 25);
		getContentPane().add(lblCostoIngresoS);
		
		lblHospedaje = new JLabel("HOSPEDAJE");
		lblHospedaje.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHospedaje.setBounds(182, 399, 126, 31);
		getContentPane().add(lblHospedaje);
		
		lblIngresoYConsumos = new JLabel("INGRESO Y CONSUMOS");
		lblIngresoYConsumos.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblIngresoYConsumos.setBounds(127, 94, 238, 31);
		getContentPane().add(lblIngresoYConsumos);
		
		lblBungalow = new JLabel("BUNGALOW :");
		lblBungalow.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblBungalow.setBounds(10, 441, 100, 25);
		getContentPane().add(lblBungalow);
		
		txtBungalow = new JTextField();
		txtBungalow.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtBungalow.setEditable(false);
		txtBungalow.setColumns(10);
		txtBungalow.setBounds(108, 441, 85, 25);
		getContentPane().add(txtBungalow);
		
		lblCategoria = new JLabel("CATEGORIA :");
		lblCategoria.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblCategoria.setBounds(10, 477, 100, 25);
		getContentPane().add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(120, 477, 83, 25);
		getContentPane().add(txtCategoria);
		
		txtIngreso = new JTextField();
		txtIngreso.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtIngreso.setEditable(false);
		txtIngreso.setColumns(10);
		txtIngreso.setBounds(285, 441, 196, 25);
		getContentPane().add(txtIngreso);
		
		lblIngreso = new JLabel("INGRESO :");
		lblIngreso.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblIngreso.setBounds(203, 441, 94, 25);
		getContentPane().add(lblIngreso);
		
		lblSalida = new JLabel("SALIDA :");
		lblSalida.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblSalida.setBounds(213, 477, 85, 25);
		getContentPane().add(lblSalida);
		
		txtSalida = new JTextField();
		txtSalida.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtSalida.setEditable(false);
		txtSalida.setColumns(10);
		txtSalida.setBounds(285, 477, 196, 25);
		getContentPane().add(txtSalida);
		
		txtCostoHospedaje = new JTextField();
		txtCostoHospedaje.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtCostoHospedaje.setEditable(false);
		txtCostoHospedaje.setColumns(10);
		txtCostoHospedaje.setBounds(285, 515, 135, 25);
		getContentPane().add(txtCostoHospedaje);
		
		lblCostoHospedaje = new JLabel("COSTO HOSPEDAJE :        S/");
		lblCostoHospedaje.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblCostoHospedaje.setBounds(10, 515, 261, 25);
		getContentPane().add(lblCostoHospedaje);
		
		lblPrecioPorDia = new JLabel("PRECIO POR DIA :         S/");
		lblPrecioPorDia.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblPrecioPorDia.setBounds(10, 551, 261, 25);
		getContentPane().add(lblPrecioPorDia);
		
		txtPrecioDia = new JTextField();
		txtPrecioDia.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtPrecioDia.setEditable(false);
		txtPrecioDia.setColumns(10);
		txtPrecioDia.setBounds(285, 551, 135, 25);
		getContentPane().add(txtPrecioDia);
		
		lblDiasTranscurridos = new JLabel("DIAS TRANSCURRIDOS :");
		lblDiasTranscurridos.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblDiasTranscurridos.setBounds(10, 587, 200, 25);
		getContentPane().add(lblDiasTranscurridos);
		
		txtDiaTranscurridos = new JTextField();
		txtDiaTranscurridos.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDiaTranscurridos.setEditable(false);
		txtDiaTranscurridos.setColumns(10);
		txtDiaTranscurridos.setBounds(285, 587, 135, 25);
		getContentPane().add(txtDiaTranscurridos);
		
		lblTotalCostoHospedaje = new JLabel("TOTAL COSTO HOSPEDAJE :  S/");
		lblTotalCostoHospedaje.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblTotalCostoHospedaje.setBounds(10, 623, 244, 25);
		getContentPane().add(lblTotalCostoHospedaje);
		
		txtTotalHospedaje = new JTextField();
		txtTotalHospedaje.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtTotalHospedaje.setEditable(false);
		txtTotalHospedaje.setColumns(10);
		txtTotalHospedaje.setBounds(285, 623, 135, 25);
		getContentPane().add(txtTotalHospedaje);
		
		lblTotalAPagar = new JLabel("TOTAL A PAGAR :  S/");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAPagar.setBounds(10, 659, 176, 31);
		getContentPane().add(lblTotalAPagar);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setColumns(10);
		txtTotalPagar.setBounds(182, 659, 135, 25);
		getContentPane().add(txtTotalPagar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		dispose();
	}
	void cargarBoleta(Hospedaje ho){
		Ingreso in = Proyecto_AED.ai.buscar(ho.getCodigoIngreso());
		Socio so = Proyecto_AED.as.buscar(in.getCodigoSocio());
		Boleta bo = Proyecto_AED.bo.buscar(in.getCodigoBoleta());
		Bungalow bu = Proyecto_AED.ab.buscar(ho.getNumeroBungalow());
		imprimirRuc("RUC 20274361531");
		imprimirRuc("VOLETA DE VENTA");
		txtRuc.append("    N° "+in.getCodigoBoleta());
		lblNombreSocio.setText(so.getNombres());
		lblApellidoSocio.setText(so.getApellidos());
		lblTelefono.setText(so.getTelefono());
		lblDni.setText(so.getDni());
		txtCostoIngreso.setText(String.valueOf(in.getCostoIngreso()));
		modelo.setRowCount(0);
		ArregloConsumo ac = new ArregloConsumo(String.valueOf(ho.getCodigoIngreso()));
		Consumo co;
		double importePago;
		for (int i=0; i<ac.tamaño(); i++){
			co =ac.obtener(i);
			importePago = co.getCantidad() * co.getPrecioUnitario();
			Producto pr = Proyecto_AED.ap.buscar(co.getCodigoProducto());
			Object fila[] = { pr.getDetalle(),
			          		  co.getCantidad(),
			          		  co.getPrecioUnitario(),
			          		  formato(importePago)};
			modelo.addRow(fila);
		}
		txtCostoConsumo.setText(String.valueOf(bo.getPagoIngresoConsumo()));
		txtBungalow.setText(String.valueOf(ho.getNumeroBungalow()));
		txtCategoria.setText(Lib.tiposDeCategoria[bu.getCategoria()]);
		txtIngreso.setText(in.getFechaIngreso()+" - "+ in.getHoraIngreso());
		txtSalida.setText(ho.getFechaSalida()+" - "+ho.getHoraSalida());
		txtCostoHospedaje.setText(formato(ho.getCostoHospedaje()));
		txtPrecioDia.setText(formato(bu.getPrecioDia()));
		int dias = Fecha.diasTranscurridos(in.getFechaIngreso(), ho.getFechaSalida());
		txtDiaTranscurridos.setText(String.valueOf(dias));
		txtTotalHospedaje.setText(formato(bo.getPagoHospedaje()));
		double totalPagar = bo.getPagoIngresoConsumo()+bo.getPagoHospedaje();
		txtTotalPagar.setText(formato(totalPagar));
		bo.setPagoTotal(totalPagar);
		Proyecto_AED.bo.grabarBoleta();
	}
	//  Métodos tipo void (con parámetros)
	void imprimirRuc(String s) {
		txtRuc.append(s + "\n");
	}
   	// Metodos tipo void con parametros
	String formato(double real) {
		return String.format(Locale.US, "%-10.2f", real);
	}
}