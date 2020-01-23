package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.AutenticazioneBar;
import model.Bar;

@WebServlet("/login")
public class LoginControllerBar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpServletRequest req = null;
	HttpSession ses = req.getSession(true);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControllerBar() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AutenticazioneBar am = new AutenticazioneBar();
		Bar b = am.login(request.getParameter("ID"), request.getParameter("password"));
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
