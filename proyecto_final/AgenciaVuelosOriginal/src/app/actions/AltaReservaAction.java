package app.actions;

import app.actionforms.FormAltaReserva;
import app.modelo.Clase;
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

public class AltaReservaAction
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
    
    Reserva r = new Reserva();
    
    Enum claseIda = Enum.valueOf(Clase.class, ((FormAltaReserva)form).getClaseIda());
    r.setClaseIda((Clase)claseIda);
    Enum claseVuelta = Enum.valueOf(Clase.class, ((FormAltaReserva)form).getClaseVuelta());
    r.setClaseVuelta((Clase)claseVuelta);
    
    Cliente c = gestionU.consultarCliente(((FormAltaReserva)form).getIdCliente());
    c.addReserva(r);
    
    r.setFecha(Fecha.convetirDate("25/03/2015"));
    
    r.setPrecioPersona(((FormAltaReserva)form).getPrecioPersona());
    
    Vuelo vueloIda = gestionV.consultarVuelo(((FormAltaReserva)form).getIdVueloIda());
    vueloIda.addReservaIda(r);
    
    Vuelo vueloVuelta = gestionV.consultarVuelo(((FormAltaReserva)form).getIdVueloVuelta());
    vueloVuelta.addReservaVuelta(r);
    
    gestionR.altaReserva(r);
    
    return mapping.findForward("ok");
  }
}