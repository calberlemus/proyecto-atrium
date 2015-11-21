package app.actions;

import app.actionforms.FormEditarAeropuerto;
import app.modelo.Aeropuerto;
import app.modelo.Rol;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EditarAeropuertoAction
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
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    
    Aeropuerto a = new Aeropuerto();
    a.setCiudad(((FormEditarAeropuerto)form).getCiudad().toUpperCase());
    a.setCodigo(((FormEditarAeropuerto)form).getCodigo().toUpperCase());
    a.setNombre(((FormEditarAeropuerto)form).getNombre().toUpperCase());
    a.setPais(((FormEditarAeropuerto)form).getPais().toUpperCase());
    a.setId(((FormEditarAeropuerto)form).getId());
    
    gestionA.editarAeropuerto(a, a.getId().longValue());
    
    return mapping.findForward("ok");
  }
}
