<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@page import="app.util.Fecha"%>
<%@page import="app.modelo.*"%>
<%@page import="java.util.List"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-editar-vuelo">
	<%
		List<Compannia> compannias = (List<Compannia>) request
				.getAttribute("compannias");
		List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
				.getAttribute("aeropuertos");
		Vuelo vuelo = (Vuelo) request.getAttribute("vuelo");
		Usuario user = (Usuario)session.getAttribute("user");
	%>

	<html:form action="editar-vuelo.do">
		<div class="dia-hora">
			<div class="dia">
				<div>Dia de salida</div>				
				<html:text property="diaSalida" size="10" value='<%=vuelo!=null ? Fecha.convertirDDMMYYY(vuelo.getDiaSalida()) : ""%>'
			styleClass="campofecha" />
			</div>
			<div class="hora">					
				<div>Hora de salida</div>
				<html:text property="horaSalida" size="10" value='<%=vuelo!=null ? Fecha.convertirHHMM(vuelo.getHoraSalida()) : ""%>'
					styleClass="clockpick" />
			</div>		
		</div>		
		<div>Origen</div>
		<html:select property="idAeropuertoOrigen" value='<%=vuelo!=null ? vuelo.getOrigen().getId().toString() :"" %>'>
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad()
										+ " " + a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<div class="dia-hora">
			<div class="dia">
				<div>Dia de llegada</div>
				<html:text property="diaLlegada" size="10" value='<%=vuelo!=null ? Fecha.convertirDDMMYYY(vuelo.getDiaLlegada()) : ""%>'
					styleClass="campofecha" />
			</div>
			<div class="hora"> 		
				<div>Hora de llegada</div>
				<html:text property="horaLlegada" size="10" value='<%=vuelo!=null ? Fecha.convertirHHMM(vuelo.getHoraLlegada()) : ""%>' 
					styleClass="clockpick" />
			</div>			
		</div>		
		<div>Destino</div>
		<html:select property="idAeropuertoDestino" value='<%=vuelo!=null ? vuelo.getDestino().getId().toString() : ""%>'>
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad()
										+ " " + a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<%
			if (user.getRol().toString().equals(Rol.SUPERADMINISTRADOR.toString())){
		%>		
			<div>Compannia</div>
			<html:select property="idCompannia" value='<%=vuelo!=null ? vuelo.getCompannia().getId().toString() : ""%>'>
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
		<div>Precio oferta</div>
		<html:text property="precioOferta" styleClass="precio" size="5" value='<%=vuelo!=null ? Double.toString(vuelo.getPrecioOferta()) : ""%>'/><span>¤</span>		
		<div>Precio turista</div>
		<html:text property="precioTurista" styleClass="precio" size="5" value='<%=vuelo!=null ? Double.toString(vuelo.getPrecioTurista()) : ""%>'/><span>¤</span>
		<div>Precio bussines</div>
		<html:text property="precioBussines" styleClass="precio" size="5" value='<%=vuelo!=null ? Double.toString(vuelo.getPrecioBussines()) : ""%>' /><span>¤</span>
		<html:hidden property="id" value='<%=vuelo!=null ? vuelo.getId().toString() : ""%>' />
		<div>Nº de asientos oferta</div>
		<html:text property="numAsientosOferta" styleClass="precio" size="5" value='<%=vuelo!=null ? Integer.toString(vuelo.getNumAsientosOferta()) : ""%>'/>
		<div>Nº de asientos turista</div>
		<html:text property="numAsientosTurista" styleClass="precio" size="5" value='<%=vuelo!=null ? Integer.toString(vuelo.getNumAsientosTurista()) : ""%>' />
		<div>Nº de asientos bussines</div>
		<html:text property="numAsientosBussines" styleClass="precio" size="5" value='<%=vuelo!=null ? Integer.toString(vuelo.getNumAsientosBussines()) : ""%>'/>
		<br>
		<html:submit value="Guardar" styleClass="bt-guardar" />
	</html:form>

</div>
