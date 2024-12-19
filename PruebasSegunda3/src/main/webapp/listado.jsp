<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>

<%@ page import="com.curso.model.Producto" %>
<%@ page import="com.curso.service.ServicioProducto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
<style>
	.submit-edit-button{
	position:relative;
	background-color: #007BFF;
	color: white;
	border:none;
	padding:10px 20px;
	cursor:pointer;
	font-size:16px;
	}
	.submit-eliminar-button{
	position:relative;
	background-color: #007BFF;
	color: white;
	border:none;
	padding:10px 20px;
	cursor:pointer;
	font-size:16px;
	}
	.submit-edit-button::after{
		content:"Editar";
		position:absolute;
		top:0;
		left:0;
		width:100%;
		height:100%;
		display:flex;
		justify-content:center;
		align-items:center;
		color:white;
	}
	.submit-eliminar-button::after{
		content:"Elimininar";
		position:absolute;
		top:0;
		left:0;
		width:100%;
		height:100%;
		display:flex;
		justify-content:center;
		align-items:center;
		color:white;
	.custom-submit[value]{
		color:transparent;
	}
	}
</style>
</head>
<body>
<h1>Lista de Productos</h1>
<ul>
<%
ServicioProducto sp = ServicioProducto.getInstance();

Set<Producto> setProd = sp.getProductos();
for (Producto it : setProd){%>
<%request.setAttribute("prod", it);%>
<li>
<%@include file="infoProd.jsp" %>
<form action="editProd.jsp" method="get">
	<input type="submit" name="id" value="<%=it.getId()%>" class="submit-edit-button" >
</form>
<form action="ServletBorrar" method="get">
	<input type="submit" name="id" value="<%=it.getId()%>" class="submit-eliminar-button">
</form>
</li>
<%}%>
</ul>
</body>
</html>