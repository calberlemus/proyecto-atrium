<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	List<Vuelo> vuelos = (List<Vuelo>) request.getAttribute("vuelos");
%>
<table>
	<tr>
		<th>ID</th>
		<th>SALIDA</th>
		<th>ORIGEN</th>
		<th>LLEGADA</th>
		<th>DESTINO</th>
		<th>COMPAÑIA</th>
		<th>PRECIO</th>		
		<th>ASIENTOS</th>
		<th>CANCELAR</th>
		<th>EDITAR</th>
		<th>ELIMINAR</th>
	</tr>
	<%
		for (Vuelo v : vuelos) {
	%>
	<tr>
		<td class="dato"><%=v.getId()%></td>
		<td class="dato"><%=Fecha.convertirDDMMYYY(v.getDiaSalida())+" - "+Fecha.convertirHHMM(v.getHoraSalida())%></td>
		<td class="dato"><%=v.getOrigen().getCiudad() + " "
						+ v.getOrigen().getNombre()%></td>
		<td class="dato"><%=Fecha.convertirDDMMYYY(v.getDiaLlegada())+" - "+Fecha.convertirHHMM(v.getHoraLlegada())%></td>
		<td class="dato"><%=v.getDestino().getCiudad() + " "
						+ v.getDestino().getNombre()%></td>
		<td class="dato"><%=v.getCompannia().getNombre()%></td>
		<td class="dato">
			<ul>
				<li>Oferta: <%=v.getPrecioOferta()%>€</li>
				<li>Turista: <%=v.getPrecioTurista()%>€</li>
				<li>Bussines: <%=v.getPrecioBussines()%>€</li>
			</ul> 
		</td>		
		<td class="dato"><a
			href="admin-asientos.do?idVuelo=<%=v.getId()%>">Asientos</a></td>
		<%
			if (v.isCancelado()){
		%>	
			<td class="dato cancelado">!CANCELADO!</td>
		<%
			}else{
		%>
			<td class="dato"><a href="cancelar-vuelo.do?id=<%=v.getId()%>">CANCELAR</a></td>
		<%
			}
		%>		
		<td class="dato"><a href="datos-vuelo.do?id=<%=v.getId()%>">Editar</a></td>
		<td class="dato"><a href="eliminar-vuelo.do?id=<%=v.getId()%>">Eliminar</a></td>
	</tr>
	<%
		}
	%>
	<tr><td colspan="11"><%=vuelos.size()<=0 ? "No existen Vuelos" : "" %></td></tr>
</table>