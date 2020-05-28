package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.SelezioneOrdine;
import model.Ordine;

@WebServlet("/Dashboard/conferma")
public class OrdineConfermato extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdineConfermato() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelezioneOrdine or = new SelezioneOrdine();
		Ordine o = or.confermato(request.getParameter("Ordine"));
		if(o!=null) {
	        PrintWriter writer = response.getWriter();
	        String htmlRespone = "<script> alert('Ordine confermato'); window.location = '../Dashboard/Ora'  </script> ";
	        writer.println(htmlRespone);
		}else {
			PrintWriter writer = response.getWriter();
	        String htmlRespone = "<script> alert('Qualcosa è andato storto'); window.location = '../Dashboard/Ora'  </script> ";
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