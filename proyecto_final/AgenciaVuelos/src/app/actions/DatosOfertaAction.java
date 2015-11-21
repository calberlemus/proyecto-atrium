package app.actions;

import java.util.List;

import app.modelo.Aeropuerto;
import app.modelo.Oferta;
import app.modelo.Rol;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.OfertaDAO;
import app.persistencia.ItfzOferta;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DatosOfertaAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if (!Acceso.Permiso(session.getAttribute("user"), Rol.SUPERADMINISTRADOR))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    
    
    
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    request.setAttribute("aeropuertos", aeropuertos);
    if (request.getParameter("id") == null) {
      return mapping.findForward("alta");
    }
    ItfzOferta gestionO = new OfertaDAO();
    Oferta o = gestionO.consultaOferta((Long.parseLong(request.getParameter("id"))));
    request.setAttribute("oferta", o);    
    return mapping.findForward("editar");
  }
}

