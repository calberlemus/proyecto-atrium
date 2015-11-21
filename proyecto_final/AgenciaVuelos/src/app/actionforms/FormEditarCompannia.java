package app.actionforms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import app.modelo.Compannia;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;

public class FormEditarCompannia extends ValidatorForm {
	private String codigo;	
	private String pais;
	private String nombre;
	private Long id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ItfzCompannia gestionC = new CompanniaDAO();
		ActionErrors errors = new ActionErrors();
		Compannia compannia = gestionC.consultarCompannia(this.id);
		
		
		if (this.codigo == null || "".equals(this.codigo)) {
			errors.add("codigo", new ActionMessage(
					"errors.required", "codigo"));
		}else if (gestionC.consultarCompannia(this.codigo)!=null && !compannia.getCodigo().equals(this.codigo)){
			errors.add("codigo", new ActionMessage(
					"errors.codigoDuplicado"));
		}
		if (this.pais == null || "".equals(this.pais)) {
			errors.add("pais", new ActionMessage(
					"errors.required", "pais"));
		}
		if (this.nombre == null || "".equals(this.nombre)) {
			errors.add("nombre", new ActionMessage(
					"errors.required", "nombre"));
		}		
		
		return errors;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		ItfzCompannia gestionC = new CompanniaDAO();
		Compannia compannia = gestionC.consultarCompannia(Long.parseLong(request.getParameter("id")));
		request.setAttribute("compannia", compannia);
		super.reset(mapping, request);
	}
	
	
}
