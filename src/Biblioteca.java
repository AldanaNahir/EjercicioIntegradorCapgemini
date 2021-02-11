import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import excepciones.DiasInvalidosException;

public class Biblioteca {

	private Set<Copia> copiasLibros;
	private Set<Lector> lectores;

	public Biblioteca(Set<Copia> copias) {

		this.copiasLibros = new TreeSet<Copia>();
		this.lectores = new TreeSet<Lector>();
	}

	public void prestar(Copia copiaLibro, Lector lector, Prestamo prestamo) {

		Iterator<Lector> itrLect = lectores.iterator();
		Iterator<Copia> itrCopia = copiasLibros.iterator();
		Copia unaCopia = null;
		boolean lectorEncontrado = false;
		
		while(itrCopia.hasNext()) {
			
			unaCopia = itrCopia.next();
			
			if (unaCopia == copiaLibro) { 
				
				copiasLibros.remove(unaCopia);
			}
		}

		while (itrLect.hasNext() && !lectorEncontrado) {

			Lector unLector = itrLect.next();

			if (unLector == lector) {

				unLector.agregarCopia(copiaLibro, prestamo);
				unaCopia.setCopia(EstadoCopia.PRESTADO);
			}
			
			else {
				
				copiasLibros.add(unaCopia);
				
			}
		}

	}

	public void registrarDevolucion(Copia copiaLibro, Lector lector, Date fechaDevolucion) throws DiasInvalidosException {

		Iterator<Lector> itrLect = lectores.iterator();
		Object info[] = null;
		boolean lectorEncontrado = false;
		Lector unLector = null;
		
		while (itrLect.hasNext() && !lectorEncontrado) {

			unLector = itrLect.next();

			if (unLector == lector) {

				info = unLector.devolverCopia(copiaLibro);
				((Copia) info[2]).setCopia(EstadoCopia.BIBLIOTECA);
				copiasLibros.add(copiaLibro);
				
			}
		}
		
		long diferenciaEn_ms = ((Prestamo) info[2]).getFin().getTime() - fechaDevolucion.getTime(); 
		long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		
		if ((int) dias > 30) {
			
			
			Multa multa = new Multa (fechaDevolucion, 2);
			unLector.multar(multa);

		}
	}

	public Set<Copia> getCopiasLibros() {
		return copiasLibros;
	}

	public Set<Lector> getLectores() {
		return lectores;
	}

}
