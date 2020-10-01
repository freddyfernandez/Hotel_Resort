package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import arreglos.ArregloConsumo;
import clases.*;
import libreria.Lib;

import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class DlgIngresosYConsumosActividad extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextArea txtS;
	
	// Declaracion global
	Ingreso ingreso;

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
					DlgIngresosYConsumosActividad dialog = new DlgIngresosYConsumosActividad();
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
	public DlgIngresosYConsumosActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 497, 510);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 471, 424);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtS);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(331, 446, 150, 25);
		getContentPane().add(btnVolver);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		pagar();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	// Pagar ingreso y consumos
	void pagar(){
		Ingreso i = Proyecto_AED.ai.buscar(ingreso.getCodigoIngreso());
		i.setEstado(1);
		Proyecto_AED.ai.actualizar();
		Lib.mensaje(this, "Su Ingreso y consumos estan Pagados");
		dispose();
	}
	// Establece la fila a pagar
	void setIngreso(Ingreso ingreso){
		this.ingreso = ingreso;
	}
	// Cargar los datos de un Ingreso
	void cargarIngresosConsumos(Ingreso x){
		Boleta b = Proyecto_AED.bo.buscar(x.getCodigoBoleta());
		Socio s = Proyecto_AED.as.buscar(x.getCodigoSocio());
		imprimir("  Socio     :  " + s.getCodigoSocio());
		imprimir("  Nombres   :  " + s.getNombres());
		imprimir("  Apellidos :  " + s.getApellidos());
		imprimir();
		imprimir("  1) COSTO DE INGRESO S/ " + x.getCostoIngreso());
		imprimir();
		ArregloConsumo ac = new ArregloConsumo(String.valueOf(x.getCodigoIngreso()));
		Consumo c;
		imprimir("  2) CONSUMO");
		imprimir("                Cantidad     Precio    Importe");
		double importePago;
		for (int i=0; i<ac.tamaño(); i++){
			c = ac.obtener(i);
			importePago = c.getCantidad() * c.getPrecioUnitario();
			Producto p = Proyecto_AED.ap.buscar(c.getCodigoProducto());
			imprimir("     " + formato(p.getDetalle()) + formato(c.getCantidad()) + 
			         formato(c.getPrecioUnitario()) + formato(importePago));
		}
		imprimir();
		imprimir("  3) TOTAL A PAGAR S/ " + formato(b.getPagoIngresoConsumo()));
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	String formato(String cadena) {
		return String.format("%-15s", cadena);
	}
	String formato(int entero) {
		return String.format("%-10d", entero);
	}
	String formato(double real) {
		return String.format(Locale.US, "%-10.2f", real);
	}
	// Metodos tipo void sin parametros
	void imprimir() {
		imprimir("");
	}
}
