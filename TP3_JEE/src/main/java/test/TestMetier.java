package test;
import java.util.List;

import metier.MetierImpl;
import metier.Produit;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MetierImpl metier= new MetierImpl();
		List<Produit> prods = metier.getProduitsParMotCle("PC");
		for (Produit p : prods)
		System.out.println(p.getNomProduit());
		}

	

}
