<%@page import="app.modelo.Oferta"%>
<%@page import="java.util.List"%>
<%@page import="app.modelo.Aeropuerto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-editar-oferta">
	<%		
		List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
				.getAttribute("aeropuertos");
	    Oferta oferta = (Oferta)request.getAttribute("oferta");
	%>	
	<html:form enctype="multipart/form-data" action="editar-oferta.do">
	    <html:hidden property="id" value='<%=oferta!=null ? oferta.getId().toString() : "" %>'/>
		<div>Imagen</div>
		<html:file accept="image/*" property="imagen" value='<%=oferta!=null ? request.getRealPath("imagen/"+oferta.getPath().toString()).toString() : "" %>'></html:file>
		<div>Destino</div>		
		<html:select property="destino" value='<%=oferta!=null ? oferta.getDestino().toString() : "" %>'>
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<br>
		<html:submit value="Guardar" styleClass="bt-alta"/>
	</html:form>
</div>

