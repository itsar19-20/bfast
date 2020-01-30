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


@WebServlet("/ok")
public class DashboardProva extends HttpServlet{
	private static final long serialVersionUID = 1345324523L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardProva() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession ses = request.getSession();
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