<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="CLIENTE/css/cliente.css">
<link rel="stylesheet" type="text/css" href="css/global.css">
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
			$(".num-cliente").mask("9999");	
			$(".dni").mask("99999999a");			     
		});
	})
</script>




<tiles:insert page="tmpAdminForm.jsp" flush="true">
	<tiles:put name="cabecera" value="cabecera.jsp"/>
	<tiles:put name="tasks" value="CLIENTE/tasks/taskAltaClienteRegistro.jsp"/>	
	<tiles:put name="contenido" value="CLIENTE/contenido/altaRegistro.jsp" />
</tiles:insert>