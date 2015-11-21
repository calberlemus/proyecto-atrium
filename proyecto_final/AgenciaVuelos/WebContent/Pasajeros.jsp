<%@page import="org.apache.struts.action.ActionMessage"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>	 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/global.css">
<link rel="stylesheet" type="text/css" href="PASAJERO/css/pasajero.css">
<link href="calendario_dw/calendario_dw-estilos.css" type="text/css"
	rel="STYLESHEET">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".campofecha").calendarioDW();
		$(":text").attr("autocomplete", "off");
		jQuery(function($){
			   $(".dni").mask("99999999a");	   
		});
	})
</script>



<title>Insert title here</title>
</head>
<body>
	<div class="page">
		<div class="cabecera">
			<tiles:insert page="cabecera.jsp"/>
		</div>
		<div class="errores"><html:errors/></div>
		<div class="content-pasajeros">			
				<div class="lista-pasajeros">
					<tiles:insert page="PASAJERO/contenido/pasajeros.jsp"/>					
				</div>			
		</div>
	</div>
</body>
</html>