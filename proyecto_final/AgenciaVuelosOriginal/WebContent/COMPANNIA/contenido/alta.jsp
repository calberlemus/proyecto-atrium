<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-alta-compannia">	
	<html:form action="alta-compannia.do">
	      <div>Código</div>	      
	      <html:text property="codigo" styleClass="codigo" size="2" />
	      <div class="ayuda">Dos dígitos alfanuméricos</div>
	      <div>Nombre de la Compañía</div>
	      <html:text property="nombre" size="30"/>
	      <div>País</div>
	      <html:text property="pais" size="30"/>
	      <br>	            	      
	      <html:submit value="Dar de alta" styleClass="bt-alta"/>
	</html:form>
</div>


