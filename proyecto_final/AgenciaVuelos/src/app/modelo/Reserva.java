package app.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reserva implements Serializable {
	
	private Long Id;	
	private Vuelo vueloIda;
	private Vuelo vueloVuelta;
	private Cliente cliente;
	private Clase claseIda;
	private Clase claseVuelta;
	private double precioPersona;
	private boolean cancelada;
	private Date fecha;
	private Set<Pasajero> pasajeros = new HashSet<Pasajero>();
	
	public Reserva() {
		
	}
	
	
	public Reserva(Long id, Vuelo vueloIda, Vuelo vueloVuelta, Cliente cliente,
			Clase claseIda, Clase claseVuelta, double precioPersona,
			boolean cancelada, Date fecha, Set<Pasajero> pasajeros) {
		super();
		Id = id;
		this.vueloIda = vueloIda;
		this.vueloVuelta = vueloVuelta;
		this.cliente = cliente;
		this.claseIda = claseIda;
		this.claseVuelta = claseVuelta;
		this.precioPersona = precioPersona;
		this.cancelada = cancelada;
		this.fecha = fecha;
		this.pasajeros = pasajeros;
	}


	public void addPasajero(Pasajero p){
		pasajeros.add(p);
		p.getReservas().add(this);
	}

	

	public boolean isCancelada() {
		return cancelada;
	}


	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Vuelo getVueloIda() {
		return vueloIda;
	}

	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}

	public Vuelo getVueloVuelta() {
		return vueloVuelta;
	}

	public void setVueloVuelta(Vuelo vueloVuelta) {
		this.vueloVuelta = vueloVuelta;
	}

	public Clase getClaseIda() {
		return claseIda;
	}

	public void setClaseIda(Clase claseIda) {
		this.claseIda = claseIda;
	}

	public Clase getClaseVuelta() {
		return claseVuelta;
	}

	public void setClaseVuelta(Clase claseVuelta) {
		this.claseVuelta = claseVuelta;
	}

	public double getPrecioPersona() {
		return precioPersona;
	}

	public void setPrecioPersona(double precioPersona) {
		this.precioPersona = precioPersona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Set<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return "Reserva [Id=" + Id + ", vueloIda=" + vueloIda
				+ ", vueloVuelta=" + vueloVuelta + ", cliente=" + cliente
				+ ", claseIda=" + claseIda + ", claseVuelta=" + claseVuelta
				+ ", precioPersona=" + precioPersona + ", fecha=" + fecha
				+ ", pasajeros=" + pasajeros + "]";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
