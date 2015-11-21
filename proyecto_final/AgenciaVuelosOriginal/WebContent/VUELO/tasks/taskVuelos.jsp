<%@page import="app.modelo.Rol"%>
<%@page import="app.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="tasks-vuelo">
	<div class="enlace-vuelos-selected">
		<a class="task" href="admin-vuelos.do">Vuelos</a>
	</div>
	<div class="enlace-vuelos">
		<a class="task" href="datos-vuelo.do">Nuevo Vuelo</a>
	</div>
	<%
		Usuario user = (Usuario)session.getAttribute("user");
	    if (user.getRol().toString()==Rol.ADMINISTRADOR.toString()){
	%>
		<div class="enlace-vuelos">
			<a href="informe-vuelos-disponibles.do" class="task">Informe de vuelos con asientos libres</a>
		</div>
		<div class="enlace-vuelos">
			<a href="informe-billetes-compannia.do?id=<%=user.getId().toString()%>" class="task">Informe de billetes vendidos por la compañía</a>
		</div>
	<%
	    }
	%>		
</div>