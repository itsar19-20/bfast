package controllers;

import java.io.*;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bar;
import business.RegistrazioneBar;


@WebServlet("/registrazione")
public class RegistrazioneControllerUtente extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/*HttpServletRequest req = null;
	HttpSession ses = req.getSession(true);*/
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
		RegistrazioneBar au = new RegistrazioneBar();
		Bar b = null;
		try {
			b = au.registrazione(request.getParameter("nome"), request.getParameter("indirizzo"), request.getParameter("OrarioApe"),request.getParameter("OrarioChi"),request.getParameter("mail"),request.getParameter("pass"), request.getParameter("copass"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == null) {
			request.getRequestDispatcher("/registrazione.html").forward(request, response);
		} else {
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