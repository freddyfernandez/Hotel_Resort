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
import clases.Ingreso;
import libreria.Coloreando;
import libreria.Lib;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgIngresosYConsumos extends JDialog implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnPagar;
	private JButton btnSalir;
	private JTable tblIngresosConsumos;
	
	// Declaracion Global
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
					DlgIngresosYConsumos dialog = new DlgIngresosYConsumos();
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
	public DlgIngresosYConsumos() {
		getContentPane().setBackground(new Color(255, 248, 220));
		addWindowListener(this);
		setResizable(false);
		setTitle("Pago | Ingresos y Consumos");
		setBounds(100, 100, 824, 519);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblIngresosConsumos = new JTable();
		tblIngresosConsumos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblIngresosConsumos.setModel(Proyecto_AED.ai);
		tblIngresosConsumos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIngresosConsumos.setFillsViewportHeight(true);
		tblIngresosConsumos.getSelectionModel().setSelectionInterval(0, 0);
		tblIngresosConsumos.setDefaultRenderer(Object.class, new Coloreando());
		
		scrollPane.setViewportView(tblIngresosConsumos);
		
		btnPagar = new JButton("Pagar", new ImageIcon("imagenes/pagar.gif"));
		btnPagar.addActionListener(this);
		btnPagar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnPagar);
		
		btnSalir = new JButton("salir", new ImageIcon("imagenes/aceptar.png"));
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
			if (Proyecto_AED.ai.obtener(tblIngresosConsumos.getSelectedRow()).getEstado() == 0){
				ingreso = Proyecto_AED.ai.obtener(tblIngresosConsumos.getSelectedRow());
				lanzarFormulario();
			}
			else{
				Lib.mensaje(this, "Este ingreso ya se pago");
			}
		}
		catch(Exception e){
			Lib.mensaje(this, "Seleccione un registro");
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		Proyecto_AED.ai.grabarIngreso();
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		Proyecto_AED.ai.grabarIngreso();
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
		DlgIngresosYConsumosActividad dica = new DlgIngresosYConsumosActividad();
		dica.setIngreso(ingreso);
		dica.setTitle(this.getTitle() + " | " + "Pagar ingresos y consumos");
		dica.setLocationRelativeTo(this);
		dica.cargarIngresosConsumos(Proyecto_AED.ai.obtener(tblIngresosConsumos.getSelectedRow()));
		dica.setVisible(true);
	}
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblIngresosConsumos.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(16)); // codigoIngreso
		tcm.getColumn(1).setPreferredWidth(anchoColumna(14)); // codigoSocio
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15)); // fechaIngreso
		tcm.getColumn(3).setPreferredWidth(anchoColumna(14)); // horaIngreso
		tcm.getColumn(4).setPreferredWidth(anchoColumna(16)); // numeroInvitados
		tcm.getColumn(5).setPreferredWidth(anchoColumna(15)); // costoIngreso
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10)); // estado
	}
	// Métodos que retornan valor con parámetros
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}