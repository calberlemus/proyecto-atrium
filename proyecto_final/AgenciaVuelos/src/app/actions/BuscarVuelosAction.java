package app.actions;

import app.actionforms.FormBusquedaVuelos;
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

public class BuscarVuelosAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Listado de vuelos con sus respectivos vuelos de vuelta
		List<VuelosIdaVuelta> vivs = new ArrayList<VuelosIdaVuelta>();
		
		ItfzVuelo gestionV = new VueloDAO();
		long origen = ((FormBusquedaVuelos) form).getIdAeropuertoOrigen();
		long destino = ((FormBusquedaVuelos) form).getIdAeropuertoDestino();
		
		int soloIda = Integer.parseInt(request.getParameter("idavuelta"));

		Date salida = Fecha.convetirDate(((FormBusquedaVuelos) form)
				.getFechaHoraSalida());
		Date llegada = Fecha.convetirDate(((FormBusquedaVuelos) form)
				.getFechaHoraLlegada());

		int numPasajeros = ((FormBusquedaVuelos) form).getNpasajeros();
		String clase = ((FormBusquedaVuelos) form).getClase();
		Enum claseVuelo = Enum.valueOf(Clase.class, clase);

		List<Vuelo> vuelos = gestionV.consultarVuelos(origen, destino, salida);
		
		for (Vuelo v : vuelos) {
			
			VueloClasePrecio vueloIda = new VueloClasePrecio();

			boolean disponibleIda = true;			
			
			if (v.asientosDisponibles((Clase)claseVuelo) < numPasajeros) {
				if (Clase.OFERTA.toString().equals(clase)) {
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
				} else if (Clase.TURISMO.toString().equals(clase)) {
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
				if (Clase.OFERTA.toString().equals(clase)) {
					vueloIda.setVuelo(v);
					vueloIda.setClase(Clase.OFERTA.toString());
					vueloIda.setPrecio(v.getPrecioOferta());
				} else if (Clase.TURISMO.toString().equals(clase)) {
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
				List<Vuelo> vuelosVueltaConsulta = gestionV
						.consultarVuelosVuelta(v, llegada);
				List<VueloClasePrecio> vuelosVuelta = new ArrayList<VueloClasePrecio>();
				for (Vuelo v2 : vuelosVueltaConsulta) {
					boolean disponibleVuelta = true;
					VueloClasePrecio vueloVuelta = new VueloClasePrecio();
					if (v2.asientosDisponibles((Clase) claseVuelo) < numPasajeros) {
						if (Clase.OFERTA.toString().equals(clase)) {
							if (v2.asientosDisponibles(Clase.TURISMO) >= numPasajeros) {
								vueloVuelta.setVuelo(v2);
								vueloVuelta.setClase(Clase.TURISMO.toString());
								vueloVuelta.setPrecio(v2.getPrecioTurista());
							} else if (v2.asientosDisponibles(Clase.BUSSINES) >= numPasajeros) {
								vueloVuelta.setVuelo(v2);
								vueloVuelta.setClase(Clase.BUSSINES.toString());
								vueloVuelta.setPrecio(v2.getPrecioBussines());
							} else {
								disponibleIda = false;
							}
						} else if (Clase.TURISMO.toString().equals(clase)) {
							if (v2.asientosDisponibles(Clase.OFERTA) >= numPasajeros) {
								vueloVuelta.setVuelo(v2);
								vueloVuelta.setClase(Clase.OFERTA.toString());
								vueloVuelta.setPrecio(v2.getPrecioOferta());
							} else if (v2.asientosDisponibles(Clase.BUSSINES) >= numPasajeros) {
								vueloVuelta.setVuelo(v2);
								vueloVuelta.setClase(Clase.BUSSINES.toString());
								vueloVuelta.setPrecio(v2.getPrecioBussines());
							} else {
								disponibleIda = false;
							}
						} else {
							if (v2.asientosDisponibles(Clase.OFERTA) >= numPasajeros) {
								vueloVuelta.setVuelo(v2);
								vueloVuelta.setClase(Clase.OFERTA.toString());
								vueloVuelta.setPrecio(v2.getPrecioOferta());
							} else if (v2.asientosDisponibles(Clase.TURISMO) >= numPasajeros) {
								vueloVuelta.setVuelo(v2);
								vueloVuelta.setClase(Clase.TURISMO.toString());
								vueloVuelta.setPrecio(v2.getPrecioTurista());
							} else {
								disponibleIda = false;
							}
						}
					} else {
						if (Clase.OFERTA.toString().equals(clase)) {
							vueloVuelta.setVuelo(v2);
							vueloVuelta.setClase(Clase.OFERTA.toString());
							vueloVuelta.setPrecio(v2.getPrecioOferta());
						} else if (Clase.TURISMO.toString().equals(clase)) {
							vueloVuelta.setVuelo(v2);
							vueloVuelta.setClase(Clase.TURISMO.toString());
							vueloVuelta.setPrecio(v2.getPrecioTurista());
						} else {
							vueloVuelta.setVuelo(v2);
							vueloVuelta.setClase(Clase.BUSSINES.toString());
							vueloVuelta.setPrecio(v2.getPrecioBussines());
						}
					}

					if (disponibleVuelta) {
						vuelosVuelta.add(vueloVuelta);
					}

				}
				if (vuelosVuelta.size() > 0 && soloIda==1) {
					viv.setVuelosVuelta(vuelosVuelta);
					vivs.add(viv);					
				}else if (soloIda==2){
					System.out.println("vuelo ida: "+viv.getVueloIda().getVuelo().getId());
					vivs.add(viv);
				}
			}
		}
		ItfzAeropuerto gestionA = new AeropuertoDAO();

		Object aeropuertos = gestionA.consultarAeropuertos();

		request.setAttribute("aeropuertos", aeropuertos);
		request.setAttribute("vuelos", vivs);
		request.setAttribute("np", Integer.valueOf(numPasajeros));
		request.setAttribute("clase", clase);		
		request.setAttribute("soloIda", Integer.valueOf(soloIda));
		if ((getErrors(request) == null) || (getErrors(request).size() == 0)) {
			return mapping.findForward("idavuelta");
		}
		return mapping.getInputForward();
	}
}
