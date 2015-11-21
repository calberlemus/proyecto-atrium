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
<div class="errores">
	<html:errors property="codigo" />
</div>
<div class="errores">
	<html:errors property="nombre" />
</div>
<div class="errores">
	<html:errors property="pais" />
</div>
<div class="errores">
	<html:errors property="ciudad" />
</div>

<%
	List<Asiento> asientosIda = (List<Asiento>) request
			.getAttribute("asientosIda");
	List<Asiento> asientosVuelta = (List<Asiento>) request
			.getAttribute("asientosVuelta");
%>

<html:form action="alta-pasajero.do">
	<div>Nombre</div>
	<html:text property="nombre" size="50" />
	<div>Apellidos</div>
	<html:text property="apellidos" size="50" />
	<div>Dni</div>
	<html:text property="dni" size="50" />
	<div>Fecha de caducidad Dni</div>
	<html:text property="fechaCadDni" size="50" styleClass="campofecha" />
	<div>Calle</div>
	<html:text property="calle" size="50" />
	<div>numero</div>
	<html:text property="numero" size="50" />
	<div>Provincia</div>
	<html:text property="provincia" size="50" />
	<div>Cp</div>
	<html:text property="cp" size="50" />
	<div>Localidad</div>
	<html:text property="poblacion" size="50" />
	<div>Fecha de naciemiento</div>
	<html:text property="fechaNacimiento" size="50" styleClass="campofecha" />
	<div>Tipo de pasajero</div>
	<html:select property="tipo">		
		<html:option value="ADULTO">ADULTO</html:option>
		<html:option value="NINNO">NIÑO</html:option>
		<html:option value="JUBILADO">JUBILADO</html:option>
		<html:option value="ESTUDIANTE">ESTUDIANTE</html:option>		
	</html:select>
	<div>Asiento Ida</div>	
	<html:select property="idAsientoIda">
		<%
			for (Asiento a : asientosIda) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getNumero()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Asiento Vuelta</div>
	<html:select property="idAsientoVuelta">
		<%
			for (Asiento a : asientosVuelta) {
		%>
		<html:option value="<%=a.getId().toString()%>"><%=a.getNumero()%></html:option>
		<%
			}
		%>
	</html:select>
	<html:submit value="Dar de alta" />
</html:form>
</body>
</html>