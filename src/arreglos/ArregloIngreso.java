package arreglos;

import clases.Ingreso;
import java.util.ArrayList;
import libreria.Lib;
import java.io.*;
import javax.swing.table.AbstractTableModel;

public class ArregloIngreso extends AbstractTableModel  {

	private static final long serialVersionUID = 1L;
	
	// Atributo privado
	private ArrayList <Ingreso> ing;
	// Constructor
	public ArregloIngreso(){
		ing = new ArrayList <Ingreso> ();
		cargarIngreso();
	}
	// Operaciones publicas basicas
	public void adicionar(Ingreso i){
		ing.add(i);
		actualizar();
	}
	public int tamaño(){
		return ing.size();
	}
	public Ingreso obtener(int pos){
		return ing.get(pos);
	}
	public void eliminar(Ingreso x){
		ing.remove(x);
		actualizar();
	}
	public Ingreso buscar(int codigo){
		Ingreso x;
		for (int i=0; i<tamaño();i++){
			x = obtener(i);
			if (x.getCodigoIngreso() == codigo)
				return x;
		}
		return null;
	}
	// Operaciones publicas complementarias
	public void actualizar(){
		fireTableDataChanged();
	}
	public int codigoCorrelativo(){
		if (tamaño() == 0)
			return 40001;
		else
			return obtener(tamaño()-1).getCodigoIngreso() + 1;
	}
	public boolean procedeCodigoSocio(int codigoSocio) {
		for (int i=tamaño()-1; i>=0; i--)
			if (obtener(i).getCodigoSocio() == codigoSocio)
				if (obtener(i).getEstado() == 0)
					return false;
				else
					return true;
		return true;
	}
	public void grabarIngreso(){
		try {
			PrintWriter pw;
			String linea;
			Ingreso x;
			pw = new PrintWriter(new FileWriter("ingreso.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoIngreso()   + ";" +
						x.getCodigoSocio()     + ";" +
						x.getFechaIngreso()    + ";" +
						x.getHoraIngreso()     + ";" +
						x.getNumeroInvitados() + ";" +
						x.getCostoIngreso()    + ";" +
						x.getEstado()          + ";" + 
						x.getCodigoBoleta();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias	
	private void cargarIngreso(){
		try {
			BufferedReader br;
			String linea, fechaIngreso, horaIngreso;
			String[] s;
			int codigoIngreso, codigoSocio, numeroInvitados, estado, codigoBoleta;
			double costoIngreso;
			br = new BufferedReader(new FileReader("ingreso.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoIngreso = Integer.parseInt(s[0].trim());
				codigoSocio = Integer.parseInt(s[1].trim());
				fechaIngreso = s[2].trim();
				horaIngreso = s[3].trim();
				numeroInvitados = Integer.parseInt(s[4].trim());
				costoIngreso = Double.parseDouble(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				codigoBoleta = Integer.parseInt(s[7].trim());
				adicionar(new Ingreso(codigoIngreso, codigoSocio, fechaIngreso, horaIngreso, 
						              numeroInvitados, costoIngreso, estado, codigoBoleta));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CODIGO INGRESO", "CODIGO SOCIO", "FECHA INGRESO", "HORA INGRESO", 
										"NUMERO INVITADOS", "COSTO INGRESO", "ESTADO"};
	public int getRowCount() {
		return ing.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {	
		Ingreso x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigoIngreso();
			case 1:
				return x.getCodigoSocio();
			case 2:
				return x.getFechaIngreso();
			case 3:
				return x.getHoraIngreso();
			case 4:
				return x.getNumeroInvitados();
			case 5:
				return x.getCostoIngreso();
			default:
				return Lib.tiposDeEstado[x.getEstado()];
		}
	}
}