package app.actionforms;

import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class FormAltaAeropuerto
  extends ValidatorForm
{
  private String codigo;
  private String nombre;
  private String pais;
  private String ciudad;
  
  public String getCodigo()
  {
    return this.codigo;
  }
  
  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }
  
  public String getNombre()
  {
    return this.nombre;
  }
  
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public String getPais()
  {
    return this.pais;
  }
  
  public void setPais(String pais)
  {
    this.pais = pais;
  }
  
  public String getCiudad()
  {
    return this.ciudad;
  }
  
  public void setCiudad(String ciudad)
  {
    this.ciudad = ciudad;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    ActionErrors errors = new ActionErrors();
    
    /*
     * Si el codigo esta vacío se muestra un error de campo requerido
     * Si el codigo ya existe se muestra un error de campo duplicado 
     */
    if ((this.codigo == null) || ("".equals(this.codigo))) {
      errors.add("codigo", new ActionMessage(
        "errors.required", "codigo"));
    } else if (gestionA.consultarAeropuertosCodigo(this.codigo) != null) {
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
	 * Si cidudad  está vacía se muetra un error de campo obligatorio		 
	 */
    if ((this.ciudad == null) || ("".equals(this.ciudad))) {
      errors.add("ciudad", new ActionMessage(
        "errors.required", "ciudad"));
    }
    
    /*
	 * Si el nombre  está vacío se muetra un error de campo obligatorio		 
	 */
    if ((this.nombre == null) || ("".equals(this.nombre))) {
      errors.add("nombre", new ActionMessage(
        "errors.required", "nombre"));
    }
    return errors;
  }
}
