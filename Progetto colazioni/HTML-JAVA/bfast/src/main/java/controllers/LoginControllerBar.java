package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.AutenticazioneBar;
import model.Bar;

@WebServlet("/Login/login")
public class LoginControllerBar extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		AutenticazioneBar am = new AutenticazioneBar();
		Bar b = am.login(request.getParameter("ID"), request.getParameter("password"));
		if (b == null) {
			request.getRequestDispatcher("../Login/index.html").forward(request, response);
		} else {
			String id2 = request.getParameter("ID");
			Integer id = Integer.parseInt(id2);
			ses.setAttribute("ID",id);
	        PrintWriter writer = response.getWriter();
	        String htmlRespone = "<script> alert(\"Benvenuto:"+b.getNome()+"\"); window.location = '../Dashboard/index.html'  </script> ";
	        writer.println(htmlRespone);
		}
	}
}
