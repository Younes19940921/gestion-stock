package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Cmetier;
import metier.ICataloguemetier;
import metier.stock;
import metier.verifstock;

public class StockServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICataloguemetier metier;
	@Override
	public void init() throws ServletException {metier=new Cmetier();}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Model model=new Model();		
        String action =req.getParameter("stock");
 
        if(action!=null) 
                         {if(action.equals("Search")) {if(req.getParameter("motcl�")!=null) {
	                                  model.setMotcl�(req.getParameter("motcl�"));
		                              List<stock> stocker=metier.stockparmcl(model.getMotcl�());
		                              model.setStock(stocker);}}
                        
                         else if(action.equals("Ajouter")){try {
							
						stock s=new stock();
              	          
               	          model.getStocks().setRefence(req.getParameter("refpstock"));
               	          model.getStocks().setProduit(req.getParameter("produitstock"));
               	          model.getStocks().setQttenter(Integer.parseInt(req.getParameter("qttentrer")));
               	          model.getStocks().setDate(s.getDate());             	         
                      
               	          metier.verifStock(model.getStocks());
               	          metier.addqttstock(model.getStocks());
             	          model.setStock(metier.Liststock());
             	          
                         
             	         model.setMotcl�(req.getParameter("refpstock"));
                         List<verifstock> verifstocker=metier.selectStock(model.getMotcl�());
                         model.setVerifstock(verifstocker);
                         }catch (Exception e) {
             	        	 model.setErrors("Entrer des valeurs correcte");
  						} 
                          }}
        req.setAttribute("model",model);
		req.getRequestDispatcher("quantiti�.jsp").forward(req, resp);
	}
	
	
}


