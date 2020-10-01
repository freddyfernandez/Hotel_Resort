package clases;

public class Hospedaje {
	// Atributos privados
	private int codigoHospedaje, codigoIngreso, numeroBungalow, estado;
	private String fechaSalida, horaSalida;
	private double costoHospedaje;
	// Constructor
	public Hospedaje(int codigoHospedaje, int codigoIngreso, int numeroBungalow, 
					 String fechaSalida, String horaSalida, double costoHospedaje, int estado){
		this.codigoHospedaje = codigoHospedaje;
		this.codigoIngreso = codigoIngreso;
		this.numeroBungalow = numeroBungalow;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.costoHospedaje = costoHospedaje;
		this.estado = estado;
	}
	// Metodos de acceso público: set/get
	public int getCodigoHospedaje() {
		return codigoHospedaje;
	}
	public void setCodigoHospedaje(int codigoHospedaje) {
		this.codigoHospedaje = codigoHospedaje;
	}
	public int getCodigoIngreso() {
		return codigoIngreso;
	}
	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}
	public int getNumeroBungalow() {
		return numeroBungalow;
	}
	public void setNumeroBungalow(int numeroBungalow) {
		this.numeroBungalow = numeroBungalow;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public double getCostoHospedaje() {
		return costoHospedaje;
	}
	public void setCostoHospedaje(double costoHospedaje) {
		this.costoHospedaje = costoHospedaje;
	}
}
