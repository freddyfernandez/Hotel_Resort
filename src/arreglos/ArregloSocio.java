package arreglos;

import clases.Socio;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ArregloSocio extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	// Atributo privado
	private ArrayList <Socio> soc;
	// Constructor
	public ArregloSocio(){
		soc = new ArrayList <Socio> ();
		cargarSocios();
	}
	// Operacione p�blicas basicas
	public void adicionar(Socio s){
		soc.add(s);
		actualizar();
	}
	public int tama�o(){
		return soc.size();
	}
	public Socio obtener(int pos){
		return soc.get(pos);
	}
	public void eliminar(Socio x){
		soc.remove(x);
		actualizar();
	}
	public Socio buscar(int codigo){
		Socio x;
		for (int i=0; i<tama�o(); i++){
			x = obtener(i);
			if (x.getCodigoSocio() == codigo)
				return x;
		}
		return null;
	}
	// Operaciones p�blicas complementarias
	public void actualizar(){
		fireTableDataChanged();
	}
	public int codigoCorrelativo(){
		if (tama�o() == 0)
			return 10001;
		else
			return obtener(tama�o()-1).getCodigoSocio() + 1;
	}
	public void grabarSocios(){
		try {
			PrintWriter pw;
			String linea;
			Socio x;
			pw = new PrintWriter(new FileWriter("socios.txt"));
			for (int i=0; i<tama�o(); i++) {
				x = obtener(i);
				linea = x.getCodigoSocio() + ";" +
						x.getNombres()     + ";" +
						x.getApellidos()   + ";" +
						x.getDni()         + ";" +
						x.getTelefono();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias
	private void cargarSocios(){
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni, telefono;
			String[] s;
			int codigoSocio;
			br = new BufferedReader(new FileReader("socios.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoSocio = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				telefono = s[4].trim();
				adicionar(new Socio(codigoSocio, nombres, apellidos, dni, telefono));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//  M�todos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "C�DIGO", "NOMBRE", "APELLIDOS", "DNI", "TELEFONO" };
	public int getRowCount() {
		return soc.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {	
		Socio x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigoSocio();
			case 1:
				return x.getNombres();
			case 2:
				return x.getApellidos();
			case 3:
				return x.getDni();
			default:
				return x.getTelefono();
		}
	}
}
