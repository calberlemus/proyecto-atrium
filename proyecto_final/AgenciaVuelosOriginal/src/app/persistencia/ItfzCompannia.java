package app.persistencia;
import app.modelo.*;
import java.util.List;
public interface ItfzCompannia {
	
	public boolean altaCompannia(Compannia compannia);	
	
	public boolean editarCompannia(Compannia compannia, long id);	
	
	public boolean eliminarCompannia(long id);
	
	public List<Compannia> consultarCompannias();
	public Compannia consultarCompannia(long id);
	public Compannia consultarCompannia(String codigo);

}
