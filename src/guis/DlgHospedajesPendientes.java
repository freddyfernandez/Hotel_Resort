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

import clases.Bungalow;
import clases.Hospedaje;
import clases.Ingreso;
import clases.Socio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgHospedajesPendientes extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JTable tblHospedajesPendientes;
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
	public DlgHospedajesPendientes() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setResizable(false);
		setTitle("Reporte | Ingresos y Consumos Pendientes");
		setBounds(100, 100, 815, 511);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 790, 424);
		getContentPane().add(scrollPane);
		
		tblHospedajesPendientes = new JTable();
		tblHospedajesPendientes.setEnabled(false);
		tblHospedajesPendientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblHospedajesPendientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHospedajesPendientes.setFillsViewportHeight(true);
		tblHospedajesPendientes.getSelectionModel().setSelectionInterval(0, 0);
		
		scrollPane.setViewportView(tblHospedajesPendientes);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Hospedaje");
		modelo.addColumn("Codigo de Socio");
		modelo.addColumn("Nombre Socio");
		modelo.addColumn("Apellidos Socio");
		modelo.addColumn("Fecha ingreso");
		modelo.addColumn("Fecha Salida");
		modelo.addColumn("Costo actual");
		tblHospedajesPendientes.setModel(modelo);
		
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
   		Bungalow bu;
		modelo.setRowCount(0);
		for (int i=0; i<Proyecto_AED.ah.tamaño(); i++) {
			ho = Proyecto_AED.ah.obtener(i);
			if (ho.getEstado() == 0){
				in = Proyecto_AED.ai.buscar(ho.getCodigoIngreso());
				so = Proyecto_AED.as.buscar(in.getCodigoSocio());
				bu = Proyecto_AED.ab.buscar(ho.getNumeroBungalow());
				Object fila[] = { ho.getCodigoHospedaje(),
						          in.getCodigoSocio(),
						          so.getNombres(),
						          so.getApellidos(),
						          in.getFechaIngreso(),
						          ho.getFechaSalida(),
						          ho.getCostoHospedaje()+bu.getPrecioDia() };
				modelo.addRow(fila);
			}
		}
	}
}