package app.actionforms;

import app.modelo.Aeropuerto;
import app.modelo.Compannia;
import app.persistencia.AeropuertoDAO;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzCompannia;
import app.util.Fecha;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class FormAltaVuelo
  extends ValidatorForm
{
  private Long idAeropuertoOrigen;
  private Long idAeropuertoDestino;
  private String diaSalida;
  private String horaSalida;
  private String diaLlegada;
  private String horaLlegada;
  private Long idCompannia;
  private double precioOferta;
  private double precioTurista;
  private double precioBussines;
  private int numAsientosOferta;
  private int numAsientosTurista;
  private int numAsientosBussines;
  
  public Long getIdAeropuertoOrigen()
  {
    return this.idAeropuertoOrigen;
  }
  
  public void setIdAeropuertoOrigen(Long idAeropuertoOrigen)
  {
    this.idAeropuertoOrigen = idAeropuertoOrigen;
  }
  
  public Long getIdAeropuertoDestino()
  {
    return this.idAeropuertoDestino;
  }
  
  public void setIdAeropuertoDestino(Long idAeropuertoDestino)
  {
    this.idAeropuertoDestino = idAeropuertoDestino;
  }
  
  public String getDiaSalida()
  {
    return this.diaSalida;
  }
  
  public void setDiaSalida(String diaSalida)
  {
    this.diaSalida = diaSalida;
  }
  
  public String getDiaLlegada()
  {
    return this.diaLlegada;
  }
  
  public void setDiaLlegada(String diaLlegada)
  {
    this.diaLlegada = diaLlegada;
  }
  
  public Long getIdCompannia()
  {
    return this.idCompannia;
  }
  
  public void setIdCompannia(Long idCompannia)
  {
    this.idCompannia = idCompannia;
  }
  
  public double getPrecioOferta()
  {
    return this.precioOferta;
  }
  
  public void setPrecioOferta(double precioOferta)
  {
    this.precioOferta = precioOferta;
  }
  
  public double getPrecioTurista()
  {
    return this.precioTurista;
  }
  
  public void setPrecioTurista(double precioTurista)
  {
    this.precioTurista = precioTurista;
  }
  
  public double getPrecioBussines()
  {
    return this.precioBussines;
  }
  
  public void setPrecioBussines(double precioBussines)
  {
    this.precioBussines = precioBussines;
  }
  
  public String getHoraSalida()
  {
    return this.horaSalida;
  }
  
  public void setHoraSalida(String horaSalida)
  {
    this.horaSalida = horaSalida;
  }
  
  public String getHoraLlegada()
  {
    return this.horaLlegada;
  }
  
  public void setHoraLlegada(String horaLlegada)
  {
    this.horaLlegada = horaLlegada;
  }
  
  public int getNumAsientosOferta()
  {
    return this.numAsientosOferta;
  }
  
  public void setNumAsientosOferta(int numAsientosOferta)
  {
    this.numAsientosOferta = numAsientosOferta;
  }
  
  public int getNumAsientosTurista()
  {
    return this.numAsientosTurista;
  }
  
  public void setNumAsientosTurista(int numAsientosTurista)
  {
    this.numAsientosTurista = numAsientosTurista;
  }
  
  public int getNumAsientosBussines()
  {
    return this.numAsientosBussines;
  }
  
  public void setNumAsientosBussines(int numAsientosBussines)
  {
    this.numAsientosBussines = numAsientosBussines;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    ItfzCompannia gestionC = new CompanniaDAO();
    
    List<Compannia> compannias = gestionC.consultarCompannias();
    request.setAttribute("compannias", compannias);
    
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    request.setAttribute("aeropuertos", aeropuertos);
    
    super.reset(mapping, request);
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    
    /*
	 * Si el Aeropuerto de Origen está vacío se muestra un error de campo obligatorio
	 * Si el Aeropuerto de Origen es el mismo que el aeropuerto de destino se muestra
	 * un error de que el origen no puede ser el mismo que el destino
	 */
    if (this.idAeropuertoOrigen.longValue() == 0) {
      errors.add("idAeropuertoOrigen", new ActionMessage(
        "errors.required", "Aeropuerto de origen"));
    } else if (this.idAeropuertoOrigen.longValue() == this.idAeropuertoDestino.longValue()) {
      errors.add("idAeropuertoOrigen", new ActionMessage(
        "errors.aeropuertos"));
    }
    
    /*
	 * Si el Aeropuerto de Destino está vacío se muestra un error de campo obligatorio	 
	 */
    if (this.idAeropuertoDestino.longValue() == 0) {
      errors.add("idAeropuertoDestino", new ActionMessage(
        "errors.required", "Aeropuerto de destino"));
    }
    
    /*
	 * Si el dia de salida está vacío se muestra un error de campo obligatorio	 
	 */
    if ((this.diaSalida.equals("")) || 
      (this.diaSalida.equals("Ida"))) {
      errors.add("diaSalida", new ActionMessage("errors.required", 
        "Fecha de salida"));
    }
    
    /*
	 * Si el dia de llegada está vacío se muestra un error de campo obligatorio	 
	 */
    if ((this.diaLlegada.equals("")) || 
      (this.diaSalida.equals("Vuelta"))) {
      errors.add("diaLlegada", new ActionMessage("errors.required", 
        "Fecha de llegada"));
    }
    
    /*
	 * Si la hora de salida está vacía se muestra un error de campo obligatorio	 
	 */
    if ((this.horaSalida == null) || (this.horaSalida.toString().equals(""))) {
      errors.add("horaSalida", new ActionMessage("errors.required", 
        "Hora de salida"));
    }
    
    /*
	 * Si la hora de salida está vacía se muestra un error de campo obligatorio	 
	 */
    if ((this.horaLlegada == null) || (this.horaLlegada.toString().equals(""))) {
      errors.add("horaLlegada", new ActionMessage("errors.required", 
        "Hora de llegada"));
    }
    
    /*
	 * Si la fecha de salida es posterior a la fecha de llegada se muestra un error
	 * anunciando este acontecimiento.
	 * Si la fecha de salida es igual a la fecha de llegada y ademas la hora de salida
	 * es igual o mayor que la de salida se muestra un error anunciando este 
	 * acontecimiento.	 
	 */
    if ((!this.diaSalida.equals("")) && 
      (!this.diaLlegada.equals("")) && 
      (Fecha.convetirDate(this.diaSalida).compareTo(
      Fecha.convetirDate(this.diaLlegada)) > 0)) {
      errors.add("diaLlegada", new ActionMessage("errors.fechas"));
    }else if ((!this.diaSalida.equals("")) && 
    	      (!this.diaLlegada.equals("")) &&
    	      (!this.horaSalida.equals("")) &&
    	      (!this.horaLlegada.equals("")) &&
    	      Fecha.convetirDate(this.diaSalida).compareTo(Fecha.convetirDate(this.diaLlegada)) == 0 &&
    	      Fecha.convetirTime(this.horaSalida).compareTo(Fecha.convetirTime(this.horaLlegada)) >=0){
    	errors.add("diaLlegada", new ActionMessage("errors.fechas"));
    }
    return errors;
  }
}
