package guis;

import libreria.*;
import clases.Bungalow;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgBungalowActividad extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNumero;
	private JLabel lblCategoria;
	private JLabel lblPrecioDia;
	private JLabel lblEstado;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JComboBox <String> cboCategoria;
	private JComboBox <String> cboEstado;

	// Atributos privados
	private int tipoOperacion;	
	
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
					DlgBungalowActividad dialog = new DlgBungalowActividad();
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
	public DlgBungalowActividad() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 307, 254);
		getContentPane().setLayout(null);
		
		lblNumero = new JLabel("CODIGO");
		lblNumero.setBounds(10, 13, 57, 20);
		getContentPane().add(lblNumero);
		
		lblNumero = new JLabel();
		lblNumero.setBounds(155, 11, 135, 22);
		getContentPane().add(lblNumero);
		
		lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setBounds(10, 49, 81, 20);
		getContentPane().add(lblCategoria);
		
		lblPrecioDia = new JLabel("PRECIO DIA");
		lblPrecioDia.setBounds(10, 84, 71, 20);
		getContentPane().add(lblPrecioDia);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 120, 81, 20);
		getContentPane().add(lblEstado);
		
		btnAceptar = new JButton("Aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 190, 135, 25);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(155, 190, 135, 25);
		getContentPane().add(btnVolver);
		
		lblPrecioDia = new JLabel();
		lblPrecioDia.setText(String.valueOf(100.0));
		lblPrecioDia.setBounds(156, 83, 135, 22);
		getContentPane().add(lblPrecioDia);
		
		cboCategoria = new JComboBox <String> ();
		cboCategoria.addActionListener(this);
		cboCategoria.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeCategoria));
		cboCategoria.setBounds(156, 44, 135, 25);
		getContentPane().add(cboCategoria);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setEnabled(false);
		cboEstado.addActionListener(this);
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstadoBungalow));
		cboEstado.setBounds(156, 115, 135, 25);
		getContentPane().add(cboEstado);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == cboCategoria) {
			actionPerformedCboCategoria(arg0);
		}
	}
	protected void actionPerformedCboCategoria(ActionEvent arg0) {
		switch (leerCategoria()){
			case 0:
				lblPrecioDia.setText(String.valueOf(100.0));
				break;
			case 1:
				lblPrecioDia.setText(String.valueOf(200.0));
				break;
			default:
				lblPrecioDia.setText(String.valueOf(500.0));
				break;
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarBungalow(true);	
				break;
			case 1:
				consultarBungalow();
				break;
			case 2:
				adicionarModificarBungalow(false);
				break;
			default:
				eliminarBungalow();
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	//  Adiciona o Modifica un nuevo bungaloww
	void adicionarModificarBungalow(boolean adicionar) {	
		if (adicionar){
			Bungalow nuevo = new Bungalow(leerNumero(), leerCategoria(), leerPrecioDia(), leerEstado());
			Proyecto_AED.ab.adicionar(nuevo);
			Lib.mensaje(this,"Su Bungalow ha sido adicionado");
		}
		else {
			Bungalow x = Proyecto_AED.ab.buscar(leerNumero());
			x.setCategoria(leerCategoria());
			x.setPrecioDia(leerPrecioDia());
			x.setEstado(leerEstado());
			Proyecto_AED.ab.actualizar();
			Lib.mensaje(this,"Su Bungalow ha sido modificado");
		}
		dispose();
	}
	// Consultar Bungalow en curso
	void consultarBungalow(){
		dispose();
	}
	// Eliminar el bungalow en curso
	void eliminarBungalow(){
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Bungalow?");
		if (ok == 0){
			Bungalow x = Proyecto_AED.ab.buscar(leerNumero());
			Proyecto_AED.ab.eliminar(x);
			Lib.mensaje(this,"El Bungalow ha sido eliminado");
			dispose();
		}
	}
	// Establece el tipo de operacion a efectuar
	void setTipoOperacion(int tipoOperacion){
		this.tipoOperacion = tipoOperacion;
	}
	// Cargar los datos de un Bungalow
	void cargarBungalow(Bungalow x){
		lblNumero.setText(String.valueOf(x.getNumeroBungalow()));
		cboCategoria.setSelectedIndex(x.getCategoria());
		lblPrecioDia.setText(String.valueOf(x.getPrecioDia()));
		cboEstado.setSelectedIndex(x.getEstado());
	}
	// Configura el formulario para la operación a efectuar
	void configurarFormulario(){
		switch (tipoOperacion){
			case 0:
				mostrarNumeroCorrelativo();
				habilitarCajasDeTexto(true);
				break;
			case 1:
				btnVolver.setVisible(false);
				habilitarCajasDeTexto(false);
				break;
			case 2:
				habilitarCajasDeTexto(true);
				break;
			default:
				habilitarCajasDeTexto(false);
		}
	}
	// Muestra el numero correlativo
	void mostrarNumeroCorrelativo(){
		lblNumero.setText(String.valueOf(Proyecto_AED.ab.numeroCorrelativo()));
	}
	// Habilita o desabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino){
		cboCategoria.setEnabled(sino);
	}
	// Metodos que retornan valor sin parametros
	int leerNumero(){
		return Integer.parseInt(lblNumero.getText().trim());
	}
	int leerCategoria(){
		return cboCategoria.getSelectedIndex();
	}
	double leerPrecioDia(){
		return Double.parseDouble(lblPrecioDia.getText().trim());
	}
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
}
