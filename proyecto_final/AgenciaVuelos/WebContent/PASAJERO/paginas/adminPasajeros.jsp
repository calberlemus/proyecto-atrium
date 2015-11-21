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
		List<Pasajero> pasajeros = (List<Pasajero>) request
				.getAttribute("pasajeros");
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>CALLE</th>
			<th>NUMERO</th>
			<th>POBLACION</th>
			<th>PROVINCIA</th>
			<th>CP</th>
			<th>FECHA DE NACIMIENTO</th>
			<th>DNI</th>
			<th>FECHA DE CADUCIDAD DNI</th>
			<th>TIPO</th>
			<th>Nº DE ASIENTO IDA</th>
			<th>Nº DE ASIENTO VUELTA</th>
			<th>EDITAR</th>
			<th>ELIMINAR</th>
		</tr>
		<%
			for (Pasajero p : pasajeros) {
		%>
		<tr>
			<td class="dato"><%=p.getId()%></td>
			<td class="dato"><%=p.getNombre()%></td>
			<td class="dato"><%=p.getApellidos()%></td>
			<td class="dato"><%=p.getDireccion().getCalle()%></td>
			<td class="dato"><%=p.getDireccion().getNumero()%></td>
			<td class="dato"><%=p.getDireccion().getPoblacion()%></td>
			<td class="dato"><%=p.getDireccion().getProvincia()%></td>
			<td class="dato"><%=p.getDireccion().getCp()%></td>
			<td class="dato"><%=Fecha.convertirDDMMYYY(p.getFechaNacimiento())%></td>
			<td class="dato"><%=p.getDni()%></td>
			<td class="dato"><%=Fecha.convertirDDMMYYY(p.getFechaCadDni())%></td>
			<td class="dato"><%=p.getTipo().toString()%></td>
			<td class="dato"><%=p.getAsientoIda().getNumero()%></td>
			<td class="dato"><%=p.getAsientoVuelta().getNumero()%></td>
			<td class="dato"><a
				href="datos-pasajero.do?id=<%=p.getId()%>&idVueloIda=<%=p.getAsientoIda().getVuelo().getId()%>&idVueloVuelta=<%=p.getAsientoVuelta().getVuelo().getId()%>">Editar</a></td>
			<td class="dato"><a
				href="eliminar-pasajero.do?id=<%=p.getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>