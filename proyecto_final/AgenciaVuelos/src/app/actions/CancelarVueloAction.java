package app.actions;

import app.modelo.Rol;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzCompannia;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CancelarVueloAction
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
    
    Vuelo v = gestionV.consultarVuelo(Long.parseLong(request.getParameter("id")));
    v.setCancelado(true);
    
    gestionV.editarVuelo(v, v.getId().longValue());
    
    return mapping.findForward("ok");
  }
}
