<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="app.modelo.Aeropuerto"%>
<%@page import="java.util.List"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Aeropuerto> aeropuertos = (List<Aeropuerto>) request
			.getAttribute("aeropuertos");
    Long destino = (Long)request.getAttribute("destino");
    Long origen = (Long)request.getAttribute("origen");
    String ida = (String)request.getAttribute("ida");
    String vuelta = (String)request.getAttribute("vuelta");
    Integer np = (Integer)request.getAttribute("np");
    String clase = (String)request.getAttribute("clase");
    
%>

<div class="titulo-bloque titulo-buscador">Titulo buscador</div>
<div class="form-buscador">
	<html:form action="busca-vuelos-interior.do">
	    <div class="label">	    
			<label>Origen</label>
		</div>	
		<html:select property="idAeropuertoOrigen" value='<%=origen!=null ? origen.toString() : ""%>' >
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
		<div class="label lb-destino">	    
			<label>Destino</label>
		</div>
		<html:select property="idAeropuertoDestino" value='<%=destino!=null ? destino.toString() : ""%>'>
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
		<br>
		<div id="ida-interior">
			<div class="label">	    
				<label>Ida</label>
			</div>
			<html:text property="fechaHoraSalida" size="20" styleClass="campofecha" value='<%=ida!=null ? ida : "Ida"%>' />
		</div>		
		<div class="radio-ida-vuelta">				    
			<label>Ida y vuelta</label>		
			<html:radio property="idavuelta" value="1" styleClass="radio-ida" onclick="mostrar();" styleId="idavuelta"/>
			<br>			
			<label class="lb-solo-ida">Sólo ida</label><html:radio property="idavuelta" value="2" onclick="ocultar();"  />
		</div>						
		<div id="vuelta">
			<div class="label">	    
				<label>Vuelta</label>
		</div>
		<html:text property="fechaHoraLlegada" size="20"
			styleClass="campofecha" title="Vuelta" value='<%=vuelta!=null ? vuelta : "Vuelta"%>'/>
		</div>
		<br>
		<div class="label">	    
			<label>Pasajeros</label>
		</div>		
		<html:select property="npasajeros" value='<%=np!=null ? np.toString() : "" %>'>
				<html:option value="0">Pasajeros</html:option>
			<%
				for(int i=1; i<10; i++){ 
			%>
				<html:option value="<%=Integer.toString(i)%>"><%=i%></html:option>
			<%
				}
			%>
		</html:select>
		<div class="label lb-clase">	    
			<label>Clase</label>
		</div>
		<html:select property="clase" title="Clase" styleClass="sl-clase" value='<%=clase!=null ? clase : "" %>'>
			<html:option value="">Clase</html:option>
			<html:option value="TURISMO">TURISMO</html:option>
			<html:option value="BUSSINES">BUSSINES</html:option>
			<html:option value="OFERTA">OFERTA</html:option>
		</html:select>
		<div class="bt">
			<html:submit value="Buscar Vuelo" styleClass="bt-buscar"/>
		</div>	
	</html:form>
</div>