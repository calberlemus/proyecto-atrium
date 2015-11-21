<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	List<Oferta> ofertas = (List<Oferta>) request
			.getAttribute("ofertas");
%>
<table>
	<tr>
		<th>ID</th>
		<th>DESTINO</th>
		<th>IMAGEN</th>		
		<th>EDITAR</th>
		<th>ELIMINAR</th>
	</tr>
	<%
		for (Oferta o : ofertas) {
	%>
	<tr>
		<td class="dato"><%=o.getId().toString()%></td>
		<td class="dato"><%=o.getCiudad()%></td>
		<td class="dato"><%=o.getPath()%></td>		
		<td class="dato"><a href="datos-oferta.do?id=<%=o.getId().toString()%>">Editar</a></td>
		<td class="dato"><a	href="eliminar-oferta.do?id=<%=o.getId()%>">Eliminar</a></td>
	</tr>
	<%
		}
	%>
	<tr><td colspan="5"><%=ofertas.size()<=0 ? "No existen Ofertas" : "" %></td></tr>
</table>