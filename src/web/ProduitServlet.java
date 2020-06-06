package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Cmetier;
import metier.ICataloguemetier;
import metier.Produit;
import metier.verifstock;


public class ProduitServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICataloguemetier metier;
	@Override
	public void init() throws ServletException {metier=new Cmetier();}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp);}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Model model=new Model();
		
		
		
		
		
		
        String action =req.getParameter("action");
 
        if(action!=null) 

        {if(action.equals("Search")) {if(req.getParameter("motclé")!=null) {
	                                  model.setMotclé(req.getParameter("motclé"));
		                              List<Produit> produit=metier.Produitparmcl(model.getMotclé());
		                              model.setProduit(produit);}}
        if(action.equals("aficher les operation non confirmer "))  {
                                       List<Produit> produit=metier.Produitnotconfirme();
                                       model.setProduit(produit);}
        
        
        if(action.equals("statistique"))  {
            List<Produit> produit=metier.statistique();
            model.setProduit(produit);}
                         
                         else if(action.equals("suprimer")){
                        	          int id=Integer.parseInt(req.getParameter("id"));
                        	          metier.retourQttétotal(id);
                        	          metier.deleteProduit(id);
                        	          model.setProduit(metier.ListProduit());}
                         
                         else if(action.equals("Valider")){
               	          int id=Integer.parseInt(req.getParameter("id"));
               	          metier.confirmProduit(id);
               	          model.setProduit(metier.ListProduit());}
                         
                         else if(action.equals("Ajouter")){ try { 
                        	
                        	
                        	 Produit p=new Produit();
              	          model.getProduits().setClientname(req.getParameter("client"));
               	          model.getProduits().setRefproduit(req.getParameter("reference"));
               	          model.getProduits().setDesignation(req.getParameter("designation"));
               	          model.getProduits().setPrix(Double.parseDouble(req.getParameter("prix")));
               	          model.getProduits().setQuantité(Integer.parseInt(req.getParameter("quantite")));              	         
               	          model.getProduits().setDate(p.getDate());
               	          model.getProduits().setConfirmation(p.getConfirmation());
               	         
               	          metier.addProduit(model.getProduits());
               	          metier.addQttétotal(model.getProduits());
             	          model.setProduit(metier.ListProduit());
							
             	          
             	         model.setMotclé(req.getParameter("reference"));
                         List<verifstock> verifstocker=metier.selectStock(model.getMotclé());
                         model.setVerifstock(verifstocker);
                      
                     
						} catch (Exception e) {
								model.setErrors("Entrer des valeurs correcte");
							}}
               
             	        }
        
                         
        req.setAttribute("model",model);
		req.getRequestDispatcher("vueproduit.jsp").forward(req, resp);
	
		}
}

