package app.actionforms;

import org.apache.struts.validator.ValidatorForm;

public class FormAltaAsiento
  extends ValidatorForm
{
  private int numero;
  private String clase;
  private Long idVuelo;
  
  public int getNumero()
  {
    return this.numero;
  }
  
  public void setNumero(int numero)
  {
    this.numero = numero;
  }
  
  public String getClase()
  {
    return this.clase;
  }
  
  public void setClase(String clase)
  {
    this.clase = clase;
  }
  
  public Long getIdVuelo()
  {
    return this.idVuelo;
  }
  
  public void setIdVuelo(Long idVuelo)
  {
    this.idVuelo = idVuelo;
  }
}
