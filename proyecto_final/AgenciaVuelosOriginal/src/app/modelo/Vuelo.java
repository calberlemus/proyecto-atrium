package app.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Vuelo
  implements Serializable
{
  private Long Id;
  private Aeropuerto origen;
  private Aeropuerto destino;
  private Date diaSalida;
  private Date horaSalida;
  private Date diaLlegada;
  private Date horaLlegada;
  private Compannia compannia;
  private double precioOferta;
  private double precioTurista;
  private double precioBussines;
  private int numAsientosOferta;
  private int numAsientosTurista;
  private int numAsientosBussines;
  private boolean cancelado;
  private Set<Asiento> asientos = new HashSet();
  private Set<Reserva> reservasIda = new HashSet();
  private Set<Reserva> reservasVuelta = new HashSet();
  
  public Vuelo() {}
  
  public Vuelo(Long id, Aeropuerto origen, Aeropuerto destino, Date diaSalida, Date horaSalida, Date diaLlegada, Date horaLlegada, Compannia compannia, double precioOferta, double precioTurista, double precioBussines, int numAsientosOferta, int numAsientosTurista, int numAsientosBussines, boolean cancelado, Set<Asiento> asientos, Set<Reserva> reservasIda, Set<Reserva> reservasVuelta)
  {
    this.Id = id;
    this.origen = origen;
    this.destino = destino;
    this.diaSalida = diaSalida;
    this.horaSalida = horaSalida;
    this.diaLlegada = diaLlegada;
    this.horaLlegada = horaLlegada;
    this.compannia = compannia;
    this.precioOferta = precioOferta;
    this.precioTurista = precioTurista;
    this.precioBussines = precioBussines;
    this.numAsientosOferta = numAsientosOferta;
    this.numAsientosTurista = numAsientosTurista;
    this.numAsientosBussines = numAsientosBussines;
    this.cancelado = cancelado;
    this.asientos = asientos;
    this.reservasIda = reservasIda;
    this.reservasVuelta = reservasVuelta;
  }
  
  public boolean isCancelado()
  {
    return this.cancelado;
  }
  
  public void setCancelado(boolean cancelado)
  {
    this.cancelado = cancelado;
  }
  
  public Date getHoraSalida()
  {
    return this.horaSalida;
  }
  
  public void setHoraSalida(Date horaSalida)
  {
    this.horaSalida = horaSalida;
  }
  
  public Date getHoraLlegada()
  {
    return this.horaLlegada;
  }
  
  public void setHoraLlegada(Date horaLlegada)
  {
    this.horaLlegada = horaLlegada;
  }
  
  public Vuelo(Aeropuerto origen, Aeropuerto destino, Date diaSalida, Date diaLlegada, Compannia compannia, double precioOferta, double precioTurista, double precioBussines)
  {
    this.origen = origen;
    this.destino = destino;
    this.diaSalida = diaSalida;
    this.diaLlegada = diaLlegada;
    this.compannia = compannia;
    this.precioOferta = precioOferta;
    this.precioTurista = precioTurista;
    this.precioBussines = precioBussines;
  }
  
  public void addReservaIda(Reserva r)
  {
    this.reservasIda.add(r);
    r.setVueloIda(this);
  }
  
  public void addReservaVuelta(Reserva r)
  {
    this.reservasVuelta.add(r);
    r.setVueloVuelta(this);
  }
  
  public void addAsiento(Asiento a)
  {
    this.asientos.add(a);
    a.setVuelo(this);
  }
  
  public int asientosDisponibles(Clase clase){
	  int contador=0;
	  for(Asiento a: this.asientos){
		  if (a.getDisponible() && a.getClase().toString()==clase.toString()){
			  contador++;
		  }
	  }
	  return contador;
  }
  public int asientosNoDisponibles(Clase clase){
	  int contador=0;
	  for(Asiento a: this.asientos){
		  if (!a.getDisponible() && a.getClase().toString()==clase.toString()){
			  contador++;
		  }
	  }
	  return contador;
  }
  
  public Long getId()
  {
    return this.Id;
  }
  
  public void setId(Long id)
  {
    this.Id = id;
  }
  
  public Aeropuerto getOrigen()
  {
    return this.origen;
  }
  
  public void setOrigen(Aeropuerto origen)
  {
    this.origen = origen;
  }
  
  public Aeropuerto getDestino()
  {
    return this.destino;
  }
  
  public void setDestino(Aeropuerto destino)
  {
    this.destino = destino;
  }
  
  public Date getDiaSalida()
  {
    return this.diaSalida;
  }
  
  public void setDiaSalida(Date diaSalida)
  {
    this.diaSalida = diaSalida;
  }
  
  public Date getDiaLlegada()
  {
    return this.diaLlegada;
  }
  
  public void setDiaLlegada(Date diaLlegada)
  {
    this.diaLlegada = diaLlegada;
  }
  
  public Compannia getCompannia()
  {
    return this.compannia;
  }
  
  public void setCompannia(Compannia compannia)
  {
    this.compannia = compannia;
  }
  
  public double getPrecioOferta()
  {
    return this.precioOferta;
  }
  
  public void setPrecioOferta(double precioOferta)
  {
    this.precioOferta = precioOferta;
  }
  
  public double getPrecioTurista()
  {
    return this.precioTurista;
  }
  
  public void setPrecioTurista(double precioTurista)
  {
    this.precioTurista = precioTurista;
  }
  
  public double getPrecioBussines()
  {
    return this.precioBussines;
  }
  
  public void setPrecioBussines(double precioBussines)
  {
    this.precioBussines = precioBussines;
  }
  
  public Set<Asiento> getAsientos()
  {
    return this.asientos;
  }
  
  public void setAsientos(Set<Asiento> asientos)
  {
    this.asientos = asientos;
  }
  
  public Set<Reserva> getReservasIda()
  {
    return this.reservasIda;
  }
  
  public void setReservasIda(Set<Reserva> reservasIda)
  {
    this.reservasIda = reservasIda;
  }
  
  public Set<Reserva> getReservasVuelta()
  {
    return this.reservasVuelta;
  }
  
  public void setReservasVuelta(Set<Reserva> reservasVuelta)
  {
    this.reservasVuelta = reservasVuelta;
  }
  
  public int getNumAsientosOferta()
  {
    return this.numAsientosOferta;
  }
  
  public void setNumAsientosOferta(int numAsientosOferta)
  {
    this.numAsientosOferta = numAsientosOferta;
  }
  
  public int getNumAsientosTurista()
  {
    return this.numAsientosTurista;
  }
  
  public void setNumAsientosTurista(int numAsientosTurista)
  {
    this.numAsientosTurista = numAsientosTurista;
  }
  
  public int getNumAsientosBussines()
  {
    return this.numAsientosBussines;
  }
  
  public void setNumAsientosBussines(int numAsientosBussines)
  {
    this.numAsientosBussines = numAsientosBussines;
  }
  
  public String toString()
  {
    return 
    
      "Vuelo [Id=" + this.Id + ", origen=" + this.origen + ", destino=" + this.destino + ", diaSalida=" + this.diaSalida + ", horaSalida=" + this.horaSalida + ", diaLlegada=" + this.diaLlegada + ", horaLlegada=" + this.horaLlegada + ", compannia=" + this.compannia + ", precioOferta=" + this.precioOferta + ", precioTurista=" + this.precioTurista + ", precioBussines=" + this.precioBussines + ", numAsientosOferta=" + this.numAsientosOferta + ", numAsientosTurista=" + this.numAsientosTurista + ", numAsientosBussines=" + this.numAsientosBussines + ", cancelado=" + this.cancelado + ", asientos=" + this.asientos + ", reservasIda=" + this.reservasIda + ", reservasVuelta=" + this.reservasVuelta + "]";
  }
}
