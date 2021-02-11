import java.util.Date;

import excepciones.NombreInvalidoException;

public class Autor {

	
	private String nombre;
	private String nacionalidad;
	private Date fechaDeNacimiento;
	
	
	public Autor (String nombre, String nacionalidad, Date fechaDeNacimiento) throws NombreInvalidoException {
		
		if (nombre.equals("") || nombre.equals(" ")) {
			
			throw new NombreInvalidoException("Ha ingresado un nombre invalido para el autor");
		}
		
		if (nacionalidad.equals("") || nacionalidad.equals(" ")) {
			
			throw new NombreInvalidoException("Ha ingresado una nacionalidad invalida");
		}
		
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	
}
