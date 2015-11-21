package app.modelo;

import java.io.Serializable;

public class Asiento
  implements Serializable
{
  private Long Id;
  private int numero;
  private Clase clase;
  private Boolean disponible;
  private Vuelo vuelo;
  
  public Asiento() {}
  
  public Asiento(Long id, int numero, Clase clase, Vuelo vuelo)
  {
    this.Id = id;
    this.numero = numero;
    this.clase = clase;
    this.vuelo = vuelo;
  }
  
  public Asiento(int numero, Clase clase, Vuelo vuelo)
  {
    this.numero = numero;
    this.clase = clase;
    this.vuelo = vuelo;
  }
  
  public Asiento(int numero, Clase clase)
  {
    this.numero = numero;
    this.clase = clase;
  }
  
  public Long getId()
  {
    return this.Id;
  }
  
  public void setId(Long id)
  {
    this.Id = id;
  }
  
  public int getNumero()
  {
    return this.numero;
  }
  
  public void setNumero(int numero)
  {
    this.numero = numero;
  }
  
  public Clase getClase()
  {
    return this.clase;
  }
  
  public void setClase(Clase clase)
  {
    this.clase = clase;
  }
  
  public Vuelo getVuelo()
  {
    return this.vuelo;
  }
  
  public void setVuelo(Vuelo vuelo)
  {
    this.vuelo = vuelo;
  }
  
  public Boolean getDisponible()
  {
    return this.disponible;
  }
  
  public void setDisponible(Boolean disponible)
  {
    this.disponible = disponible;
  }
}
