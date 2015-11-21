package app.actionforms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FormEditarOferta extends ActionForm {
	private Long id;
	private String path;
	private Long destino;
	protected FormFile imagen;	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
