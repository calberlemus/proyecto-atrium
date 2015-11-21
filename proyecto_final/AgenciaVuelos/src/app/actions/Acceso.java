package app.actions;

import app.modelo.Rol;
import app.modelo.Usuario;

/*
 * Comprueba si un usuario tiene un rol de igual o mas prioridad
 * que un rol dado.
 */

public class Acceso
{
  public static boolean Permiso(Object usuario, Rol rol)
  {
    if ((usuario == null) || ((usuario != null) && (((Usuario)usuario).getRol().ordinal() < rol.ordinal()))) {
      return false;
    }
    return true;
  }
}