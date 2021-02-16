package biblioteca;
import excepciones.FechaInvalidaException;
import excepciones.NombreInvalidoException;

public class Libro {

	private Autor autorDelLibro;
	private String titulo;
	private int anyo;
	private TipoLibro tipo;
	private String editorial;


	public Libro  (String titulo, Autor autorDelLibro, int anyo, TipoLibro tipo, String editorial ) throws FechaInvalidaException, NombreInvalidoException{
		
		if (titulo.equals("") || titulo.equals(" ")) {
			
			throw new NombreInvalidoException("Ha ingresado un nombre invalido para el libro");
		}
		
		if (editorial.equals("") || editorial.equals(" ")) {
			
			throw new NombreInvalidoException("Ha ingresado un nombre invalido para la editorial");
		}
		
		if (anyo>2021) 
			throw new FechaInvalidaException ("Año invalido");
			
		this.autorDelLibro= autorDelLibro;
		this.titulo=titulo;
		this.anyo=anyo;
		this.tipo=tipo;
		this.editorial=editorial;

	}


	public Autor getAutorDelLibro() {
		return autorDelLibro;
	}


	public String getTitulo() {
		return titulo;
	}


	public int getAnyo() {
		return anyo;
	}


	public TipoLibro getTipo() {
		return tipo;
	}


	public String getEditorial() {
		return editorial;
	}
	
}
