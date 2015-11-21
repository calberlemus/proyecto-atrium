package app.actionforms;

import app.modelo.Aeropuerto;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;
import app.util.Fecha;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class FormBusquedaVuelos  extends ValidatorForm{
  int idavuelta;
  long idAeropuertoOrigen;
  long idAeropuertoDestino;
  String diaSalida;
  String diaLlegada;
  int npasajeros;
  private String clase;
  
  public int getIdavuelta()
  {
    return this.idavuelta;
  }
  
  public void setIdavuelta(int idavuelta)
  {
    this.idavuelta = idavuelta;
  }
  
  public long getIdAeropuertoOrigen()
  {
    return this.idAeropuertoOrigen;
  }
  
  public void setIdAeropuertoOrigen(long idAeropuertoOrigen)
  {
    this.idAeropuertoOrigen = idAeropuertoOrigen;
  }
  
  public long getIdAeropuertoDestino()
  {
    return this.idAeropuertoDestino;
  }
  
  public void setIdAeropuertoDestino(long idAeropuertoDestino)
  {
    this.idAeropuertoDestino = idAeropuertoDestino;
  }
  
  public String getFechaHoraSalida()
  {
    return this.diaSalida;
  }
  
  public void setFechaHoraSalida(String diaSalida)
  {
    this.diaSalida = diaSalida;
  }
  
  public String getFechaHoraLlegada()
  {
    return this.diaLlegada;
  }
  
  public void setFechaHoraLlegada(String diaLlegada)
  {
    this.diaLlegada = diaLlegada;
  }
  
  public int getNpasajeros()
  {
    return this.npasajeros;
  }
  
  public void setNpasajeros(int npasajeros)
  {
    this.npasajeros = npasajeros;
  }
  
  public String getClase()
  {
    return this.clase;
  }
  
  public void setClase(String clase)
  {
    this.clase = clase;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    
    /*
	 * Si el Aeropuerto de Origen está vacío se muestra un error de campo obligatorio
	 * Si el Aeropuerto de Origen es el mismo que el aeropuerto de destino se muestra
	 * un error de que el origen no puede ser el mismo que el destino
	 */
    if (this.idAeropuertoOrigen == 0) {
      errors.add("idAeropuertoOrigen", new ActionMessage("errors.required", "Aeropuerto de origen"));
    } else if (this.idAeropuertoOrigen == this.idAeropuertoDestino) {
      errors.add("idAeropuertoOrigen", new ActionMessage("errors.aeropuertos"));
    }
    
    /*
	 * Si el Aeropuerto de Destino está vacío se muestra un error de campo obligatorio	 
	 */
    if (this.idAeropuertoDestino == 0) {
      errors.add("idAeropuertoDestino", new ActionMessage("errors.required", "Aeropuerto de destino"));
    }
    
    /*
	 * Si el dia de salida está vacío se muestra un error de campo obligatorio	 
	 */
    if ((this.diaSalida.equals("")) || (this.diaSalida.equals("Ida"))) {
      errors.add("diaSalida", new ActionMessage("errors.required", "Fecha de salida"));
    }
    
    /*
	 * Si el dia de llegada está vacío se muestra un error de campo obligatorio	 
	 */
    if ((this.idavuelta == 1) && ((this.diaLlegada.equals("")) || (this.diaLlegada.equals("Vuelta")))) {
      errors.add("diaLlegada", new ActionMessage("errors.required", "Fecha de llegada"));
    }
    
    /*
	 * Si la fecha de salida es posterior a la fecha de llegada se muestra un error
	 * anunciando este acontecimiento.
	 */
    if ((this.idavuelta == 1) && (!this.diaSalida.equals("")) && (!this.diaLlegada.equals("")) 
    		&& (Fecha.convetirDate(this.diaSalida).compareTo(Fecha.convetirDate(this.diaLlegada)) > 0)) {
      errors.add("diaLlegada", new ActionMessage("errors.fechas"));
    }
    
    /*
	 * Si la fecha de salida es anterior al dia de hoy se muestra un error
	 * anunciando este acontecimiento.
	 */
    Date hoy = new Date();
    if (!this.diaSalida.equals("") && !this.diaSalida.equals("Ida") && Fecha.convetirDate(this.diaSalida).compareTo(Fecha.fechaSinHora(hoy))<0){
    	errors.add("diaSalida", new ActionMessage("errors.fechaAntigua","Fecha de Salida"));
    }
    
    /*
	 * Si la fecha de Llegada es anterior al dia de hoy se muestra un error
	 * anunciando este acontecimiento.
	 */
    if (!this.diaLlegada.equals("") && !this.diaLlegada.equals("Ida") && Fecha.convetirDate(this.diaLlegada).compareTo(hoy)<0){
    	errors.add("diaLlegada", new ActionMessage("errors.fechaAntigua","Fecha de Llegada"));
    }
    
    /*
   	 * Si el numero de pasajeros está vacío se muestra un error de campo obligatorio	 
   	 */
    if (this.npasajeros == 0) {
      errors.add("npasajeros", new ActionMessage("errors.required", "Nº de Pasajeros"));
    }
    
    /*
   	 * Si la clase está vacía se muestra un error de campo obligatorio	 
   	 */
    if (this.clase.equals("")) {
      errors.add("clase", new ActionMessage("errors.required", "Clase"));
    }
    return errors;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {    
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    ItfzVuelo gestionV = new VueloDAO();
    List<Vuelo> vuelosNac = gestionV.consultarVuelosNacionales();
	List<Vuelo> vuelosInt = gestionV.consultarVuelosInternacionales();
	request.setAttribute("vuelosNac", vuelosNac);
	request.setAttribute("vuelosInt", vuelosInt);
    request.setAttribute("aeropuertos", aeropuertos);
    
    super.reset(mapping, request);
  }
}

