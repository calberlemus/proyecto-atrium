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

public class FormBusquedaVuelosInterior
  extends ValidatorForm
{
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
    if (this.idAeropuertoOrigen == 0L) {
      errors.add("idAeropuertoOrigen", new ActionMessage("errors.required", "Aeropuerto de origen"));
    } else if (this.idAeropuertoOrigen == this.idAeropuertoDestino) {
      errors.add("idAeropuertoOrigen", new ActionMessage("errors.aeropuertos"));
    }
    if (this.idAeropuertoDestino == 0L) {
      errors.add("idAeropuertoDestino", new ActionMessage("errors.required", "Aeropuerto de destino"));
    }
    if ((this.diaSalida.equals("")) || (this.diaSalida.equals("Ida"))) {
      errors.add("diaSalida", new ActionMessage("errors.required", "Fecha de salida"));
    }
    if ((this.idavuelta == 1) && ((this.diaLlegada.equals("")) || (this.diaSalida.equals("Vuelta")))) {
      errors.add("diaLlegada", new ActionMessage("errors.required", "Fecha de llegada"));
    }
    if ((this.idavuelta == 1) && (!this.diaSalida.equals("")) && (!this.diaLlegada.equals("")) && (Fecha.convetirDate(this.diaSalida).compareTo(Fecha.convetirDate(this.diaLlegada)) > 0)) {
      errors.add("diaLlegada", new ActionMessage("errors.fechas"));
    }
    Date hoy = new Date();
    if (!this.diaSalida.equals("") && !this.diaSalida.equals("Ida") && Fecha.convetirDate(this.diaSalida).compareTo(Fecha.fechaSinHora(hoy))<0){
    	errors.add("diaSalida", new ActionMessage("errors.fechaAntigua","Fecha de Salida"));
    }
    if (!this.diaLlegada.equals("") && !this.diaLlegada.equals("Ida") && Fecha.convetirDate(this.diaLlegada).compareTo(Fecha.fechaSinHora(hoy))<0){
    	errors.add("diaLlegada", new ActionMessage("errors.fechaAntigua","Fecha de Llegada"));
    }
    if (this.npasajeros == 0) {
      errors.add("npasajeros", new ActionMessage("errors.required", "Nº de pasajeros"));
    }
    if (this.clase.equals("")) {
      errors.add("clase", new ActionMessage("errors.required", "Clase"));
    }
    return errors;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    this.idavuelta = 1;
    this.idAeropuertoOrigen = 0L;
    this.idAeropuertoDestino = 0L;
    this.diaSalida = "";
    this.diaLlegada = "";
    this.clase = "";
    int npasajeros = 0;
    
    ItfzVuelo gestionV = new VueloDAO();
    List<Vuelo> vuelosNac = gestionV.consultarVuelosNacionales();
	List<Vuelo> vuelosInt = gestionV.consultarVuelosInternacionales();
	request.setAttribute("vuelosNac", vuelosNac);
	request.setAttribute("vuelosInt", vuelosInt);
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    request.setAttribute("aeropuertos", aeropuertos);
    super.reset(mapping, request);
  }
}

