<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	Reserva reserva = (Reserva)request.getAttribute("reserva");
	if (reserva==null){
%>

<html:form action="editar-reserva.do">	
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
	<html:hidden property="id" />
	<html:submit value="Guardar" />
</html:form>
<%
	} else {
%>
<html:form action="editar-reserva.do">	
	<div>Vuelo Ida</div>
	<html:select property="idVueloIda" value="<%=reserva.getVueloIda().getId() %>">
		<%
			for (Vuelo v : vuelosIda) {
		%>
		<html:option value="<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad() + " -  " + v.getDestino().getCiudad() %></html:option>
		<%
			}
		%>
	</html:select>
	<div>Vuelo Vuelta</div>
	<html:select property="idVueloVuelta" value="<%=reserva.getVueloIda().getId() %>">
		<%
			for (Vuelo v : vuelosVuelta) {
		%>
		<html:option value="<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad() + " -  " + v.getDestino().getCiudad() %></html:option>
		<%
			}
		%>
	</html:select>
	<div>Cliente</div>
	<html:select property="idCliente" value="<%=reserva.getCliente().getId() %>">
		<%
			for (Cliente c : clientes) {
		%>
		<html:option value="<%=c.getId().toString()%>"><%=c.getNick()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Clase Ida</div>
	<html:select property="claseIda" value="<%=reserva.getClaseIda().toString() %>">		
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>		
	</html:select>
	<div>Clase Vuelta</div>
	<html:select property="claseVuelta" value="<%=reserva.getClaseVuelta().toString() %>">		
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>		
	</html:select>	
	<html:hidden property="id"  value="<%=Long.toString(reserva.getId()) %>"/>	
	<html:submit value="Guardar" />
</html:form>
<%
	}
%>
</body>
</html>