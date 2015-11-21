package app.actionforms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import app.persistencia.ItfzUsuario;
import app.persistencia.UsuarioDAO;
import app.util.Fecha;

public class FormLogin
  extends ValidatorForm
{
  private String nick;
  private String pass;
  
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
  
  @Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ItfzUsuario gestionU = new UsuarioDAO();
		ActionErrors errors = new ActionErrors();		
		
		/*
		 * Si el nick está vacío se muetra un error de campo obligatorio		
		 */
		if (this.nick==null || "".equals(this.nick)){
			errors.add("nick", new ActionMessage(
					"errors.required", "Nick"));
		}
		
		/*
		 * Se comprueba si existe un usuario con el nick y el pass indicados
		 * si esto no es así se muestra un error		
		 */
		if((this.nick==null || "".equals(this.nick)) &&
		   (this.pass==null || "".equals(this.pass)) &&		
		   !this.pass.equals(gestionU.ConsultaPass(this.nick))){
			errors.add("nick", new ActionMessage(
					"errors.noExisteUsuario"));
		}
		/*
		 * Si el pass está vacío se muetra un error de campo obligatorio		 
		 */
		if (this.pass==null || "".equals(this.pass)){
			errors.add("pass", new ActionMessage(
					"errors.required", "Pass"));
		}		
		
		return errors;
	}
}
