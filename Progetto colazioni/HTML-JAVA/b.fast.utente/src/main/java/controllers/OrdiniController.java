package controllers;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.Ordini;
import model.Ordine;
import utils.OrdineJson;

@WebServlet("/Carrello")
public class OrdiniController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdiniController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession ses = request.getSession();
		int id = Integer.parseInt(request.getParameter("ordine"));
		Ordini au = new Ordini();
		Ordine b = null;
		b = au.carrello(id,request.getParameter("orario"), request.getParameter("note"),request.getParameter("pagamento"));
		if (b == null) {
			request.getRequestDispatcher("/prodotto.html").forward(request, response);
		} else {
			OrdineJson o = new OrdineJson();
			o.setId(String.valueOf(id));
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(o));			}
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