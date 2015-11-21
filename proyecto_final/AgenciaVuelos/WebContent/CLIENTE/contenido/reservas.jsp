<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
		List<Reserva> reservas = (List<Reserva>) request
				.getAttribute("reservas");
%>
	<table class="tabla-reservas">
		<tr>				
				<th>Nº DE RESERVA</th>
                <th>IDA</th>                         
                <th>VUELTA</th>
                <th>CLASE</th>
                <th>Nº DE PASAJEROS</th>
                <th>PRECIO</th>                 
                <th>EDITAR</th>
                <th>CANCELAR</th>
		</tr>
		<%
			for (Reserva r : reservas) {
		%>
		<tr>		    
		    <td class="dato"><%=r.getId()%></td>
			<td class="dato"><%=r.getVueloIda().getOrigen().getCiudad()+" "+r.getVueloIda().getDestino().getCiudad()%></td>			
			<td class="dato"><%=r.getVueloVuelta()!=null ? r.getVueloVuelta().getOrigen().getCiudad()+" "+r.getVueloVuelta().getDestino().getCiudad() : ""%></td>
			<td class="dato"><%=r.getPasajeros().size()%></td>			
			<td class="dato"><%=r.getPrecioPersona()*r.getPasajeros().size()%></td>					
			<td class="dato"><a href="datos-reserva.do?id=<%=r.getId().toString()%>">Editar</a></td>
			<td class="dato"><a href="cancelar-reserva.do?id=<%=r.getId().toString()%>">Cancelar</a></td>
		</tr>
		<%
			}
		%>

	</table>