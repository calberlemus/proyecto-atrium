package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Compannia implements Serializable {
	private Long Id;
	private String codigo;	
	private String pais;
	private String nombre;
	private Set<Vuelo> vuelos = new HashSet<Vuelo>();
	private Set<AdminCompannia> administradores = new HashSet<AdminCompannia>();
	
	public Compannia(){
		
	}	

	public Compannia(Long id, String codigo, String pais, String nombre,
			Set<Vuelo> vuelos, Set<AdminCompannia> administradores) {
		super();
		Id = id;
		this.codigo = codigo;
		this.pais = pais;
		this.nombre = nombre;
		this.vuelos = vuelos;
		this.administradores = administradores;
	}
	
	

	public Compannia(String nombre, String pais,String codigo) {
		super();
		this.codigo = codigo;
		this.pais = pais;
		this.nombre = nombre;
	}

	public void addAdministradorCompannia(AdminCompannia a){
		administradores.add(a);
		a.setCompannia(this);
	}

	public void addVuelo(Vuelo v){
		vuelos.add(v);
		v.setCompannia(this);
	}

	public Set<Vuelo> getVuelos() {
		return vuelos;
	}



	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<AdminCompannia> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(Set<AdminCompannia> administradores) {
		this.administradores = administradores;
	}

	@Override
	public String toString() {
		return "Compannia [Id=" + Id + ", codigo=" + codigo + ", pais=" + pais
				+ ", nombre=" + nombre + ", vuelos=" + vuelos
				+ ", administradores=" + administradores + "]";
	}
	
}
