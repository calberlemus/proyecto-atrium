package app.actions;

import app.actionforms.FormAltaAsiento;
import app.modelo.Asiento;
import app.modelo.Clase;
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

public class AltaAsientoAction
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
    ItfzVuelo gestionV = new VueloDAO();
    
    Vuelo vuelo = gestionV.consultarVuelo(((FormAltaAsiento)form).getIdVuelo().longValue());
    
    Asiento asiento = new Asiento();
    Enum clase = Enum.valueOf(Clase.class, ((FormAltaAsiento)form).getClase());
    asiento.setClase((Clase)clase);
    asiento.setNumero(((FormAltaAsiento)form).getNumero());
    vuelo.addAsiento(asiento);
    
    gestionV.altaAsiento(asiento);
    
    return mapping.findForward("ok");
  }
}

