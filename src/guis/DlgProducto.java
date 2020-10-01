package guis;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.UIManager;
//import javax.swing.ImageIcon;
import libreria.Lib;
import libreria.Coloreando;
import java.awt.Color;

public class DlgProducto extends JDialog implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tlbProducto;

	// Declaracion global
	int tipoOperacion;
	
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
					DlgProducto dialog = new DlgProducto();
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
	public DlgProducto() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Mantenimiento | Productos");
		setBounds(100, 100, 825, 520);
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("Adicionar", new ImageIcon("imagenes/adicionar.png"));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar", new ImageIcon("imagenes/consultar.png"));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(170, 446, 150, 25);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar", new ImageIcon("imagenes/modificar.png"));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(330, 446, 150, 25);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar", new ImageIcon("imagenes/eliminar.png"));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(490, 446, 150, 25);
		getContentPane().add(btnEliminar);
		
		btnSalir = new JButton("salir", new ImageIcon("imagenes/delete.gif"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(650, 446, 150, 25);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tlbProducto = new JTable();
		tlbProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tlbProducto.setModel(Proyecto_AED.ap);
		tlbProducto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tlbProducto.setFillsViewportHeight(true);
		tlbProducto.getSelectionModel().setSelectionInterval(0, 0);
		tlbProducto.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tlbProducto);
		
		ajustarAnchoColumnas();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = 0;
		lanzarFormulario();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		try{	
			tipoOperacion = 1;
			lanzarFormulario();
		}
		catch(Exception e){
			Lib.mensaje(this, "Seleccione un registro");
		}
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		try{
			tipoOperacion = 2;
			lanzarFormulario();
		}
		catch(Exception e){
			Lib.mensaje(this, "Seleccione un registro");
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		try{
			tipoOperacion = 3;
			lanzarFormulario();
		}
		catch(Exception e){
			Lib.mensaje(this, "Seleccione un registro");
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		Proyecto_AED.ap.grabarProducto();
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		Proyecto_AED.ap.grabarProducto();
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
	}
	// Metodos tipo void sin parametros
	void lanzarFormulario(){
		DlgProductoActividad dpa = new DlgProductoActividad();
		dpa.setTipoOperacion(tipoOperacion);
		dpa.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dpa.configurarFormulario();
		dpa.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dpa.cargarProducto(Proyecto_AED.ap.obtener(tlbProducto.getSelectedRow()));
		dpa.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tlbProducto.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // codigoProducto
		tcm.getColumn(1).setPreferredWidth(anchoColumna(40)); // detalle
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25)); // stock
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25)); // precioUnitario
	}
	//  Métodos que retornan valor (sin parámetros)
	String obtenerTitulo() {
		String titulo[] = { "Adicionar", "Consultar" , "Modificar", "Eliminar" };
		return titulo[tipoOperacion];
	}
	//  Métodos que retornan valor con parámetros
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}
