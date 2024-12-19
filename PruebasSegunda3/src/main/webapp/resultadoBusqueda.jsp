<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>

<%@ page import="com.curso.model.Producto" %>
<%@ page import="com.curso.service.ServicioProducto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado Busqueda</title>
</head>
<body>
<h1>Productos encontrados</h1>

<%
Object busq = request.getAttribute("busqueda");
ServicioProducto sp = ServicioProducto.getInstance();
Set<Producto> setProd = sp.buscarProductos(busq.toString());
if (!setProd.isEmpty()){%>
<ul>
<%for (Producto prod : setProd){%>
<%request.setAttribute("prod", prod);%>
<li>
<%@include file="infoProd.jsp" %>
</li>
</ul>
<%}%>
<%}else{%>
<h1>El elemento buscado no existe</h1>
<%}%>
<a href="index.html"><input type="submit" value="Volver a inicio"></a>
</body>
</html>