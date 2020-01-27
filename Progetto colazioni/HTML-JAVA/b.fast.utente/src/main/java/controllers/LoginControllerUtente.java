package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.AutenticazioneUtente;
import model.Utente;

@WebServlet("/login")
public class LoginControllerUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest req = null;
	HttpSession ses = req.getSession(true);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControllerUtente() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AutenticazioneUtente au = new AutenticazioneUtente();
		Utente b = au.login(request.getParameter("mail"), request.getParameter("password"));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			String id = request.getParameter("ID");
			req.setAttribute("ID",id);
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