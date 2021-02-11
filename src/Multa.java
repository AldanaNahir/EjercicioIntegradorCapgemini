import java.util.Calendar;
import java.util.Date;

import excepciones.DiasInvalidosException;
import excepciones.IdInvalidoException;

public class Multa {

	private Date fechaInicio;
	private Date fechaFin;
	private int dias;

	public Multa(Date fechaInicio, int dias) throws DiasInvalidosException {
		
		if (dias < 0) {
			
			throw new DiasInvalidosException("Ha ingresado una cantidad de dias invalida.");
		}
		

		this.fechaInicio = fechaInicio;

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(this.fechaInicio); 

		calendar.add(Calendar.DAY_OF_YEAR, dias); 

		this.fechaFin = calendar.getTime();
		

	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public int getDias() {
		return dias;
	}
	
	
}
