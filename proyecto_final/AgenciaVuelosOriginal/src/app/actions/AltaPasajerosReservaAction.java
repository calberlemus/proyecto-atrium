package app.actions;

import app.modelo.Direccion;
import app.modelo.Pasajero;
import app.modelo.Rol;
import app.modelo.TipoPasajero;
import app.util.Fecha;
import java.util.ArrayList;
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

public class AltaPasajerosReservaAction
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
    int np = Integer.parseInt(request.getParameter("np"));    
    HttpSession sesion = request.getSession(true);
    List<Pasajero> pasajeros = new ArrayList<Pasajero>();
    
    ActionErrors errors = new ActionErrors();
    
    sesion.removeAttribute("pasajeros");
    sesion.removeAttribute("np");
    /*
     * Se obtinene los datos de los pasajeros de la reserva a la vez que se validan 
     */
    for (int i = 1; i <= np; i++)
    {
      Pasajero p = new Pasajero();
      if ((request.getParameter("nombre-" + i) == null) || (request.getParameter("nombre-" + i).equals(""))) {
        errors.add("nombre-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Nombre"));
      } else {
        p.setNombre(request.getParameter("nombre-" + i));
      }
      if ((request.getParameter("apellidos-" + i) == null) || (request.getParameter("apellidos-" + i).equals(""))) {
        errors.add("apellidos-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Apellidos"));
      } else {
        p.setApellidos(request.getParameter("apellidos-" + i));
      }
      if ((request.getParameter("tipo-" + i) == null) || (request.getParameter("tipo-" + i).equals("")))
      {
        errors.add("tipo-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Tipo"));
      }
      else
      {
        Enum tipo = Enum.valueOf(TipoPasajero.class, request.getParameter("tipo-" + i));
        p.setTipo((TipoPasajero)tipo);
      }
      Direccion d = new Direccion();
      if ((request.getParameter("calle-" + i) == null) || (request.getParameter("calle-" + i).equals(""))) {
        errors.add("calle-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Calle"));
      } else {
        d.setCalle(request.getParameter("calle-" + i));
      }
      if ((request.getParameter("cp-" + i) == null) || (request.getParameter("dni-" + i).equals(""))) {
        errors.add("cp-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Cp"));
      } else if (isNumeric(request.getParameter("cp-" + i))) {
        d.setCp(Long.parseLong(request.getParameter("cp-" + i)));
      } else {
        errors.add("cp-" + i, new ActionMessage("errors.numericoPasajeros", "Cp", Integer.valueOf(i)));
      }
      if ((request.getParameter("numero-" + i) == null) || (request.getParameter("numero-" + i).equals(""))) {
        errors.add("numero-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Numero"));
      } else {
        d.setNumero(request.getParameter("numero-" + i));
      }
      if ((request.getParameter("poblacion-" + i) == null) || (request.getParameter("poblacion-" + i).equals(""))) {
        errors.add("poblacion-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Población"));
      } else {
        d.setPoblacion(request.getParameter("poblacion-" + i));
      }
      if ((request.getParameter("provincia-" + i) == null) || (request.getParameter("provincia-" + i).equals(""))) {
        errors.add("provincia-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Provincia"));
      } else {
        d.setProvincia(request.getParameter("provincia-" + i));
      }
      p.setDireccion(d);
      if ((request.getParameter("dni-" + i) == null) || (request.getParameter("dni-" + i).equals("")))
      {
        errors.add("dni-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Dni"));
      }
      else
      {
        boolean duplicado = false;
        for (Pasajero pasajero : pasajeros) {
          if ((pasajero.getDni() != null) && (pasajero.getDni().equals(request.getParameter("dni-" + i).toUpperCase())))
          {
            errors.add("dni-" + i, new ActionMessage("errors.dniPasajeros", Integer.valueOf(i)));
            duplicado = true;
            break;
          }
        }
        if (!duplicado) {
          p.setDni(request.getParameter("dni-" + i).toUpperCase());
        }
      }
      if ((request.getParameter("fechaNacimiento-" + i) == null) || (request.getParameter("fechaNacimiento-" + i).equals(""))) {
        errors.add("fechaNacimiento-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Fecha de nacimiento"));
      } else {
        p.setFechaNacimiento(Fecha.convetirDate(request.getParameter("fechaNacimiento-" + i)));
      }
      if ((request.getParameter("fechaCadDni-" + i) == null) || (request.getParameter("fechaCadDni-" + i).equals("")))
      {
        errors.add("fechaCadDni-" + i, new ActionMessage("errors.requiredMultiple", Integer.valueOf(i), "Fecha de caducidad Dni"));
      }
      else
      {
        p.setFechaCadDni(Fecha.convetirDate(request.getParameter("fechaCadDni-" + i)));
        if (p.getFechaCadDni().before(p.getFechaNacimiento())) {
          errors.add("fechaCadDni-" + i, new ActionMessage("errors.fechaCadNoValida", Integer.valueOf(i)));
        }
      }
      pasajeros.add(p);
    }
    sesion.setAttribute("np", Integer.valueOf(np));
    sesion.setAttribute("pasajeros", pasajeros);
    if (errors.size() == 0) {
      return mapping.findForward("ok");
    }
    addErrors(request, errors);
    return mapping.findForward("ok2");
  }
  
  private static boolean isNumeric(String cadena)
  {
    try
    {
      Long.parseLong(cadena);
      return true;
    }
    catch (NumberFormatException nfe) {}
    return false;
  }
}
