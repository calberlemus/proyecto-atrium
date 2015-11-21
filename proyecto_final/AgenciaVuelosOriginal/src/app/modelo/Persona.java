package app.modelo;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {
	
	private Long Id;
	private String nombre;
	private String apellidos;
	private String dni;	
	private Date fechaNacimiento;
	private Direccion direccion;
	
	
	public Persona() {		
	}
	
	public Persona(Long id, String nombre, String apellidos, String dni,
			Date fechaNacimiento, Direccion direccion) {
		super();
		Id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;		
	}


	public Persona(String nombre, String apellidos, String dni,
			Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;		
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	

	@Override
	public String toString() {
		return "Persona [Id=" + Id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + "]";
	}
	
		
}
