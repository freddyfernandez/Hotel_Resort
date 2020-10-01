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
import clases.Hospedaje;
import clases.Ingreso;
import clases.Socio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgHospedajesPagados extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JTable tblHospedajesPagados;
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
	public DlgHospedajesPagados() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setResizable(false);
		setTitle("Reporte | Ingresos y Consumos Pendientes");
		setBounds(100, 100, 815, 511);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblHospedajesPagados = new JTable();
		tblHospedajesPagados.setEnabled(false);
		tblHospedajesPagados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblHospedajesPagados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHospedajesPagados.setFillsViewportHeight(true);
		tblHospedajesPagados.getSelectionModel().setSelectionInterval(0, 0);
		
		scrollPane.setViewportView(tblHospedajesPagados);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo Hospedaje");
		modelo.addColumn("Codigo de Socio");
		modelo.addColumn("Nombre Socio");
		modelo.addColumn("Apellidos Socio");
		modelo.addColumn("Fecha ingreso");
		modelo.addColumn("Fecha Salida");
		modelo.addColumn("Total Pagado");
		tblHospedajesPagados.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 446, 150, 25);
		getContentPane().add(btnAceptar);
		
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		dispose();
	}
	// Listar
   	void listar() {
   		Hospedaje ho;
   		Ingreso in;
   		Socio so;
   		Boleta bo;
		modelo.setRowCount(0);
		for (int i=0; i<Proyecto_AED.ah.tama�o(); i++) {
			ho = Proyecto_AED.ah.obtener(i);
			if (ho.getEstado() == 1){
				in = Proyecto_AED.ai.buscar(ho.getCodigoIngreso());
				so = Proyecto_AED.as.buscar(in.getCodigoSocio());
				bo = Proyecto_AED.bo.buscar(in.getCodigoBoleta());
				Object fila[] = { ho.getCodigoHospedaje(),
						          in.getCodigoSocio(),
						          so.getNombres(),
						          so.getApellidos(),
						          in.getFechaIngreso(),
						          ho.getFechaSalida(),
						          bo.getPagoHospedaje() };
				modelo.addRow(fila);
			}
		}
	}
}