package app.actionforms;

import app.modelo.Aeropuerto;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class FormEditarAeropuerto
  extends ValidatorForm
{
  private String codigo;
  private String nombre;
  private String pais;
  private String ciudad;
  private Long id;
  
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
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    Aeropuerto aeropuerto = gestionA.consultarAeropuertos(this.id);
    
    
    ActionErrors errors = new ActionErrors();
    if ((this.codigo == null) || ("".equals(this.codigo))) {
      errors.add("codigo", new ActionMessage(
        "errors.required", "codigo"));
    } else if (gestionA.consultarAeropuertosCodigo(this.codigo) != null && !aeropuerto.getCodigo().equals(this.codigo)) {
      errors.add("codigo", new ActionMessage(
        "errors.codigoDuplicado"));
    }
    if ((this.pais == null) || ("".equals(this.pais))) {
      errors.add("pais", new ActionMessage(
        "errors.required", "pais"));
    }
    if ((this.ciudad == null) || ("".equals(this.ciudad))) {
      errors.add("ciudad", new ActionMessage(
        "errors.required", "ciudad"));
    }
    if ((this.nombre == null) || ("".equals(this.nombre))) {
      errors.add("nombre", new ActionMessage(
        "errors.required", "nombre"));
    }
    return errors;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    ItfzAeropuerto gestionA = new AeropuertoDAO();
    Aeropuerto aeropuerto = gestionA.consultarAeropuertos(Long.parseLong(request.getParameter("id")));
    request.setAttribute("aeropuerto", aeropuerto);
    super.reset(mapping, request);
  }
}
