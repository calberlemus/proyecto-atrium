package app.actions;

import app.actionforms.FormBusquedaVuelos;
import app.modelo.Aeropuerto;
import app.modelo.Clase;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;
import app.util.Fecha;
import app.util.VueloClasePrecio;
import app.util.VuelosIdaVuelta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

public class BuscarVuelosOfertas
  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    List<VuelosIdaVuelta> vivs = new ArrayList<VuelosIdaVuelta>();
    ItfzVuelo gestionV = new VueloDAO();  
    
    int numPasajeros = 1;
    String clase = Clase.OFERTA.toString();
    request.setAttribute("clase",clase);
    Enum claseVuelo = Enum.valueOf(Clase.class, clase);
    
    List<Vuelo> vuelos = new ArrayList<Vuelo>();
    
    if (request.getParameter("destino")!=null){
    	vuelos = gestionV.consultarVuelosDestino(Long.parseLong(request.getParameter("destino")));
    	request.setAttribute("destino",Long.parseLong(request.getParameter("destino")));
    }else if (request.getParameter("id")!=null){
    	Vuelo vuelo = gestionV.consultarVuelo(Long.parseLong(request.getParameter("id")));
    	request.setAttribute("ida",Fecha.convertirDDMMYYY(vuelo.getDiaSalida()));    	
        Long origen = vuelo.getOrigen().getId();
        request.setAttribute("origen",origen);
        Long destino = vuelo.getDestino().getId();
        request.setAttribute("destino",destino);
    	vuelos = gestionV.consultarVuelos(origen, destino);
    }	
    for (Vuelo v : vuelos)
    {
    	VueloClasePrecio vueloIda = new VueloClasePrecio();

		boolean disponibleIda = true;
		if (v.asientosDisponibles((Clase) claseVuelo) < numPasajeros) {
			if (Clase.OFERTA.toString() == clase) {
				if (v.asientosDisponibles(Clase.TURISMO) >= numPasajeros) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.TURISMO.toString());
					vueloIda.setPrecio(v.getPrecioTurista());
				} else if (v.asientosDisponibles(Clase.BUSSINES) >= numPasajeros) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.BUSSINES.toString());
					vueloIda.setPrecio(v.getPrecioBussines());
				} else {
					disponibleIda = false;
				}
			} else if (Clase.TURISMO.toString() == clase) {
				if (v.asientosDisponibles(Clase.OFERTA) >= numPasajeros) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.OFERTA.toString());
					vueloIda.setPrecio(v.getPrecioOferta());
				} else if (v.asientosDisponibles(Clase.BUSSINES) >= numPasajeros) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.BUSSINES.toString());
					vueloIda.setPrecio(v.getPrecioBussines());
				} else {
					disponibleIda = false;
				}
			} else {
				if (v.asientosDisponibles(Clase.OFERTA) >= numPasajeros) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.OFERTA.toString());
					vueloIda.setPrecio(v.getPrecioOferta());
				} else if (v.asientosDisponibles(Clase.TURISMO) >= numPasajeros) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.TURISMO.toString());
					vueloIda.setPrecio(v.getPrecioTurista());
				} else {
					disponibleIda = false;
				}
			}
		} else {
			if (Clase.OFERTA.toString() == clase) {
				vueloIda.setVuelo(v);
				vueloIda.setClase(Clase.OFERTA.toString());
				vueloIda.setPrecio(v.getPrecioOferta());
			} else if (Clase.TURISMO.toString() == clase) {
				vueloIda.setVuelo(v);
				vueloIda.setClase(Clase.TURISMO.toString());
				vueloIda.setPrecio(v.getPrecioTurista());
			} else {
				vueloIda.setVuelo(v);
				vueloIda.setClase(Clase.BUSSINES.toString());
				vueloIda.setPrecio(v.getPrecioBussines());
			}
		}
		if (disponibleIda) {
			VuelosIdaVuelta viv = new VuelosIdaVuelta();
			viv.setVueloIda(vueloIda);            
			vivs.add(viv);
		}	
    }
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    
    List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
    
    request.setAttribute("aeropuertos", aeropuertos);
    request.setAttribute("vuelos", vivs);
    request.setAttribute("np", Integer.valueOf(numPasajeros));
    request.setAttribute("clase", clase);
    int soloIda = 2;
    request.setAttribute("soloIda", Integer.valueOf(soloIda));
    if ((getErrors(request) == null) || (getErrors(request).size() == 0)) {
      return mapping.findForward("idavuelta");
    }
    return mapping.getInputForward();
  }
}
