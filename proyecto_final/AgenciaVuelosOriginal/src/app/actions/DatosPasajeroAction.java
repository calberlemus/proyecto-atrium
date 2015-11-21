package app.actions;

import app.modelo.Asiento;
import app.modelo.Pasajero;
import app.modelo.Rol;
import app.persistencia.ItfzPasajero;
import app.persistencia.ItfzVuelo;
import app.persistencia.PasajeroDAO;
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

public class DatosPasajeroAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if (!Acceso.Permiso(session.getAttribute("user"), Rol.CLIENTE))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    ItfzPasajero gestionP = new PasajeroDAO();
    ItfzVuelo gestionV = new VueloDAO();
    List<Asiento> asientosIda = gestionV.consultaAsientosVuelo(Long.parseLong(request.getParameter("idVueloIda")));
    request.setAttribute("asientosIda", asientosIda);
    List<Asiento> asientosVuelta = gestionV.consultaAsientosVuelo(Long.parseLong(request.getParameter("idVueloVuelta")));
    request.setAttribute("asientosVuelta", asientosVuelta);
    if (request.getParameter("id") == null) {
      return mapping.findForward("alta");
    }
    Pasajero p = gestionP.consultaPasajero(Long.parseLong(request.getParameter("id")));
    request.setAttribute("pasajero", p);
    return mapping.findForward("editar");
  }
}