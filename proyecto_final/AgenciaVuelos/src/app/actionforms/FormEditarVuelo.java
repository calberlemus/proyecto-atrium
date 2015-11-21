package app.actionforms;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import app.modelo.Aeropuerto;
import app.modelo.Compannia;
import app.modelo.Direccion;
import app.modelo.Vuelo;
import app.persistencia.AeropuertoDAO;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzCompannia;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;
import app.util.Fecha;

public class FormEditarVuelo extends ValidatorForm {
	private Long id;
	private Long idAeropuertoOrigen;
	private Long idAeropuertoDestino;
	private String diaSalida;
	private String horaSalida;
	private String diaLlegada;
	private String horaLlegada;
	private Long idCompannia;
	private double precioOferta;
	private double precioTurista;
	private double precioBussines;
	private int numAsientosOferta;
	private int numAsientosTurista;
	private int numAsientosBussines;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdAeropuertoOrigen() {
		return idAeropuertoOrigen;
	}
	public void setIdAeropuertoOrigen(Long idAeropuertoOrigen) {
		this.idAeropuertoOrigen = idAeropuertoOrigen;
	}
	public Long getIdAeropuertoDestino() {
		return idAeropuertoDestino;
	}
	public void setIdAeropuertoDestino(Long idAeropuertoDestino) {
		this.idAeropuertoDestino = idAeropuertoDestino;
	}
	public String getDiaSalida() {
		return diaSalida;
	}
	public void setDiaSalida(String diaSalida) {
		this.diaSalida = diaSalida;
	}
	public String getDiaLlegada() {
		return diaLlegada;
	}
	public void setDiaLlegada(String diaLlegada) {
		this.diaLlegada = diaLlegada;
	}
	public Long getIdCompannia() {
		return idCompannia;
	}
	public void setIdCompannia(Long idCompannia) {
		this.idCompannia = idCompannia;
	}
	public double getPrecioOferta() {
		return precioOferta;
	}
	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}
	public double getPrecioTurista() {
		return precioTurista;
	}
	public void setPrecioTurista(double precioTurista) {
		this.precioTurista = precioTurista;
	}
	public double getPrecioBussines() {
		return precioBussines;
	}
	public void setPrecioBussines(double precioBussines) {
		this.precioBussines = precioBussines;
	}
	
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public int getNumAsientosOferta() {
		return numAsientosOferta;
	}
	public void setNumAsientosOferta(int numAsientosOferta) {
		this.numAsientosOferta = numAsientosOferta;
	}
	public int getNumAsientosTurista() {
		return numAsientosTurista;
	}
	public void setNumAsientosTurista(int numAsientosTurista) {
		this.numAsientosTurista = numAsientosTurista;
	}
	public int getNumAsientosBussines() {
		return numAsientosBussines;
	}
	public void setNumAsientosBussines(int numAsientosBussines) {
		this.numAsientosBussines = numAsientosBussines;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		ItfzAeropuerto gestionA = new AeropuertoDAO();
		ItfzCompannia gestionC = new CompanniaDAO();
		ItfzVuelo gestionV = new VueloDAO();

		List<Compannia> compannias = gestionC.consultarCompannias();
		request.setAttribute("compannias", compannias);

		List<Aeropuerto> aeropuertos = gestionA.consultarAeropuertos();
		request.setAttribute("aeropuertos", aeropuertos);
		
		Vuelo vuelo = gestionV.consultarVuelo(Long.parseLong(request.getParameter("id")));
		request.setAttribute("vuelo", vuelo);

		super.reset(mapping, request);
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (this.idAeropuertoOrigen == 0) {
			errors.add("idAeropuertoOrigen", new ActionMessage(
					"errors.required", "Aeropuerto de origen"));
		} else if (this.idAeropuertoOrigen.longValue() == this.idAeropuertoDestino.longValue()) {
			errors.add("idAeropuertoOrigen", new ActionMessage(
					"errors.aeropuertos"));
		}
		if (this.idAeropuertoDestino == 0) {
			errors.add("idAeropuertoDestino", new ActionMessage(
					"errors.required", "Aeropuerto de destino"));
		}
		if (this.diaSalida.equals("")
				|| this.diaSalida.equals("Ida")) {
			errors.add("diaSalida", new ActionMessage("errors.required",
					"Fecha de salida"));
		}
		if (this.diaLlegada.equals("")
				|| this.diaSalida.equals("Vuelta")) {
			errors.add("diaLlegada", new ActionMessage("errors.required",
					"Fecha de llegada"));
		}
		if (this.horaSalida==null || this.horaSalida.toString().equals("")){
			errors.add("horaSalida", new ActionMessage("errors.required",
					"Hora de salida"));
		}
		if (this.horaLlegada==null || this.horaLlegada.toString().equals("")) {
			errors.add("horaLlegada", new ActionMessage("errors.required",
					"Hora de llegada"));
		}

		if (!this.diaSalida.equals("")
				&& !this.diaLlegada.equals("")
				&& Fecha.convetirDate(this.diaSalida).compareTo(
						Fecha.convetirDate(this.diaLlegada)) > 0) {
			errors.add("diaLlegada", new ActionMessage("errors.fechas"));
		}

		return errors;
	}
	
}
