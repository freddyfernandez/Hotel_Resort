package clases;

public class Consumo {
	// Atributos privados
	private int codigoProducto, cantidad;
	private double precioUnitario;
	// Constructor
	public Consumo(int codigoProducto, int cantidad, double precioUnitario){
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	// Metodos de acceso publico: set/get
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
