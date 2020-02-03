package controllers;

import java.io.*;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Ordini;
import business.Prodotti;
import model.Contiene;
import model.Ordine;

@WebServlet("/prodotto")
public class SelezioneProdotti extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelezioneProdotti() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession ses = request.getSession();
		int id =(Integer) ses.getAttribute("IDo");
		Prodotti au = new Prodotti();
		Contiene b = null;
		try {
			b = au.selezione(id,request.getParameter("prodotto"), request.getParameter("quantita"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == null) {
			request.getRequestDispatcher("/prodotto.html").forward(request, response);
		} else {
			Ordini o = new Ordini();
			int IDo = (Integer)ses.getAttribute("IDo");
			int IDb = (Integer)ses.getAttribute("IDb");
			Ordine or = o.bar(IDo,IDb);
			if(or==null) {
				request.getRequestDispatcher("/prodotto.html").forward(request, response);
			}else {
				request.getRequestDispatcher("/ok.html").forward(request, response);
			}
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