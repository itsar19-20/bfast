package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.GestioneMenu;
import model.Menu;

@WebServlet("/Dashboard/Aggiungi")
public class AggiungiProdottoController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiProdottoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		int s= (Integer) ses.getAttribute("ID");
		GestioneMenu or = new GestioneMenu();
		String result = request.getParameter("nome");
		Menu o = or.Aggiungi(result,s);
		if(o!=null) {
	        PrintWriter writer = response.getWriter();
	        String htmlRespone = "<script> alert('Prodotto aggiunto nel menu'); window.location = '../Dashboard/VisualizzazioneProdotti'  </script> ";
	        writer.println(htmlRespone);
		}else {
			PrintWriter writer = response.getWriter();
	        String htmlRespone = "<script> alert('Qualcosa è andato storto'); window.location = '../Dashboard/VisualizzazioneProdotti'  </script> ";
	        writer.println(htmlRespone);
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