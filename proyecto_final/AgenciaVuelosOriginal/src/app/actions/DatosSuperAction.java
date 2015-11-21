package app.actions;

import app.modelo.Rol;
import app.modelo.Usuario;
import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DatosSuperAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ItfzUsuario gestionU = new UsuarioDAO();
    if (request.getParameter("id") != null)
    {
      HttpSession session = request.getSession();
      if (!Acceso.Permiso(session.getAttribute("user"), Rol.SUPERADMINISTRADOR))
      {
        ActionErrors errors = new ActionErrors();
        errors.add("Permiso", new ActionMessage("errors.permiso"));
        addErrors(request, errors);
        return mapping.findForward("error");
      }
      Usuario u = gestionU.consultarUsuario(Long.parseLong(request.getParameter("id")));
      request.setAttribute("super", u);
      return mapping.findForward("editar");
    }
    return mapping.findForward("alta");
  }
}
