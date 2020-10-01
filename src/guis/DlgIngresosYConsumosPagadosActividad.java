package guis;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.UIManager;
import clases.Consumo;
import clases.Ingreso;
import clases.Producto;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloConsumo;
import java.awt.Color;

public class DlgIngresosYConsumosPagadosActividad extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTable tblConsumosProductos;
	private DefaultTableModel modelo;

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
					DlgIngresosYConsumosPendientesActividad dialog = new DlgIngresosYConsumosPendientesActividad();
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
	public DlgIngresosYConsumosPagadosActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 817, 517);
		getContentPane().setLayout(null);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 445, 150, 25);
		getContentPane().add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 791, 424);
		getContentPane().add(scrollPane);
		
		tblConsumosProductos = new JTable();
		tblConsumosProductos.setEnabled(false);
		tblConsumosProductos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblConsumosProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblConsumosProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblConsumosProductos);
		tblConsumosProductos.getSelectionModel().setSelectionInterval(0, 0);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo Ingreso");
		modelo.addColumn("Codigo Producto");
		modelo.addColumn("Detalle Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Unitario");
		modelo.addColumn("Importe");
		tblConsumosProductos.setModel(modelo);
		
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		dispose();
	}
	// Listar
   	void listar() {
   		Ingreso in;
		modelo.setRowCount(0);
		for (int i=0; i<Proyecto_AED.ai.tamaño(); i++) {
			in = Proyecto_AED.ai.obtener(i);
			if (in.getEstado() == 1){
				ArregloConsumo ac = new ArregloConsumo(String.valueOf(in.getCodigoIngreso()));
				Consumo co;
				double importePago;
				for (int c=0; c<ac.tamaño(); c++){
					co = ac.obtener(c);
					importePago = co.getCantidad() * co.getPrecioUnitario();
					Producto pr = Proyecto_AED.ap.buscar(co.getCodigoProducto());
					Object fila[] = { in.getCodigoIngreso(),
							          co.getCodigoProducto(),
							          pr.getDetalle(),
							          co.getCantidad(),
							          co.getPrecioUnitario(),
							          formato(importePago)};
					modelo.addRow(fila);
				}
			}
		}
	}
   	// Metodos tipo void con parametros
	String formato(double real) {
		return String.format(Locale.US, "%-10.2f", real);
	}
}