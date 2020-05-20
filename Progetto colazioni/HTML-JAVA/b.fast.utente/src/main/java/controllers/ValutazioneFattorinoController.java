package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.ValutazioneFattorino;
import model.Ordine;
import utils.OrdineJson;

@WebServlet("/ValutazioneFattorino")
public class ValutazioneFattorinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValutazioneFattorinoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ValutazioneFattorino au = new ValutazioneFattorino();
		Ordine b = au.cerca(request.getParameter("ordine"), request.getParameter("valutazione"));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			OrdineJson o = new OrdineJson();
			o.setId(request.getParameter("ordine"));
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(o));		}
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