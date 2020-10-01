package clases;

public class Bungalow {
	// Atributos privados
	private int numeroBungalow, categoria, estado;
	private double precioDia;
	// Constructor
	public Bungalow(int numeroBungalow, int categoria, double precioDia, int estado){
		this.numeroBungalow = numeroBungalow;
		this.categoria = categoria;
		this.precioDia = precioDia;
		this.estado = estado;
	}
	// Metodos de acceso público: set/get
	public int getNumeroBungalow() {
		return numeroBungalow;
	}
	public void setNumeroBungalow(int numeroBungalow) {
		this.numeroBungalow = numeroBungalow;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public double getPrecioDia() {
		return precioDia;
	}
	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
}
