package controllers;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.Prodotti;
import model.Contiene;
import utils.OrdineJson;

@WebServlet("/SelezionaProdotto")
public class SelezioneProdotti extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelezioneProdotti() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		int ido = Integer.parseInt(request.getParameter("ordine"));
		Prodotti pr = new Prodotti();
		Contiene c = pr.selezione(ido, request.getParameter("Nome"), request.getParameter("Quantita"));
		if(c==null) {
			request.getRequestDispatcher("/").forward(request, response);
		}else {
			OrdineJson o = new OrdineJson();
			o.setId(request.getParameter("ordine"));
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(c));
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