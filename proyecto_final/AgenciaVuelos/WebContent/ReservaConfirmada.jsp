<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/global.css">
<link rel="stylesheet" type="text/css" href="RESERVA/css/reserva.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="page">
		<div class="cabecera">
			<tiles:insert page="cabecera.jsp"/>
		</div>
		<div class="content-reserva">			
			<div class="datos-reserva">			    
				<tiles:insert page="RESERVA/contenido/reservaConfirmada.jsp"/>					
			</div>						
		</div>
	</div>
</body>
</html>