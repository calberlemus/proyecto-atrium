<%@page import="app.modelo.Vuelo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="ofertas-vuelos-internacionales">
	<div class="titulo-bloque titulo-ofertas-internacionales">Ofertas
		Vuelos Internacionales</div>
	<div class="lista-vuelos">
		<table>
		<%		
			List<Vuelo> vuelos = (List<Vuelo>)request.getAttribute("vuelosInt");
		 	int conta=0;
			for(Vuelo v: vuelos){
				conta++;
		%>
		
				<tr><td class="origen-destino"><a href="busca-vuelos-ofertas.do?id=<%=v.getId().toString()%>"><%=v.getOrigen().getCiudad()+" - "+v.getDestino().getCiudad()%></a></td><td><%=v.getPrecioOferta()%>¤</td></tr>
		<%
				if(conta>8){
					break;
				}
			}
		%>
		</table>
	</div>		
</div>
