<%@page import="app.modelo.Oferta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="slider-ofertas">
    <%
    	List<Oferta> ofertas = (List<Oferta>)request.getAttribute("ofertas");
    %>
     
	<div id="slider">
		<%
			if (ofertas==null || ofertas.size()<=0){
		%>
			<div>
				<a href="#"><img src="imagenes/madrid.jpg" /></a>
			</div>
			<div>
				<a href=#"><img src="imagenes/paris.jpg" /></a>
			</div>
			<div>
				<a href="#"><img src="imagenes/roma.jpg" /></a>
			</div>
		<%
			}else{
				for(Oferta o : ofertas){
		%>
			<div>
				<a href="busca-vuelos-ofertas.do?destino=<%=o.getDestino().toString()%>"><img src="images/<%=o.getPath().toString() %>" /></a>
			</div>
		<%
				}
			}
		%>
	</div>
</div>