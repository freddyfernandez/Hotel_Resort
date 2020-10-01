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

import libreria.Coloreando;
//import javax.swing.ImageIcon;
import libreria.Lib;
import java.awt.Color;

public class DlgHospedaje extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnSalir;
	private JTable tblHospedaje;

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
					DlgHospedaje dialog = new DlgHospedaje();
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
	public DlgHospedaje() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Registro | Hospedaje");
		setBounds(100, 100, 827, 521);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblHospedaje = new JTable();
		tblHospedaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblHospedaje.setModel(Proyecto_AED.ah);
		tblHospedaje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHospedaje.setFillsViewportHeight(true);
		tblHospedaje.getSelectionModel().setSelectionInterval(0, 0);
		tblHospedaje.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tblHospedaje);
		
		btnAdicionar = new JButton("Adicionar", new ImageIcon("imagenes/adicionar.png"));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAdicionar);
		
		btnSalir = new JButton("salir", new ImageIcon("imagenes/delete.gif"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(650, 446, 150, 25);
		getContentPane().add(btnSalir);
		
		ajustarAnchoColumnas();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		DlgHospedajeActividad dha = new DlgHospedajeActividad();
		if (dha.leerCantidadIngreso() <0)
			Lib.mensaje(this, "Todos los ingresos están alojados");
		else
			if (dha.leerCantidadBungalow() < 0)
				Lib.mensaje(this, "Todas los bungalow están ocupados");
			else{
				tipoOperacion = 0;
				lanzarFormulario();
			}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		Proyecto_AED.ah.grabarHospedaje();
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		Proyecto_AED.ah.grabarHospedaje();
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
		DlgHospedajeActividad dha = new DlgHospedajeActividad();
		dha.setTipoOperacion(tipoOperacion);
		dha.setTitle(this.getTitle() + " | " + "Adicionar");
		dha.configurarFormulario();
		dha.setLocationRelativeTo(this);
		dha.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblHospedaje.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(17)); // codigoHospedaje
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15)); // codigoIngreso
		tcm.getColumn(2).setPreferredWidth(anchoColumna(18)); // numeroBungalow
		tcm.getColumn(3).setPreferredWidth(anchoColumna(12)); // fechaSalida
		tcm.getColumn(4).setPreferredWidth(anchoColumna(12)); // horaSalida
		tcm.getColumn(5).setPreferredWidth(anchoColumna(16)); // costoIngreso
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10)); // estado
	}
	//  Métodos que retornan valor con parámetros
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}
