package guis;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumnModel;
import javax.swing.UIManager;
//import javax.swing.ImageIcon;
import libreria.Lib;
import java.awt.Color;
import libreria.Coloreando;

public class DlgSocio extends JDialog implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblSocio;
	
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
					DlgSocio dialog = new DlgSocio();
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
	public DlgSocio() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Mantenimiento | Socios");
		setBounds(100, 100, 821, 520);
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("Adicionar", new ImageIcon("imagenes/adicionar.png"));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 447, 150, 25);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar", new ImageIcon("imagenes/consultar.png"));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(170, 447, 150, 25);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar", new ImageIcon("imagenes/modificar.png"));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(330, 447, 150, 25);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar", new ImageIcon("imagenes/eliminar.png"));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(490, 447, 150, 25);
		getContentPane().add(btnEliminar);
		
		btnSalir = new JButton("Salir",new ImageIcon("imagenes/delete.gif"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(650, 447, 150, 25);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 425);
		getContentPane().add(scrollPane);
		
		tblSocio = new JTable();
		tblSocio.setBackground(Color.WHITE);
		tblSocio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblSocio.setModel(Proyecto_AED.as);
		tblSocio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblSocio.setFillsViewportHeight(true);
		tblSocio.getSelectionModel().setSelectionInterval(0, 0);
		tblSocio.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tblSocio);
		
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
		Proyecto_AED.as.grabarSocios();
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		Proyecto_AED.as.grabarSocios();
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
		DlgSocioActividad dsa = new DlgSocioActividad();
		dsa.setTipoOperacion(tipoOperacion);
		dsa.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dsa.configurarFormulario();
		dsa.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dsa.cargarSocio(Proyecto_AED.as.obtener(tblSocio.getSelectedRow()));
		dsa.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblSocio.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // codigoSocio
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30)); // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(30)); // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15)); // dni
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15)); // telefono
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
