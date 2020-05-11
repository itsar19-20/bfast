package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.ControlloMail;
import model.Utente;

@WebServlet("/ConfermaMail")
public class ControllerControlloMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest req = null;
	HttpSession ses = req.getSession(true);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerControlloMail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		ControlloMail au = new ControlloMail();
		Utente b = au.cambio(request.getParameter("mail"));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			ses.setAttribute("ID",request.getParameter("mail"));
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(b));		}
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