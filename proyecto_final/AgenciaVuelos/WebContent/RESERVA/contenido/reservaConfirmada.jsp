<%@page import="java.util.List"%>
<%@page import="app.modelo.Pasajero"%>
<%@page import="app.modelo.Clase"%>
<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.Vuelo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Vuelo vueloIda = (Vuelo)session.getAttribute("vueloIda");
	Vuelo vueloVuelta = null;
	String claseIda = (String)session.getAttribute("claseIda");
	String claseVuelta="";	
	int np = (Integer)session.getAttribute("np");	
	double precioIda =(Double)session.getAttribute("precioIda");
	double precioTotal = precioIda * np;
	double precioVuelta =0;
	if (session.getAttribute("vueloVuelta")!=null){
		vueloVuelta = (Vuelo)session.getAttribute("vueloVuelta");
		claseVuelta = (String)session.getAttribute("claseVuelta");
		precioVuelta =(Double)session.getAttribute("precioVuelta");
		precioTotal = precioTotal + (precioVuelta*np);
	}	
	List<Pasajero> pasajeros = (List<Pasajero>)session.getAttribute("pasajeros");	
	
%>
<div class="titulo">Datos de la reserva</div>
<div class="datos-vuelos">
	<div class="vuelo-ida-vuelta">
		<table class="vuelos-ida-vuelta">
			<tr class="compannia-vuelo">
				<td colspan="6">
					<div>Ida <%=vueloIda.getCompannia().getNombre()%> (<%=claseIda%>)</div>
				</td>
			</tr>
			<tr>
				<td><%=vueloIda.getId() %></td>
				<td class="fecha"><%=Fecha.convertirDDMMYYY(vueloIda.getDiaSalida())%></td>
				<td class="aeropuerto"><%=vueloIda.getOrigen().getCiudad() + " "
					+ vueloIda.getOrigen().getNombre()%></td>
				<td class="aeropuerto"><%=vueloIda.getDestino().getCiudad() + " "
					+ vueloIda.getDestino().getNombre()%></td>
				<td class="fecha"><%=Fecha.convertirDDMMYYY(vueloIda.getDiaLlegada())%></td>				
				<td class="precio"><%=precioIda%>€</td>
				<td class="confirmado">Confirmado</td>				
			</tr>
		</table>	
			
					
		<%
			if (vueloVuelta != null) {				
		%>
		<table class="vuelos-ida-vuelta">
			<tr class="compannia-vuelo">
				<td colspan="6">
					<div>Vuelta <%=vueloVuelta.getCompannia().getNombre()%> (<%=claseVuelta%>)</div>
				</td>
			</tr>						
			<tr>
				<td><%=vueloVuelta.getId() %></td>
				<td class="fecha"><%=Fecha.convertirDDMMYYY(vueloVuelta.getDiaSalida())%></td>
				<td class="aeropuerto"><%=vueloVuelta.getOrigen().getCiudad() + " "
								+ vueloVuelta.getOrigen().getNombre()%></td>
				<td class="aeropuerto"><%=vueloVuelta.getDestino().getCiudad() + " "
								+ vueloVuelta.getDestino().getNombre()%></td>			
				<td class="fecha"><%=Fecha.convertirDDMMYYY(vueloVuelta.getDiaLlegada())%></td>			
				<td class="precio"><%=precioVuelta%>€</td>
				<td class="confirmado">Confirmado</td>
			</tr>
		</table>	

		<%
			}
		%>		
		
			
		
	</div>	
</div>

<div class="datos-pasajeros">
	<table class="lista pasajeros">
		<tr>
				<th>Nombre y Apellidos</th>
				<th>Dni</th>
			    <th>Nº Asiento Ida</th>	
			    <%
			    	if (vueloVuelta != null){
			    %>			
				<th>Nº Asiento Vuelta</th>
				<%
			    	}
				%>			
		</tr>
		<%			
			for(Pasajero p: pasajeros){
		%>
			
		<tr>
			<td><%=p.getNombre()+" "+p.getApellidos()%></td>
			<td><%=p.getDni()%></td>
			<td><%=p.getAsientoIda().getNumero()%></td>				
			<%
			   	if (vueloVuelta != null){
			%>			
				<td><%=p.getAsientoVuelta().getNumero()%></td>
			<%
			   	}
			%>		
			
		</tr>		
		<%				
			}
		%>
	</table>
</div>
<div class="espacio-lateral"></div>
<div class="precio-total">
	<div class="titulo">Precio de la reserva</div>
	<table>
		<tr class="precio-final">
			<td class="numpas">Pasajeros x<%=np%></td>
			<td><%=precioTotal %>€</td>
		</tr>
	</table>	
</div>




