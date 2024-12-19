package com.curso.servlet;

import java.io.IOException;

import com.curso.model.Producto;
import com.curso.service.ServicioProducto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAlta
 * @author Aitor Alejandro Martinez Cedillo Viewnext
 * @version 1.0 19/12/2024
 */
public class ServletAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id= Long.parseLong(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock=Integer.parseInt(request.getParameter("stock"));
		
		Producto p = new Producto(id, nombre, categoria, precio, stock);
		
		ServicioProducto sp = ServicioProducto.getInstance();
		if(sp.add(p)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listado.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("fallo.html");
			dispatcher.forward(request, response);
		}
	}

}
