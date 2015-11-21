<%@page import="app.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
    Usuario user = null;
	if(session.getAttribute("user")!=null){
		user = (Usuario)session.getAttribute("user");
	}
%>

<div class="tasks-cliente">	
	<div class="enlace-clientes">
		<a href='datos-cliente-registro.do?id=<%=user!=null ? user.getId().toString() : "" %>' class="task">Editar perfil</a>
	</div>
	<div class="enlace-clientes-selected">
		<a href="reservas-cliente.do?id=<%=user.getId().toString() %>" class="task">Mis reservas</a>
	</div>	
</div>