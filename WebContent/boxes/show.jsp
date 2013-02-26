<%@page import="es.experiences.model.Box"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caja XXX</title>
</head>
<body>
<%

	Box box = (Box) request.getAttribute("box");

%>
<form action="/experiences-jee/boxes" method="POST">
	<table>
		<tbody>
			<tr>
				<th>Nombre</th>
				<td><input type="text" name="name" value="<%= box.getName() %>" /></td>
			</tr>
			<tr>
				<th>Titulo</th>
				<td><input type="text" name="title" value="<%= box.getTitle() %>" /></td>
			</tr>
			<tr>
				<th>Estado</th>
				<% if(box.isActivated()) { %>
				<td><input type="checkbox" name="activated" value="true" checked="checked"/></td>
				<% } else { %>
				<td><input type="checkbox" name="activated" value="false" /></td>
				<% } %>				
			</tr>
		</tbody>
	</table>
	<% if (box.getId() == null) { %>
		<button>Guardar</button>
	<% } else { %>
		<input type="hidden" name="id" value="<%= box.getId() %>" />
		<button name="_action" value="update">Actualizar</button>
		<button name="_action" value="delete">Borrar</button>
	<% } %>
	
</form>
</body>
</html>