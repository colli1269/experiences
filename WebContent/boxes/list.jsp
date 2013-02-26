<%@page import="java.util.List"%>
<%@page import="es.experiences.model.Box"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listado de cajas</title>
</head>
<body>
	<h1>Listado de cajas</h1>
	
	<% if(request.getAttribute("error") != null) { %>
		<span style="color:red"><%= request.getAttribute("error") %></span>
	<% } %>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Titulo</th>
				<th>Estado</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for(Box box : (List<Box>) request.getAttribute("boxes")) { %>
			<tr>
				<td><%= box.getId() %></td>
				<td><%= box.getName() %></td>
				<td><%= box.getTitle() %></td>
				<td><%= box.isActivated() %></td>
				<td>
					<a href="/experiences-jee/boxes?id=<%=box.getId()%>">Ver</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>