package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.PasswordDimenticata;
import model.Utente;

@WebServlet("/PasswordDimenticataMail")
public class ControllerPasswordDimenticata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest req = null;
	HttpSession ses = req.getSession(true);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerPasswordDimenticata() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente u = new Utente();
		PasswordDimenticata au = new PasswordDimenticata();
		Utente b = au.cambio(u,request.getParameter("pass"),request.getParameter("copass"));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
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