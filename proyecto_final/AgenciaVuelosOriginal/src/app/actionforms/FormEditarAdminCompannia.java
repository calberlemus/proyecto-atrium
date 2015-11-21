package app.actionforms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import app.modelo.AdminCompannia;
import app.modelo.Compannia;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;
import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;

public class FormEditarAdminCompannia extends ValidatorForm {
	private Long id;
	private String nick;
	private String pass;
	private String rol;
	private String nombre;
	private String apellidos;
	private String dni;
	private String fechaNacimiento;
	private String telefono;
	private String email;
	private long numRegistro;
	private long idCompannia;
	private String calle;
	private String numero;
	private String poblacion;
	private long cp;
	private String provincia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public long getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(long numRegistro) {
		this.numRegistro = numRegistro;
	}

	public long getIdCompannia() {
		return idCompannia;
	}

	public void setIdCompannia(long idCompannia) {
		this.idCompannia = idCompannia;
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
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		ItfzUsuario gestionU = new UsuarioDAO();
		ItfzCompannia gestionC = new CompanniaDAO();
		List<Compannia> compannias = gestionC.consultarCompannias();
		request.setAttribute("compannias", compannias);

		AdminCompannia admin = gestionU.consultarAdminCompannias(Long
				.parseLong(request.getParameter("id")));
		request.setAttribute("admin", admin);

		super.reset(mapping, request);

	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ItfzUsuario gestionU = new UsuarioDAO();
		ActionErrors errors = new ActionErrors();
		
		if (this.numRegistro == 0) {
			errors.add("numRegistro", new ActionMessage("errors.required", "Número de registro"));
		} else if (gestionU.consultarAdminCompanniasRegistro(this.numRegistro) != null
				&& ((AdminCompannia) gestionU
						.consultarAdminCompanniasRegistro(this.numRegistro)).getId()
						.longValue() != this.id) {
			errors.add("numRegistro", new ActionMessage("errors.duplicado", "Número de registro"));
		}
		
		if (this.nick == null || "".equals(this.nick)) {
			errors.add("nick", new ActionMessage("errors.required", "Nick"));
		} else if (gestionU.ConsultaUsuario(this.nick) != null
				&& ((AdminCompannia) gestionU
						.consultarAdminCompanniasNick(this.nick)).getId()
						.longValue() != this.id) {
			errors.add("nick", new ActionMessage("errors.duplicado", "Nick"));
		}
		if (this.pass == null || "".equals(this.pass)) {
			errors.add("pass", new ActionMessage("errors.required", "Pass"));
		}
		if (this.nombre == null || "".equals(this.nombre)) {
			errors.add("nombre", new ActionMessage("errors.required", "Nombre"));
		}
		if (this.apellidos == null || "".equals(this.apellidos)) {
			errors.add("apellidos", new ActionMessage("errors.required",
					"Apellidos"));
		}
		if (this.dni == null || "".equals(this.dni)) {
			errors.add("dni", new ActionMessage("errors.required", "dni"));
		} else if (gestionU.consultarAdminCompanniasDni(this.dni) != null && ((AdminCompannia) gestionU
				.consultarAdminCompanniasDni(this.dni)).getId()
				.longValue() != this.id) {
			errors.add("dni", new ActionMessage("errors.duplicado", "Dni"));
		}
		if (this.calle == null || "".equals(this.calle)) {
			errors.add("calle", new ActionMessage("errors.required", "Calle"));
		}
		if (this.numero == null || "".equals(this.numero)) {
			errors.add("numero", new ActionMessage("errors.required", "Numero"));
		}
		if (this.provincia == null || "".equals(this.provincia)) {
			errors.add("provincia", new ActionMessage("errors.required",
					"Provincia"));
		}
		if (this.poblacion == null || "".equals(this.poblacion)) {
			errors.add("poblacion", new ActionMessage("errors.required",
					"Poblacion"));
		}
		if (this.cp == 0) {
			errors.add("cp", new ActionMessage("errors.required", "Cp"));
		}
		if (this.fechaNacimiento == null || "".equals(this.fechaNacimiento)) {
			errors.add("fechaNacimiento", new ActionMessage("errors.required",
					"FechaNacimiento"));
		}
		if (this.telefono == null || "".equals(this.telefono)) {
			errors.add("telefono", new ActionMessage("errors.required",
					"Telefono"));
		}
		if (this.email == null || "".equals(this.email)) {
			errors.add("email", new ActionMessage("errors.required", "Email"));
		} else if (gestionU.consultarAdminCompanniasEmail(this.email) != null &&((AdminCompannia) gestionU
				.consultarAdminCompanniasEmail(this.email)).getId()
				.longValue() != this.id) {
			errors.add("email", new ActionMessage("errors.duplicado", "Email"));
		}

		return errors;
	}

}
