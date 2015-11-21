package app.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Usuario implements Serializable {
	
	private Set<Reserva> reservas = new HashSet<Reserva>();
	private Long numCliente;
	public Cliente() {
		
	}	

	public void addReserva(Reserva r){
		reservas.add(r);
		r.setCliente(this);
	}
	
	public Set<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	public Long getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(Long numCliente) {
		this.numCliente = numCliente;
	}
	@Override
	public String toString() {
		return "Cliente [reservas=" + reservas + "]";
	}	

}
