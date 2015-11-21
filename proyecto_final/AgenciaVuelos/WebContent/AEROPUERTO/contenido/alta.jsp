<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-alta-aeropuerto">	
	<html:form action="alta-aeropuerto.do">
		<div>Código</div>
		<html:text property="codigo" size="3" styleClass="codigo"/>
		<div class="ayuda">Trés dígitos alfanuméricos</div>
		<div>Nombre</div>
		<html:text property="nombre" size="50"/>
		<div>País</div>
		<html:text property="pais" size="30"/>
		<div>Ciudad</div>
		<html:text property="ciudad" size="30"/>
		<br>
		<html:submit value="Dar de alta" styleClass="bt-alta"/>
	</html:form>
</div>


