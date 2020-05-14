package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.ConfermaPosizione;
import model.Sceglie;

@WebServlet("/SelezionePosizione")
public class SelezionePosizioneController extends HttpServlet{
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String mail = (String) ses.getAttribute("ID");
		ConfermaPosizione au = new ConfermaPosizione();
		Sceglie b = null;
		b = au.Seleziona(mail,request.getParameter("x"), request.getParameter("y"));
		if (b == null) {
			request.getRequestDispatcher("/prodotto.html").forward(request, response);
		} else {
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(b));			}
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