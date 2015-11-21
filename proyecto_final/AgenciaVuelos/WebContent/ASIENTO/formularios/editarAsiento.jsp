<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="errores">
	<html:errors property="codigo" />
</div>
<div class="errores">
	<html:errors property="nombre" />
</div>
<div class="errores">
	<html:errors property="pais" />
</div>
<div class="errores">
	<html:errors property="ciudad" />
</div>
<%
	List<Vuelo> vuelos = (List<Vuelo>) request.getAttribute("vuelos");
	Asiento asiento = (Asiento) request.getAttribute("asiento");
	if (asiento == null) {
%>
<html:form action="editar-asiento.do">
	<div>Vuelo</div>
	<html:select property="idVuelo">
		<%
			for (Vuelo v : vuelos) {
		%>
		<html:option value="<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad() + " - "
										+ v.getDestino().getCiudad()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Numero</div>
	<html:text property="numero" size="50" />
	<div>Clase</div>
	<html:select property="clase">
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>
	</html:select>
	<html:hidden property="id"/>
	<html:submit value="Guardar" />
</html:form>
<%
	} else {
%>
<html:form action="editar-asiento.do">
	<div>Vuelo</div>
	<html:select property="idVuelo" value="<%=asiento.getVuelo().getId().toString() %>">
		<%
			for (Vuelo v : vuelos) {				
		%>
		<html:option value="<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad() + " - "
										+ v.getDestino().getCiudad()%></html:option>
		<%
			}
		%>
	</html:select>
	<div>Numero</div>
	<html:text property="numero" size="50" value="<%=Integer.toString(asiento.getNumero()) %>" />
	<div>Clase</div>
	<html:select property="clase" value="<%=asiento.getClase().toString() %>">
		<html:option value="TURISMO">TURISMO</html:option>
		<html:option value="BUSSINES">BUSSINES</html:option>
		<html:option value="OFERTA">OFERTA</html:option>
	</html:select>
	<html:hidden property="id" value="<%=asiento.getId().toString() %>"/>
	<html:submit value="Dar de alta" />
</html:form>
<%
	}
%>

</body>
</html>