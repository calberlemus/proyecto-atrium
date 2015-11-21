<%@page import="app.util.Fecha"%>
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
	Cliente cliente = (Cliente) request
			.getAttribute("cliente");	
	if (cliente == null) {
		
%>
<html:form action="editar-cliente.do">
	<div>Nº de Cliente</div>
	<html:text property="numCliente" size="50" />
	<div>Nick</div>
	<html:text property="nick" size="50" />
	<div>Pass</div>
	<html:text property="pass" size="50" />
	<div>Nombre</div>
	<html:text property="nombre" size="50" />
	<div>Apellidos</div>
	<html:text property="apellidos" size="50" />
	<div>Dni</div>
	<html:text property="dni" size="50" />
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
	<div>Teléfono</div>
	<html:text property="telefono" size="50" />
	<div>Email</div>
	<html:text property="email" size="50" />	
	<html:hidden property="id"/>
	<html:submit value="Dar de alta" />
	
</html:form>
<%
	} else {
%>
<html:form action="editar-cliente.do">
	<div>Nº de Cliente</div>
	<html:text property="numCliente" size="50" value="<%=cliente.getNumCliente().toString() %>" />
	<div>Nick</div>
	<html:text property="nick" size="50" value="<%=cliente.getNick() %>" />
	<div>Pass</div>
	<html:text property="pass" size="50" />
	<div>Nombre</div>
	<html:text property="nombre" size="50" value="<%=cliente.getNombre() %>" />
	<div>Apellidos</div>
	<html:text property="apellidos" size="50" value="<%=cliente.getApellidos() %>" />
	<div>Dni</div>
	<html:text property="dni" size="50" value="<%=cliente.getDni() %>" />
	<div>Calle</div>
	<html:text property="calle" size="50" value="<%=cliente.getDireccion().getCalle() %>" />
	<div>numero</div>
	<html:text property="numero" size="50" value="<%=cliente.getDireccion().getNumero() %>" />
	<div>Provincia</div>
	<html:text property="provincia" size="50" value="<%=cliente.getDireccion().getProvincia() %>" />
	<div>Cp</div>
	<html:text property="cp" size="50" value="<%=Long.toString(cliente.getDireccion().getCp()) %>" />
	<div>Localidad</div>
	<html:text property="poblacion" size="50" value="<%=cliente.getDireccion().getPoblacion() %>" />
	<div>Fecha de naciemiento</div>
	<html:text property="fechaNacimiento" size="50" styleClass="campofecha" value="<%=Fecha.convertirDDMMYYY(cliente.getFechaNacimiento())%>" />
	<div>Teléfono</div>
	<html:text property="telefono" size="50" value="<%=cliente.getTelefono() %>" />
	<div>Email</div>
	<html:text property="email" size="50" value="<%=cliente.getEmail() %>" />	
	<html:hidden property="id" value="<%=cliente.getId().toString() %>"/>
	<html:submit value="Guardar" />
</html:form>
<%
	}
%>

</body>
</html>