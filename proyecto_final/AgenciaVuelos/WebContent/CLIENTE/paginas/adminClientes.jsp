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
		List<Cliente> clientes = (List<Cliente>) request
				.getAttribute("clientes");
	%>
	<table>
		<tr>
			<th>ID</th>
				<th>Nº DE CLIENTE</th>
			    <th>NICK</th>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>
                <th>CALLE</th>
                <th>NUMERO</th>
                <th>POBLACION</th>
                <th>PROVINCIA</th>
                <th>CP</th>
                <th>FECHA DE NACIMIENTO</th>                
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
		    <td class="dato"><%=c.getId().toString()%></td>
		    <td class="dato"><%=c.getNumCliente().toString()%></td>
		    <td class="dato"><%=c.getNick()%></td>
			<td class="dato"><%=c.getNombre()%></td>
			<td class="dato"><%=c.getApellidos()%></td>
			<td class="dato"><%=c.getDireccion().getCalle()%></td>
			<td class="dato"><%=c.getDireccion().getNumero()%></td>
			<td class="dato"><%=c.getDireccion().getPoblacion()%></td>
			<td class="dato"><%=c.getDireccion().getProvincia()%></td>
			<td class="dato"><%=Long.toString(c.getDireccion().getCp())%></td>
			<td class="dato"><%=Fecha.convertirDDMMYYY(c.getFechaNacimiento())%></td>
			<td class="dato"><%=c.getDni()%></td>
			<td class="dato"><%=c.getTelefono()%></td>
			<td class="dato"><%=c.getEmail()%></td>					
			<td class="dato"><a href="datos-cliente.do?id=<%=c.getId()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-cliente.do?id=<%=c.getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>