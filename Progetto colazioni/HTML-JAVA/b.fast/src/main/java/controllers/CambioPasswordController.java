package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.CambioPassword;
import model.Bar;

@WebServlet("/GestioneUtente/pass")
public class CambioPasswordController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CambioPasswordController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		CambioPassword am = new CambioPassword();
		int s= (Integer) ses.getAttribute("ID");
		Bar b = am.cambio(s,request.getParameter("pass"), request.getParameter("copass"));
		if (b == null) {
			request.getRequestDispatcher("/passwordCambio.html").forward(request, response);
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