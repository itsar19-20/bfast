package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.PopupBar;
import model.Bar;
import utils.BarJson;

@WebServlet("/PopupBar")
public class PopupBarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PopupBarController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PopupBar au = new PopupBar();
		List<Bar> b = au.sel(Integer.parseInt(request.getParameter("indirizzo")));
		if (b == null) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			BarJson bj = new BarJson();
			bj.setId(b.get(0).getId());
			bj.setNome(b.get(0).getNome());
			bj.setVal(b.get(0).getValutazione());
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(bj));		}
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