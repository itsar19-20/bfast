package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.TotaleOrdiniGiornalieri;

@WebServlet("/Dashboard/Giorno")
public class PaginaOrdiniGiornalieri extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaginaOrdiniGiornalieri() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		TotaleOrdiniGiornalieri am = new TotaleOrdiniGiornalieri();
		int s= (Integer) ses.getAttribute("ID");
		long t = am.Visualizza(s);
        PrintWriter writer = response.getWriter();
        String htmlRespone = "<script> alert("+t+"); window.location = '../Dashboard/index.html'  </script> ";
        writer.println(htmlRespone);
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
