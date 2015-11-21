package app.modelo;

import java.io.Serializable;

public class Direccion
  implements Serializable
{
  private String calle;
  private String numero;
  private String poblacion;
  private long cp;
  private String provincia;
  
  public Direccion() {}
  
  public Direccion(String calle, String numero, String poblacion, long cp, String provincia)
  {
    this.calle = calle;
    this.numero = numero;
    this.poblacion = poblacion;
    this.cp = cp;
    this.provincia = provincia;
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
  
  public String toString()
  {
    return 
    
      "Direccion [calle=" + this.calle + ", numero=" + this.numero + ", poblacion=" + this.poblacion + ", cp=" + this.cp + ", provincia=" + this.provincia + "]";
  }
}
