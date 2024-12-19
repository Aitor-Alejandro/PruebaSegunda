<%@page import="com.curso.service.ServicioProducto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.curso.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicion</title>
</head>
<body>
<%
ServicioProducto sp = ServicioProducto.getInstance();

Producto aux = new Producto();
aux.setId(Integer.parseInt(request.getParameter("id")));
Producto p = sp.find(aux);
request.setAttribute("id_obj", p); %>

<form action="ServletEdit" method="post">
		<input type="hidden" name="id_obj" value="<%=p.getId()%>">
		Nombre: <input type="text" name="nombre" value="<%=p.getNombre()%>">
		Categoria: <input type="text" name="categoria" value="<%=p.getCategoria()%>">
		Precio: <input type="number" name="precio" value="<%=p.getPrecio()%>">
		Stock: <input type="number" name="stock" value="<%=p.getStock()%>">
		<input type="submit" value="Cambiar">
</form>
</body>
</html>