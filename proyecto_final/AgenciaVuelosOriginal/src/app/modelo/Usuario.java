package app.modelo;

import java.io.Serializable;
import java.util.Date;

public class Usuario
  extends Persona
  implements Serializable
{
  private String telefono;
  private String email;
  private String nick;
  private String pass;
  private Rol rol;
  
  public Usuario() {}
  
  public Usuario(Long id, String nombre, String apellidos, String dni, Date fechaNacimiento, Direccion direccion, String telefono, String email, String nick, String pass, Rol rol)
  {
    super(id, nombre, apellidos, dni, fechaNacimiento, direccion);
    this.telefono = telefono;
    this.email = email;
    this.nick = nick;
    this.pass = pass;
    this.rol = rol;
  }
  
  public Usuario(String nombre, String apellidos, String dni, Date fechaNacimiento, String telefono, String email)
  {
    super(nombre, apellidos, dni, fechaNacimiento);
    this.telefono = telefono;
    this.email = email;
  }
  
  public Rol getRol()
  {
    return this.rol;
  }
  
  public void setRol(Rol rol)
  {
    this.rol = rol;
  }
  
  public String getTelefono()
  {
    return this.telefono;
  }
  
  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getNick()
  {
    return this.nick;
  }
  
  public void setNick(String nick)
  {
    this.nick = nick;
  }
  
  public String getPass()
  {
    return this.pass;
  }
  
  public void setPass(String pass)
  {
    this.pass = pass;
  }
  
  public String toString()
  {
    return 
      "Usuario [telefono=" + this.telefono + ", email=" + this.email + ", nick=" + this.nick + ", pass=" + this.pass + "]";
  }
}
