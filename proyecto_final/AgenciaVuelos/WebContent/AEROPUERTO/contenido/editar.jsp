<%@page import="app.modelo.Aeropuerto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-editar-aeropuerto">
<%
	Aeropuerto aeropuerto = (Aeropuerto) request
			.getAttribute("aeropuerto");	
%>
<html:form action="editar-aeropuerto.do">
	<div>Código</div>
	<html:hidden property="id" value='<%=aeropuerto!=null ? aeropuerto.getId().toString() : "" %>' />
	<html:text property="codigo" size="3" styleClass="codigo" value='<%=aeropuerto!=null ? aeropuerto.getCodigo() : "" %>'  />
	<div>Nombre</div>
	<html:text property="nombre" size="50" value='<%=aeropuerto!=null ? aeropuerto.getNombre() : "" %>'  />
	<div>País</div>
	<html:text property="pais" size="30" value='<%=aeropuerto!=null ? aeropuerto.getPais() : "" %>'  />
	<div>Ciudad</div>
	<html:text property="ciudad" size="30" value='<%=aeropuerto!=null ? aeropuerto.getCiudad() : "" %>'  />
	<br>
	<html:submit value="Guardar" styleClass="bt-guardar" />
</html:form>

</div>
