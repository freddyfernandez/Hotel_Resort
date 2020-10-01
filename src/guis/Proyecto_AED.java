package guis;

import arreglos.*;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Proyecto_AED extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmSocio;
	private JMenuItem mntmProducto;
	private JMenuItem mntmBungalow;
	private JMenuItem mntmIngreso;
	private JMenuItem mntmConsumo;
	private JMenuItem mntmHospedaje;
	private JMenuItem mntmIngresosYConsumos;
	private JMenuItem mntmHospedajes;
	private JMenuItem mntmIngresosYConsumos_1;
	private JMenuItem mntmIngresosYConsumos_2;
	private JMenuItem mntmHospedajePendientes;
	private JMenuItem mntmHospedajesPagados;
	
	// Declaraciones publicas estaticas globales
	public static ArregloSocio as = new ArregloSocio();
	public static ArregloProducto ap = new ArregloProducto();
	public static ArregloBungalow ab = new ArregloBungalow();
	public static ArregloIngreso ai = new ArregloIngreso();
	public static ArregloHospedaje ah = new ArregloHospedaje();
	public static ArregloBoleta bo =  new ArregloBoleta();
	private JLabel lblFondo;
	private JLabel lblTitulo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_AED frame = new Proyecto_AED();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto_AED() {
		setResizable(false);
		setTitle("Hotel Misti Resort");
		setIconImage(new ImageIcon("imagenes/Bungalow.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 626);
		this.setLocationRelativeTo(null);
		
		menuProyecto = new JMenuBar();
		menuProyecto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuProyecto.setForeground(Color.WHITE);
		menuProyecto.setBackground(new Color(205, 133, 63));
		setJMenuBar(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnArchivo.setForeground(Color.WHITE);
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon("imagenes/delete.gif"));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnMantenimiento.setForeground(Color.WHITE);
		menuProyecto.add(mnMantenimiento);
		
		mntmSocio = new JMenuItem("Socio");
		mntmSocio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmSocio.addActionListener(this);
		mntmSocio.setIcon(new ImageIcon("imagenes/socio.png"));
		mnMantenimiento.add(mntmSocio);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmProducto.addActionListener(this);
		mntmProducto.setIcon(new ImageIcon("imagenes/producto.png"));
		mnMantenimiento.add(mntmProducto);
		
		mntmBungalow = new JMenuItem("Bungalow");
		mntmBungalow.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmBungalow.addActionListener(this);
		mntmBungalow.setIcon(new ImageIcon("imagenes/bungalow.png"));
		mnMantenimiento.add(mntmBungalow);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnRegistro.setForeground(Color.WHITE);
		menuProyecto.add(mnRegistro);
		
		mntmIngreso = new JMenuItem("Ingreso");
		mntmIngreso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmIngreso.addActionListener(this);
		mntmIngreso.setIcon(new ImageIcon("imagenes/ingreso.png"));
		mnRegistro.add(mntmIngreso);
		
		mntmConsumo = new JMenuItem("Consumo");
		mntmConsumo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmConsumo.addActionListener(this);
		mntmConsumo.setIcon(new ImageIcon("imagenes/consumo.gif"));
		mnRegistro.add(mntmConsumo);
		
		mntmHospedaje = new JMenuItem("Hospedaje");
		mntmHospedaje.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmHospedaje.addActionListener(this);
		mntmHospedaje.setIcon(new ImageIcon("imagenes/hospedaje.png"));
		mnRegistro.add(mntmHospedaje);
		
		mnPago = new JMenu("Pago");
		mnPago.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnPago.setForeground(Color.WHITE);
		menuProyecto.add(mnPago);
		
		mntmIngresosYConsumos = new JMenuItem("Ingresos y Consumos");
		mntmIngresosYConsumos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmIngresosYConsumos.addActionListener(this);
		mntmIngresosYConsumos.setIcon(new ImageIcon("imagenes/pagoingreso.png"));
		mnPago.add(mntmIngresosYConsumos);
		
		mntmHospedajes = new JMenuItem("Hospedajes");
		mntmHospedajes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmHospedajes.addActionListener(this);
		mntmHospedajes.setIcon(new ImageIcon("imagenes/pagohospedaje.png"));
		mnPago.add(mntmHospedajes);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReporte.setForeground(Color.WHITE);
		menuProyecto.add(mnReporte);
		
		mntmIngresosYConsumos_1 = new JMenuItem("Ingresos y Consumos Pendientes");
		mntmIngresosYConsumos_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmIngresosYConsumos_1.addActionListener(this);
		mntmIngresosYConsumos_1.setIcon(new ImageIcon("imagenes/reporte.png"));
		mnReporte.add(mntmIngresosYConsumos_1);
		
		mntmIngresosYConsumos_2 = new JMenuItem("Ingresos y Consumos Pagados");
		mntmIngresosYConsumos_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmIngresosYConsumos_2.addActionListener(this);
		mntmIngresosYConsumos_2.setIcon(new ImageIcon("imagenes/reporte.png"));
		mnReporte.add(mntmIngresosYConsumos_2);
		
		mntmHospedajePendientes = new JMenuItem("Hospedaje Pendientes");
		mntmHospedajePendientes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmHospedajePendientes.addActionListener(this);
		mntmHospedajePendientes.setIcon(new ImageIcon("imagenes/reporte.png"));
		mnReporte.add(mntmHospedajePendientes);
		
		mntmHospedajesPagados = new JMenuItem("Hospedajes Pagados");
		mntmHospedajesPagados.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmHospedajesPagados.addActionListener(this);
		mntmHospedajesPagados.setIcon(new ImageIcon("imagenes/reporte.png"));
		mnReporte.add(mntmHospedajesPagados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel(new ImageIcon("imagenes/titulo.png"));
		lblTitulo.setBounds(0, 379, 1018, 185);
		contentPane.add(lblTitulo);
		
		lblFondo = new JLabel(new ImageIcon("imagenes/fondo.gif"));
		lblFondo.setBounds(0, 0, 1018, 589);
		contentPane.add(lblFondo);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmHospedajesPagados) {
			actionPerformedMntmHospedajesPagados(arg0);
		}
		if (arg0.getSource() == mntmHospedajePendientes) {
			actionPerformedMntmHospedajePendientes(arg0);
		}
		if (arg0.getSource() == mntmIngresosYConsumos_2) {
			actionPerformedMntmIngresosYConsumos_2(arg0);
		}
		if (arg0.getSource() == mntmIngresosYConsumos_1) {
			actionPerformedMntmIngresosYConsumos_1(arg0);
		}
		if (arg0.getSource() == mntmHospedajes) {
			actionPerformedMntmHospedajes(arg0);
		}
		if (arg0.getSource() == mntmIngresosYConsumos) {
			actionPerformedMntmIngresosYConsumos(arg0);
		}
		if (arg0.getSource() == mntmHospedaje) {
			actionPerformedMntmHospedaje(arg0);
		}
		if (arg0.getSource() == mntmConsumo) {
			actionPerformedMntmConsumo(arg0);
		}
		if (arg0.getSource() == mntmIngreso) {
			actionPerformedMntmIngreso(arg0);
		}
		if (arg0.getSource() == mntmBungalow) {
			actionPerformedMntmBungalow(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			actionPerformedMntmProducto(arg0);
		}
		if (arg0.getSource() == mntmSocio) {
			actionPerformedMntmSocio(arg0);
		}
	}
	// Menu Item Socio
	protected void actionPerformedMntmSocio(ActionEvent arg0) {
		DlgSocio s = new DlgSocio();
		s.setLocationRelativeTo(this);
		s.setVisible(true);
	}
	// Menu Item Producto
	protected void actionPerformedMntmProducto(ActionEvent arg0) {
		DlgProducto p = new DlgProducto();
		p.setLocationRelativeTo(this);
		p.setVisible(true);
	}
	// Menu Item Bungalow
	protected void actionPerformedMntmBungalow(ActionEvent arg0) {
		DlgBungalow b = new DlgBungalow();
		b.setLocationRelativeTo(this);
		b.setVisible(true);
	}
	// Menu Item Ingreso
	protected void actionPerformedMntmIngreso(ActionEvent arg0) {
		DlgIngreso i = new DlgIngreso();
		i.setLocationRelativeTo(this);
		i.setVisible(true);
	}
	// Menu Item Consumo
	protected void actionPerformedMntmConsumo(ActionEvent arg0) {
		DlgConsumo c = new DlgConsumo();
		c.setLocationRelativeTo(this);
		c.setVisible(true);
	}
	// Menu Item Hospedaje
	protected void actionPerformedMntmHospedaje(ActionEvent arg0) {
		DlgHospedaje h = new DlgHospedaje();
		h.setLocationRelativeTo(this);
		h.setVisible(true);
	}
	// Menu Item Ingresos y Consumos
	protected void actionPerformedMntmIngresosYConsumos(ActionEvent arg0) {
		DlgIngresosYConsumos ic = new DlgIngresosYConsumos();
		ic.setLocationRelativeTo(this);
		ic.setVisible(true);
	}
	// Menu Item Hospedajes
	protected void actionPerformedMntmHospedajes(ActionEvent arg0) {
		DlgHospedajes hs = new DlgHospedajes();
		hs.setLocationRelativeTo(this);
		hs.setVisible(true);
	}
	// Menu Item Ingresos y Consumos Pendientes
	protected void actionPerformedMntmIngresosYConsumos_1(ActionEvent arg0) {
		DlgIngresosYConsumosPendientes icp = new DlgIngresosYConsumosPendientes();
		icp.setLocationRelativeTo(this);
		icp.setVisible(true);
	}
	// Menu Item Ingresos y Consumos Pagados
	protected void actionPerformedMntmIngresosYConsumos_2(ActionEvent arg0) {
		DlgIngresosYConsumosPagados icpa = new DlgIngresosYConsumosPagados();
		icpa.setLocationRelativeTo(this);
		icpa.setVisible(true);
	}
	// Menu Item Hospedaje Pendientes
	protected void actionPerformedMntmHospedajePendientes(ActionEvent arg0) {
		DlgHospedajesPendientes hp = new DlgHospedajesPendientes();
		hp.setLocationRelativeTo(this);
		hp.setVisible(true);
	}
	// Menu Item Hospedajes Pagados
	protected void actionPerformedMntmHospedajesPagados(ActionEvent arg0) {
		DlgHospedajesPagados hpa = new DlgHospedajesPagados();
		hpa.setLocationRelativeTo(this);
		hpa.setVisible(true);
	}
	// Menu Item Salir
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		int ok = confirmacionDeSalida();	
		if (ok == 0)
			System.exit(0);
	}
	//  Métodos que retornan valor (sin parámetros)
	int confirmacionDeSalida() {
		return JOptionPane.showConfirmDialog(this,
			   "¿ Desea salir del Sistema ?",
			   "Hotel Misti Resort", 0, -1, new ImageIcon("imagenes/loading.gif"));
	}
}