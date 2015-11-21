package app.actions;

import app.actionforms.FormAltaPasajero;
import app.modelo.Asiento;
import app.modelo.Direccion;
import app.modelo.Pasajero;
import app.modelo.Rol;
import app.modelo.TipoPasajero;
import app.persistencia.ItfzPasajero;
import app.persistencia.ItfzVuelo;
import app.persistencia.PasajeroDAO;
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

public class AltaPasajeroAction
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
    ItfzPasajero gestionP = new PasajeroDAO();
    ItfzVuelo gestionV = new VueloDAO();
    
    Pasajero p = new Pasajero();
    
    p.setNombre(((FormAltaPasajero)form).getNombre());
    p.setApellidos(((FormAltaPasajero)form).getApellidos());
    p.setDni(((FormAltaPasajero)form).getDni());
    p.setFechaNacimiento(Fecha.convetirDate(((FormAltaPasajero)form).getFechaNacimiento()));
    p.setFechaCadDni(Fecha.convetirDate(((FormAltaPasajero)form).getFechaCadDni()));
    
    Enum tipo = Enum.valueOf(TipoPasajero.class, ((FormAltaPasajero)form).getTipo());
    p.setTipo((TipoPasajero)tipo);
    
    Asiento asientoIda = gestionV.consultarAsiento(((FormAltaPasajero)form).getIdAsientoIda());
    asientoIda.setDisponible(Boolean.valueOf(false));
    gestionV.editarAsiento(asientoIda);
    Asiento asientoVuelta = gestionV.consultarAsiento(((FormAltaPasajero)form).getIdAsientoVuelta());
    asientoVuelta.setDisponible(Boolean.valueOf(false));
    gestionV.editarAsiento(asientoVuelta);
    
    p.setAsientoIda(asientoIda);
    p.setAsientoVuelta(asientoVuelta);
    
    Direccion d = new Direccion(((FormAltaPasajero)form).getCalle(), ((FormAltaPasajero)form).getNumero(), 
      ((FormAltaPasajero)form).getPoblacion(), ((FormAltaPasajero)form).getCp(), 
      ((FormAltaPasajero)form).getProvincia());
    
    p.setDireccion(d);
    
    gestionP.altaPasajero(p);
    
    return mapping.findForward("ok");
  }
}
