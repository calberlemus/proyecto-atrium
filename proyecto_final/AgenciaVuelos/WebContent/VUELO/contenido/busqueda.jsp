<%@page import="app.modelo.Aeropuerto"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
			.getAttribute("aeropuertos");
%>

<html:form action="busca-vuelos-interior">
	<html:radio property="idavuelta" title="Ida y vuelta" value="1" />
	<html:radio property="idavuleta" title="Solo ida" value="2" />
	<html:select property="idAeropuertoOrigen" title="Origen">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<html:select property="idAeropuertoDestino" title="Destino">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<html:text property="fechaHoraSalida" size="50" styleClass="campofecha"
		title="Ida"  />
	<html:text property="fechaHoraLlegada" size="50"
		styleClass="campofecha" title="Vuelta" />
	<html:text property="npasajeros" />
	<html:select property="clase" title="Clase">
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>
	</html:select>
	<html:submit value="Buscar Vuelo" />
</html:form>
