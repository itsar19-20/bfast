package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.Ordini;
import model.Ordine;


@WebServlet("/SelezionaBar")
public class SelezioneBar extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelezioneBar() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession ses = request.getSession();
			int ido = (Integer) ses.getAttribute("ido");
			int idbar = Integer.parseInt(request.getParameter("bar"));
			Ordini o = new Ordini();
			Ordine or = o.bar(ido, idbar);
			if(or==null) {
				
			}else {
				ses.setAttribute("IDb", request.getAttribute("ID"));
				ObjectMapper om = new ObjectMapper();
				response.setContentType("application/json");
				response.getWriter().append(om.writeValueAsString(or));				}

	
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