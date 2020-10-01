package clases;

public class Boleta {
	// Atributos privados
	private int codigoBoleta, codigoIngreso;
	private double pagoTotal, pagoIngresoConsumo, pagoHospedaje;
	// Constructor
	public Boleta(int codigoBoleta, int codigoIngreso, double pagoTotal,double pagoIngresoConsumo, double pagoHospedaje){
		this.codigoBoleta = codigoBoleta;
		this.codigoIngreso = codigoIngreso;
		this.pagoTotal = pagoTotal;
		this.pagoIngresoConsumo = pagoIngresoConsumo;
		this.pagoHospedaje = pagoHospedaje;
	}
	// Metodos de acceso público: set/get
	public int getCodigoBoleta() {
		return codigoBoleta;
	}
	public void setCodigoBoleta(int codigoBoleta) {
		this.codigoBoleta = codigoBoleta;
	}
	public int getCodigoIngreso() {
		return codigoIngreso;
	}
	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}
	public double getPagoTotal() {
		return pagoTotal;
	}
	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	public double getPagoIngresoConsumo() {
		return pagoIngresoConsumo;
	}
	public void setPagoIngresoConsumo(double pagoIngresoConsumo) {
		this.pagoIngresoConsumo = pagoIngresoConsumo;
	}
	public double getPagoHospedaje() {
		return pagoHospedaje;
	}
	public void setPagoHospedaje(double pagoHospedaje) {
		this.pagoHospedaje = pagoHospedaje;
	}
}