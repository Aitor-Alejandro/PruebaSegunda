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
 * Servlet implementation class ServletBorrar
 * @author Aitor Alejandro Martinez Cedillo Viewnext
 * @version 1.0 19/12/2024
 */
public class ServletBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		
		Producto p = new Producto();
		p.setId(id);
		
		ServicioProducto sp = ServicioProducto.getInstance();
		if (sp.eliminar(p)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listado.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
	}

}
