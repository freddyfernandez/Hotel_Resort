package arreglos;

import clases.Producto;
import libreria.Lib;
import java.util.ArrayList;
import java.io.*;
import javax.swing.table.AbstractTableModel;

public class ArregloProducto extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	// Atributo privado
	private ArrayList <Producto> pro;
	// Constructor
	public ArregloProducto(){
		pro = new ArrayList <Producto> ();
		cargarProductos();
	}
	// Operaciones publicas basicas
	public void adicionar(Producto p){
		pro.add(p);
		actualizar();
	}
	public int tamaño(){
		return pro.size();
	}
	public Producto obtener(int pos){
		return pro.get(pos);
	}
	public void eliminar(Producto x){
		pro.remove(x);
		actualizar();
	}
	public Producto buscar(int codigo){
		Producto x;
		for (int i=0; i<tamaño(); i++){
			x=obtener(i);
			if (x.getCodigoProducto() == codigo)
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
			return 20001;
		else
			return obtener(tamaño()-1).getCodigoProducto() + 1;
	}
	public void grabarProducto(){
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("productos.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoProducto() + ";" +
						x.getDetalle()        + ";" +
						x.getStock()          + ";" +
						x.getPrecioUnitario();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias	
	private void cargarProductos(){
		try {
			BufferedReader br;
			String linea, detalle;
			String[] s;
			int codigoProducto, stock;
			double precioUnitario;
			br = new BufferedReader(new FileReader("productos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				detalle = s[1].trim();
				stock = Integer.parseInt(s[2].trim());
				precioUnitario = Double.parseDouble(s[3].trim());
				adicionar(new Producto(codigoProducto, detalle, stock, precioUnitario));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO", "DETALLE", "STOCK", "PRECIO UNITARIO"};
	public int getRowCount() {
		return pro.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {	
		Producto x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigoProducto();
			case 1:
				return x.getDetalle();
			case 2:
				return x.getStock();
			default:
				return Lib.dosDecimales(x.getPrecioUnitario());
		}
	}
}
