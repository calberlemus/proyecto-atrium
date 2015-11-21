package app.actions;

import app.modelo.AdminCompannia;
import app.modelo.Compannia;
import app.modelo.Rol;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;
import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
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

public class DatosAdminCompanniaAction
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
    ItfzUsuario gestionU = new UsuarioDAO();
    ItfzCompannia gestionC = new CompanniaDAO();
    List<Compannia> compannias = gestionC.consultarCompannias();
    request.setAttribute("compannias", compannias);
    if (request.getParameter("id") == null) {
      return mapping.findForward("alta");
    }
    AdminCompannia a = gestionU.consultarAdminCompannias(Long.parseLong(request.getParameter("id")));
    request.setAttribute("admin", a);
    return mapping.findForward("editar");
  }
}
