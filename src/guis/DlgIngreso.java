package guis;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import libreria.Lib;
import libreria.Coloreando;
import javax.swing.UIManager;
import java.awt.Color;
//import javax.swing.ImageIcon;

public class DlgIngreso extends JDialog implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnSalir;
	private JTable tblIngreso;

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
					DlgIngreso dialog = new DlgIngreso();
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
	public DlgIngreso() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Registro | Ingreso");
		setBounds(100, 100, 826, 522);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblIngreso = new JTable();
		tblIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblIngreso.setModel(Proyecto_AED.ai);
		tblIngreso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIngreso.setFillsViewportHeight(true);
		tblIngreso.getSelectionModel().setSelectionInterval(0, 0);
		tblIngreso.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tblIngreso);
		
		btnAdicionar = new JButton("Adicionar", null);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAdicionar);
		
		btnSalir = new JButton("salir", null);
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
		try{
			tipoOperacion = 0;
			lanzarFormulario();
		}
		catch(Exception e){
			Lib.mensaje(this, "Todos los SOCIOS tienen un ingreso \n Debe agregar un NUEVO socio o PAGAR el ingreso");
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		Proyecto_AED.ai.grabarIngreso();
		Proyecto_AED.bo.grabarBoleta();
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		Proyecto_AED.ai.grabarIngreso();
		Proyecto_AED.bo.grabarBoleta();
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
		DlgIngresoActividad dia = new DlgIngresoActividad();
		dia.setTipoOperacion(tipoOperacion);
		dia.setTitle(this.getTitle() + " | " + "Adicionar");
		dia.configurarFormulario();
		dia.setLocationRelativeTo(this);
		dia.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblIngreso.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(16)); // codigoIngreso
		tcm.getColumn(1).setPreferredWidth(anchoColumna(14)); // codigoSocio
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15)); // fechaIngreso
		tcm.getColumn(3).setPreferredWidth(anchoColumna(14)); // horaIngreso
		tcm.getColumn(4).setPreferredWidth(anchoColumna(16)); // numeroInvitados
		tcm.getColumn(5).setPreferredWidth(anchoColumna(15)); // costoIngreso
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10)); // estado
	}
	//  Métodos que retornan valor con parámetros
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}