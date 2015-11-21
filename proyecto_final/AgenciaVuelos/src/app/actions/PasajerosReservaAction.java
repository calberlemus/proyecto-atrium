package app.actions;

import app.modelo.Rol;
import app.modelo.Vuelo;
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

public class PasajerosReservaAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ActionErrors errors = new ActionErrors();
    HttpSession session = request.getSession();
    if (Acceso.Permiso(session.getAttribute("user"), Rol.ADMINISTRADOR) || !Acceso.Permiso(session.getAttribute("user"), Rol.CLIENTE))
    {
      errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.soloClientes"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    
    
    ItfzVuelo gestionV = new VueloDAO();
    
    HttpSession sesion = request.getSession(true);
    
    Long vuelta = null;
    Long ida = null;
    
    sesion.removeAttribute("vueloIda");
    sesion.removeAttribute("vueloVuelta");
    sesion.removeAttribute("claseIda");
    sesion.removeAttribute("claseVuelta");
    sesion.removeAttribute("precioIda");
    sesion.removeAttribute("precioVuelta");
    sesion.removeAttribute("np");
    sesion.removeAttribute("pasajeros");
    
    int numPasajeros = Integer.parseInt(request.getParameter("np"));
    sesion.setAttribute("np", Integer.valueOf(numPasajeros));
    
    double precioIda = Double.parseDouble(request.getParameter("precioIda"));
    String claseIda = request.getParameter("claseIda");    
    
    sesion.setAttribute("claseIda", claseIda);
    session.setAttribute("precioIda", precioIda);
    
    
    ida = Long.valueOf(Long.parseLong(request.getParameter("id_ida")));
    Vuelo vueloIda = gestionV.consultarVuelo(ida.longValue());
    sesion.setAttribute("vueloIda", vueloIda);
    if (request.getParameter("id_vuelta") != null)
    {
      double precioVuelta = Double.parseDouble(request.getParameter("precioVuelta"));	
      String claseVuelta = request.getParameter("claseVuelta");
      
      sesion.setAttribute("claseVuelta", claseVuelta);
      sesion.setAttribute("precioVuelta", precioVuelta);
      
      vuelta = Long.valueOf(Long.parseLong(request.getParameter("id_vuelta")));
      Vuelo vueloVuelta = gestionV.consultarVuelo(vuelta.longValue());
      sesion.setAttribute("vueloVuelta", vueloVuelta);
    }
    return mapping.findForward("ok");
  }
}
