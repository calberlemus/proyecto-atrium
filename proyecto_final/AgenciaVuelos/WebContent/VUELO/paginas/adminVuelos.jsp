<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Vuelo> vuelos = (List<Vuelo>) request
				.getAttribute("vuelos");
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>FECHA DE SALIDA</th>
			<th>ORIGEN</th>
			<th>FECHA DE LLEGADA</th>
			<th>DESTINO</th>									
			<th>COMPAÑIA</th>
			<th>PRECIO OFERTA</th>
			<th>PRECIO TURISTA</th>
			<th>PRECIO BUSSINES</th>
			<th>ASIENTOS</th>
			<th>EDITAR</th>
			<th>ELIMINAR</th>
		</tr>
		<%
			for (Vuelo v : vuelos) {
		%>
		<tr>
		    <td class="dato"><%=v.getId()%></td>
		    <td class="dato"><%=Fecha.convertirDDMMYYY(v.getDiaSalida())%></td>
			<td class="dato"><%=v.getOrigen().getCiudad()+" "+v.getOrigen().getNombre()%></td>
			<td class="dato"><%=Fecha.convertirDDMMYYY(v.getDiaLlegada())%></td>
			<td class="dato"><%=v.getDestino().getCiudad()+" "+v.getDestino().getNombre()%></td>			
			<td class="dato"><%=v.getCompannia().getNombre()%></td>
			<td class="dato"><%=v.getPrecioOferta()%></td>
			<td class="dato"><%=v.getPrecioTurista()%></td>
			<td class="dato"><%=v.getPrecioBussines()%></td>
			<td class="dato"><a href="admin-asientos.do?idVuelo=<%=v.getId()%>">Asientos</a></td>
			<td class="dato"><a href="datos-vuelo.do?id=<%=v.getId()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-vuelo.do?id=<%=v.getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>