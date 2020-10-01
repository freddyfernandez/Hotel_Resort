package arreglos;

import clases.Hospedaje;
import java.util.ArrayList;
import libreria.Lib;
import java.io.*;
import javax.swing.table.AbstractTableModel;

public class ArregloHospedaje extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	// Atributo privado
	private ArrayList <Hospedaje> hos;
	// Constructor
	public ArregloHospedaje(){
		hos = new ArrayList <Hospedaje> ();
		cargarHospedaje();
	}
	// Operaciones publicas basicas
	public void adicionar(Hospedaje h){
		hos.add(h);
		actualizar();
	}
	public int tamaño(){
		return hos.size();
	}
	public Hospedaje obtener(int pos){
		return hos.get(pos);
	}
	public void eliminar(Hospedaje x){
		hos.remove(x);
		actualizar();
	}
	public Hospedaje buscar(int codigo){
		Hospedaje x;
		for (int i=0; i<tamaño(); i++){
			x = obtener(i);
			if (x.getCodigoHospedaje() == codigo)
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
			return 50001;
		else
			return obtener(tamaño()-1).getCodigoHospedaje() + 1;
	}
	public boolean procedeCodigoIngreso(int codigoIngreso) {
		for (int i=tamaño()-1; i>=0; i--)
			if (obtener(i).getCodigoIngreso() == codigoIngreso)
				if (obtener(i).getEstado() == 0)
					return false;
				else
					return false;
		return true;
	}
	public void grabarHospedaje(){
		try {
			PrintWriter pw;
			String linea;
			Hospedaje x;
			pw = new PrintWriter(new FileWriter("hospedaje.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoHospedaje() + ";" +
						x.getCodigoIngreso()   + ";" +
						x.getNumeroBungalow()  + ";" +
						x.getFechaSalida()     + ";" +
						x.getHoraSalida()      + ";" +
						x.getCostoHospedaje()  + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias	
	private void cargarHospedaje(){
		try {
			BufferedReader br;
			String linea, fechaSalida, horaSalida;
			String[] s;
			int codigoHospedaje, codigoIngreso, numeroBungalow, estado;
			double costoHospedaje;
			br = new BufferedReader(new FileReader("hospedaje.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoHospedaje = Integer.parseInt(s[0].trim());
				codigoIngreso = Integer.parseInt(s[1].trim());
				numeroBungalow = Integer.parseInt(s[2].trim());
				fechaSalida = s[3].trim();
				horaSalida = s[4].trim();
				costoHospedaje = Double.parseDouble(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionar(new Hospedaje(codigoHospedaje, codigoIngreso, numeroBungalow, 
										fechaSalida, horaSalida, costoHospedaje, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CODIGO HOSPEDAJE", "CODIGO INGRESO", "NUMERO BUNGALOW", "FECHA SALIDA", 
										"HORA SALIDA", "COSTO HOSPEDAJE", "ESTADO"};
	public int getRowCount() {
		return hos.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {	
		Hospedaje x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigoHospedaje();
			case 1:
				return x.getCodigoIngreso();
			case 2:
				return x.getNumeroBungalow();
			case 3:
				return x.getFechaSalida();
			case 4:
				return x.getHoraSalida();
			case 5:
				return x.getCostoHospedaje();
			default:
				return Lib.tiposDeEstado[x.getEstado()];
		}
	}
}