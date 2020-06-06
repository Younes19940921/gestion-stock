package metier;

import  java.sql.Date;

public class stock {
	private String refence;
	private String produit;
	private int    qttenter;

	private Date  date;
	public String getRefence() {
		return refence;
	}
	public void setRefence(String refence) {
		this.refence = refence;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public int getQttenter() {
		return qttenter;
	}
	public void setQttenter(int qttenter) {
		this.qttenter = qttenter;
	}
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public stock(String refence, String produit, int qttenter, int qttStock, Date date) {
		super();
		this.refence = refence;
		this.produit = produit;
		this.qttenter = qttenter;
		this.date = date;
	}
	public stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
