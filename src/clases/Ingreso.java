package clases;

public class Ingreso {
	// Atributos privados
	private int codigoIngreso, codigoSocio, numeroInvitados, estado, codigoBoleta;
	private String fechaIngreso, horaIngreso;
	private double costoIngreso;
	// Constructor
	public Ingreso(int codigoIngreso, int codigoSocio, String fechaIngreso, String horaIngreso, 
					int numeroInvitados, double costoIngreso, int estado, int codigoBoleta){
		this.codigoIngreso = codigoIngreso;
		this.codigoSocio = codigoSocio;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.numeroInvitados = numeroInvitados;
		this.costoIngreso = costoIngreso;
		this.estado = estado;
		this.codigoBoleta = codigoBoleta;
	}
	// Metodos de acceso publico: set/get
	public int getCodigoIngreso() {
		return codigoIngreso;
	}
	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}
	public int getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public int getNumeroInvitados() {
		return numeroInvitados;
	}
	public void setNumeroInvitados(int numeroInvitados) {
		this.numeroInvitados = numeroInvitados;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public double getCostoIngreso() {
		return costoIngreso;
	}
	public void setCostoIngreso(double costoIngreso) {
		this.costoIngreso = costoIngreso;
	}
	public int getCodigoBoleta() {
		return codigoBoleta;
	}
	public void setCodigoBoleta(int codigoBoleta) {
		this.codigoBoleta = codigoBoleta;
	}
}
