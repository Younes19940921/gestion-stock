package metier;

import java.util.Date;

public class Statistique {

	private String reference;
	private String produit;
	private int quantité;
	private Date date;
	public Statistique(String reference, String produit, int quantité, Date date) {
		super();
		this.reference = reference;
		this.produit = produit;
		this.quantité = quantité;
		this.date = date;
	}
	public Statistique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
