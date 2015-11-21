package app.actions;

import app.modelo.Aeropuerto;
import app.modelo.Asiento;
import app.modelo.Clase;
import app.modelo.Cliente;
import app.modelo.Pasajero;
import app.modelo.Reserva;
import app.modelo.Rol;
import app.modelo.Usuario;
import app.modelo.Vuelo;
import app.persistencia.ItfzReserva;
import app.persistencia.ItfzUsuario;
import app.persistencia.ItfzVuelo;
import app.persistencia.ReservaDAO;
import app.persistencia.UsuarioDAO;
import app.persistencia.VueloDAO;
import java.util.Date;
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

public class ConfirmarReservaAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession sesion = request.getSession();
    ActionErrors errors = new ActionErrors();
    if (Acceso.Permiso(sesion.getAttribute("user"), Rol.ADMINISTRADOR) || !Acceso.Permiso(sesion.getAttribute("user"), Rol.CLIENTE))
    {      
      errors.add("Permiso", new ActionMessage("errors.soloClientes"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }   
    
    int numPasajeros = ((Integer)sesion.getAttribute("np")).intValue();
    
    boolean disponibleIda = false;
    boolean disponibleVuelta = false;
    
    List<Asiento> asientosIda = null;
    List<Asiento> asientosVuelta = null;
    Vuelo vueloVuelta = null;
    
    ItfzVuelo gestionV = new VueloDAO();
    ItfzUsuario gestionU = new UsuarioDAO();
    ItfzReserva gestionR = new ReservaDAO();
    
    Usuario user = (Usuario)sesion.getAttribute("user");
    Cliente cliente =gestionU.consultarCliente(user.getId()); 
    
    Reserva r = new Reserva();
    
    cliente.addReserva(r);
    r.setCancelada(false);
    
    String claseI = (String)sesion.getAttribute("claseIda");
    Enum claseIda = Enum.valueOf(Clase.class, claseI);
    r.setClaseIda((Clase)claseIda);
    
    double precioIda = (Double)sesion.getAttribute("precioIda");
    r.setPrecioPersona(precioIda);
    if (sesion.getAttribute("precioVuelta")!=null){
    	 double precioVuelta = (Double)sesion.getAttribute("precioVuelta");
    	 r.setPrecioPersona(r.getPrecioPersona()+precioIda);
    }
    
    Enum claseVuelta=null;
    if (sesion.getAttribute("claseVuelta")!=null){
    	String claseV = (String)sesion.getAttribute("claseVuelta");
    	claseVuelta = Enum.valueOf(Clase.class, claseV);
        r.setClaseVuelta((Clase)claseVuelta);
    }
    
    
    r.setFecha(new Date());
    
    Vuelo vueloIda = (Vuelo)sesion.getAttribute("vueloIda");
    vueloIda.addReservaIda(r);
    synchronized (this)
    {
      asientosIda = gestionV.consultaAsientosDisponiblesVuelo(vueloIda.getId().longValue(), ((Clase)claseIda).toString());
      if (asientosIda.size() >= numPasajeros) {
        disponibleIda = true;
      } else {
        errors.add("disponible", new ActionMessage("errors.disponible", vueloIda.getOrigen().getCiudad(), vueloIda.getDestino().getCiudad()));
      }
      if (sesion.getAttribute("vueloVuelta") != null)
      {
        vueloVuelta = (Vuelo)sesion.getAttribute("vueloVuelta");
        vueloVuelta.addReservaVuelta(r);
        
        asientosVuelta = gestionV.consultaAsientosDisponiblesVuelo(vueloVuelta.getId().longValue(), ((Clase)claseVuelta).toString());
        if (asientosVuelta.size() >= numPasajeros) {
          disponibleVuelta = true;
        } else {
          errors.add("disponible", new ActionMessage("errors.disponible", vueloVuelta.getOrigen().getCiudad(), vueloVuelta.getDestino().getCiudad()));
        }
        if ((disponibleIda) && (disponibleVuelta))
        {
          asientosIda = gestionV.reservarAsientosVuelo(vueloIda.getId().longValue(), ((Clase)claseIda).toString(), numPasajeros);
          asientosVuelta = gestionV.reservarAsientosVuelo(vueloVuelta.getId().longValue(), ((Clase)claseVuelta).toString(), numPasajeros);
          
          sesion.setAttribute("asientosVuelta", asientosVuelta);
        }
        else
        {
          addErrors(request, errors);
          return mapping.findForward("error");
        }
      }
      else if (disponibleIda)
      {
        asientosIda = gestionV.reservarAsientosVuelo(vueloIda.getId().longValue(), claseI, numPasajeros);
      }
      else
      {
        addErrors(request, errors);
        return mapping.findForward("error");
      }
    }
    List<Pasajero> pasajeros = (List<Pasajero>)sesion.getAttribute("pasajeros");
    int conta = 0;
    for (Pasajero p : pasajeros)
    {
      p.setAsientoIda((Asiento)asientosIda.get(conta));
      if (sesion.getAttribute("vueloVuelta") != null) {
        p.setAsientoVuelta((Asiento)asientosVuelta.get(conta));
      }
      conta++;
      r.addPasajero(p);
    }
    
    
    gestionR.altaReserva(r);
    
    return mapping.findForward("ok");
  }
}
