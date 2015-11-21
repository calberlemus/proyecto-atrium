<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
			.getAttribute("aeropuertos");
%>
<table>
	<tr>
		<th>ID</th>
		<th>CODIGO</th>
		<th>NOMBRE</th>
		<th>PAIS</th>
		<th>CIUDAD</th>
		<th>EDITAR</th>
		<th>ELIMINAR</th>
	</tr>
	<%
		for (Aeropuerto a : aeropuertos) {
	%>
	<tr>
		<td class="dato"><%=a.getId()%></td>
		<td class="dato"><%=a.getCodigo()%></td>
		<td class="dato"><%=a.getNombre()%></td>
		<td class="dato"><%=a.getPais()%></td>
		<td class="dato"><%=a.getCiudad()%></td>
		<td class="dato"><a href="datos-aeropuerto.do?id=<%=a.getId()%>">Editar</a></td>
		<td class="dato"><a
			href="eliminar-aeropuerto.do?id=<%=a.getId()%>">Eliminar</a></td>
	</tr>
	<%
		}
	%>
	<tr><td colspan="7"><%=aeropuertos.size()<=0 ? "No existen Aeropuertos" : "" %></td></tr>
</table>