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
import javax.swing.table.DefaultTableModel;

import clases.Boleta;
import clases.Ingreso;
import clases.Socio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgIngresosYConsumosPagados extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JTable tblIngresosConsumosPagados;
	private DefaultTableModel modelo;
	private JButton btnProductos;
	
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
					DlgIngresosYConsumosPendientes dialog = new DlgIngresosYConsumosPendientes();
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
	public DlgIngresosYConsumosPagados() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setResizable(false);
		setTitle("Reporte | Ingresos y Consumos Pendientes");
		setBounds(100, 100, 815, 511);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblIngresosConsumosPagados = new JTable();
		tblIngresosConsumosPagados.setEnabled(false);
		tblIngresosConsumosPagados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblIngresosConsumosPagados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIngresosConsumosPagados.setFillsViewportHeight(true);
		tblIngresosConsumosPagados.getSelectionModel().setSelectionInterval(0, 0);
		
		scrollPane.setViewportView(tblIngresosConsumosPagados);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código de Ingreso");
		modelo.addColumn("Codigo de Socio");
		modelo.addColumn("Nombre Socio");
		modelo.addColumn("Apellidos Socio");
		modelo.addColumn("Total Pagado");
		tblIngresosConsumosPagados.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAceptar);
		
		btnProductos = new JButton("Productos", new ImageIcon("imagenes/pagar.gif"));
		btnProductos.addActionListener(this);
		btnProductos.setBounds(170, 446, 150, 25);
		getContentPane().add(btnProductos);
		
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProductos) {
			actionPerformedBtnProductos(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnProductos(ActionEvent arg0) {
		lanzarFormulario();
	}
	// Listar
   	void listar() {
   		Ingreso in;
   		Socio so;
   		Boleta bo;
		modelo.setRowCount(0);
		for (int i=0; i<Proyecto_AED.ai.tamaño(); i++) {
			in = Proyecto_AED.ai.obtener(i);
			if (in.getEstado() == 1){
				so = Proyecto_AED.as.buscar(in.getCodigoSocio());
				bo = Proyecto_AED.bo.buscar(in.getCodigoBoleta());
				Object fila[] = { in.getCodigoIngreso(),
						          in.getCodigoSocio(),
						          so.getNombres(),
						          so.getApellidos(),
						          bo.getPagoIngresoConsumo() };
				modelo.addRow(fila);
			}
		}
	}
	// Metodos tipo void sin parametros
	void lanzarFormulario(){
		DlgIngresosYConsumosPagadosActividad dicpa = new DlgIngresosYConsumosPagadosActividad();
		dicpa.setTitle(this.getTitle() + " | " + "Lista Productos");
		dicpa.setLocationRelativeTo(this);
		dicpa.setVisible(true);
	}
}
