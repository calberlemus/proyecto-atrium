package app.persistencia;

import java.util.Date;
import java.util.List;
import app.modelo.*;

public interface ItfzVuelo {
	public boolean altaVuelo(Vuelo vuelo);
	public boolean editarVuelo(Vuelo vuelo, long id);
	public boolean eliminarVuelo(long id);
	public List<Vuelo> consultarVuelos();
	public List<Vuelo> consultarVuelos(long origen,long destino, Date ida);
	public List<Vuelo> consultarVuelos(long origen,long destino);	
	public List<Vuelo> consultarVuelosCompannia(long idCompannia);
	public List<Vuelo> consultarVuelosDestino(long destino);
	public Vuelo consultarVuelo(long id);
	public boolean altaAsiento(Asiento asiento);
	public boolean editarAsiento(Asiento asiento);
	public boolean eliminarAsiento(long id);
	public List<Asiento> consultaAsientosVuelo(long id_vuelo);
	public List<Vuelo> consultarVuelosVuelta(Vuelo vuelo, Date vuelta);
	public Asiento consultarAsiento(long id);
	public List<Asiento> consultaAsientosDisponiblesVuelo(long id_vuelo, String clase);
	public List<Asiento> reservarAsientosVuelo(long id_vuelo, String clase, int num);
	public boolean anularReservaAsientosVuelo(long id_vuelo, List<Asiento> asientos);
	public boolean eliminarAsientosVuelo(long id_vuelo);
	public List<Vuelo> consultarVuelosNacionales();
	public List<Vuelo> consultarVuelosInternacionales();
}
