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
	AdminCompannia admin = (AdminCompannia) request
			.getAttribute("admin");
	List<Compannia> compannias = (List<Compannia>) request
		.getAttribute("compannias");
	if (admin == null) {
		
%>
<html:form action="editar-admin-compannia.do">
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
	<div>Nº de registro</div>
	<html:text property="nregistro" size="50" />
	<html:hidden property="id"/>
	<html:submit value="Dar de alta" />
	<html:select property="idCompannia">
		<%
			for (Compannia c : compannias) {
		%>		
		<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%></html:option>
		<%
			}
		%>
	</html:select>
</html:form>
<%
	} else {
%>
<html:form action="editar-admin-compannia.do">
	<div>Nombre</div>
	<html:text property="nombre" size="50" value="<%=admin.getNombre() %>" />
	<div>Apellidos</div>
	<html:text property="apellidos" size="50" value="<%=admin.getApellidos() %>" />
	<div>Dni</div>
	<html:text property="dni" size="50" value="<%=admin.getDni() %>" />
	<div>Calle</div>
	<html:text property="calle" size="50" value="<%=admin.getDireccion().getCalle() %>" />
	<div>numero</div>
	<html:text property="numero" size="50" value="<%=admin.getDireccion().getNumero() %>" />
	<div>Provincia</div>
	<html:text property="provincia" size="50" value="<%=admin.getDireccion().getProvincia() %>" />
	<div>Cp</div>
	<html:text property="cp" size="50" value="<%=Long.toString(admin.getDireccion().getCp()) %>" />
	<div>Localidad</div>
	<html:text property="poblacion" size="50" value="<%=admin.getDireccion().getPoblacion() %>" />
	<div>Fecha de naciemiento</div>
	<html:text property="fechaNacimiento" size="50" styleClass="campofecha" value="<%=Fecha.convertirDDMMYYY(admin.getFechaNacimiento())%>" />
	<div>Teléfono</div>
	<html:text property="telefono" size="50" value="<%=admin.getTelefono() %>" />
	<div>Email</div>
	<html:text property="email" size="50" value="<%=admin.getEmail() %>" />
	<div>Nº de registro</div>
	<html:text property="nregistro" size="50" value="<%=Long.toString(admin.getNumRegistro()) %>" />
	<html:submit value="Dar de alta" />
	<html:select property="idCompannia" value="<%=Long.toString(admin.getCompannia().getId()) %>">
		<%
			for (Compannia c : compannias) {
				if (admin.getCompannia().getId()==c.getId()){
		%>			
		<html:option value="<%=c.getId().toString()%>" ><%=c.getNombre()%></html:option>
		<%
				}else{
		%>
		<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%> </html:option>
		<%
				}
			}
		%>
	</html:select>
	<html:hidden property="id" value="<%=admin.getId().toString() %>"/>
</html:form>
<%
	}
%>

</body>
</html>