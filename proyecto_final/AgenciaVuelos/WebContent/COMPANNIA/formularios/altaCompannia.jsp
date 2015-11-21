<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<div class="errores">
			<html:errors property="codigo"/>
	</div>
	<div class="errores">	
		   <html:errors property="nombre" />
	</div>	
	<div class="errores">	
			<html:errors property="pais"/>
	</div>
	<div class="errores">	
			<html:errors property="ciudad"/>
	</div>

	<html:form action="alta-compannia.do">
	      <div>Código</div>	      
	      <html:text property="codigo" size="50"/>
	      <div>Nombre</div>
	      <html:text property="nombre" size="50"/>
	      <div>País</div>
	      <html:text property="pais" size="50"/>	            	      
	      <html:submit value="Dar de alta"/>
	</html:form>
</body>
</html>