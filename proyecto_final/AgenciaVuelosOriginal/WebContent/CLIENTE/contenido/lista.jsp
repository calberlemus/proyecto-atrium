<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
		List<Cliente> clientes = (List<Cliente>) request
				.getAttribute("clientes");
%>
	<table class="tabla-clientes">
		<tr>				
				<th>N.REG</th>
                <th>NOMBRE Y APELLIDOS</th>          
                <th>DNI</th>
                <th>TELEFONO</th>
                <th>EMAIL</th>                
                <th>EDITAR</th>
                <th>ELIMINAR</th>
		</tr>
		<%
			for (Cliente c : clientes) {
		%>
		<tr>		    
		    <td class="dato"><%=c.getNumCliente()%></td>
			<td class="dato"><%=c.getNombre()+" "+c.getApellidos()%></td>			
			<td class="dato"><%=c.getDni()%></td>
			<td class="dato"><%=c.getTelefono()%></td>
			<td class="dato"><%=c.getEmail()%></td>					
			<td class="dato"><a href="datos-cliente.do?id=<%=c.getId().toString()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-cliente.do?id=<%=c.getId().toString()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>
		<tr><td colspan="7"><%=clientes.size()<=0 ? "No existen Clientes" : "" %></td></tr>
	</table>