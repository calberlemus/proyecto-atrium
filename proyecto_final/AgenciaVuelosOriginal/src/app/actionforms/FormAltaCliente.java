package app.actionforms;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;


import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
import app.util.Fecha;

public class FormAltaCliente extends ValidatorForm {
	private String nombre;
	private String apellidos;
	private String dni;
	private String fechaNacimiento;
	private String telefono;
	private String email;
	private long numCliente;
	private String nick;
	private String pass;
	private String rol;
	private String calle;
	private String numero;
	private String poblacion;
	private long cp;
	private String provincia;
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(long numCliente) {
		this.numCliente = numCliente;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public long getCp() {
		return cp;
	}
	public void setCp(long cp) {
		this.cp = cp;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ItfzUsuario gestionU = new UsuarioDAO();
		ActionErrors errors = new ActionErrors();
		
		/*
		 * Si el numCliente es 0 se muestra un error de campo obligatorio
		 * Si el numCliente existe se muestra un error de numCliente duplicado
		 */
		if (this.numCliente == 0) {
			errors.add("numCliente", new ActionMessage("errors.required", "N�mero de cliente"));
		} else if (gestionU.consultarClientesNumero(this.numCliente) != null) {
			errors.add("numCliente", new ActionMessage("errors.duplicado", "N�mero de cliente"));
		}
		
		/*
		 * Si el nick está vac�o se muetra un error de campo obligatorio
		 * Si el nick existe se produce un error de nick duplicado
		 */
		if (this.nick==null || "".equals(this.nick)){
			errors.add("nick", new ActionMessage(
					"errors.required", "Nick"));
		}else if(gestionU.ConsultaUsuario(this.nick)!=null){
			errors.add("nick", new ActionMessage(
					"errors.duplicado", "Nick"));
		}
		/*
		 * Si el pass está vac�o se muetra un error de campo obligatorio		 
		 */
		if (this.pass==null || "".equals(this.pass)){
			errors.add("pass", new ActionMessage(
					"errors.required", "Pass"));
		}
		
		/*
		 * Si el nombre est� vac�o se muetra un error de campo obligatorio		 
		 */
		if (this.nombre==null || "".equals(this.nombre)){
			errors.add("nombre", new ActionMessage(
					"errors.required", "Nombre"));
		}
		
		/*
		 * Si el campo apellidos est� vac�o se muetra un error de campo obligatorio		 
		 */
		if (this.apellidos==null || "".equals(this.apellidos)){
			errors.add("apellidos", new ActionMessage(
					"errors.required", "Apellidos"));
		}
		
		/*
		 * Si el dni est� vac�o se muetra un error de campo obligatorio
		 * Si existe un dni entre Clientes se muestra un error de dni duplicado		 
		 */
		if (this.dni==null || "".equals(this.dni)){
			errors.add("dni", new ActionMessage(
					"errors.required", "dni"));
		}else if(gestionU.consultarClientesDni(this.dni)!=null){
			errors.add("dni", new ActionMessage(
					"errors.duplicado", "Dni"));
		}
		
		/*
		 * Si la calle est� vac�a se muetra un error de campo obligatorio		 
		 */
		if (this.calle==null || "".equals(this.calle)){
			errors.add("calle", new ActionMessage(
					"errors.required", "Calle"));
		}
		
		/*
		 * Si el numero est� vac�o se muetra un error de campo obligatorio		 
		 */
		if (this.numero==null || "".equals(this.numero)){
			errors.add("numero", new ActionMessage(
					"errors.required", "Numero"));
		}
		
		/*
		 * Si la provincia est� vac�a se muetra un error de campo obligatorio		 
		 */
		if (this.provincia==null || "".equals(this.provincia)){
			errors.add("provincia", new ActionMessage(
					"errors.required", "Provincia"));
		}
		/*
		 * Si la poblaci�n est� vac�a se muetra un error de campo obligatorio		 
		 */
		if (this.poblacion==null || "".equals(this.poblacion)){
			errors.add("poblacion", new ActionMessage(
					"errors.required", "Poblacion"));
		}
		
		/*
		 * Si el cp est� vac�o se muetra un error de campo obligatorio		 
		 */
		if (this.cp==0){
			errors.add("cp", new ActionMessage(
					"errors.required", "Cp"));
		}
		

		/*
		 * Si la fecha de nacimiento est� vac�a se muetra un error de campo obligatorio
		 * Si la fecha de nacimiente es igual o posterior al d�a de hoy se muestra un error
		 * indicando esta cirscunstancia.		 
		 */
		if (this.fechaNacimiento==null || "".equals(this.fechaNacimiento)){
			errors.add("fechaNacimiento", new ActionMessage(
					"errors.required", "FechaNacimiento"));
		}else if ((Fecha.convetirDate(this.fechaNacimiento)).compareTo(new Date())>=0){
			errors.add("fechaNacimiento", new ActionMessage(
					"errors.fechaPosterior"));			
		}
		
		/*
		 * Si el telefono  est� vac�o se muetra un error de campo obligatorio		 
		 */
		if (this.telefono==null || "".equals(this.telefono)){
			errors.add("telefono", new ActionMessage(
					"errors.required", "Telefono"));
		}
		
		/*
		 * Si el email  est� vac�o se muetra un error de campo obligatorio
		 * Si el email ya existe entre los Clientes se muestra
		 * un error de email duplicado		 
		 */
		if (this.email==null || "".equals(this.email)){
			errors.add("email", new ActionMessage(
					"errors.required", "Email"));
		}else if(gestionU.consultarClientesEmail(this.email)!=null){
			errors.add("email", new ActionMessage(
					"errors.duplicado", "Email"));
		}	
		
		
		return errors;
	}
	
}
