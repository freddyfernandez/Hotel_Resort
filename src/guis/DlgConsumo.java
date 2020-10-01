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

public class DlgConsumo extends JDialog implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnAtender;
	private JButton btnSalir;
	private JTable tblConsumo;

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
					DlgConsumo dialog = new DlgConsumo();
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
	public DlgConsumo() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Consumo ");
		setBounds(100, 100, 827, 519);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblConsumo = new JTable();
		tblConsumo.setFillsViewportHeight(true);
		tblConsumo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblConsumo.setModel(Proyecto_AED.ai);
		tblConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblConsumo.getSelectionModel().setSelectionInterval(0, 0);
		tblConsumo.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tblConsumo);
		
		btnAtender = new JButton("Atender", new ImageIcon("imagenes/atender.jpg"));
		btnAtender.addActionListener(this);
		btnAtender.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAtender);
		
		btnSalir = new JButton("Salir", new ImageIcon("imagenes/delete.gif"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(650, 446, 150, 25);
		getContentPane().add(btnSalir);
		
		ajustarAnchoColumnas();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnAtender) {
			actionPerformedBtnAtender(arg0);
		}
	}
	protected void actionPerformedBtnAtender(ActionEvent arg0) {
		try{
			lanzarFormulario();
		}
		catch(Exception e){
			Lib.mensaje(this, "Seleccione un registro");
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
		DlgConsumoActividad dca = new DlgConsumoActividad();
		dca.setTitle(this.getTitle() + " | " + "Atender");
		dca.setLocationRelativeTo(this);
		dca.cargarConsumo(Proyecto_AED.ai.obtener(tblConsumo.getSelectedRow()));
		dca.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblConsumo.getColumnModel();
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
