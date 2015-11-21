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
		List<Reserva> reservas = (List<Reserva>) request
				.getAttribute("reservas");
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>VUELO IDA</th>
			<th>VUELO VUELTA</th>
			<th>CLIENTE</th>
			<th>CLASE IDA</th>
			<th>CLASE VUELTA</th>
			<th>PRECIO POR PERSONA</th>
			<th>FECHA</th>
			<th>EDITAR</th>
			<th>ELIMINAR</th>
		</tr>
		<%
			for (Reserva r : reservas) {
		%>
		<tr>
			<td class="dato"><%=r.getId()%></td>
			<td class="dato"><%=r.getVueloIda().getId() %></td>
			<td class="dato"></td>
			<td class="dato"><%=r.getCliente().getNick()%></td>
			<td class="dato"><%=r.getClaseIda().toString()%></td>
			<td class="dato"><%=r.getClaseVuelta().toString()%></td>
			<td class="dato">10</td>
			<td class="dato"><%=Fecha.convertirDDMMYYY(r.getFecha())%></td>
			<td class="dato"><a href="datos-reserva.do?id=<%=r.getId()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-reserva.do?id=<%=r.getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>