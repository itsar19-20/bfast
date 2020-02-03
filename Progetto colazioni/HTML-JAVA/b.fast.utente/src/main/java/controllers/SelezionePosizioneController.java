package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.SelezionePosizione;


@WebServlet("/CambioMail")
public class SelezionePosizioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelezionePosizioneController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession ses = request.getSession();
			SelezionePosizione sp = new SelezionePosizione();
			int i = sp.Visualizza(request.getParameter("via"), request.getParameter("civico"), request.getParameter("cap"), request.getParameter("citta"));
			if(i==0) {
				request.getRequestDispatcher("/").forward(request, response);
			}else {
				ses.setAttribute("IDi", i);
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