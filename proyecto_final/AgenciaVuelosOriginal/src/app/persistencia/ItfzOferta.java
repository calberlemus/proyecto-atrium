package app.persistencia;

import java.util.List;

import app.modelo.Oferta;

public interface ItfzOferta {
	public boolean altaOferta(Oferta oferta);
	public boolean editarOferta(Oferta oferta);
	public boolean eliminarOferta(long id);
	public List<Oferta> consultarOfertas();
	public Oferta consultaOferta(long id);

}
