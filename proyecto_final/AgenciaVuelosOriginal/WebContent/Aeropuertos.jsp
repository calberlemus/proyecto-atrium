<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="AEROPUERTO/css/aeropuerto.css">
<link rel="stylesheet" type="text/css" href="css/global.css">

<tiles:insert page="tmpAdmin.jsp" flush="true">
	<tiles:put name="cabecera" value="cabecera.jsp"/>	
	<tiles:put name="tasks" value="AEROPUERTO/tasks/taskAeropuertos.jsp" />	
	<tiles:put name="contenido" value="AEROPUERTO/contenido/lista.jsp" />
	<tiles:put name="filtros" value="AEROPUERTO/filtros/filtros.jsp" />
</tiles:insert>