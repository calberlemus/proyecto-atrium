<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="calendario_dw/calendario_dw-estilos.css" type="text/css"
	rel="STYLESHEET">
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
%>

<html:form action="alta-vuelo.do">
	<div>Fecha y hora de salida</div>
	<html:text property="fechaHoraSalida" size="50" styleClass="campofecha"  />
	<div>Origen</div>
	<html:select property="idAeropuertoOrigen">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Fecha y hora de llegada</div>
	<html:text property="fechaHoraLlegada" size="50" styleClass="campofecha"  />
	<div>Destino</div>
	<html:select property="idAeropuertoDestino">
		<%
			for (Aeropuerto a : aeropuertos) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
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
	<html:submit value="Dar de alta" />
</html:form>
</body>
</html>