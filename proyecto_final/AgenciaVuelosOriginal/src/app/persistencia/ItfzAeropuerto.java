package app.persistencia;
import app.modelo.*;
import java.util.List;
public interface ItfzAeropuerto {
	
	  public  boolean altaAeropuerto(Aeropuerto paramAeropuerto);
	  
	  public  boolean editarAeropuerto(Aeropuerto paramAeropuerto, long paramLong);
	  
	  public  boolean eliminarAeropuerto(long paramLong);
	  
	  public  List<Aeropuerto> consultarAeropuertos();
	  
	  public  List<Aeropuerto> consultarAeropuertos(String paramString);
	  
	  public  Aeropuerto consultarAeropuertos(long paramLong);
	  
	  public  Aeropuerto consultarAeropuertosCodigo(String paramString);

}
