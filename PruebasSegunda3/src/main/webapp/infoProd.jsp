<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.model.Producto" %>
<div>
	<%Producto p = (Producto) request.getAttribute("prod");%>
	
	<h5><%=p.getNombre()%></h5>
	<table>
	<tr>
	<td><%=p.getCategoria()%></td>
	<td><%=p.getPrecio()%>€</td>
	<td><%=p.getStock() %></td>
	</tr>
	</table>
</div>