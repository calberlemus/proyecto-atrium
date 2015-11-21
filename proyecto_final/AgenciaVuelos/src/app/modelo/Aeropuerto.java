package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Aeropuerto
  implements Serializable
{
  private Long Id;
  private String codigo;
  private String ciudad;
  private String pais;
  private String nombre;
  private Set<Vuelo> vuelosOrigen = new HashSet();
  private Set<Vuelo> vuelosDestino = new HashSet();
  
  public Aeropuerto() {}
  
  public Aeropuerto(Long id, String codigo, String ciudad, String pais, String nombre, Set<Vuelo> vuelosOrigen, Set<Vuelo> vuelosDestino)
  {
    this.Id = id;
    this.codigo = codigo;
    this.ciudad = ciudad;
    this.pais = pais;
    this.nombre = nombre;
    this.vuelosOrigen = vuelosOrigen;
    this.vuelosDestino = vuelosDestino;
  }
  
  public Aeropuerto(String nombre, String ciudad, String pais, String codigo)
  {
    this.codigo = codigo;
    this.ciudad = ciudad;
    this.pais = pais;
    this.nombre = nombre;
  }
  
  public void addVueloOrigen(Vuelo v)
  {
    this.vuelosOrigen.add(v);
    v.setOrigen(this);
  }
  
  public void addVueloDestino(Vuelo v)
  {
    this.vuelosDestino.add(v);
    v.setDestino(this);
  }
  
  public Long getId()
  {
    return this.Id;
  }
  
  public void setId(Long id)
  {
    this.Id = id;
  }
  
  public String getCodigo()
  {
    return this.codigo;
  }
  
  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }
  
  public String getCiudad()
  {
    return this.ciudad;
  }
  
  public void setCiudad(String ciudad)
  {
    this.ciudad = ciudad;
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
  
  public Set<Vuelo> getVuelosOrigen()
  {
    return this.vuelosOrigen;
  }
  
  public void setVuelosOrigen(Set<Vuelo> vuelos)
  {
    this.vuelosOrigen = vuelos;
  }
  
  public Set<Vuelo> getVuelosDestino()
  {
    return this.vuelosDestino;
  }
  
  public void setVuelosDestino(Set<Vuelo> vuelos)
  {
    this.vuelosDestino = vuelos;
  }
  
  public String toString()
  {
    return 
    
      "Aeropuerto [Id=" + this.Id + ", codigo=" + this.codigo + ", ciudad=" + this.ciudad + ", pais=" + this.pais + ", nombre=" + this.nombre + ", vuelosOrigen=" + this.vuelosOrigen + ", vuelosDestino=" + this.vuelosDestino + "]";
  }
}
