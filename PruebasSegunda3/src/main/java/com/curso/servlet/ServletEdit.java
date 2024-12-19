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
 * Servlet implementation class ServletEdit
 * 
 * @author Aitor Alejandro Martinez Cedillo Viewnext
 * @version 1.0 19/12/2024
 */
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		//System.out.println(request.getAttribute("id_obj"));
		long id = Long.parseLong(request.getParameter("id_obj"));
		Producto p = new Producto();
		p.setId(id);

		ServicioProducto sp = ServicioProducto.getInstance();
		
		String nombre = request.getParameter("nombre");
		
		String categoria = request.getParameter("categoria");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		if (sp.change(p, new Producto(id, nombre, categoria,precio, stock))) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listado.jsp");
			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
		
	}

}
