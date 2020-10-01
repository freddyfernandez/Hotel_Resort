package guis;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableColumnModel;

import clases.Hospedaje;
import libreria.Coloreando;
import libreria.Lib;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgHospedajes extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	private JButton btnPagar;
	private JButton btnSalir;
	private JTable tblHospedajes;
	
	// Declaracion Global
	Hospedaje hospedaje;

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
					DlgHospedajes dialog = new DlgHospedajes();
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
	public DlgHospedajes() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Pago | Hospedajes");
		setBounds(100, 100, 824, 517);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblHospedajes = new JTable();
		tblHospedajes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblHospedajes.setModel(Proyecto_AED.ah);
		tblHospedajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHospedajes.setFillsViewportHeight(true);
		tblHospedajes.getSelectionModel().setSelectionInterval(0, 0);
		tblHospedajes.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tblHospedajes);
		
		btnPagar = new JButton("Pagar", new ImageIcon("imagenes/pagar.gif"));
		btnPagar.addActionListener(this);
		btnPagar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnPagar);
		
		btnSalir = new JButton("Salir",  new ImageIcon("imagenes/delete.gif"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(650, 446, 150, 25);
		getContentPane().add(btnSalir);
		
		ajustarAnchoColumnas();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnPagar) {
			actionPerformedBtnPagar(arg0);
		}
	}
	protected void actionPerformedBtnPagar(ActionEvent arg0) {
		try{	
			if (Proyecto_AED.ah.obtener(tblHospedajes.getSelectedRow()).getEstado() == 0){
				hospedaje = Proyecto_AED.ah.obtener(tblHospedajes.getSelectedRow());
				lanzarFormulario();
			}
			else{
				Lib.mensaje(this, "Este hospedaje ya se pago");
			}
		}
		catch(Exception e){
			Lib.mensaje(this, "Seleccione un registro");
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
		DlgHospedajesActividad dha = new DlgHospedajesActividad();
		dha.setHospedaje(hospedaje);
		dha.setTitle(this.getTitle() + " | " + "Pagar hospedajes");
		dha.setLocationRelativeTo(this);
		dha.cargarHospedajes(Proyecto_AED.ah.obtener(tblHospedajes.getSelectedRow()));
		dha.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblHospedajes.getColumnModel();
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
