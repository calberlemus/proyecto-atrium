package app.actions;

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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DatosVueloAction
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
    
    List<Compannia> compannias = gestionC.consultarCompannias();
    request.setAttribute("compannias", compannias);
    
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    request.setAttribute("aeropuertos", aeropuertos);
    if (request.getParameter("id") == null) {
      return mapping.findForward("alta");
    }
    Vuelo v = gestionV.consultarVuelo(Long.parseLong(request.getParameter("id")));
    request.setAttribute("vuelo", v);
    return mapping.findForward("editar");
  }
}
