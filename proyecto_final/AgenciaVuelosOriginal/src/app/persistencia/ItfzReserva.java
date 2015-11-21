package app.persistencia;

import java.util.List;

import app.modelo.Reserva;

public interface ItfzReserva {
	public boolean altaReserva(Reserva Reserva);	
	
	public boolean editarReserva(Reserva reserva, long id);	
	
	public boolean eliminarReserva(long id);
	
	public List<Reserva> consultarReserva();
	public Reserva consultarReserva(long id);
	public List<Reserva> consultaReservasCliente(long idCliente);
	
	
}
