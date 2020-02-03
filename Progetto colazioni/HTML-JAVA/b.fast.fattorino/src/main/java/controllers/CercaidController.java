package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.CercaID;
import model.Bar;

@WebServlet("/mail")
public class CercaidController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CercaidController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		CercaID am = new CercaID();
		Bar b = am.cambio(request.getParameter("ID"));
		if (b == null) {
			request.getRequestDispatcher("/mail.html").forward(request, response);
		} else {
			String s = request.getParameter("ID");
			Integer id=Integer.parseInt(s);
			ses.setAttribute("ID",id);
			request.getRequestDispatcher("/password.html").forward(request, response);
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