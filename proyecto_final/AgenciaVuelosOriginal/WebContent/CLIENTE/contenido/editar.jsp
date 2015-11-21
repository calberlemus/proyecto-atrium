<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-editar-cliente">
	<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");		
	%>
	<html:form action="editar-cliente.do">
		<div>Nº de Cliente</div>
		<html:text property="numCliente" size="5" styleClass="num-cliente" value = '<%=cliente!=null ? cliente.getNumCliente().toString() : "" %>' />
		<div class="ayuda">Máximo 4 digitos.</div>
		<div>Nick</div>
		<html:text property="nick" size="20" value = '<%=cliente!=null ? cliente.getNick() : "" %>' />
		<div>Pass</div>
		<html:password property="pass" size="20" value = '<%=cliente!=null ? cliente.getPass() : "" %>' />
		<div>Nombre</div>
		<html:text property="nombre" size="50" value = '<%=cliente!=null ? cliente.getNombre() : "" %>' />
		<div>Apellidos</div>
		<html:text property="apellidos" size="50" value = '<%=cliente!=null ? cliente.getApellidos() : "" %>' />
		<div>Dni</div>
		<html:text property="dni" styleClass="dni" size="10" value = '<%=cliente!=null ? cliente.getDni() : "" %>'/>
		<div>Calle</div>
		<html:text property="calle" size="50" value = '<%=cliente!=null ? cliente.getDireccion().getCalle() : "" %>' />
		<div>Numero</div>
		<html:text property="numero" size="5" value = '<%=cliente!=null ? cliente.getDireccion().getNumero() : "" %>' />		
		<div>Cp</div>
		<html:text property="cp" size="5"  value = '<%=cliente!=null ? Long.toString(cliente.getDireccion().getCp()) : "" %>' />
		<div>Localidad</div>
		<html:text property="poblacion" size="50" value = '<%=cliente!=null ? cliente.getDireccion().getPoblacion() : "" %>' />
		<div>Provincia</div>
		<html:text property="provincia" size="50" value = '<%=cliente!=null ? cliente.getDireccion().getProvincia() : "" %>' />  
		<div>Fecha de naciemiento</div>
		<html:text property="fechaNacimiento" size="10" value = '<%=cliente!=null ? Fecha.convertirDDMMYYY(cliente.getFechaNacimiento()) : "" %>' 
			styleClass="campofecha" />
		<div>Teléfono</div>
		<html:text property="telefono" size="5" value = '<%=cliente!=null ? cliente.getTelefono() : "" %>' /> 
		<div>Email</div>
		<html:text property="email" size="30" value = '<%=cliente!=null ? cliente.getEmail() : "" %>' />
		<html:hidden property="id" value = '<%=cliente!=null ? cliente.getId().toString() : "" %>' />
		<br>
		<html:submit value="Guardar" styleClass="bt-guardar" />
	</html:form>

</div>
