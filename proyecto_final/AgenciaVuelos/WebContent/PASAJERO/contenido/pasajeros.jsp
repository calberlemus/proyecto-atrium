<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.Pasajero"%>
<%@page import="app.modelo.Vuelo"%>
<%@page import="app.modelo.Asiento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	
	List<Pasajero> pasajeros = new ArrayList<Pasajero>();
	if(session.getAttribute("pasajeros")!=null){
		pasajeros = (List<Pasajero>)session.getAttribute("pasajeros");
	}	
	Pasajero p;
	int numPasajeros = (Integer)(session.getAttribute("np"));
	Vuelo vueloIda =(Vuelo)(session.getAttribute("vueloIda"));
	List<Asiento> asientosIda = (List<Asiento>) session
			.getAttribute("asientosIda");
	
	Vuelo vueloVuelta = null;
	List<Asiento> asientosVuelta=null;
	if (session.getAttribute("vueloVuelta")!=null){
		vueloVuelta =(Vuelo)(session.getAttribute("vueloVuelta"));
		asientosVuelta = (List<Asiento>) session
				.getAttribute("asientosVuelta");
		
	}
	
%>
<form action="alta-pasajeros-reserva.do" method="post">
	<input type="hidden" name="np" value="<%=numPasajeros%>"/>
	<%
		for (int i = 1; i <= numPasajeros; i++) {
	%>
	
    <%
    	if (pasajeros.size()>0){
    		p=pasajeros.get(i-1);
    	}else{
    		p=null;
    	}
    		
    %> 
	<div class="pasajero">
		<div class="num-pasajero">Pasajero <%=i%></div>
		<div class="campo primer-campo">
			<div class="label">
				<label>Nombre</label>
			</div>
			<INPUT type="text" name="nombre-<%=i%>" value="<%=p!=null && p.getNombre()!=null ? p.getNombre() : "" %>" />
		</div>
		<div class="campo">
			<div class="label">
				<label>Apellidos</label>
			</div>
			
			<INPUT type="text" name="apellidos-<%=i%>" value="<%=p!=null && p.getApellidos()!=null ? p.getApellidos() : "" %>" />
		</div>
		<div class="campo">
			<div class="label">
				<label>Dni</label>
			</div>
			<INPUT class = "dni" type="text" name="dni-<%=i%>" value="<%=p!=null && p.getDni()!=null ? p.getDni() : "" %>" />
		</div>
		<div class="campo">
			<div class="label">
				<label>Fecha de caducidad del dni</label>
			</div>
			<INPUT type="text" name="fechaCadDni-<%=i%>" class="campofecha" value="<%=p!=null && p.getFechaCadDni()!=null ? Fecha.convertirDDMMYYY(p.getFechaCadDni()) : "" %>" />
		</div>
		<div class="campo">
			<div class="label">
				<label>Calle</label>
			</div>
			<INPUT type="text" name="calle-<%=i%>" value="<%=p!=null && p.getDireccion().getCalle()!=null ? p.getDireccion().getCalle() : "" %>" />
		</div>
		<div class="campo">
			<div class="label">
				<label>Numero</label>
			</div>
			<INPUT type="text" name="numero-<%=i%>" value="<%=p!=null && p.getDireccion().getNumero()!=null ? p.getDireccion().getNumero() : "" %>"/>
		</div>
		<div class="campo">
			<div class="label">
				<label>Provincia</label>
			</div>
			<INPUT type="text" name="provincia-<%=i%>" value="<%=p!=null && p.getDireccion().getProvincia()!=null ? p.getDireccion().getProvincia() : "" %>" />
		</div>
		<div class="campo">
			<div class="label">
				<label>Cp</label>
			</div>
			<INPUT type="text" name="cp-<%=i%>" value="<%=p!=null && p.getDireccion().getCp()!=0 ? p.getDireccion().getCp() : "" %>"/>
		</div>
		<div class="campo">
			<div class="label">
				<label>Localidad</label>
			</div>
			<INPUT type="text" name="poblacion-<%=i%>" value="<%=p!=null && p.getDireccion().getPoblacion()!=null ? p.getDireccion().getPoblacion() : "" %>"/>
		</div>
		<div class="campo">
			<div class="label">
				<label>Fecha de Nacimiento</label>
			</div>
			<INPUT type="text" name="fechaNacimiento-<%=i%>" class="campofecha" value="<%=p!=null && p.getFechaNacimiento()!=null ? Fecha.convertirDDMMYYY(p.getFechaNacimiento()) : "" %>" />
		</div>
		
	<%-- 	<div class="campo">
			<div class="label">
				<label>Asiento Ida</label>
			</div>
			<SELECT name="idAsientoIda-<%=i%>" value="<%=p!=null && p.getAsientoIda().getId()!=null ? p.getAsientoIda().getId() : "" %>">
				<%
					for (Asiento a :asientosIda) {
				%>
				<option value="<%=a.getId().toString()%>"><%=a.getNumero()%></option>				
					<%
						}
					%>
				
			</select>
		</div> 
		
	
		<div class="campo">
			<div class="label">
				<label>Asiento Vuelta</label>
			</div>
			<SELECT name="idAsientoVuelta-<%=i%>" value="<%=p!=null && p.getAsientoVuelta().getId()!=null ? p.getAsientoVuelta().getId() : "" %>">
				<%
					for (Asiento a : asientosVuelta) {
				%>
				<option value="<%=a.getId().toString()%>"><%=a.getNumero()%></option>
				<%
					}
				%>
			</select>
		</div>
	--%>	
		<div class="campo ultimo-campo">
			<div class="label">
				<label>Tipo de pasajero</label>
			</div>
			<SELECT name="tipo-<%=i%>" value="<%=p!=null ? p.getTipo().toString() : "ADULTO" %>">
				<option value="ADULTO">ADULTO</option>
				<option value="NINNO">NIÑO</option>
				<option value="JUBILADO">JUBILADO</option>
				<option value="ESTUDIANTE">ESTUDIANTE</option>
			</SELECT>
		</div>
	</div>

	<%
		}
	%>
	<div class="bt-submit">
		<INPUT type="submit" value="Continuar" class="bt-continuar" />
	</div>
</form>
