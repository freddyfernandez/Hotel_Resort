package guis;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UIManager;
import arreglos.ArregloConsumo;
import clases.Boleta;
import clases.Consumo;
import clases.Ingreso;
import clases.Producto;
import libreria.Lib;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgConsumoActividad extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblCodigoConsumo;
	private JLabel lblNombreSocio;
	private JLabel lblProductosAgregados;
	private JComboBox<String> cboProductosAgregados;
	private JButton btnQuitar;
	private JLabel lblNombreProductoAgregado;
	private JLabel lblProductosDisponibles;
	private JComboBox<String> cboProductosDisponibles;
	private JButton btnAgregar;
	private JLabel lblNombreProductoDisponible;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JLabel lblCantidad;
	private JLabel lblPrecioUnitario;
	private JLabel lblCodigoBoleta;

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
					DlgConsumoActividad dialog = new DlgConsumoActividad();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgConsumoActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(0, 0, 316, 492);
		getContentPane().setLayout(null);
		
		lblCodigoConsumo = new JLabel("CODIGO CONSUMO");
		lblCodigoConsumo.setBounds(10, 11, 114, 20);
		getContentPane().add(lblCodigoConsumo);
		
		lblCodigoConsumo = new JLabel();
		lblCodigoConsumo.setBounds(160, 11, 135, 22);
		getContentPane().add(lblCodigoConsumo);
		
		lblNombreSocio = new JLabel("NOMBRE SOCIO");
		lblNombreSocio.setBounds(10, 50, 114, 20);
		getContentPane().add(lblNombreSocio);
		
		lblNombreSocio = new JLabel();
		lblNombreSocio.setBounds(160, 50, 135, 22);
		getContentPane().add(lblNombreSocio);
		
		lblProductosAgregados = new JLabel("PRODUCTOS AGREGADOS");
		lblProductosAgregados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProductosAgregados.setBounds(10, 105, 208, 20);
		getContentPane().add(lblProductosAgregados);
		
		cboProductosAgregados = new JComboBox<String>();
		cboProductosAgregados.addActionListener(this);
		cboProductosAgregados.setBounds(10, 136, 135, 25);
		getContentPane().add(cboProductosAgregados);
		
		btnQuitar = new JButton("Quitar", new ImageIcon("imagenes/quitar.gif"));
		btnQuitar.addActionListener(this);
		btnQuitar.setBounds(160, 136, 135, 25);
		getContentPane().add(btnQuitar);
		
		lblNombreProductoAgregado = new JLabel("NOMBRE PRODUCTO");
		lblNombreProductoAgregado.setBounds(10, 172, 135, 20);
		getContentPane().add(lblNombreProductoAgregado);
		
		lblNombreProductoAgregado = new JLabel();
		lblNombreProductoAgregado.setText((String) null);
		lblNombreProductoAgregado.setBounds(160, 172, 135, 22);
		getContentPane().add(lblNombreProductoAgregado);
		
		lblProductosDisponibles = new JLabel("PRODUCTOS DISPONIBLES");
		lblProductosDisponibles.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProductosDisponibles.setBounds(10, 289, 208, 20);
		getContentPane().add(lblProductosDisponibles);
		
		cboProductosDisponibles = new JComboBox<String>();
		cboProductosDisponibles.addActionListener(this);
		cboProductosDisponibles.setBounds(10, 320, 135, 25);
		getContentPane().add(cboProductosDisponibles);
		
		btnAgregar = new JButton("Agregar", new ImageIcon("imagenes/agregar.png"));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(160, 320, 135, 25);
		getContentPane().add(btnAgregar);
		
		lblNombreProductoDisponible = new JLabel("NOMBRE PRODUCTO");
		lblNombreProductoDisponible.setBounds(10, 356, 135, 20);
		getContentPane().add(lblNombreProductoDisponible);
		
		lblNombreProductoDisponible = new JLabel();
		lblNombreProductoDisponible.setText((String) null);
		lblNombreProductoDisponible.setBounds(160, 354, 135, 22);
		getContentPane().add(lblNombreProductoDisponible);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 426, 135, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(160, 426, 135, 25);
		getContentPane().add(btnVolver);
		
		lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(10, 203, 114, 20);
		getContentPane().add(lblCantidad);
		
		lblCantidad = new JLabel();
		lblCantidad.setBounds(160, 203, 135, 22);
		getContentPane().add(lblCantidad);
		
		lblPrecioUnitario = new JLabel("PRECIO UNITARIO");
		lblPrecioUnitario.setBounds(10, 234, 114, 20);
		getContentPane().add(lblPrecioUnitario);
		
		lblPrecioUnitario = new JLabel();
		lblPrecioUnitario.setBounds(160, 236, 135, 22);
		getContentPane().add(lblPrecioUnitario);
		
		lblCodigoBoleta = new JLabel();
		lblCodigoBoleta.setBounds(10, 136, 135, 22);
		getContentPane().add(lblCodigoBoleta);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == cboProductosDisponibles) {
			actionPerformedCboProductosDisponibles(arg0);
		}
		if (arg0.getSource() == btnQuitar) {
			actionPerformedBtnQuitar(arg0);
		}
		if (arg0.getSource() == cboProductosAgregados) {
			actionPerformedCboProductosAgregados(arg0);
		}
	}
	protected void actionPerformedCboProductosAgregados(ActionEvent arg0) {
		if (cboProductosAgregados.getSelectedIndex() >=0)
			mostrarNompreCantidadProductoAgregado();
		else{
			lblNombreProductoAgregado.setText("");
			lblCantidad.setText("");
			lblPrecioUnitario.setText("");
		}
	}
	protected void actionPerformedBtnQuitar(ActionEvent arg0) {
		quitarProducto();
	}
	protected void actionPerformedCboProductosDisponibles(ActionEvent arg0) {
		if (cboProductosDisponibles.getSelectedIndex() >=0)
			mostrarNompreProductoDisponible();
		else
			lblNombreProductoDisponible.setText("");
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		agregarProducto();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		aceptar();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	// Agrega un producto
	void agregarProducto(){
		Ingreso i = Proyecto_AED.ai.buscar(leerCodigoIngreso());
		Boleta b = Proyecto_AED.bo.buscar(leerCodigoBoleta());
		if(i.getEstado() == 0)
			try{
				int codigoProducto = leerCodigoProductoDisponible();
				Producto p = Proyecto_AED.ap.buscar(codigoProducto);
				int ok = Lib.mensajeConfirmacion(this, "¿Añadir "+p.getDetalle()+" al consumo?"+
												"\n"+"Precio Unitario :  "+p.getPrecioUnitario());
				if (ok == 0)
					try{
						int cantidad = Integer.parseInt(Lib.confirmarIngreso(this, "Cantidad"));
						
						if (cantidad <= p.getStock()){
							ArregloConsumo ac = new ArregloConsumo(leerNumeroConsumo());
							ac.adicionar(new Consumo(codigoProducto, cantidad, p.getPrecioUnitario()));
							ac.grabarConsumo();
							p.setStock(p.getStock() - cantidad);
							Proyecto_AED.ap.grabarProducto();
							b.setPagoIngresoConsumo(Lib.redondear(b.getPagoIngresoConsumo()+(cantidad*p.getPrecioUnitario())));
							Proyecto_AED.bo.grabarBoleta();
							cboProductosAgregados.addItem(cboProductosDisponibles.getSelectedItem().toString());
							cboProductosDisponibles.removeItem(cboProductosDisponibles.getSelectedItem());
						}
						else
							Lib.mensaje(this, "Sólo hay " + p.getStock() + " unidades en stock");
					}
					catch(Exception e){
						Lib.mensaje(this, "Ingrese CANTIDAD correcta");
					}
			}
			catch(Exception e){
				Lib.mensaje(this, "El consumo ya tiene todos los productos");
			}
		else
			Lib.mensaje(this, "No se puede agregar productos porque la consulta esta pagada");
	}
	// Quitar Producto
	void quitarProducto(){
		Ingreso i = Proyecto_AED.ai.buscar(leerCodigoIngreso());
		Boleta b = Proyecto_AED.bo.buscar(leerCodigoBoleta());
		if(i.getEstado() == 0){
			int codigoProducto = leerCodigoProductoAgregado();
			Producto p = Proyecto_AED.ap.buscar(codigoProducto);
			int ok = Lib.mensajeConfirmacion(this, "¿Quitar "+p.getDetalle()+" del consumo?"+
											"\n"+"Precio unitario :  "+p.getPrecioUnitario());
			if (ok == 0){
				ArregloConsumo ac = new ArregloConsumo(leerNumeroConsumo());
				Consumo c = ac.buscar(codigoProducto);
				ac.eliminar(c);
				ac.grabarConsumo();
				p.setStock(p.getStock()+c.getCantidad());
				Proyecto_AED.ap.grabarProducto();
				b.setPagoIngresoConsumo(Lib.redondear(b.getPagoIngresoConsumo()-(c.getCantidad()*c.getPrecioUnitario())));
				Proyecto_AED.bo.grabarBoleta();
				cboProductosDisponibles.addItem(cboProductosAgregados.getSelectedItem().toString());
				cboProductosAgregados.removeItem(cboProductosAgregados.getSelectedItem());
			}
		}
		else
			Lib.mensaje(this, "No se puede quitar productos porque la consulta esta pagada");
	}
	// Aceptar cambios
	void aceptar(){
		Proyecto_AED.ai.actualizar();
		Lib.mensaje(this,"Su consumo ha sido ingresado");
		ArregloConsumo ac = new ArregloConsumo(leerNumeroConsumo());
		ac.grabarConsumo();
		dispose();
	}
	void mostrarNompreCantidadProductoAgregado(){
		lblNombreProductoAgregado.setText(Proyecto_AED.ap.buscar(leerCodigoProductoAgregado()).getDetalle());
		ArregloConsumo ac = new ArregloConsumo(leerNumeroConsumo());
		lblCantidad.setText(String.valueOf(ac.buscar(leerCodigoProductoAgregado()).getCantidad()));
		lblPrecioUnitario.setText(String.valueOf(ac.buscar(leerCodigoProductoAgregado()).getPrecioUnitario()));
	}
	void mostrarNompreProductoDisponible(){
		lblNombreProductoDisponible.setText(Proyecto_AED.ap.buscar(leerCodigoProductoDisponible()).getDetalle());
	}
	// Cargar los datos de un consumo
	void cargarConsumo(Ingreso x){
		lblCodigoConsumo.setText(String.valueOf(x.getCodigoIngreso()));
		lblNombreSocio.setText(Proyecto_AED.as.buscar(x.getCodigoSocio()).getNombres());
		lblCodigoBoleta.setText(String.valueOf(x.getCodigoBoleta()));
		distribuirCodigosProductos();
	}
	void distribuirCodigosProductos(){
		ArregloConsumo ac = new ArregloConsumo(leerNumeroConsumo());
		Consumo c;
		cboProductosAgregados.removeAllItems();
		for (int pos=0; pos<ac.tamaño(); pos++){
			c = ac.obtener(pos);
			cboProductosAgregados.addItem(String.valueOf(c.getCodigoProducto()));
		}
		Producto p;
		cboProductosDisponibles.removeAllItems();
		for (int pos=0; pos<Proyecto_AED.ap.tamaño(); pos++){
			p = Proyecto_AED.ap.obtener(pos);
			if (ac.buscar(p.getCodigoProducto()) == null)
				cboProductosDisponibles.addItem(String.valueOf(p.getCodigoProducto()));
		}
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigoProductoAgregado(){
		return Integer.parseInt(cboProductosAgregados.getSelectedItem().toString());
	}
	int leerCodigoProductoDisponible(){
		return Integer.parseInt(cboProductosDisponibles.getSelectedItem().toString());
	}	
	int leerCodigoIngreso(){
		return Integer.parseInt(lblCodigoConsumo.getText().trim());
	}
	String leerNumeroConsumo(){
		return String.valueOf(leerCodigoIngreso());
	}
	int leerCodigoBoleta(){
		return Integer.parseInt(lblCodigoBoleta.getText().trim());
	}
}