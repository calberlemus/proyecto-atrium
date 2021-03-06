package app.actions;
import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import app.modelo.AdminCompannia;
import app.modelo.Clase;
import app.modelo.Compannia;
import app.modelo.Usuario;
import app.modelo.Vuelo;
import app.persistencia.CompanniaDAO;
import app.persistencia.ItfzCompannia;
import app.persistencia.ItfzVuelo;
import app.persistencia.VueloDAO;
import app.util.Fecha;

import com.itextpdf.text.Document;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPTable;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class InformeVuelosDisponiblesAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		Usuario user = null;
		AdminCompannia admin = null;
		if(session.getAttribute("user")!=null){
			user = (Usuario)session.getAttribute("user");
			admin = (AdminCompannia)user;
		}
		ItfzCompannia gestionC = new CompanniaDAO();
		Compannia compannia = gestionC.consultarCompannia(admin.getCompannia().getId());
		
		// Se crea el documento
		Document documento = new Document();
		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		
		ServletContext sc = request.getServletContext();
		
		
		FileOutputStream ficheroPdf = new FileOutputStream(sc.getRealPath("/VUELO/Informes/fichero"+user.getId()+".pdf"));
		
		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
		// Se abre el documento.
		documento.open();
		Font fuente3 =FontFactory.getFont("arial",14,Font.BOLD);
		Paragraph titulo =new Paragraph("Informe de vuelos con asientos libres de "+compannia.getNombre()+"\n\n",fuente3);
		titulo.setAlignment(Chunk.ALIGN_CENTER);
		documento.add(titulo);
		 
		
		
		/*ItfzVuelo gestionV = new VueloDAO();
		List<Vuelo> vuelos = gestionV.consultarVuelos();*/
		
		
		
		Font fuente2 =FontFactory.getFont("arial",12);
		Font fuente1 =FontFactory.getFont("arial",8);
		
		
		PdfPTable tabla = new PdfPTable(6);
		tabla.addCell(new Paragraph("Nº de vuelo",fuente2));
		tabla.addCell(new Paragraph("Origen",fuente2));
		tabla.addCell(new Paragraph("Destino",fuente2));
		tabla.addCell(new Paragraph("Asientos Oferta",fuente2));
		tabla.addCell(new Paragraph("Asientos Bussines",fuente2));
		tabla.addCell(new Paragraph("Asientos Turista",fuente2));
		Date hoy = new Date();
		for(Vuelo v : compannia.getVuelos()){
			if ((v.asientosDisponibles(Clase.OFERTA)>0 || v.asientosDisponibles(Clase.BUSSINES)>0 || v.asientosDisponibles(Clase.TURISMO)>0)
				&& Fecha.fechaSinHora(v.getDiaSalida()).compareTo(Fecha.fechaSinHora(hoy))>=0){
			    tabla.addCell(new Paragraph(v.getId().toString(),fuente1));
			    tabla.addCell(new Paragraph(Fecha.convertirDDMMYYY(v.getDiaSalida())+" "+Fecha.convertirHHMM(v.getHoraSalida())+" "+v.getOrigen().getCiudad(),fuente1));
			    tabla.addCell(new Paragraph(Fecha.convertirDDMMYYY(v.getDiaLlegada())+" "+Fecha.convertirHHMM(v.getHoraLlegada())+" "+v.getDestino().getCiudad(),fuente1));
			    tabla.addCell(new Paragraph(Integer.toString(v.asientosDisponibles(Clase.OFERTA)),fuente1));
			    tabla.addCell(new Paragraph(Integer.toString(v.asientosDisponibles(Clase.BUSSINES)),fuente1));
			    tabla.addCell(new Paragraph(Integer.toString(v.asientosDisponibles(Clase.TURISMO)),fuente1));
			}    
		}		
		documento.add(tabla);
		
		
		documento.close();
		
		response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition","attachment;filename=fichero"+user.getId()+".pdf");
	    
	    ServletOutputStream stream = response.getOutputStream();
	    FileInputStream input = new FileInputStream(sc.getRealPath("/VUELO/Informes/fichero"+user.getId()+".pdf"));
	    BufferedInputStream buf = new BufferedInputStream(input);
        int readBytes = 0;

        while ((readBytes = buf.read()) != -1) {
            stream.write(readBytes);
        }

        stream.flush();
        stream.close();
	    
		
		return null;
	}

	
	
}
