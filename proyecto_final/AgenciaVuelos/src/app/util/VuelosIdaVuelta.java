package app.util;

import app.modelo.Vuelo;
import java.util.List;

public class VuelosIdaVuelta {
	private VueloClasePrecio vueloIda;
	private List<VueloClasePrecio> vuelosVuelta;

	public VuelosIdaVuelta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VueloClasePrecio getVueloIda() {
		return vueloIda;
	}

	public void setVueloIda(VueloClasePrecio vueloIda) {
		this.vueloIda = vueloIda;
	}

	public List<VueloClasePrecio> getVuelosVuelta() {
		return vuelosVuelta;
	}

	public void setVuelosVuelta(List<VueloClasePrecio> vuelosVuelta) {
		this.vuelosVuelta = vuelosVuelta;
	}

}