<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@page import="app.modelo.Aeropuerto"%>
<%@page import="java.util.List"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
			.getAttribute("aeropuertos");
%>

<div class="titulo-bloque titulo-buscador">Titulo buscador</div>
<div class="form-buscador">
	<html:form action="busca-vuelos.do">
		<span>Ida y vuelta</span><html:radio property="idavuelta" value="1" styleClass="radio-ida" onclick="mostrar();" styleId="idavuelta"/>
		<span>Sólo ida</span><html:radio property="idavuelta" value="2" onclick="ocultar();"  />
		<br>		
		<html:select property="idAeropuertoOrigen" >
			<html:option value="0">Origen</html:option>
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>		
		<html:select property="idAeropuertoDestino">
			<html:option value="0">Destino</html:option>
			<%
				for (Aeropuerto a : aeropuertos) {
			%>
			<html:option value="<%=a.getId().toString()%>"><%=a.getCodigo() + " " + a.getCiudad() + " "
									+ a.getNombre()%></html:option>
			<%
				}
			%>
		</html:select>
		<div id="ida">
			<label><b>Ida: </b></label>
			<html:text property="fechaHoraSalida"
				styleClass="campofecha" />
		</div>	
		<div id="vuelta">
			<label><b>Vuelta: </b></label>	
			<html:text property="fechaHoraLlegada" 
				styleClass="campofecha"/>
		</div>		
		<html:select property="npasajeros">
				<html:option value="0">Pasajeros</html:option>
			<%
				for(int i=1; i<10; i++){ 
			%>
				<html:option value="<%=Integer.toString(i)%>"><%=i%></html:option>
			<%
				}
			%>
		</html:select>
		<html:select property="clase">
			<html:option value="">Clase</html:option>
			<html:option value="TURISMO">TURISMO</html:option>
			<html:option value="BUSSINES">BUSSINES</html:option>
			<html:option value="OFERTA">OFERTA</html:option>
		</html:select>
		<html:submit value="Buscar Vuelo" styleClass="bt-buscar"/>
	</html:form>	
</div>