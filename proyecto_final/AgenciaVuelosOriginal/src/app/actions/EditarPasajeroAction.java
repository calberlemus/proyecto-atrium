package app.actions;

import app.actionforms.FormEditarPasajero;
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

public class EditarPasajeroAction
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
    
    p.setId(Long.valueOf(((FormEditarPasajero)form).getId()));
    p.setNombre(((FormEditarPasajero)form).getNombre());
    p.setApellidos(((FormEditarPasajero)form).getApellidos());
    p.setDni(((FormEditarPasajero)form).getDni());
    p.setFechaNacimiento(Fecha.convetirDate(((FormEditarPasajero)form).getFechaNacimiento()));
    p.setFechaCadDni(Fecha.convetirDate(((FormEditarPasajero)form).getFechaCadDni()));
    
    Enum tipo = Enum.valueOf(TipoPasajero.class, ((FormEditarPasajero)form).getTipo());
    p.setTipo((TipoPasajero)tipo);
    
    Asiento asientoIda = gestionV.consultarAsiento(((FormEditarPasajero)form).getIdAsientoIda());
    Asiento asientoVuelta = gestionV.consultarAsiento(((FormEditarPasajero)form).getIdAsientoVuelta());
    
    p.setAsientoIda(asientoIda);
    p.setAsientoVuelta(asientoVuelta);
    
    Direccion d = new Direccion(((FormEditarPasajero)form).getCalle(), ((FormEditarPasajero)form).getNumero(), 
      ((FormEditarPasajero)form).getPoblacion(), ((FormEditarPasajero)form).getCp(), 
      ((FormEditarPasajero)form).getProvincia());
    
    p.setDireccion(d);
    
    gestionP.editarPasajero(p);
    
    return mapping.findForward("ok");
  }
}