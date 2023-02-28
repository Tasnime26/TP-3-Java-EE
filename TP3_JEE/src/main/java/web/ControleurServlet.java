package web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ImetierCatalogue;
import metier.MetierImpl;
import metier.Produit;
@WebServlet (name="cs",urlPatterns= {"/controleur"})//remplace le fichier web.xml

public class ControleurServlet extends HttpServlet {
	private ImetierCatalogue metier;
	@Override
	public void init() throws ServletException {
	metier=new MetierImpl();
	}
	@Override
	protected void doPost(HttpServletRequest request,
	 HttpServletResponse response) 
	 throws ServletException, IOException {
		String mc=request.getParameter("motCle");//je vais lire le parametre mots cle 
		ProduitModele mod = new ProduitModele();//je vais creer un modele  produit je vais affecter mc le mots cle dans le modele 
		mod.setMotCle(mc);
		List<Produit> prods = metier.getProduitsParMotCle(mc);//je vais appeler fetProduit par mot cle la methode qui retoyrne la list des produit qui contient le mots cle mc je vais la placer dans prods 
		mod.setProduits(prods);
		request.setAttribute("modele", mod);//je veut  passer le modele a la couche vue ily hya jsp 
		request.getRequestDispatcher("ProduitsView.jsp").forward(request,response);//transmet request et response a la vue 
		}
		}
