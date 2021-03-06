package biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;

import excepciones.DireccionInvalidaException;
import excepciones.IdInvalidoException;
import excepciones.NombreInvalidoException;

@Entity
public class Lector implements Comparable<Lector> {

@Column	private int numeroDeSocio;
@Column private String nombre;
@Column private String telefono;
@Column private String direccion;
		private Copia[] copiasRetiradas;
@Column	private Multa multa;
		private Prestamo[] prestamos;

	public Lector(int numeroSocio, String nombre, String telefono, String direccion)
			throws NombreInvalidoException, DireccionInvalidaException, IdInvalidoException {

		if (nombre.equals("") || nombre.equals(" ")) {

			throw new NombreInvalidoException("Ha ingresado un nombre invalido para el lector");
		}

		if (direccion.equals("") || direccion.equals(" ")) {

			throw new DireccionInvalidaException("Ha ingresado una direccion invalida para el lector");
		}

		if (numeroSocio < 0) {

			throw new IdInvalidoException("Ha ingresado un ID invalido para el lector");
		}

		this.numeroDeSocio = numeroSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.multa = null;

		this.prestamos = new Prestamo[3];

		this.copiasRetiradas = new Copia[3];

		for (int i = 0; i < this.copiasRetiradas.length; i++) {

			copiasRetiradas[i] = null;
			prestamos[i] = null;
		}
	}

	public int getNumeroDeSocio() {
		return numeroDeSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public Copia[] getCopiasRetiradas() {
		return copiasRetiradas;
	}

	public void multar(Multa multa) {

		this.multa = multa;
	}

	public boolean tieneMulta() {

		boolean hayMulta = false;
		
		if (this.multa != null) {
			
			hayMulta = true;
		}
		
		return hayMulta;
	}

	public Prestamo[] getPrestamos() {

		return this.prestamos;
	}

	public void agregarCopia(Copia copia, Prestamo prestamo) {

		for (int i = 0; i < this.copiasRetiradas.length; i++) {

			if (copiasRetiradas[i] == null) {

				copiasRetiradas[i] = copia;
				prestamos[i] = prestamo;
				break;
			}
		}

	}

	public Object[] devolverCopia(Copia copia) {

		Copia copiaDevuelta = null;
		Prestamo prestamoCorrespondiente = null;
		for (int i = 0; i < this.copiasRetiradas.length; i++) {
			
			if (copiasRetiradas[i] == copia) {
				
				copiaDevuelta = copiasRetiradas[i];
				prestamoCorrespondiente = prestamos[i];
				copiasRetiradas[i] = null;
				prestamos[i] = null;
				break;
			}
		}

		Object[] copiaPrestamo = { copiaDevuelta, prestamoCorrespondiente };

		return copiaPrestamo;

	}

	public int compareTo(Lector o) {
		int output;

		if (this.getNumeroDeSocio() > o.getNumeroDeSocio()) {

			output = 1;

		} else if (this.getNumeroDeSocio() < o.getNumeroDeSocio()) {

			output = -1;

		} else {

			output = 0;
		}

		return output;
	}

}
