package app.actions;

import app.actionforms.FormAltaSuper;
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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AltaSuperAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    
    ItfzUsuario gestionU = new UsuarioDAO();
    
    Usuario u = new Usuario();
    
    u.setNick(((FormAltaSuper)form).getNick());
    u.setPass(((FormAltaSuper)form).getPass());
    
    u.setRol(Rol.SUPERADMINISTRADOR);
    
    u.setNombre(((FormAltaSuper)form).getNombre());
    u.setApellidos(((FormAltaSuper)form).getApellidos());
    u.setDni(((FormAltaSuper)form).getDni());
    u.setFechaNacimiento(Fecha.convetirDate(((FormAltaSuper)form).getFechaNacimiento()));
    u.setDni(((FormAltaSuper)form).getDni());
    u.setTelefono(((FormAltaSuper)form).getTelefono());
    u.setEmail(((FormAltaSuper)form).getEmail());
    
    Direccion d = new Direccion(((FormAltaSuper)form).getCalle(), ((FormAltaSuper)form).getNumero(), 
      ((FormAltaSuper)form).getPoblacion(), ((FormAltaSuper)form).getCp(), 
      ((FormAltaSuper)form).getProvincia());
    
    u.setDireccion(d);
    gestionU.altaUsuario(u);
    
    return mapping.findForward("ok");
  }
}
