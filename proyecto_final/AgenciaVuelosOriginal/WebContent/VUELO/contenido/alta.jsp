<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-alta-vuelo">
	<%
		List<Compannia> compannias = (List<Compannia>) request
				.getAttribute("compannias");
		List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
				.getAttribute("aeropuertos");
		Usuario user = (Usuario)session.getAttribute("user");
	%>

	<html:form action="alta-vuelo.do">
		<div class="dia-hora">
			<div class="dia">
				<div>Dia de salida</div>				
				<html:text property="diaSalida" size="10" 
					styleClass="campofecha" />
			</div>
			<div class="hora">					
				<div>Hora de salida</div>
				<html:text property="horaSalida" size="10" 
					styleClass="clockpick" />
			</div>		
		</div>		
		<div>Origen</div>
		<html:select property="idAeropuertoOrigen">
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<div class="dia-hora">
			<div class="dia">
				<div>Dia de llegada</div>
				<html:text property="diaLlegada" size="10"
					styleClass="campofecha" />
			</div>
			<div class="hora"> 		
				<div>Hora de llegada</div>
				<html:text property="horaLlegada" size="10" 
					styleClass="clockpick" />
			</div>			
		</div>	
		<div>Destino</div>		
		<html:select property="idAeropuertoDestino">
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<%
			if (user.getRol().toString().equals(Rol.SUPERADMINISTRADOR.toString())){
		%>
		
		<div>Compannia</div>		
		<html:select property="idCompannia">
			<%
				for (Compannia c : compannias) {
			%>
			<html:option value="<%=c.getId().toString()%>"><%=c.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<%
			}else{				
				AdminCompannia admin = (AdminCompannia)user;
		%>
		<html:hidden property="idCompannia" value="<%=admin.getCompannia().getId().toString() %>"/>
		<%
			}
		%>
		<div class="fieldset">
		    <div class="titulo">Precios</div>		
			<div class="label-inline">Oferta</div>
			<div class="precio"><html:text property="precioOferta" size="5" /><span>¤</span></div>
			<div class="label-inline">Turista</div>
			<div class="precio"><html:text property="precioTurista" size="5" /><span>¤</span></div>
			<div class="label-inline">Bussines</div>
			<div class="precio"><html:text property="precioBussines" size="5" /><span>¤</span></div>
		</div>
		<div class="fieldset">
			<div class="titulo">Nº de Asientos</div>	
			<div class="label-inline">Oferta</div>
			<html:text property="numAsientosOferta" styleClass="precio" size="5" />
			<div class="label-inline">Turista</div>
			<html:text property="numAsientosTurista" styleClass="precio" size="5" />
			<div class="label-inline">Bussines</div>
			<html:text property="numAsientosBussines" styleClass="precio" size="5" />
		</div>	
		<br>
		<html:submit value="Dar de alta" styleClass="bt-alta" />
	</html:form>
</div>


