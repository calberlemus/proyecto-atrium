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
		List<AdminCompannia> admins = (List<AdminCompannia>) request
				.getAttribute("admins");
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
                <th>TELEFONO</th>
                <th>EMAIL</th>
                <th>REGISTRO</th>
                <th>COMPAÑIA</th>
                <th>EDITAR</th>
                <th>ELIMINAR</th>
		</tr>
		<%
			for (AdminCompannia a : admins) {
		%>
		<tr>			
		    <td class="dato"><%=a.getId()%></td>
			<td class="dato"><%=a.getNombre()%></td>
			<td class="dato"><%=a.getApellidos()%></td>
			<td class="dato"><%=a.getDireccion().getCalle()%></td>
			<td class="dato"><%=a.getDireccion().getNumero()%></td>
			<td class="dato"><%=a.getDireccion().getPoblacion()%></td>
			<td class="dato"><%=a.getDireccion().getProvincia()%></td>
			<td class="dato"><%=a.getDireccion().getCp()%></td>
			<td class="dato"><%=Fecha.convertirDDMMYYY(a.getFechaNacimiento())%></td>
			<td class="dato"><%=a.getDni()%></td>
			<td class="dato"><%=a.getTelefono()%></td>
			<td class="dato"><%=a.getEmail()%></td>
			<td class="dato"><%=a.getNumRegistro()%></td>
			<td class="dato"><%=a.getCompannia().getNombre()%></td>			
			<td class="dato"><a href="datos-admincompannia.do?id=<%=a.getId()%>">Editar</a></td>
			<td class="dato"><a href="eliminar-admincompannia.do?id=<%=a.getId()%>">Eliminar</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>