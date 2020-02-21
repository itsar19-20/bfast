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


@WebServlet("/Registrazione/registrazione")
public class RegistrazioneControllerBar extends HttpServlet{
	private static final long serialVersionUID = 102831973239L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneControllerBar() {
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
		Bar b = null;
		try {
			b = au.registrazione(request.getParameter("nome"),request.getParameter("mail"),request.getParameter("pass"), request.getParameter("copass"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == null) {
			request.getRequestDispatcher("../Registrazione/index.html").forward(request, response);
		} else {
			int id = b.getId();
			ses.setAttribute("ID",id);
			request.getRequestDispatcher("../GestioneIndirizzoOrario/index.html").forward(request, response);
		}
	}
}