package app.actionforms;

import org.apache.struts.validator.ValidatorForm;

public class FormEditarPasajero
  extends ValidatorForm
{
  private long id;
  private String nombre;
  private String apellidos;
  private String dni;
  private String fechaNacimiento;
  private String fechaCadDni;
  private String tipo;
  private long idAsientoIda;
  private long idAsientoVuelta;
  private String calle;
  private String numero;
  private String poblacion;
  private long cp;
  private String provincia;
  
  public long getId()
  {
    return this.id;
  }
  
  public void setId(long id)
  {
    this.id = id;
  }
  
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
  
  public String getFechaCadDni()
  {
    return this.fechaCadDni;
  }
  
  public void setFechaCadDni(String fechaCadDni)
  {
    this.fechaCadDni = fechaCadDni;
  }
  
  public String getTipo()
  {
    return this.tipo;
  }
  
  public void setTipo(String tipo)
  {
    this.tipo = tipo;
  }
  
  public long getIdAsientoIda()
  {
    return this.idAsientoIda;
  }
  
  public void setIdAsientoIda(long idAsientoIda)
  {
    this.idAsientoIda = idAsientoIda;
  }
  
  public long getIdAsientoVuelta()
  {
    return this.idAsientoVuelta;
  }
  
  public void setIdAsientoVuelta(long idAsientoVuelta)
  {
    this.idAsientoVuelta = idAsientoVuelta;
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
}
