package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.RimuoviProdotto;
import model.Contiene;
import utils.OrdineJson;


@WebServlet("/RimuoviCarrello")
public class RimuoviCarrelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RimuoviCarrelloController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RimuoviProdotto c = new RimuoviProdotto();
			Contiene or = c.rimuovi(request.getParameter("ordine"), request.getParameter("nome"));
			if(or!=null) {
				OrdineJson oj = new OrdineJson();
				oj.setId(String.valueOf(or.getQuantita()));
				ObjectMapper om = new ObjectMapper();
				response.setContentType("application/json");
				response.getWriter().append(om.writeValueAsString(oj));		
			}
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(or));	

	
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