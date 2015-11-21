<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="VUELO/css/vuelo.css">
<link rel="stylesheet" type="text/css" href="css/global.css">
<link href="calendario_dw/calendario_dw-estilos.css" type="text/css"
	rel="STYLESHEET">
<link href="clockpick/jquery.clockpick.1.2.9.css" type="text/css"
	rel="STYLESHEET">	
<script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
<script type="text/javascript" src="clockpick/jquery.clockpick.1.2.9.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".campofecha").calendarioDW();
		$(".clockpick").clockpick({
			starthour : 0,
			endhour : 23,
			minutedivisions:12,
			military : true
			}
		);
	})
</script>



<tiles:insert page="tmpAdminForm.jsp" flush="true">
	<tiles:put name="cabecera" value="cabecera.jsp"/>
	<tiles:put name="tasks" value="VUELO/tasks/taskAltaVuelo.jsp"/>	
	<tiles:put name="contenido" value="VUELO/contenido/alta.jsp" />
</tiles:insert>