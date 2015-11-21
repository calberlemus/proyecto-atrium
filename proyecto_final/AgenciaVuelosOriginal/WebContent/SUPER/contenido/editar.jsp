<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-editar-super">
	<%
		Usuario superAdmin = (Usuario)request.getAttribute("super");		
	%>
	<html:form action="editar-super.do">		
		<div>Nick</div>
		<html:text property="nick" size="20" value = '<%=superAdmin!=null ? superAdmin.getNick() : "" %>' />
		<div>Pass</div>
		<html:password property="pass" size="20" value = '<%=superAdmin!=null ? superAdmin.getPass() : "" %>' />
		<div>Nombre</div>
		<html:text property="nombre" size="50" value = '<%=superAdmin!=null ? superAdmin.getNombre() : "" %>' />
		<div>Apellidos</div>
		<html:text property="apellidos" size="50" value = '<%=superAdmin!=null ? superAdmin.getApellidos() : "" %>' />
		<div>Dni</div>
		<html:text property="dni" styleClass="dni" size="10" value = '<%=superAdmin!=null ? superAdmin.getDni() : "" %>' />
		<div>Calle</div>
		<html:text property="calle" size="50" value = '<%=superAdmin!=null ? superAdmin.getDireccion().getCalle() : "" %>' />
		<div>numero</div>
		<html:text property="numero" size="5" value = '<%=superAdmin!=null ? superAdmin.getDireccion().getNumero() : "" %>' /> 
		<div>Provincia</div>
		<html:text property="provincia" size="50" value = '<%=superAdmin!=null ? superAdmin.getDireccion().getProvincia() : "" %>' /> 
		<div>Cp</div>
		<html:text property="cp" size="5"  value = '<%=superAdmin!=null ? Long.toString(superAdmin.getDireccion().getCp()) : "" %>' />
		<div>Localidad</div>
		<html:text property="poblacion" size="50" value = '<%=superAdmin!=null ? superAdmin.getDireccion().getPoblacion() : "" %>' /> 
		<div>Fecha de naciemiento</div>
		<html:text property="fechaNacimiento" size="10" value = '<%=superAdmin!=null ? Fecha.convertirDDMMYYY(superAdmin.getFechaNacimiento()) : "" %>' 
			styleClass="campofecha" />
		<div>Teléfono</div>
		<html:text property="telefono" size="5" value = '<%=superAdmin!=null ? superAdmin.getTelefono() : "" %>' /> 
		<div>Email</div>
		<html:text property="email" size="30" value = '<%=superAdmin!=null ? superAdmin.getEmail() : "" %>' />
		<html:hidden property="id" value = '<%=superAdmin!=null ? superAdmin.getId().toString() : "" %>' />
		<br>
		<html:submit value="Guardar" styleClass="bt-guardar" />
	</html:form>

</div>
