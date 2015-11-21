<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
		List<Compannia> compannias = (List<Compannia>) request
				.getAttribute("compannias");
       AdminCompannia admin = (AdminCompannia) request.getAttribute("admin");
%>
<div class="form-editar-admin">
	 
	<html:form action="editar-admin-compannia.do">
		<div>Nº de Registro</div>
		<html:text property="numRegistro" styleClass="num-registro" maxlength="4" size="5" value='<%=admin!=null ? Long.toString(admin.getNumRegistro()) : "" %>' />
		<div class="ayuda">Máximo 4 caracteres.</div>
		<div>Compannia</div>
		<html:select property="idCompannia" value = '<%=admin!=null ? admin.getCompannia().getId().toString() : "" %>' >
			<%
				for (Compannia c : compannias) {
			%>
			<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<div>Nick</div>
		<html:text property="nick" size="20" value = '<%=admin!=null ? admin.getNick() : "" %>' />
		<div>Pass</div>
		<html:password property="pass" size="20" value = '<%=admin!=null ? admin.getPass() : "" %>' />
		<div>Nombre</div>
		<html:text property="nombre" size="50" value = '<%=admin!=null ? admin.getNombre() : "" %>' />
		<div>Apellidos</div>
		<html:text property="apellidos" size="50" value = '<%=admin!=null ? admin.getApellidos() : "" %>' />
		<div>Dni</div>
		<html:text property="dni" styleClass="dni" size="10" value = '<%=admin!=null ? admin.getDni() : "" %>' />
		<div>Calle</div>
		<html:text property="calle" size="50" value = '<%=admin!=null ? admin.getDireccion().getCalle() : "" %>' />
		<div>Numero</div>
		<html:text property="numero" size="5" value = '<%=admin!=null ? admin.getDireccion().getNumero() : "" %>' /> 		 
		<div>Cp</div>
		<html:text property="cp" size="5"  value = '<%=admin!=null ? Long.toString(admin.getDireccion().getCp()) : "" %>' />
		<div>Localidad</div>
		<html:text property="poblacion" size="50" value = '<%=admin!=null ? admin.getDireccion().getPoblacion() : "" %>' /> 
		<div>Provincia</div>
		<html:text property="provincia" size="50" value = '<%=admin!=null ? admin.getDireccion().getProvincia() : "" %>' />
		<div>Fecha de naciemiento</div>
		<html:text property="fechaNacimiento" size="10" value = '<%=admin!=null ? Fecha.convertirDDMMYYY(admin.getFechaNacimiento()) : "" %>' 
			styleClass="campofecha" />
		<div>Teléfono</div>
		<html:text property="telefono" size="10" value = '<%=admin!=null ? admin.getTelefono() : "" %>' /> 
		<div>Email</div>
		<html:text property="email" size="30" value = '<%=admin!=null ? admin.getEmail() : "" %>' />
		<html:hidden property="id" value = '<%=admin!=null ? admin.getId().toString() : "" %>' />
		<br>
		<html:submit value="Guardar" styleClass="bt-guardar" />

	</html:form>	

</div>
