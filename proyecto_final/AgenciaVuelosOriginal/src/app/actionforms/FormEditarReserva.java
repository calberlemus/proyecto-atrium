package app.actionforms;

import org.apache.struts.validator.ValidatorForm;

public class FormEditarReserva
  extends ValidatorForm
{
  private long id;
  private long idVueloIda;
  private long idVueloVuelta;
  private long idCliente;
  private String claseIda;
  private String claseVuelta;
  private double precioPersona;
  private String fecha;
  
  public long getId()
  {
    return this.id;
  }
  
  public void setId(long id)
  {
    this.id = id;
  }
  
  public long getIdVueloIda()
  {
    return this.idVueloIda;
  }
  
  public void setIdVueloIda(long idVueloIda)
  {
    this.idVueloIda = idVueloIda;
  }
  
  public long getIdVueloVuelta()
  {
    return this.idVueloVuelta;
  }
  
  public void setIdVueloVuelta(long idVueloVuelta)
  {
    this.idVueloVuelta = idVueloVuelta;
  }
  
  public long getIdCliente()
  {
    return this.idCliente;
  }
  
  public void setIdCliente(long idCliente)
  {
    this.idCliente = idCliente;
  }
  
  public String getClaseIda()
  {
    return this.claseIda;
  }
  
  public void setClaseIda(String claseIda)
  {
    this.claseIda = claseIda;
  }
  
  public String getClaseVuelta()
  {
    return this.claseVuelta;
  }
  
  public void setClaseVuelta(String claseVuelta)
  {
    this.claseVuelta = claseVuelta;
  }
  
  public double getPrecioPersona()
  {
    return this.precioPersona;
  }
  
  public void setPrecioPersona(double precioPersona)
  {
    this.precioPersona = precioPersona;
  }
  
  public String getFecha()
  {
    return this.fecha;
  }
  
  public void setFecha(String fecha)
  {
    this.fecha = fecha;
  }
}
