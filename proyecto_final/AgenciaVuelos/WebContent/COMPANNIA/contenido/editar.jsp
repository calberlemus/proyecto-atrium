<%@page import="app.modelo.Compannia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-editar-compannia">
<%
	Compannia compannia = (Compannia) request
			.getAttribute("compannia");
	//if (compannia == null) {
%>
<html:form action="editar-compannia.do">
	<div>Código</div>
	<html:hidden property="id" value = '<%=compannia!=null ? compannia.getId().toString() : "" %>' />
	<html:text property="codigo" styleClass="codigo" size="2" value = '<%=compannia!=null ? compannia.getCodigo() : "" %>'/>
	<div class="ayuda">Dos dígitos alfanuméricos</div>
	<div>Nombre</div>
	<html:text property="nombre" size="30" value = '<%=compannia!=null ? compannia.getNombre() : "" %>' />
	<div>País</div>
	<html:text property="pais" size="30"  value = '<%=compannia!=null ? compannia.getPais() : "" %>'/>
	<br>	
	<html:submit value="Guardar" styleClass="bt-guardar"/>
</html:form>
<%-- 
<%
	} else 
%>
<html:form action="editar-compannia.do">
	<div>Código</div>
	<html:hidden property="id" value="<%=compannia.getId().toString()%>" />
	<html:text property="codigo" size="50"
		value="<%=compannia.getCodigo()%>" />
	<div>Nombre</div>
	<html:text property="nombre" size="50"
		value="<%=compannia.getNombre()%>" />
	<div>País</div>
	<html:text property="pais" size="50" value="<%=compannia.getPais()%>" />
	<br>		
	<html:submit value="Guardar" styleClass="bt-guardar" />
</html:form>
<%
	}
%>
--%>
</div>
