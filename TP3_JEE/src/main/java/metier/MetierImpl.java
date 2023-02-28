package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue {
@Override
public List<Produit> getProduitsParMotCle(String mc) {
 List<Produit> prods= new ArrayList<Produit>();
 Connection conn=SingletonConnection.getConnection();//je fait appel a une methode static dans la classe singeltonconnection
 try {
PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT LIKE ?");//je prepare une requette sql ? c est un parametre 
ps.setString(1, "%"+mc+"%");//% 3al like mta3 sql w mc hya parametre mta3 methode getProduitsParMotCle(String mc)
ResultSet rs = ps.executeQuery();//j'execute la requette 
while (rs.next()) {
Produit p = new Produit();// a chaque fois j'ai cree un produit et j'affecte a ce produit son id son nom et son prix 
p.setIdProduit(rs.getLong("ID_PRODUIT"));
p.setNomProduit(rs.getString("NOM_PRODUIT"));
p.setPrix(rs.getDouble("PRIX"));
prods.add(p);//j'ajoute le produit p a la list prods 
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;//il va me retourner la list de produit dont le nom contient le mots clee mc 
}
@Override
public void addProduit(Produit p) {
// TODO Auto-generated method stub
}
}
