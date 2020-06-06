package metier;

import java.sql.Date;

public class Produit {
	private String confirmation;
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String Clientname;
	public Produit(String clientname) {
		super();
		Clientname = clientname;
	}
	public String getClientname() {
		return Clientname;
	}
	public void setClientname(String clientname) {
		Clientname = clientname;
	}
	private double PrixTotal;
	public Produit(double prixTotal) {
		super();
		PrixTotal = prixTotal;
	}
	public double getPrixTotal() {
		return PrixTotal;
	}
	public void setPrixTotal(double prixTotal) {
		PrixTotal = prixTotal;
	}
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private String refproduit;
	private String designation;
	private int quantité;
	private double prix;
	public String getRefproduit() {
		return refproduit;
	}
	public void setRefproduit(String refProduit) {
		this.refproduit = refProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String refProduit, String designation, int quantité, double prix,Date date) {
		super();
		this.refproduit = refProduit;
		this.designation = designation;
		this.quantité = quantité;
		this.prix = prix;
		this.date= date;
	}
	
	}




