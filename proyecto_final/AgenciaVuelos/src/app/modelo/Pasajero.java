package app.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pasajero
  extends Persona
  implements Serializable
{
  private Date fechaCadDni;
  private Set<Reserva> reservas = new HashSet();
  private TipoPasajero tipo;
  private Asiento asientoIda;
  private Asiento asientoVuelta;
  
  public Pasajero() {}
  
  public Pasajero(Long id, String nombre, String apellidos, String dni, Date fechaNacimiento, Direccion direccion)
  {
    super(id, nombre, apellidos, dni, fechaNacimiento, direccion);
  }
  
  public Pasajero(Date fechaCadDni, Set<Reserva> reservas, TipoPasajero tipo, Asiento asientoIda, Asiento asientoVuelta)
  {
    this.fechaCadDni = fechaCadDni;
    this.reservas = reservas;
    this.tipo = tipo;
    this.asientoIda = asientoIda;
    this.asientoVuelta = asientoVuelta;
  }
  
  public Pasajero(String nombre, String apellidos, String dni, Date fechaNacimiento, Date fechaCadDni)
  {
    super(nombre, apellidos, dni, fechaNacimiento);
    this.fechaCadDni = fechaCadDni;
  }
  
  public void addReserva(Reserva r)
  {
    this.reservas.add(r);
    r.getPasajeros().add(this);
  }
  
  public Date getFechaCadDni()
  {
    return this.fechaCadDni;
  }
  
  public void setFechaCadDni(Date fechaCadDni)
  {
    this.fechaCadDni = fechaCadDni;
  }
  
  public Set<Reserva> getReservas()
  {
    return this.reservas;
  }
  
  public void setReservas(Set<Reserva> reservas)
  {
    this.reservas = reservas;
  }
  
  public TipoPasajero getTipo()
  {
    return this.tipo;
  }
  
  public void setTipo(TipoPasajero tipo)
  {
    this.tipo = tipo;
  }
  
  public Asiento getAsientoIda()
  {
    return this.asientoIda;
  }
  
  public void setAsientoIda(Asiento asientoIda)
  {
    this.asientoIda = asientoIda;
  }
  
  public Asiento getAsientoVuelta()
  {
    return this.asientoVuelta;
  }
  
  public void setAsientoVuelta(Asiento asientoVuelta)
  {
    this.asientoVuelta = asientoVuelta;
  }
  
  public String toString()
  {
    return 
      "Pasajero [fechaCadDni=" + this.fechaCadDni + ", reservas=" + this.reservas + ", tipo=" + this.tipo + "]";
  }
}
