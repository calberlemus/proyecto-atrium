<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
		List<Compannia> compannias = (List<Compannia>) request
				.getAttribute("compannias");		
%>

<div class="form-alta-admin">
	<html:form action="alta-admin-compannia.do">
		<div>Nº de Registro</div>
		<html:text property="numRegistro" styleClass="num-registro" size="5"  />
		<div class="ayuda">Máximo 4 caracteres.</div>
		<div>Compannia</div>
		<html:select property="idCompannia" >
			<%
				for (Compannia c : compannias) {
			%>
			<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<div>Nick</div>
		<html:text property="nick" size="20" />
		<div>Pass</div>
		<html:password property="pass" size="20" />
		<div>Nombre</div>
		<html:text property="nombre" size="50" />
		<div>Apellidos</div>
		<html:text property="apellidos" size="50" />
		<div>Dni</div>
		<html:text property="dni" styleClass="dni" size="10" />
		<div>Calle</div>
		<html:text property="calle" size="50" />
		<div>Numero</div>
		<html:text property="numero" size="5" />		
		<div>Cp</div>
		<html:text property="cp" size="5" />
		<div>Localidad</div>
		<html:text property="poblacion" size="50" />
		<div>Provincia</div>
		<html:text property="provincia" size="50" />
		<div>Fecha de naciemiento</div>
		<html:text property="fechaNacimiento" size="10"
			styleClass="campofecha" />
		<div>Teléfono</div>
		<html:text property="telefono" size="10" />
		<div>Email</div>
		<html:text property="email" size="30" />
		<br>
		<html:submit value="Dar de alta" styleClass="bt-alta"/>
	</html:form>
</div>


