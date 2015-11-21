<%@page import="app.modelo.Aeropuerto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-alta-oferta">
	<%		
		List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
				.getAttribute("aeropuertos");		
	%>	
	<html:form enctype="multipart/form-data" action="alta-oferta.do">
		<div>Imagen</div>
		<html:file accept="image/*" property="imagen"></html:file>
		<div>Destino</div>		
		<html:select property="destino">
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
		<html:submit value="Dar de alta" styleClass="bt-alta"/>
	</html:form>
</div>


