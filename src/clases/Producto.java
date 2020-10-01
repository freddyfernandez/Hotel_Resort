package clases;

public class Producto {
	// Atributos Privados
	private int codigoProducto, stock;
	private String detalle;
	private double precioUnitario;
	// Constructor
	public Producto(int codigoProducto, String detalle, int stock, double preciounitario){
		this.codigoProducto = codigoProducto;
		this.detalle = detalle;
		this.stock =  stock;
		this.precioUnitario = preciounitario;
	}
	// Metodos de acceso públic: set/get
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
