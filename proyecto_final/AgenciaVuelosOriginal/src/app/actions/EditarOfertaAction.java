package app.actions;

import java.io.File;
import java.io.FileOutputStream;

import app.actionforms.FormAltaAeropuerto;
import app.actionforms.FormAltaOferta;
import app.actionforms.FormEditarOferta;
import app.modelo.Aeropuerto;
import app.modelo.Oferta;
import app.modelo.Rol;
import app.persistencia.AeropuertoDAO;
import app.persistencia.ItfzAeropuerto;
import app.persistencia.ItfzOferta;
import app.persistencia.OfertaDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class EditarOfertaAction  extends Action
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
        FormEditarOferta formBean = (FormEditarOferta)form;        
	        FormFile imagen = formBean.getImagen();
	        
	        if (imagen.getFileName()!=null && !imagen.getFileName().toString().equals("") && imagen.getContentType().contains("image/")){
	        formBean.setPath(imagen.getFileName());
	        String filePath = request.getRealPath("/").toString();
	        if (filePath.contains("build")){
	        	filePath= filePath.replace("\\build", "");
	        }
	        File file = new File(filePath+"\\images\\"+imagen.getFileName());	        
	        if (!file.exists()){
	        	file.createNewFile();
	        	FileOutputStream fos = new FileOutputStream(file);
	        	fos.write(imagen.getFileData());
	        	fos.flush();
	        	fos.close();
	        }
	        imagen.destroy();
        }
        
        ItfzOferta gestionO = new OfertaDAO();
        Oferta of = gestionO.consultaOferta(((FormEditarOferta)form).getId());
        of.setDestino(((FormEditarOferta)form).getDestino());
        
        
        
        if(imagen.getFileName()!=null && !imagen.getFileName().toString().equals("") && imagen.getContentType().contains("image/")){ 
        	of.setPath(((FormEditarOferta)form).getPath());
        }
        ItfzAeropuerto gestionA = new AeropuertoDAO();
        of.setCiudad((gestionA.consultarAeropuertos(of.getDestino())).getCiudad());
        gestionO.editarOferta(of);
        
        request.setAttribute("oferta", formBean.getPath());
    return mapping.findForward("ok");
  }
}
