package app.actions;

import app.actionforms.FormAltaCliente;
import app.modelo.Cliente;
import app.modelo.Direccion;
import app.modelo.Rol;
import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
import app.util.Fecha;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AltaClienteAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ItfzUsuario gestionU = new UsuarioDAO();
    
    Cliente c = new Cliente();
    
    c.setNick(((FormAltaCliente)form).getNick());
    c.setPass(((FormAltaCliente)form).getPass());
    
    c.setRol(Rol.CLIENTE);
    
    c.setNombre(((FormAltaCliente)form).getNombre());
    c.setApellidos(((FormAltaCliente)form).getApellidos());
    c.setDni(((FormAltaCliente)form).getDni());
    c.setFechaNacimiento(Fecha.convetirDate(((FormAltaCliente)form).getFechaNacimiento()));
    c.setDni(((FormAltaCliente)form).getDni());
    c.setTelefono(((FormAltaCliente)form).getTelefono());
    c.setEmail(((FormAltaCliente)form).getEmail());
    c.setNumCliente(Long.valueOf(((FormAltaCliente)form).getNumCliente()));
    
    Direccion d = new Direccion(((FormAltaCliente)form).getCalle(), ((FormAltaCliente)form).getNumero(), 
      ((FormAltaCliente)form).getPoblacion(), ((FormAltaCliente)form).getCp(), 
      ((FormAltaCliente)form).getProvincia());
    
    c.setDireccion(d);
    gestionU.altaCliente(c);
    
    return mapping.findForward("ok");
  }
}

