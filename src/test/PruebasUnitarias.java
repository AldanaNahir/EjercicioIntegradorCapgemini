package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import biblioteca.*;
import excepciones.*;

public class PruebasUnitarias {

	Biblioteca biblioteca;
	Lector lectorA;
	Lector lectorB;

	// -----------------------------------------------//

	@Before
	public void crearObjetos() throws IdInvalidoException, FechaInvalidaException, NombreInvalidoException,
			ParseException, DireccionInvalidaException {

		TreeSet<Copia> copiasLibros = new TreeSet<Copia>();
		TreeSet<Lector> lectores = new TreeSet<Lector>();
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	    String dateInString = "31-08-1982 10:20:56";
	    
		
		Copia copia1 = new Copia(EstadoCopia.BIBLIOTECA, 1, new Libro("Cuento1", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia2 = new Copia(EstadoCopia.BIBLIOTECA, 2, new Libro("Cuento2", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia3 = new Copia(EstadoCopia.BIBLIOTECA, 3, new Libro("Cuento3", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia4 = new Copia(EstadoCopia.BIBLIOTECA, 4, new Libro("Cuento4", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia5 = new Copia(EstadoCopia.BIBLIOTECA, 5, new Libro("Cuento5", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia6 = new Copia(EstadoCopia.BIBLIOTECA, 6, new Libro("Cuento6", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia7 = new Copia(EstadoCopia.BIBLIOTECA, 7, new Libro("Cuento7", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia8 = new Copia(EstadoCopia.BIBLIOTECA, 8, new Libro("Cuento8", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia9 = new Copia(EstadoCopia.BIBLIOTECA, 9, new Libro("Cuento9", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		Copia copia10 = new Copia(EstadoCopia.BIBLIOTECA, 10, new Libro("Cuento10", new Autor("Jose", "Argentino", sdf.parse(dateInString)), 2010, TipoLibro.NOVELA, "Pepito"));
		
		
		copiasLibros.add(copia1);
		copiasLibros.add(copia2);
		copiasLibros.add(copia3);
		copiasLibros.add(copia4);
		copiasLibros.add(copia5);
		copiasLibros.add(copia6);
		copiasLibros.add(copia7);
		copiasLibros.add(copia8);
		copiasLibros.add(copia9);
		copiasLibros.add(copia10);
		
		
		lectorA = new Lector(2, "Marquitos", "48444041", "Victor Hugo 5279, Villa Bosch");
		lectorB = new Lector(3, "Pedrito", "48444042", "Victor Hugo 5278, Villa Bosch");
		
		
		lectores.add(lectorA);
		lectores.add(lectorB);
		
		
		biblioteca = new Biblioteca(copiasLibros, lectores);
	    
		
	}

	// -----------------------------------------------//

	@SuppressWarnings("deprecation")
	@Test
	public void testPrestarTres() throws ParseException {

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString2 = "11-02-2021 10:20:56";
		int contador = 0;

		Iterator<Copia> itrCopia = this.biblioteca.getCopiasLibros().iterator();
		
		Copia copiaA = itrCopia.next();
		Copia copiaB = itrCopia.next();
		Copia copiaC = itrCopia.next();
		

		biblioteca.prestar(copiaA, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		

		biblioteca.prestar(copiaB, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		

		biblioteca.prestar(copiaC, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		
		for (Copia c: this.biblioteca.getCopiasLibros()) {
			
			contador++;
		}


		assertEquals(7, contador);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPrestarCuatro() throws ParseException {

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString2 = "11-02-2021 10:20:56";
		int contador = 0;

		Iterator<Copia> itrCopia = this.biblioteca.getCopiasLibros().iterator();
		
		Copia copiaA = itrCopia.next();
		Copia copiaB = itrCopia.next();
		Copia copiaC = itrCopia.next();
		Copia copiaD = itrCopia.next();
		

		biblioteca.prestar(copiaA, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		

		biblioteca.prestar(copiaB, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		

		biblioteca.prestar(copiaC, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		
		biblioteca.prestar(copiaD, lectorB, new Prestamo(sdf2.parse(dateInString2)));
		
		
		for (Copia c: this.biblioteca.getCopiasLibros()) {
			
			contador++;
		}


		assertEquals(6, contador);
	}
	
	
	@Test
	public void testPedirYDevolver() throws ParseException, DiasInvalidosException {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString2 = "11-02-2021 10:20:56";
		String dateInString3 = "13-02-2021 10:20:56";
		int contador = 0;

		Iterator<Copia> itrCopia = this.biblioteca.getCopiasLibros().iterator();
		
		Copia copiaA = itrCopia.next();
		Copia copiaB = itrCopia.next();
		Copia copiaC = itrCopia.next();
		Copia copiaD = itrCopia.next();
		

		biblioteca.prestar(copiaA, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		

		biblioteca.prestar(copiaB, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		

		biblioteca.prestar(copiaC, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		
		biblioteca.registrarDevolucion(copiaB, lectorA, sdf2.parse(dateInString3));
		
		
		biblioteca.prestar(copiaD, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		
		for (Copia c: this.biblioteca.getCopiasLibros()) {
			
			contador++;
		}


		assertEquals(7, contador);
		
	}
	
	@Test
	public void testPedirConMulta() throws ParseException, DiasInvalidosException {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString2 = "11-02-2021 10:20:56";
		String dateInString3 = "13-04-2021 10:20:56";

		Iterator<Copia> itrCopia = this.biblioteca.getCopiasLibros().iterator();
		
		Copia copiaA = itrCopia.next();

		biblioteca.prestar(copiaA, lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		biblioteca.registrarDevolucion(copiaA, lectorA, sdf2.parse(dateInString3));
		
		assertTrue(lectorA.tieneMulta());
		
		
		
		
	}

}