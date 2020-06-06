package web;
import java.util.ArrayList;
import java.util.List;
import metier.stock;
import metier.Produit;
import metier.Statistique;
import metier.login;
import metier.verifstock;;

public class Model {
	private String motclé;
	private Produit produits=new Produit();
	private List<Produit> produit = new ArrayList<Produit>();
	private stock   stocks=new stock();
	private List<stock> stock = new ArrayList<stock>();
	private verifstock   verifstocks=new verifstock();
	private List<verifstock> verifstock = new ArrayList<verifstock>();
	private Statistique Statistiques=new Statistique();
	private List<Statistique> Stat = new ArrayList<Statistique>();

	
	
	public List<Statistique> getStat() {
		return Stat;
	}
	public void setStat(List<Statistique> stat) {
		Stat = stat;
	}
	public Statistique getStatistiques() {
		return Statistiques;
	}
	public void setStatistiques(Statistique statistiques) {
		Statistiques = statistiques;
	}



	private String date1;

    public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}



	private String errors;
    private String login;
	private String password;
	private  List<login> log = new ArrayList<login>();
	private login   logs=new login();	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<login> getLog() {
		return log;
	}
	public void setLog(List<login> log) {
		this.log = log;
	}
	public login getLogs() {
		return logs;
	}
	public void setLogs(login logs) {
		this.logs = logs;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}		
	public verifstock getVerifstocks() {
		return verifstocks;
	}
	public void setVerifstocks(verifstock verifstocks) {
		this.verifstocks = verifstocks;
	}
	public List<verifstock> getVerifstock() {
		return verifstock;
	}
	public void setVerifstock(List<verifstock> verifstock) {
		this.verifstock = verifstock;
	}
	public stock getStocks() {
		return stocks;
	}
	public void setStocks(stock stocks) {
		this.stocks = stocks;
	}
	public List<stock> getStock() {
		return stock;
	}
	public void setStock(List<stock> stock) {
		this.stock = stock;
	}
	public Produit getProduits() {
		return produits;
	}
	public void setProduits(Produit produits) {
		this.produits = produits;
	}
	public String getMotclé() {
		return motclé;
	}
	public void setMotclé(String motclé) {
		this.motclé = motclé;
	}
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	public void setDate(String parameter) {
		// TODO Auto-generated method stub
		
	}

}
