package app.actions;

import app.actionforms.FormEditarVuelo;
import app.modelo.Aeropuerto;
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

public class EditarVueloAction
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
    
    v.setId(((FormEditarVuelo)form).getId());
    v.setDiaSalida(Fecha.convetirDate(((FormEditarVuelo)form).getDiaSalida()));
    v.setDiaLlegada(Fecha.convetirDate(((FormEditarVuelo)form).getDiaLlegada()));
    v.setHoraSalida(Fecha.convetirTimeHM(((FormEditarVuelo)form).getHoraSalida()));
    v.setHoraLlegada(Fecha.convetirTimeHM(((FormEditarVuelo)form).getHoraLlegada()));
    
    v.setNumAsientosBussines(((FormEditarVuelo)form).getNumAsientosBussines());
    v.setNumAsientosOferta(((FormEditarVuelo)form).getNumAsientosOferta());
    v.setNumAsientosTurista(((FormEditarVuelo)form).getNumAsientosTurista());
    
    v.setPrecioBussines(((FormEditarVuelo)form).getPrecioBussines());
    v.setPrecioOferta(((FormEditarVuelo)form).getPrecioOferta());
    v.setPrecioTurista(((FormEditarVuelo)form).getPrecioTurista());
    
    Aeropuerto origen = gestionA.consultarAeropuertos(((FormEditarVuelo)form).getIdAeropuertoOrigen().longValue());
    origen.addVueloOrigen(v);
    
    Aeropuerto destino = gestionA.consultarAeropuertos(((FormEditarVuelo)form).getIdAeropuertoDestino().longValue());
    destino.addVueloDestino(v);
    
    Compannia c = gestionC.consultarCompannia(((FormEditarVuelo)form).getIdCompannia().longValue());
    c.addVuelo(v);
    System.out.println(v.getId());
    gestionV.editarVuelo(v, v.getId().longValue());
    
    return mapping.findForward("ok");
  }
}
