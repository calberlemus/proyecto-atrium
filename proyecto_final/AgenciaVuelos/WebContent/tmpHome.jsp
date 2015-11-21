<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles"
	uri="http://jakarta.apache.org/struts/tags-tiles"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    	<div class="page">
			<div class="cabecera">
				<tiles:insert attribute="cabecera"/>
			</div>
			<div class="errores"><html:errors/></div>
			<div class="content-home">
				<div class="content-top">			
					<div class="buscador"><tiles:insert attribute="buscador"/></div>
					<div class="slider"><tiles:insert attribute="slider"/></div>
				</div>
				<div class="content-bottom">	
					<div class="ultimos-vuleos-int"><tiles:insert attribute="vuelos-int"/></div>
					<div class="ultimos-vuleos-nac"><tiles:insert attribute="vuelos-nac"/></div>
				</div>	
			</div>		
		</div>
</body>
</html>