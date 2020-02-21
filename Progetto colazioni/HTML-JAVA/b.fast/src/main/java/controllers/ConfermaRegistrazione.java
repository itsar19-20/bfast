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


@WebServlet("/GestioneIndirizzoOrario/ConfermaRegistrazione")
public class ConfermaRegistrazione extends HttpServlet{
	private static final long serialVersionUID = 102831973239L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfermaRegistrazione() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		RegistrazioneBar au = new RegistrazioneBar();
		String s = (String) ses.getAttribute("ID"); 
		Bar b = null;
		b = au.Conregistrazione(s,request.getParameter("orarioap"),request.getParameter("orarioch"),request.getParameter("via"),request.getParameter("civico"), request.getParameter("citta"), request.getParameter("cap"));
		if (b == null) {
			request.getRequestDispatcher("../Registrazione/index.html").forward(request, response);
		} else {
			int id = b.getId();
			ses.setAttribute("ID",id);
			request.getRequestDispatcher("/ok.html").forward(request, response);
		}
	}
}