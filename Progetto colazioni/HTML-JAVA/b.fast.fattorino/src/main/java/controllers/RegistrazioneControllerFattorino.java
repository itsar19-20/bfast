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

import business.RegistrazioneFattorino;
import model.Fattorino;

@WebServlet("/registrazione")
public class RegistrazioneControllerFattorino extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneControllerFattorino() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RegistrazioneFattorino au = new RegistrazioneFattorino();
		Fattorino b = null;
		try {
			b = au.registrazione(request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("nascita"),request.getParameter("mail"),request.getParameter("pass"), request.getParameter("copass"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
