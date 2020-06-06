package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Cmetier;
import metier.ICataloguemetier;
import metier.verifstock;

public class VerifStockservlet extends HttpServlet {
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

		
        String action =req.getParameter("verificationstock");
 
        if(action!=null) 
                         {if(action.equals("Search")) {if(req.getParameter("motclé")!=null) {
	                                  model.setMotclé(req.getParameter("motclé"));
		                              List<verifstock> verifstocker=metier.verifstockparmcl(model.getMotclé());
		                              model.setVerifstock(verifstocker);}}
                        
                         else if(action.equals("Ajouter")){ 
              	          
               	          model.getVerifstocks().setReference(req.getParameter("refpstock"));
               	          model.getVerifstocks().setProduit(req.getParameter("produitstock"));
               	          model.getVerifstocks().setQuantite(Integer.parseInt(req.getParameter("qttstock")));
               	                        	         

               	          
               	        
               	          metier.ajouteprdstock(model.getVerifstocks());
             	          model.setVerifstock(metier.Listverifstock());}
                          }
        req.setAttribute("model",model);
		req.getRequestDispatcher("verificationstock.jsp").forward(req, resp);
	}
	
	
	
	}

