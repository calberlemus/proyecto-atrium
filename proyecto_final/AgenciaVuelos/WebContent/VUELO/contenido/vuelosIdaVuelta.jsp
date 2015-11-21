<%@page import="java.util.ArrayList"%>
<%@page import="app.util.*"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
if (request.getAttribute("vuelos")!=null){
	List<VuelosIdaVuelta> vuelos = (List<VuelosIdaVuelta>) request
			.getAttribute("vuelos");
	boolean existeDisponible=false;
%>

<div class="vuelo-ida-vuelta">
	
	<%
		for (VuelosIdaVuelta viv : vuelos) {
			List<VueloClasePrecio> vuelosVuelta = viv.getVuelosVuelta();
	%>
	<table class="vuelos-ida-vuelta">		
		<%
			for (VueloClasePrecio v : vuelosVuelta) {
				if (v.getVuelo()!=null){
					existeDisponible=true;
		%>
		
					<tr class="compannia-vuelo"><td colspan="6"><div><%=viv.getVueloIda().getVuelo().getCompannia().getNombre() %> + <%=v.getVuelo().getCompannia().getNombre() %> (<%=viv.getVueloIda().getClase()+" - "+v.getClase()%>)</div></td></tr>
					<tr>
						<td><%=Fecha.convertirDDMMYYY(viv.getVueloIda().getVuelo().getDiaSalida())+" - "+Fecha.convertirHHMM(viv.getVueloIda().getVuelo().getHoraSalida())%></td>
						<td><%=viv.getVueloIda().getVuelo().getOrigen().getCiudad() + " "
										+ viv.getVueloIda().getVuelo().getOrigen().getNombre()%></td>
						<td><%=viv.getVueloIda().getVuelo().getDestino().getCiudad() + " "
										+ viv.getVueloIda().getVuelo().getDestino().getNombre()%></td>				
						<td><%=Fecha.convertirDDMMYYY(viv.getVueloIda().getVuelo().getDiaLlegada())+" - "+Fecha.convertirHHMM(viv.getVueloIda().getVuelo().getHoraLlegada())%></td>
								
						<td><%=viv.getVueloIda().getPrecio()%>€</td>
						<td rowspan="2" class="celda-continuar">
							<form action="pasajeros-reserva.do" method="post">
								<input type="hidden" name="id_ida" value="<%=viv.getVueloIda().getVuelo().getId().toString()%>"/>
								<input type="hidden" name="id_vuelta" value="<%=v.getVuelo().getId().toString()%>"/>
								<input type="hidden" name="np" value='<%=request.getAttribute("np")%>'/>
								<input type="hidden" name="claseIda" value='<%=viv.getVueloIda().getClase()%>'/>
								<input type="hidden" name="claseVuelta" value='<%=v.getClase()%>'/>
								<input type="hidden" name="precioIda" value='<%=Double.toString(viv.getVueloIda().getPrecio())%>'/>
								<input type="hidden" name="precioVuelta" value='<%=Double.toString(v.getPrecio())%>'/>
								<div><%=viv.getVueloIda().getPrecio()+v.getPrecio()%></div>
								<input type="submit" value="Continuar"/>								
							</form>
						</td>
					</tr>		
					<tr>
						<td><%=Fecha.convertirDDMMYYY(v.getVuelo().getDiaSalida())+" - "+Fecha.convertirHHMM(v.getVuelo().getHoraSalida())%></td>
						<td><%=v.getVuelo().getOrigen().getCiudad() + " "
										+ v.getVuelo().getOrigen().getNombre()%></td>
						<td><%=v.getVuelo().getDestino().getCiudad() + " "
										+ v.getVuelo().getDestino().getNombre()%></td>			
						<td><%=Fecha.convertirDDMMYYY(v.getVuelo().getDiaLlegada())+" - "+Fecha.convertirHHMM(v.getVuelo().getHoraLlegada())%></td>			
						<td><%=v.getPrecio()%>€</td>
					</tr>
					<tr class="espacio-vuelos"></tr>
		
		<%
				}
			}
		%>
	</table>
	<%
		}
	%>
	<%=(vuelos==null || vuelos.size()==0 || !existeDisponible) ? "No se han encontrado vuelos para las condiciones buscadas" : "" %>
</div>
<%
}
%>