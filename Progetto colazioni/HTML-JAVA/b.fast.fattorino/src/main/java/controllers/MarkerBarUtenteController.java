package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.MarkerBarUtente;
import business.OrdiniDaFare;
import model.Indirizzo;
import utils.OrdineJSON;

@WebServlet("/MarkerBarUtente")
public class MarkerBarUtenteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarkerBarUtenteController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int idbar = Integer.valueOf(request.getParameter("bar"));
		int idord = Integer.valueOf(request.getParameter("ordine"));
		MarkerBarUtente au = new MarkerBarUtente();
		List<Indirizzo> b = au.marker(idbar, idord);
		if (b == null) {
			request.getRequestDispatcher("/registrazione.html").forward(request, response);
		} else {
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(b));
		}
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