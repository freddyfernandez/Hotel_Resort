package arreglos;

import clases.Bungalow;
import java.util.ArrayList;
import libreria.Lib;
import java.io.*;
import javax.swing.table.AbstractTableModel;

public class ArregloBungalow extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	// Atributo privado
	private ArrayList <Bungalow> bun;
	// Constructor
	public ArregloBungalow(){
		bun = new ArrayList <Bungalow> ();
		cargarBungalow();
	}
	// Operaciones públicas basicas
	public void adicionar(Bungalow b){
		bun.add(b);
		actualizar();
	}
	public int tamaño(){
		return bun.size();
	}
	public Bungalow obtener(int pos){
		return bun.get(pos);
	}
	public void eliminar(Bungalow x){
		bun.remove(x);
		actualizar();
	}
	public Bungalow buscar(int numero){
		Bungalow x;
		for (int i=0; i<tamaño(); i++){
			x = obtener(i);
			if (x.getNumeroBungalow() == numero)
				return x;
		}
		return null;
	}
	// Operaciones publicas complementarias
	public void actualizar(){
		fireTableDataChanged();
	}
	public int numeroCorrelativo(){
		if (tamaño() == 0)
			return 30001;
		else
			return obtener(tamaño()-1).getNumeroBungalow() + 1;
	}
	public void grabarBungalow(){
		try {
			PrintWriter pw;
			String linea;
			Bungalow x;
			pw = new PrintWriter(new FileWriter("bungalow.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getNumeroBungalow() + ";" +
						x.getCategoria()      + ";" +
						x.getPrecioDia()      + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias	
	private void cargarBungalow(){
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int numeroBungalow, categoria, estado;
			double precioDia;
			br = new BufferedReader(new FileReader("bungalow.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numeroBungalow = Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				precioDia = Double.parseDouble(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				adicionar(new Bungalow(numeroBungalow, categoria, precioDia, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "NUMERO BUNGALOW", "CATEGORIA", "PRECIO DIA", "ESTADO"};
	public int getRowCount() {
		return bun.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {	
		Bungalow x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getNumeroBungalow();
			case 1:
				return Lib.tiposDeCategoria[x.getCategoria()];
			case 2:
				return x.getPrecioDia();
			default:
				return Lib.tiposDeEstadoBungalow[x.getEstado()];
		}
	}
}
