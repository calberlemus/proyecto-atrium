<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
		List<Compannia> compannias = (List<Compannia>) request
				.getAttribute("compannias");
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>CODIGO</th>
			<th>NOMBRE</th>
			<th>PAIS</th>								
			<th>EDITAR</th>
			<th>ELIMINAR</th>
		</tr>
		<%
			for (Compannia c : compannias) {
		%>
		<tr>
		    <td class="dato"><%=c.getId()%></td>
			<td class="dato"><%=c.getCodigo()%></td>
			<td class="dato"><%=c.getNombre()%></td>
			<td class="dato"><%=c.getPais()%></td>			
			<td class="dato"><a href="datos-compannia.do?id=<%=c.getId()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-compannia.do?id=<%=c.getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>
		<tr><td colspan="6"><%=compannias.size()<=0 ? "No existen Clientes" : "" %></td></tr>
	</table>