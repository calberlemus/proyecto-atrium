<%@page import="java.io.File"%>
<%@page import="app.modelo.Oferta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String of = (String)request.getAttribute("oferta");
		File fichero = new File(request.getRealPath("images/"+of).toString());		
	%>
	<%
		if (fichero.exists()){
	%>
	<img src="images/<%=of %>"></img>
	<%
		}else{
	%>
		NO existe el fichero en  <%=request.getRealPath("images/"+of).toString()%>
	<%
		}
	%>
</body>
</html>