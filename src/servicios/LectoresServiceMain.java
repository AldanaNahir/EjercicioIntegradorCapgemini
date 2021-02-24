package servicios;

import jakarta.xml.ws.Endpoint;

public class LectoresServiceMain {

	public static void main(String[] args) {
	
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/LectorService", new LectorService());
		
	}

}
