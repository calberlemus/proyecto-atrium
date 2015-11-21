package app.actions;

import app.modelo.Aeropuerto;
import app.modelo.Oferta;
import app.modelo.Usuario;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzOferta;
import app.persistencia.ItfzUsuario;
import app.persistencia.ItfzVuelo;
import app.persistencia.OfertaDAO;
import app.persistencia.UsuarioDAO;
import app.persistencia.VueloDAO;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HomeAction
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
	ItfzVuelo gestionV = new VueloDAO();	
	List<Vuelo> vuelosNac = gestionV.consultarVuelosNacionales();
	List<Vuelo> vuelosInt = gestionV.consultarVuelosInternacionales();
	request.setAttribute("vuelosNac", vuelosNac);
	request.setAttribute("vuelosInt", vuelosInt);
	
	ItfzOferta gestionO = new OfertaDAO();
	List<Oferta> ofertas = gestionO.consultarOfertas();
	request.setAttribute("ofertas", ofertas);
	
	  
    ItfzUsuario gestionU = new UsuarioDAO();    
    List<Usuario> usuarios = gestionU.ConsultaUsuarios();
    if ((usuarios == null) || (usuarios.size() == 0)) {
      return mapping.findForward("Super");
    }
    HttpSession sesion = request.getSession(true);
    sesion.removeAttribute("vueloIda");
    sesion.removeAttribute("vueloVuelta");
    sesion.removeAttribute("clase");
    sesion.removeAttribute("np");
    sesion.removeAttribute("pasajeros");
    sesion.removeAttribute("asientosIda");
    sesion.removeAttribute("asientosVuelta");
    
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    request.setAttribute("aeropuertos", aeropuertos);
    
    return mapping.findForward("ok");
  }
}
