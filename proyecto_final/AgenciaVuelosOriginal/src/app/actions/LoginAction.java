package app.actions;

import app.actionforms.FormLogin;
import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ItfzUsuario gestionU = new UsuarioDAO();
    
    String nick = ((FormLogin)form).getNick();
    String pass = ((FormLogin)form).getPass();
    HttpSession session = request.getSession(true);
    if (pass.equals(gestionU.ConsultaPass(nick)))
    {
      session.setAttribute("user", gestionU.ConsultaUsuario(nick));
      return mapping.findForward("ok");
    }
    return mapping.findForward("error");
  }
}