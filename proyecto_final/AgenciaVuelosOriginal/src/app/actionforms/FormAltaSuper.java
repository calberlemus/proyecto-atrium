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

public class FormAltaSuper  extends ValidatorForm{
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
  
  public String getNombre()
  {
    return this.nombre;
  }
  
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public String getApellidos()
  {
    return this.apellidos;
  }
  
  public void setApellidos(String apellidos)
  {
    this.apellidos = apellidos;
  }
  
  public String getDni()
  {
    return this.dni;
  }
  
  public void setDni(String dni)
  {
    this.dni = dni;
  }
  
  public String getFechaNacimiento()
  {
    return this.fechaNacimiento;
  }
  
  public void setFechaNacimiento(String fechaNacimiento)
  {
    this.fechaNacimiento = fechaNacimiento;
  }
  
  public String getTelefono()
  {
    return this.telefono;
  }
  
  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public long getNumCliente()
  {
    return this.numCliente;
  }
  
  public void setNumCliente(long numCliente)
  {
    this.numCliente = numCliente;
  }
  
  public String getCalle()
  {
    return this.calle;
  }
  
  public void setCalle(String calle)
  {
    this.calle = calle;
  }
  
  public String getNumero()
  {
    return this.numero;
  }
  
  public void setNumero(String numero)
  {
    this.numero = numero;
  }
  
  public String getPoblacion()
  {
    return this.poblacion;
  }
  
  public void setPoblacion(String poblacion)
  {
    this.poblacion = poblacion;
  }
  
  public long getCp()
  {
    return this.cp;
  }
  
  public void setCp(long cp)
  {
    this.cp = cp;
  }
  
  public String getProvincia()
  {
    return this.provincia;
  }
  
  public void setProvincia(String provincia)
  {
    this.provincia = provincia;
  }
  
  public String getNick()
  {
    return this.nick;
  }
  
  public void setNick(String nick)
  {
    this.nick = nick;
  }
  
  public String getPass()
  {
    return this.pass;
  }
  
  public void setPass(String pass)
  {
    this.pass = pass;
  }
  
  public String getRol()
  {
    return this.rol;
  }
  
  public void setRol(String rol)
  {
    this.rol = rol;
  }
  
  @Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ItfzUsuario gestionU = new UsuarioDAO();
		ActionErrors errors = new ActionErrors();	
		
		/*
		 * Si el nick está vacío se muetra un error de campo obligatorio
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
		 * Si el pass está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.pass==null || "".equals(this.pass)){
			errors.add("pass", new ActionMessage(
					"errors.required", "Pass"));
		}
		
		/*
		 * Si el nombre está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.nombre==null || "".equals(this.nombre)){
			errors.add("nombre", new ActionMessage(
					"errors.required", "Nombre"));
		}
		
		/*
		 * Si el campo apellidos está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.apellidos==null || "".equals(this.apellidos)){
			errors.add("apellidos", new ActionMessage(
					"errors.required", "Apellidos"));
		}
		
		/*
		 * Si el dni está vacío se muetra un error de campo obligatorio		 		 
		 */
		if (this.dni==null || "".equals(this.dni)){
			errors.add("dni", new ActionMessage(
					"errors.required", "dni"));
		}
		
		/*
		 * Si la calle está vacía se muetra un error de campo obligatorio		 
		 */
		if (this.calle==null || "".equals(this.calle)){
			errors.add("calle", new ActionMessage(
					"errors.required", "Calle"));
		}
		
		/*
		 * Si el numero está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.numero==null || "".equals(this.numero)){
			errors.add("numero", new ActionMessage(
					"errors.required", "Numero"));
		}
		
		/*
		 * Si la provincia está vacía se muetra un error de campo obligatorio		 
		 */
		if (this.provincia==null || "".equals(this.provincia)){
			errors.add("provincia", new ActionMessage(
					"errors.required", "Provincia"));
		}
		
		/*
		 * Si la población está vacía se muetra un error de campo obligatorio		 
		 */
		if (this.poblacion==null || "".equals(this.poblacion)){
			errors.add("poblacion", new ActionMessage(
					"errors.required", "Poblacion"));
		}
		
		/*
		 * Si el cp está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.cp==0){
			errors.add("cp", new ActionMessage(
					"errors.required", "Cp"));
		}
		
		/*
		 * Si la fecha de nacimiento está vacía se muetra un error de campo obligatorio
		 * Si la fecha de nacimiente es igual o posterior al dÃ­a de hoy se muestra un error
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
		 * Si el telefono  está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.telefono==null || "".equals(this.telefono)){
			errors.add("telefono", new ActionMessage(
					"errors.required", "Telefono"));
		}
		
		/*
		 * Si el email  está vacío se muetra un error de campo obligatorio		 		 
		 */
		if (this.email==null || "".equals(this.email)){
			errors.add("email", new ActionMessage(
					"errors.required", "Email"));
		}	
		
		
		return errors;
	}
}

