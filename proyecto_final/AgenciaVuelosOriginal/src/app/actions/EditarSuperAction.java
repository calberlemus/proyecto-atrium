package app.actions;

import app.actionforms.FormEditarSuper;
import app.modelo.Direccion;
import app.modelo.Rol;
import app.modelo.Usuario;
import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
import app.util.Fecha;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EditarSuperAction
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
    ItfzUsuario gestionU = new UsuarioDAO();
    
    Usuario u = new Usuario();
    u.setNick(((FormEditarSuper)form).getNick());
    u.setPass(((FormEditarSuper)form).getPass());
    u.setRol(Rol.SUPERADMINISTRADOR);
    u.setId(((FormEditarSuper)form).getId());
    u.setNombre(((FormEditarSuper)form).getNombre());
    u.setApellidos(((FormEditarSuper)form).getApellidos());
    u.setDni(((FormEditarSuper)form).getDni());
    u.setFechaNacimiento(Fecha.convetirDate(((FormEditarSuper)form).getFechaNacimiento()));
    u.setDni(((FormEditarSuper)form).getDni());
    u.setTelefono(((FormEditarSuper)form).getTelefono());
    u.setEmail(((FormEditarSuper)form).getEmail());
    
    Direccion d = new Direccion(((FormEditarSuper)form).getCalle(), ((FormEditarSuper)form).getNumero(), 
      ((FormEditarSuper)form).getPoblacion(), ((FormEditarSuper)form).getCp(), 
      ((FormEditarSuper)form).getProvincia());
    
    u.setDireccion(d);
    
    gestionU.editarUsuario(u, u.getId().longValue());
    
    return mapping.findForward("ok");
  }
}
