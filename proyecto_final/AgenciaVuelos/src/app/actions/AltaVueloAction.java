package app.actions;

import app.actionforms.FormAltaVuelo;
import app.modelo.Aeropuerto;
import app.modelo.Asiento;
import app.modelo.Clase;
import app.modelo.Compannia;
import app.modelo.Rol;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzCompannia;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;
import app.util.Fecha;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AltaVueloAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if (!Acceso.Permiso(session.getAttribute("user"), Rol.ADMINISTRADOR))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    ItfzCompannia gestionC = new CompanniaDAO();
    ItfzVuelo gestionV = new VueloDAO();
    
    Vuelo v = new Vuelo();
    
    v.setDiaSalida(Fecha.convetirDate(((FormAltaVuelo)form).getDiaSalida()));
    v.setDiaLlegada(Fecha.convetirDate(((FormAltaVuelo)form).getDiaLlegada()));
    v.setHoraSalida(Fecha.convetirTimeHM(((FormAltaVuelo)form).getHoraSalida()));
    v.setHoraLlegada(Fecha.convetirTimeHM(((FormAltaVuelo)form).getHoraLlegada()));
    v.setNumAsientosBussines(((FormAltaVuelo)form).getNumAsientosBussines());
    v.setNumAsientosOferta(((FormAltaVuelo)form).getNumAsientosOferta());
    v.setNumAsientosTurista(((FormAltaVuelo)form).getNumAsientosTurista());
    v.setPrecioBussines(((FormAltaVuelo)form).getPrecioBussines());
    v.setPrecioOferta(((FormAltaVuelo)form).getPrecioOferta());
    v.setPrecioTurista(((FormAltaVuelo)form).getPrecioTurista());
    v.setCancelado(false);
    
    Aeropuerto origen = gestionA.consultarAeropuertos(((FormAltaVuelo)form).getIdAeropuertoOrigen().longValue());
    
    origen.addVueloOrigen(v);
    
    Aeropuerto destino = gestionA.consultarAeropuertos(((FormAltaVuelo)form).getIdAeropuertoDestino().longValue());
    destino.addVueloDestino(v);
    
    Compannia c = gestionC.consultarCompannia(((FormAltaVuelo)form).getIdCompannia().longValue());
    c.addVuelo(v);
    
    int contador = 1;
    for (int i = 0; i < v.getNumAsientosBussines(); i++)
    {
      Asiento asiento = new Asiento();
      asiento.setClase(Clase.BUSSINES);
      asiento.setNumero(contador);
      contador++;
      asiento.setDisponible(Boolean.valueOf(true));
      v.addAsiento(asiento);
    }
    for (int i = 0; i < v.getNumAsientosOferta(); i++)
    {
      Asiento asiento = new Asiento();
      asiento.setClase(Clase.OFERTA);
      asiento.setNumero(contador);
      contador++;
      asiento.setDisponible(Boolean.valueOf(true));
      v.addAsiento(asiento);
    }
    for (int i = 0; i < v.getNumAsientosTurista(); i++)
    {
      Asiento asiento = new Asiento();
      asiento.setClase(Clase.TURISMO);
      asiento.setNumero(contador);
      contador++;
      asiento.setDisponible(Boolean.valueOf(true));
      v.addAsiento(asiento);
    }
    gestionV.altaVuelo(v);
    
    return mapping.findForward("ok");
  }
}
