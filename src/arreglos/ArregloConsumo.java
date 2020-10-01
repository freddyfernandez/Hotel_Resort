package arreglos;

import clases.Consumo;
import java.io.*;
import java.util.ArrayList;

public class ArregloConsumo {
	//  Atributos privados
	private ArrayList <Consumo> con;
	private String numeroConsumo;
	//  Constructor
    public ArregloConsumo(String numeroConsumo) {
    	this.numeroConsumo = numeroConsumo;
    	con = new ArrayList <Consumo> ();
		cargarConsumo();
    }
	// Operaciones públicas basicas
	public void adicionar(Consumo c){
		con.add(c);
	}
	public int tamaño(){
		return con.size();
	}
	public Consumo obtener(int i) {
		return con.get(i);
	}
	public void eliminar(Consumo x){
		con.remove(x);
	}
	public Consumo buscar(int codigoProducto){
		Consumo x;
		for (int i=0; i<tamaño(); i++){
			x = obtener(i);
			if (x.getCodigoProducto() == codigoProducto)
				return x;
		}
		return null;
	}
	// Operaciones publicas complementarias
	public void grabarConsumo() {
		try {
			PrintWriter pw;
			String linea;
			Consumo x;
			pw = new PrintWriter(new FileWriter(numeroConsumo + ".txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoProducto() + ";" +
						x.getCantidad()       + ";" +
						x.getPrecioUnitario();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias
	private void cargarConsumo() {
		try {
			BufferedReader br;
			String linea; 
			String[] s;
			int codigoProducto, cantidad;
			double precioUnitario;
			br = new BufferedReader(new FileReader(numeroConsumo + ".txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				cantidad = Integer.parseInt(s[1].trim());
				precioUnitario = Double.parseDouble(s[2].trim());
				adicionar(new Consumo(codigoProducto, cantidad, precioUnitario));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
