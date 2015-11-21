package app.persistencia;

import java.util.List;

import app.modelo.Pasajero;

public interface ItfzPasajero {
	public boolean altaPasajero(Pasajero pasajero);
	public boolean editarPasajero(Pasajero pasajero);
	public boolean eliminarPasajero(long id);
	public List<Pasajero> consultarPasajeros();
	public Pasajero consultaPasajero(long id);

}
