<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".campofecha").calendarioDW();
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	List<Compannia> compannias = (List<Compannia>) request
			.getAttribute("compannias");
	List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
			.getAttribute("aeropuertos");
	Vuelo vuelo = (Vuelo) request.getAttribute("vuelo");
	if (vuelo == null) {
%>

<html:form action="editar-vuelo.do">
	<div>Origen</div>
	<html:select property="idAeropuertoOrigen">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad()
										+ " " + a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Origen</div>
	<html:select property="idAeropuertoDestino">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad()
										+ " " + a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Fecha y hora de salida</div>
	<html:text property="fechaHoraSalida" size="50" styleClass="campofecha"  />
	<div>Fecha y hora de llegada</div>
	<html:text property="fechaHoraLlegada" size="50" styleClass="campofecha" />
	<div>Compannia</div>
	<html:select property="idCompannia">
		<%
			for (Compannia c : compannias) {
		%>
		<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Precio oferta</div>
	<html:text property="precioOferta" size="50" />
	<div>Precio turista</div>
	<html:text property="precioTurista" size="50" />
	<div>Precio bussines</div>
	<html:text property="precioBussines" size="50" />
	<html:hidden property="id" />
	<html:submit value="Dar de alta" />
</html:form>
<%
	} else {
%>
<html:form action="editar-vuelo.do">
	<div>Origen</div>
	<html:select property="idAeropuertoOrigen" value="<%=Long.toString(vuelo.getOrigen().getId()) %>">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad()
										+ " " + a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Origen</div>
	<html:select property="idAeropuertoDestino" value="<%=Long.toString(vuelo.getDestino().getId()) %>">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad()
										+ " " + a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Fecha y hora de salida</div>
	<html:text property="fechaHoraSalida" size="50"
		value="<%=Fecha.convertirDDMMYYY(vuelo.getDiaSalida())%>" />
	<div>Fecha y hora de llegada</div>
	<html:text property="fechaHoraLlegada" size="50"
		value="<%=Fecha.convertirDDMMYYY(vuelo
							.getDiaLlegada())%>" />
	<html:select property="idCompannia" value="<%=Long.toString(vuelo.getCompannia().getId()) %>">
		<%
			for (Compannia c : compannias) {
		%>
		<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Precio oferta</div>
	<html:text property="precioOferta" size="50"
		value="<%=Double.toString(vuelo.getPrecioOferta())%>" />
	<div>Precio turista</div>
	<html:text property="precioTurista" size="50"
		value="<%=Double.toString(vuelo.getPrecioTurista())%>" />
	<div>Precio bussines</div>
	<html:text property="precioBussines" size="50"
		value="<%=Double.toString(vuelo.getPrecioBussines())%>" />
	<html:hidden property="id"  value="<%=Long.toString(vuelo.getId()) %>"/>	
	<html:submit value="Dar de alta" />
</html:form>
<%
	}
%>
</body>
</html>