package app.util;

import java.util.Date;
import java.util.Set;

import app.modelo.Aeropuerto;
import app.modelo.Asiento;
import app.modelo.Compannia;
import app.modelo.Reserva;
import app.modelo.Vuelo;

public class VueloClasePrecio {
	private String clase;	
	private double precio;
	private Vuelo vuelo;
	public VueloClasePrecio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
}
