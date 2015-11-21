<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="VUELO/css/vuelo.css">
<link rel="stylesheet" type="text/css" href="css/global.css">

<tiles:insert page="tmpAdmin.jsp" flush="true">
	<tiles:put name="cabecera" value="cabecera.jsp"/>	
	<tiles:put name="tasks" value="VUELO/tasks/taskVuelos.jsp" />	
	<tiles:put name="contenido" value="VUELO/contenido/lista.jsp" />
	<tiles:put name="filtros" value="VUELO/filtros/filtros.jsp" />
</tiles:insert>