<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles"
	uri="http://jakarta.apache.org/struts/tags-tiles"%> 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="css/global.css">
<script
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js'
	type='text/javascript' >
</script>	
<script type="text/javascript">
	//<![CDATA[
	$(function() {
		$('#slider div:gt(0)').hide();
		setInterval(function() {
			$('#slider div:first-child').fadeOut(0).next('div').fadeIn(1000)
					.end().appendTo('#slider');
		}, 10000);
	});
	//]]>
</script>
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
<tiles:insert page="tmpHome.jsp" flush="true">
	<tiles:put name="cabecera" value="cabecera.jsp" />
	<tiles:put name="buscador" value="HOME/buscador.jsp" />
	<tiles:put name="slider" value="HOME/slider.jsp" />
	<tiles:put name="vuelos-int" value="HOME/vuelosInt.jsp" />
	<tiles:put name="vuelos-nac" value="HOME/vuelosNac.jsp" />
</tiles:insert>