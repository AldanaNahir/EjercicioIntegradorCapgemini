package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import excepciones.*;
import junit.framework.Assert;
import main.*;

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
		
		System.out.println("Print A");

		biblioteca.prestar(itrCopia.next(), lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		System.out.println("Print B");

		biblioteca.prestar(itrCopia.next(), lectorA, new Prestamo(sdf2.parse(dateInString2)));
		
		System.out.println("Print C");

		biblioteca.prestar(itrCopia.next(), lectorA, new Prestamo(sdf2.parse(dateInString2)));

		while (itrCopia.hasNext()) {

			contador++;
		}

		assertEquals(7, contador);
	}

}