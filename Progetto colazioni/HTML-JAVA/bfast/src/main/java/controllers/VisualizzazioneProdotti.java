package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.TuttiProdotti;
import model.Prodotto;

@WebServlet("/Dashboard/VisualizzazioneProdotti")
public class VisualizzazioneProdotti extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizzazioneProdotti() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		TuttiProdotti am = new TuttiProdotti();
		int s= (Integer) ses.getAttribute("ID");
		List<Prodotto> pro = am.Nonpresenti(s);
		List<Prodotto> prop = am.Presenti(s);
        String htmlRespone = "";
        PrintWriter writer = response.getWriter();
        htmlRespone += "<!doctype html>\r\n" + 
        		"<html lang=\"it-it\" >\r\n" + 
        		"\r\n" + 
        		"<head>\r\n" + 
        		"    <title>Bfast</title>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"    <!-- Serve per ottimizzare prima i dispositi mobili e poi in base alla necessità utilizzando \r\n" + 
        		"                le query multimediali CSS. \r\n" + 
        		"                Per garantire il rendering corretto e lo zoom tattile per tutti i dispositivi  -->\r\n" + 
        		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
        		"\r\n" + 
        		"    <!-- Bootstrap CSS -->\r\n" + 
        		"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
        		"\r\n" + 
        		"    <!-- Collegamento con Style.css -->\r\n" + 
        		"    <link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\">\r\n" + 
        		"\r\n" + 
        		"</head>\r\n" + 
        		"\r\n" + 
        		"<body>\r\n" + 
        		"\r\n" + 
        		"    <!--Navigation-->\r\n" + 
        		"	<div id=\"content\">\r\n" + 
        		"            <nav class=\"navbar navbar-expand-lg navbar-light\">\r\n" + 
        		"                <div class=\"d-inline-flex justify-content-between w-100 align-items-center\">\r\n" + 
        		"				<div>\r\n" + 
        		"                    <button type=\"button\" id=\"sidebarCollapse\" class=\"btn\">\r\n" + 
        		"                        <img src=\"../img/logo4.png\" class=\"img-fluid\">\r\n" + 
        		"                    </button>\r\n" + 
        		"				</div>					\r\n"+
        		"					<div>\r\n" + 
        		"						<ul class=\"nav navbar-nav ml-auto\">\r\n" + 
        		"							<li class=\"nav-item text-white\">\r\n" + 
        		"								<a class=\"nav-link text-dark\" href=\"../Dashboard/index.html\">Home</a>\r\n" + 
        		"							</li>\r\n" + 
        		"					</div>	\r\n"+ 
        		"				</div>\r\n" + 
        		"            </nav>";
        if(pro == null) {
        	htmlRespone +="<p class=\"h1 text-center text-white\"> Nessun prodotto da aggiungere";
        }else {
            for(int a =0;a<pro.size();a++) {
            	htmlRespone += "                <div class=\"login mt-50 p-auto\">\r\n" + 
                		"                    <div class=\"login-screen2\">\r\n" + 
                		"                            <div class=\"app-title\">\r\n" + 
                		"                                <h1>Nome:"+pro.get(a).getNome() +"</h1>\r\n" + 
                		"                            </div>\r\n" + 
                		" <p> Prezzo: "+pro.get(a).getPrezzo()+" &euro; Ingredienti: "+pro.get(a).getIngredienti()+
                		"                            <div class=\"login-form d-flex justify-content-center\">\r\n" + 
                        "<form action=\"Aggiungi\" method=\"POST\">"+
                        "<input type=\"hidden\" name=\"nome\" value= \""+pro.get(a).getNome()+"\" />"+
                		"                                <input type=\"submit\" value=\"Mettilo nel menu\" class=\"btn btn-primary btn-large btn-block bg-success text-white\"> </form>\r\n" +  
                		"                            </div>\r\n" + 
                		"\r\n" + 
                		"                    </div>\r\n" + 
                		"                </div></br>";      
            }
        }

        if(prop != null) {
            for(int a =0;a<prop.size();a++) {
            	htmlRespone += "                <div class=\"login mt-50 p-auto\">\r\n" + 
                		"                    <div class=\"login-screen2\">\r\n" + 
                		"                            <div class=\"app-title\">\r\n" + 
                		"                                <h1>Nome:"+prop.get(a).getNome() +"</h1>\r\n" + 
                		"                            </div>\r\n" + 
                		" <p> Prezzo: "+prop.get(a).getPrezzo()+" &euro; Ingredienti: "+prop.get(a).getIngredienti()+
                		"                            <div class=\"login-form d-flex justify-content-center\">\r\n" + 
                        "<form action=\"Rimuovi\" method=\"POST\">"+
                        "<input type=\"hidden\" name=\"nome\" value= \""+prop.get(a).getNome()+"\" />"+
                		"                                <input type=\"submit\" value=\"Toglilo dal menu\" class=\"btn btn-primary btn-large btn-block bg-danger text-white\"> </form>\r\n" +  
                		"                            </div>\r\n" + 
                		"\r\n" + 
                		"                    </div>\r\n" + 
                		"                </div></br>";      
            }
        }
        
        htmlRespone += "    <!-- Optional JavaScript -->\r\n" + 
        		"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n" + 
        		"    <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\r\n" + 
        		"    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n" + 
        		"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n" + 
        		"\r\n" + 
        		"    <script src=\"Regole.js\"></script>\r\n" + 
        		"\r\n" + 
        		"</body>\r\n" + 
        		"\r\n" + 
        		"</html>";
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
