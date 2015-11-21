package app.actions;

import app.actionforms.FormEditarCliente;
import app.modelo.Cliente;
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

public class EditarClienteAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if ((!Acceso.Permiso(session.getAttribute("user"), Rol.CLIENTE)) || (
      (((Usuario)session.getAttribute("user")).getRol().ordinal() == Rol.CLIENTE.ordinal()) && 
      (((Usuario)session.getAttribute("user")).getId().longValue() != ((FormEditarCliente)form)
      .getId().longValue())))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    ItfzUsuario gestionU = new UsuarioDAO();
    
    Cliente c = new Cliente();
    c.setNick(((FormEditarCliente)form).getNick());
    c.setPass(((FormEditarCliente)form).getPass());
    c.setRol(Rol.CLIENTE);
    c.setId(((FormEditarCliente)form).getId());
    c.setNombre(((FormEditarCliente)form).getNombre());
    c.setApellidos(((FormEditarCliente)form).getApellidos());
    c.setDni(((FormEditarCliente)form).getDni());
    c.setFechaNacimiento(Fecha.convetirDate(((FormEditarCliente)form).getFechaNacimiento()));
    c.setDni(((FormEditarCliente)form).getDni());
    c.setTelefono(((FormEditarCliente)form).getTelefono());
    c.setEmail(((FormEditarCliente)form).getEmail());
    c.setNumCliente(Long.valueOf(((FormEditarCliente)form).getNumCliente()));
    
    Direccion d = new Direccion(((FormEditarCliente)form).getCalle(), ((FormEditarCliente)form).getNumero(), 
      ((FormEditarCliente)form).getPoblacion(), ((FormEditarCliente)form).getCp(), 
      ((FormEditarCliente)form).getProvincia());
    
    c.setDireccion(d);
    
    gestionU.editarCliente(c, c.getId().longValue());
    
    return mapping.findForward("ok");
  }
}
