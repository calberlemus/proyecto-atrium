package app.actions;

import app.actionforms.FormEditarAdminCompannia;
import app.modelo.AdminCompannia;
import app.modelo.Compannia;
import app.modelo.Direccion;
import app.modelo.Rol;
import app.modelo.Usuario;
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

public class EditarAdminCompanniaAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if ((!Acceso.Permiso(session.getAttribute("user"), Rol.ADMINISTRADOR)) || (
      (Acceso.Permiso(session.getAttribute("user"), Rol.ADMINISTRADOR)) 
      && !((Usuario)session.getAttribute("user")).getRol().equals(Rol.SUPERADMINISTRADOR) 
      && (((Usuario)session.getAttribute("user")).getId().longValue() != ((FormEditarAdminCompannia)form)
      .getId().longValue())))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    ItfzUsuario gestionU = new UsuarioDAO();
    ItfzCompannia gestionC = new CompanniaDAO();
    
    AdminCompannia a = new AdminCompannia();
    
    a.setId(((FormEditarAdminCompannia)form).getId());
    a.setNombre(((FormEditarAdminCompannia)form).getNombre());
    a.setApellidos(((FormEditarAdminCompannia)form).getApellidos());
    a.setDni(((FormEditarAdminCompannia)form).getDni());
    
    a.setNick(((FormEditarAdminCompannia)form).getNick());
    a.setPass(((FormEditarAdminCompannia)form).getPass());
    
    a.setRol(Rol.ADMINISTRADOR);
    
    a.setFechaNacimiento(
      Fecha.convetirDate(((FormEditarAdminCompannia)form)
      .getFechaNacimiento()));
    a.setDni(((FormEditarAdminCompannia)form).getDni());
    a.setTelefono(((FormEditarAdminCompannia)form).getTelefono());
    a.setEmail(((FormEditarAdminCompannia)form).getEmail());
    a.setNumRegistro(((FormEditarAdminCompannia)form).getNumRegistro());
    
    Compannia c = gestionC
      .consultarCompannia(((FormEditarAdminCompannia)form)
      .getIdCompannia());
    c.addAdministradorCompannia(a);
    
    Direccion d = new Direccion(
      ((FormEditarAdminCompannia)form).getCalle(), 
      ((FormEditarAdminCompannia)form).getNumero(), 
      ((FormEditarAdminCompannia)form).getPoblacion(), 
      ((FormEditarAdminCompannia)form).getCp(), 
      ((FormEditarAdminCompannia)form).getProvincia());
    
    a.setDireccion(d);
    
    gestionU.editarAdminCompannia(a, a.getId().longValue());
    
    return mapping.findForward("ok");
  }
}
