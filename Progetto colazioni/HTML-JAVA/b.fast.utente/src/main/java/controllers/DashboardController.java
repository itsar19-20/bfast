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
import com.google.gson.Gson;

import business.Ordini;
import model.Ordine;
import utils.OrdineJson;

@WebServlet("/Inizio")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		Ordini au = new Ordini();
		List<Integer> b = au.creazione(request.getParameter("mail"));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			OrdineJson o = new OrdineJson();
			String id = String.valueOf(b.get(b.size()-1));
			o.setId(id);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(o));			
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