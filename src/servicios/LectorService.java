package servicios;

import java.util.ArrayList;

import biblioteca.Lector;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import persistencia.LectorDAO;

@WebService
public class LectorService {
	@WebMethod (operationName="agregarLectorWS")
	public boolean agregarLector(@WebParam(name="lector")Lector l) {
		LectorDAO dao= new LectorDAO();
		try {
			dao.agregarLector(l);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@WebMethod(operationName="obtenerLectoresWS")
	public ArrayList<Lector> obtenerLectores(){
		LectorDAO dao= new LectorDAO();
		ArrayList<Lector> lectores = new ArrayList();
		try {
			lectores= (ArrayList<Lector>) dao.consultarLectores();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lectores;
	}

}
