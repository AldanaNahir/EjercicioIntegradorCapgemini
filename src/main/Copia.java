package main;
import excepciones.IdInvalidoException;

public class Copia implements Comparable <Copia>{

	private Libro nombreLibro;
	private int id;
	private EstadoCopia copia;
	
	public Copia (EstadoCopia copia, int id, Libro nombreLibro) throws IdInvalidoException {
		
		if (id < 0) {
			
			throw new IdInvalidoException("Ha ingresado un ID invalido para la copia");
		}
		
		this.nombreLibro=nombreLibro;
		this.copia=copia;
		this.id=id;
		
		
	}

	public Libro getNombreLibro() {
		return nombreLibro;
	}

	public int getId() {
		return id;
	}

	public EstadoCopia getCopia() {
		return copia;
	}

	public void setCopia(EstadoCopia copia) {
		this.copia = copia;
	}

	public int compareTo(Copia c2) {
		
		int output;
		
		if (this.getId() > c2.getId()) {
			
			output = 1;
		
		} else if (this.getId() < c2.getId()) {
			
			output = -1;
			
		} else {
			
			output = 0;
		}
		
		return output;
	}
	
}