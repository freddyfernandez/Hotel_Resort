package arreglos;

import clases.Boleta;
import java.io.*;
import java.util.ArrayList;

public class ArregloBoleta {
	// Atributo privado
	private ArrayList <Boleta> bol;
	// Constructor
	public ArregloBoleta(){
		bol = new ArrayList <Boleta> ();
		cargarBoleta();
	}
	// Operaciones publicas basicas
	public void adicionar(Boleta b){
		bol.add(b);
	}
	public int tamaño(){
		return bol.size();
	}
	public Boleta obtener(int pos){
		return bol.get(pos);
	}
	public void eliminar(Boleta x){
		bol.remove(x);
	}
	public Boleta buscar(int codigo){
		Boleta x;
		for (int i=0; i<tamaño(); i++){
			x = obtener(i);
			if (x.getCodigoBoleta() == codigo)
				return x;
		}
		return null;
	}
	// Operaciones publicas complementarias
	public int codigoCorrelativo(){
		if (tamaño() == 0)
			return 60001;
		else
			return obtener(tamaño()-1).getCodigoBoleta() + 1;
	}
	public void grabarBoleta(){
		try {
			PrintWriter pw;
			String linea;
			Boleta x;
			pw = new PrintWriter(new FileWriter("boleta.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoBoleta()       + ";" +
						x.getCodigoIngreso()      + ";" +
						x.getPagoTotal()          + ";" +
						x.getPagoIngresoConsumo() + ";" +
						x.getPagoHospedaje();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	// Operaciones privadas complementarias	
	private void cargarBoleta(){
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoBoleta, codigoIngreso;
			double pagoTotal, pagoIngresoConsumo, pagoHospedaje;
			br = new BufferedReader(new FileReader("boleta.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoBoleta = Integer.parseInt(s[0].trim());
				codigoIngreso = Integer.parseInt(s[1].trim());
				pagoTotal = Double.parseDouble(s[2].trim());
				pagoIngresoConsumo = Double.parseDouble(s[3].trim());
				pagoHospedaje = Double.parseDouble(s[4].trim());
				adicionar(new Boleta(codigoBoleta, codigoIngreso, pagoTotal, pagoIngresoConsumo, pagoHospedaje));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}