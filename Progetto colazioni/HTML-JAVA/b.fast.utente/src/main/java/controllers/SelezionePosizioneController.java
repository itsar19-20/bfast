package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.ConfermaPosizione;
import business.Ordini;
import model.Indirizzo;
import utils.OrdineJson;

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
		String mail = request.getParameter("mail");
		ConfermaPosizione au = new ConfermaPosizione();
		Ordini or = new Ordini();
		Indirizzo b = null;
		b = au.Seleziona(mail,request.getParameter("x"), request.getParameter("y"));
		or.SetIndirizzo(b.getId(),request.getParameter("ordine"));
		OrdineJson o = new OrdineJson();
		o.setId(String.valueOf(b.getId()));
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(om.writeValueAsString(o));
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