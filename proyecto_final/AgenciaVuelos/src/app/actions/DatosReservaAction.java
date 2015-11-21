package app.actions;

import app.modelo.Cliente;
import app.modelo.Reserva;
import app.modelo.Rol;
import app.modelo.Vuelo;
import app.persistencia.ItfzReserva;
import app.persistencia.ItfzUsuario;
import app.persistencia.ItfzVuelo;
import app.persistencia.ReservaDAO;
import app.persistencia.UsuarioDAO;
import app.persistencia.VueloDAO;
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

public class DatosReservaAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if (!Acceso.Permiso(session.getAttribute("user"), Rol.CLIENTE))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }
    ItfzVuelo gestionV = new VueloDAO();
    ItfzUsuario gestionU = new UsuarioDAO();
    ItfzReserva gestionR = new ReservaDAO();
    
    List<Cliente> clientes = gestionU.consultarClientes();
    request.setAttribute("clientes", clientes);
    
    List<Vuelo> vuelos = gestionV.consultarVuelos();
    request.setAttribute("vuelosIda", vuelos);
    request.setAttribute("vuelosVuelta", vuelos);
    if (request.getParameter("id") == null) {
      return mapping.findForward("alta");
    }
    Reserva r = gestionR.consultarReserva(Long.parseLong(request.getParameter("id")));
    request.setAttribute("reserva", r);
    return mapping.findForward("editar");
  }
}
