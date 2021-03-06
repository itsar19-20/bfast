package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.CancellazioneFattorino;
import model.Fattorino;

@WebServlet("/cancellazioneFattorino")
public class CancellazioneFattorinoController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancellazioneFattorinoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		CancellazioneFattorino am = new CancellazioneFattorino();
		int s= (Integer) ses.getAttribute("ID");
		Fattorino b = am.canc(s);
		if (b == null) {
			request.getRequestDispatcher("/mailCambio.html").forward(request, response);
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