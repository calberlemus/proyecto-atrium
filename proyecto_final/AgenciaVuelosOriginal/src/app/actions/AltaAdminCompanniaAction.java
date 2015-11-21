package app.actions;

import app.actionforms.FormAltaAdminCompannia;
import app.modelo.AdminCompannia;
import app.modelo.Compannia;
import app.modelo.Direccion;
import app.modelo.Rol;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;
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

public class AltaAdminCompanniaAction
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
    ItfzCompannia gestionC = new CompanniaDAO();
    
    AdminCompannia a = new AdminCompannia();
    
    a.setNombre(((FormAltaAdminCompannia)form).getNombre());
    a.setApellidos(((FormAltaAdminCompannia)form).getApellidos());
    a.setDni(((FormAltaAdminCompannia)form).getDni());
    
    a.setNick(((FormAltaAdminCompannia)form).getNick());
    a.setPass(((FormAltaAdminCompannia)form).getPass());
    
    a.setRol(Rol.ADMINISTRADOR);
    
    a.setFechaNacimiento(Fecha.convetirDate(((FormAltaAdminCompannia)form).getFechaNacimiento()));
    a.setDni(((FormAltaAdminCompannia)form).getDni());
    a.setTelefono(((FormAltaAdminCompannia)form).getTelefono());
    a.setEmail(((FormAltaAdminCompannia)form).getEmail());
    a.setNumRegistro(((FormAltaAdminCompannia)form).getNumRegistro());
    
    Compannia c = gestionC.consultarCompannia(((FormAltaAdminCompannia)form).getIdCompannia());
    c.addAdministradorCompannia(a);
    
    Direccion d = new Direccion(((FormAltaAdminCompannia)form).getCalle(), ((FormAltaAdminCompannia)form).getNumero(), 
      ((FormAltaAdminCompannia)form).getPoblacion(), ((FormAltaAdminCompannia)form).getCp(), 
      ((FormAltaAdminCompannia)form).getProvincia());
    
    a.setDireccion(d);
    
    gestionU.altaAdminCompannia(a);
    
    return mapping.findForward("ok");
  }
}