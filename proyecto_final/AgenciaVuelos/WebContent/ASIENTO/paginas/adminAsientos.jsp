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
		List<Asiento> asientos = (List<Asiento>) request
				.getAttribute("asientos");
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>VUELO</th>
			<th>NUMERO</th>
			<th>CLASE</th>
			<th>EDITAR</th>
			<th>ELIMINAR</th>
		</tr>
		<%
			for (Asiento a : asientos) {
		%>
		<tr>
			<td class="dato"><%=a.getId()%></td>
			<td class="dato"><%=a.getVuelo().getOrigen().getCiudad() + " - "
						+ a.getVuelo().getDestino().getCiudad()%></td>
			<td class="dato"><%=a.getNumero()%></td>
			<td class="dato"><%=a.getClase()%></td>
			<td class="dato"><a
				href="datos-asiento.do?id=<%=a.getId()%>&idVuelo=<%=a.getVuelo().getId()%>">Editar</a></td>
			<td class="dato"><a
				href="eliminar-asiento.do?id=<%=a.getId()%>&idVuelo=<%=a.getVuelo().getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>