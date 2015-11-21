package app.actions;

import app.modelo.AdminCompannia;
import app.modelo.Rol;
import app.modelo.Usuario;
import app.modelo.Vuelo;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;

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

public class AdminVuelosAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession session = request.getSession();
    if (!Acceso.Permiso(session.getAttribute("user"), Rol.ADMINISTRADOR))
    {
      ActionErrors errors = new ActionErrors();
      errors.add("Permiso", new ActionMessage("errors.permiso"));
      addErrors(request, errors);
      return mapping.findForward("error");
    }    
    
    ItfzVuelo gestionV = new VueloDAO();    
    List<Vuelo> vuelos = new ArrayList<Vuelo>();
    
    Usuario user = (Usuario)session.getAttribute("user");
    if (user.getRol().toString().equals(Rol.ADMINISTRADOR.toString())){
    	AdminCompannia admin = (AdminCompannia)user;
    	vuelos = gestionV.consultarVuelosCompannia(admin.getCompannia().getId());
    }else{
    	vuelos = gestionV.consultarVuelos();
    }       
    request.setAttribute("vuelos", vuelos);
    return mapping.findForward("ok");
  }
}
