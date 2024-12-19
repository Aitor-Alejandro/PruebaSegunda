package com.curso.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerFront
 * @author Aitor Alejandro Martinez Cedillo Viewnext
 * @version 1.0 19/12/2024
 */
public class ControllerFront extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");

		String urlVista = "/";

		switch (option) {
		case "alta":
			urlVista = "alta.html";
			break;
		case "baja":
			urlVista = "baja.jsp";
			break;
		case "edit":
			urlVista = "edit.jsp";
			break;
		case "list":
			urlVista = "listado.jsp";
			break;
		case "buscar":
			urlVista = "ServletBusqueda";
			break;

		}

		RequestDispatcher despachador = request.getRequestDispatcher(urlVista);

		despachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
