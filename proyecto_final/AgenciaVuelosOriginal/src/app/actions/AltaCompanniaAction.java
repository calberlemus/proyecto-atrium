package app.actions;

import app.actionforms.FormAltaCompannia;
import app.modelo.Compannia;
import app.modelo.Rol;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AltaCompanniaAction
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
    ItfzCompannia gestionC = new CompanniaDAO();
    
    Compannia c = new Compannia();
    
    c.setCodigo(((FormAltaCompannia)form).getCodigo().toUpperCase());
    c.setNombre(((FormAltaCompannia)form).getNombre().toUpperCase());
    c.setPais(((FormAltaCompannia)form).getPais().toUpperCase());
    gestionC.altaCompannia(c);
    
    return mapping.findForward("ok");
  }
}