package metier;

import java.util.List;

public interface ICataloguemetier {
	public  void addQttétotal(Produit p);
	public  void retourQttétotal(int id);
	public  void addProduit(Produit p);
	public List<Produit> Produitparmcl(String mcl);
	public List<Produit> Produitnotconfirme();
	
	public List<Produit> statistique();
	
	public void verifStock (stock s);
	public  void addqttstock(stock s);
	
	public List<stock> Liststock();
	public List<stock> stockparmcl(String mcl);
	
	public  void ajouteprdstock(verifstock vs);

	public List<verifstock> verifstockparmcl(String mcl);
	public List<verifstock> selectStock(String ref);
	
	
	public void deleteProduit(int id);
	public void confirmProduit(int id);
	public List<login> Produitparmcl(String log,String password);
	public List<verifstock> Listverifstock();
	public List<Produit> ListProduit();


	

	
	
	
	

}
