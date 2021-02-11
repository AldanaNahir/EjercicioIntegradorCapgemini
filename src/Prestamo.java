import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;

public class Prestamo {

	
	private Date inicio;
	private Date fin;
	private boolean hayMulta;
	
	
	public Prestamo (Date inicio) {
		
		
		this.inicio=inicio;
		
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(this.inicio); 

		calendar.add(Calendar.DAY_OF_YEAR, 30); 

		this.fin = calendar.getTime();
		
		
	}

	public Date getInicio() {
		return inicio;
	}


	public Date getFin() {
		return fin;
	}
	
	/*public void agregarMulta() {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(this.fin);
		
		calendar.add(Calendar.DAY_OF_YEAR, 30);
		
		
	}*/
	
	
	 
	
}
