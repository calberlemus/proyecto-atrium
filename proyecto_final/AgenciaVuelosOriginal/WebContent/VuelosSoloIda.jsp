<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%> 	
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/global.css">
<link rel="stylesheet" type="text/css" href="VUELO/css/vuelo.css">
<link href="calendario_dw/calendario_dw-estilos.css" type="text/css"
	rel="STYLESHEET">
<script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".campofecha").calendarioDW();
	})
</script>
<script type="text/javascript" src="HOME/js/home.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="page">
		<div class="cabecera">
			<tiles:insert page="cabecera.jsp"/>
		</div>
		<div class="errores"><html:errors/></div>
		<div class="content-vuelos">
			<div class="content-top">
				<div class="buscador-vuelos"><tiles:insert page="VUELO/contenido/buscador.jsp"/></div>							
			</div>
			<div class="content-bottom">
				<div class="vuelos-ida-vuelta">
					<tiles:insert page="VUELO/contenido/vuelosSoloIda.jsp"/>					
				</div>
			</div>
		</div>
	</div>
</body>
</html>