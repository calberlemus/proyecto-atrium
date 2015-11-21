package app.actionforms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FormAltaOferta extends ActionForm {
	private String path;
	private Long destino;
	protected FormFile imagen;	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getDestino() {
		return destino;
	}
	public void setDestino(Long destino) {
		this.destino = destino;
	}
	public FormFile getImagen() {
		return imagen;
	}
	public void setImagen(FormFile imagen) {
		this.imagen = imagen;
	}
		

}
