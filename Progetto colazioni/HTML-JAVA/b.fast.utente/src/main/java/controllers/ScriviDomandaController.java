package controllers;

import java.io.*;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.ScriviDomanda;
import model.Domanda;

@WebServlet("/ScriviDomanda")
public class ScriviDomandaController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScriviDomandaController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String mail = (String) ses.getAttribute("mail");
		ScriviDomanda au = new ScriviDomanda();
		Domanda d = null;
		try {
			d = au.registrazione(request.getParameter("testo"), mail);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (d == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			ses.setAttribute("Domanda", d.getId());
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(d));		}
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