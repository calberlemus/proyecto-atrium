<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


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
		<th>DISPONIBLE</th>
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
		<%
			if (a.getDisponible()) {
		%>
		<td class="dato">Sí</td>
		<%
			} else {
		%>
		<td class="dato">No</td>
		<%
			}
		%>
	</tr>
	<%
		}
	%>

</table>