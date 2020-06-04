package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.PopUpCarrello;
import utils.OrdineJson;

@WebServlet("/PopUpCarrello")
public class PopUpCarrelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PopUpCarrelloController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PopUpCarrello au = new PopUpCarrello();
		OrdineJson b = au.prodotti(request.getParameter("ordine"));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(b));		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}