<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-alta-super">
	<html:form action="alta-super.do">		
		<div>Nick</div>
		<html:text property="nick" size="20" />
		<div>Pass</div>
		<html:password property="pass" size="20" />
		<div>Nombre</div>
		<html:text property="nombre" size="50" />
		<div>Apellidos</div>
		<html:text property="apellidos" size="50" />
		<div>Dni</div>
		<html:text property="dni" size="10" styleClass="dni" />
		<div>Calle</div>
		<html:text property="calle" size="50" />
		<div>Numero</div>
		<html:text property="numero" size="10" />		
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


