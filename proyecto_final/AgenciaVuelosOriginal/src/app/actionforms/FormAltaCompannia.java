package app.actionforms;

import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class FormAltaCompannia
  extends ValidatorForm
{
  private String codigo;
  private String pais;
  private String nombre;
  
  public String getCodigo()
  {
    return this.codigo;
  }
  
  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }
  
  public String getPais()
  {
    return this.pais;
  }
  
  public void setPais(String pais)
  {
    this.pais = pais;
  }
  
  public String getNombre()
  {
    return this.nombre;
  }
  
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    ItfzCompannia gestionC = new CompanniaDAO();
    ActionErrors errors = new ActionErrors();
    
    /*
     * Si el codigo esta vacío se muestra un error de campo requerido
     * Si el codigo ya existe se muestra un error de campo duplicado 
     */
    if ((this.codigo == null) || ("".equals(this.codigo))) {
      errors.add("codigo", new ActionMessage(
        "errors.required", "codigo"));
    } else if (gestionC.consultarCompannia(this.codigo) != null) {
      errors.add("codigo", new ActionMessage(
        "errors.codigoDuplicado"));
    }
    
    /*
	 * Si el pais está vacío se muetra un error de campo obligatorio		 
	 */
    if ((this.pais == null) || ("".equals(this.pais))) {
      errors.add("pais", new ActionMessage(
        "errors.required", "pais"));
    }
    
    /*
	 * Si el nombre está vacío se muetra un error de campo obligatorio		 
	 */
    if ((this.nombre == null) || ("".equals(this.nombre))) {
      errors.add("nombre", new ActionMessage(
        "errors.required", "nombre"));
    }
    return errors;
  }
}
