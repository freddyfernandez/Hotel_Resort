package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import clases.*;
import libreria.*;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgHospedajesActividad extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnAceptar;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	// Declaracion Global
	Hospedaje hospedaje;
	String fechaSalida, horaSalida;
	double totalPagar;
	
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
					DlgHospedajesActividad dialog = new DlgHospedajesActividad();
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
	public DlgHospedajesActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 507, 521);
		getContentPane().setLayout(null);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 445, 150, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(331, 445, 150, 25);
		getContentPane().add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 471, 424);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtS);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		pagar();
		DlgBoleta db = new DlgBoleta();
		//db.setHospedaje(hospedaje);
		db.setTitle("Boleta");
		db.setLocationRelativeTo(this);
		db.cargarBoleta(hospedaje);
		db.setVisible(true);
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		dispose();
	}
	// Pagar hospedajes
	void pagar(){
		Hospedaje h = Proyecto_AED.ah.buscar(hospedaje.getCodigoHospedaje());
		Ingreso i = Proyecto_AED.ai.buscar(h.getCodigoIngreso());
		Boleta bo = Proyecto_AED.bo.buscar(i.getCodigoBoleta());
		h.setEstado(1);
		h.setFechaSalida(fechaSalida);
		h.setHoraSalida(horaSalida);
		Proyecto_AED.ah.grabarHospedaje();
		bo.setPagoHospedaje(totalPagar);
		Proyecto_AED.bo.grabarBoleta();
		Bungalow b = Proyecto_AED.ab.buscar(h.getNumeroBungalow());
		b.setEstado(0);
		Proyecto_AED.ab.grabarBungalow();
		Proyecto_AED.ah.actualizar();
		Lib.mensaje(this, "Su hospedaje esta pagado");
		dispose();
	}
	// Establece la fila a pagar
	void setHospedaje(Hospedaje hospedaje){
		this.hospedaje = hospedaje;
	}
	// Cargar los datos de un hospedaje
	void cargarHospedajes(Hospedaje x){
		Ingreso i = Proyecto_AED.ai.buscar(x.getCodigoIngreso());
		Socio s = Proyecto_AED.as.buscar(i.getCodigoSocio());
		imprimir("  Socio     :  " + s.getCodigoSocio());
		imprimir("  Nombres   :  " + s.getNombres());
		imprimir("  Apellidos :  " + s.getApellidos());
		imprimir();
		imprimir("  Bungalow  :  " + x.getNumeroBungalow());
		Bungalow b = Proyecto_AED.ab.buscar(x.getNumeroBungalow());
		imprimir("	Categoría :  " + Lib.tiposDeCategoria[b.getCategoria()]);
		imprimir();
		imprimir("  Ingreso   :  " + i.getFechaIngreso() + " - " + i.getHoraIngreso());
		fechaSalida = Fecha.leerFechaActual();
		horaSalida = Fecha.leerHoraActual();
		imprimir("  Salida    :  " + fechaSalida + " - " + horaSalida);
		int dias = Fecha.diasTranscurridos(i.getFechaIngreso(), fechaSalida);
		if (dias == 0)
			totalPagar = x.getCostoHospedaje() + b.getPrecioDia();
		else
			totalPagar = x.getCostoHospedaje() + dias * b.getPrecioDia();
		imprimir();
		imprimir("  1) COSTO DE HOSPEDAJE S/ " + formato(x.getCostoHospedaje()));
		imprimir();
		imprimir("  2) PRECIO POR DÍA S/ " + formato(b.getPrecioDia()));
		imprimir();
		imprimir("  3) DÍAS TRANSCURRIDOS " + dias);
		imprimir();
		imprimir("  4) TOTAL A PAGAR S/ " + formato(totalPagar));
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
