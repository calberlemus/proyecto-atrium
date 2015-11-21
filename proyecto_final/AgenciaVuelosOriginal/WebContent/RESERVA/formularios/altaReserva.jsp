<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="calendario_dw/calendario_dw-estilos.css" type="text/css"
	rel="STYLESHEET">
<script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".campofecha").calendarioDW();
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	List<Cliente> clientes = (List<Cliente>) request
			.getAttribute("clientes");
	List<Vuelo> vuelosIda = (List<Vuelo>) request
			.getAttribute("vuelosIda");
	List<Vuelo> vuelosVuelta = (List<Vuelo>) request
			.getAttribute("vuelosVuelta");
%>
<html:form action="alta-reserva.do">	
	<div>Vuelo Ida</div>
	<html:select property="idVueloIda">
		<%
			for (Vuelo v : vuelosIda) {
		%>
		<html:option value="<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad() + " -  " + v.getDestino().getCiudad() %></html:option>
		<%
			}
		%>
	</html:select>
	<div>Vuelo Vuelta</div>
	<html:select property="idVueloVuelta">
		<%
			for (Vuelo v : vuelosVuelta) {
		%>
		<html:option value="<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad() + " -  " + v.getDestino().getCiudad() %></html:option>
		<%
			}
		%>
	</html:select>
	<div>Cliente</div>
	<html:select property="idCliente">
		<%
			for (Cliente c : clientes) {
		%>
		<html:option value="<%=c.getId().toString()%>"><%=c.getNick()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Clase Ida</div>
	<html:select property="claseIda">		
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>		
	</html:select>
	<div>Clase Vuelta</div>
	<html:select property="claseVuelta">		
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>		
	</html:select>		
	<html:submit value="Dar de alta" />
</html:form>
</body>
</html>