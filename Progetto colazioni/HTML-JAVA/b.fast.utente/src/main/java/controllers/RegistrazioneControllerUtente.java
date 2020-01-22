package controllers;

import java.io.*;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.RegistrazioneUtente;
import model.Utente;
import business.CambioPassword;
import business.Ordini;

@WebServlet("/registrazione")
public class RegistrazioneControllerUtente extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneControllerUtente() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RegistrazioneUtente au = new RegistrazioneUtente();
		Utente b = null;
		try {
			b = au.registrazione(request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("nascita"),request.getParameter("telefono"),request.getParameter("mail"),request.getParameter("pass"), request.getParameter("copass"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == null) {
			request.getRequestDispatcher("/registrazione.html").forward(request, response);
		} else {
			CambioPassword cp = new CambioPassword();
			cp.utente(request.getParameter("mail"));
			Ordini o = new Ordini();
			o.utente(request.getParameter("mail"));
			request.getRequestDispatcher("/ok.html").forward(request, response);
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
