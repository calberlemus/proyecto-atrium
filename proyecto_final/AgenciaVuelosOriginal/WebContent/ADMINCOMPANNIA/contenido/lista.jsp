<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
		List<AdminCompannia> admins = (List<AdminCompannia>) request
				.getAttribute("admins");
%>
	<table class="tabla-admins">
		<tr>				
				<th>N.REG</th>
                <th>NOMBRE Y APELLIDOS</th>          
                <th>DNI</th>
                <th>TELEFONO</th>
                <th>EMAIL</th>
                <th>COMPAÑIA</th>
                <th>EDITAR</th>
                <th>ELIMINAR</th>
		</tr>
		
		<%		
			for (AdminCompannia a : admins) {
		%>
		<tr>		    
		    <td class="dato"><%=a.getNumRegistro()%></td>
			<td class="dato"><%=a.getNombre()+" "+a.getApellidos()%></td>			
			<td class="dato"><%=a.getDni()%></td>
			<td class="dato"><%=a.getTelefono()%></td>
			<td class="dato"><%=a.getEmail()%></td>			
			<td class="dato"><%=a.getCompannia().getNombre()%></td>		
			<td class="dato"><a href="datos-admincompannia.do?id=<%=a.getId().toString()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-admincompannia.do?id=<%=a.getId().toString()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>
		<tr><td colspan="8"><%=admins.size()<=0 ? "No existen Administradores de Compañía" : "" %></td></tr>
	</table>
	