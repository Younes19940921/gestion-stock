package web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Cmetier;
import metier.ICataloguemetier;
import metier.Statistique;

public class Statistiqueservlet extends HttpServlet{
	

	
			/**
			 * 
			 */
			private static final long serialVersionUID = -4346729385891427918L;
			private ICataloguemetier sv;
			@Override
			public void init() throws ServletException {sv=new Cmetier();	}
			
			
			
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {doPost(req, resp);}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			    Model mod =new Model();
			                                   
			    
			    String action =req.getParameter("cherche");
			    
		        if(action!=null) 
		                         {if(action.equals("chercher")) {
			    
			                                       mod.setMotclé(req.getParameter("ref"));
			                                       mod.setDate1(req.getParameter("date"));
			                                       List<Statistique> lg = sv.statistique(mod.getMotclé(), mod.getDate1());
			                                       mod.setStat(lg);
		                         }}
			
			                                       
			                                       
			                                       
			                                       
			                                       
			                                       
			
			                                       req.setAttribute("model",mod);
			                               		req.getRequestDispatcher("Statistique.jsp").forward(req, resp);
			                               		
			
			
		}}


