<%@page import="app.actions.Acceso"%>
<%@page import="app.modelo.Rol"%>
<%@page import="app.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div>
	<div class="banner-logo">
		<img class ="imagen-logo" src="imagenes/banner_superior.png">
	</div>
	<%
		Usuario user = null;
		if (session.getAttribute("user") == null) {
	%>
	<div class="login">
		<html:form action="login.do">
			<div>Usuario</div>
			<html:text property="nick" styleClass="input-text" />
			<div>Contraseña</div>
			<html:password property="pass" styleClass="input-text" />
			<br>
			<html:submit value="Login" styleClass="bt-login" />
			<button class="link-registro">
				<a href="datos-cliente-registro.do">Registro</a>
			</button>
		</html:form>
	</div>
	<%
		} else {
			user = (Usuario) session.getAttribute("user");
	%>
	<div class="logout">
		<div class="bienvenido">
			<div class="saludo">Bienvenido</div>
			<div class="usuario-logado"><%=user.getNombre() + " " + user.getApellidos()%></div>
			<button class="bt-perfil">
				<%
					if (user.getRol().toString()==Rol.ADMINISTRADOR.toString()){
				%>
					<a href="datos-admin-compannia-registro.do?id=<%=user.getId().toString()%>">Mi cuenta</a>
				<%
					}else if (user.getRol().toString()==Rol.SUPERADMINISTRADOR.toString()){
				%>				
					<a href="datos-super.do?id=<%=user.getId().toString()%>">Mi cuenta</a>
				<%
					}else if (user.getRol().toString()==Rol.CLIENTE.toString()){
				%>
					<a href="datos-cliente-registro.do?id=<%=user.getId().toString()%>">Mi cuenta</a>
				<%
					}
				%>			
			</buton>				
				<button class="bt-logout">
					<a href="logout.do">Logout</a>
					</buton>
		</div>
		<div class="menu-oculto"></div>
	</div>
	<%
		}
	%>

</div>
<div class="menu-principal">
	<ul>
		<li class="item item-inicial"><a href="home.do">Inicio</a></li>
		<%
			if (session.getAttribute("user")!=null && Acceso.Permiso(session.getAttribute("user"), Rol.ADMINISTRADOR)){
		%>
		<li class="item"><a href="admin-vuelos.do">Administrar Vuelos</a></li>		
		
		<%
			}
			if (session.getAttribute("user")!=null && Acceso.Permiso(session.getAttribute("user"), Rol.SUPERADMINISTRADOR)){
		%>
		<li class="item"><a href="admin-aeropuertos.do">Administrar
				Aeropuertos</a></li>
		<li class="item"><a href="admin-compannias.do">Administrar
				compañías</a></li>
		<li class="item"><a href="admin-admincompannias.do">Administradores
				de Compañías</a></li>
		<li class="item"><a href="admin-clientes.do">Clientes</a></li>
		<li class="item  item-final"><a href="admin-ofertas.do">Ofertas</a></li>
		<%			
			}
		%>
	</ul>
</div>