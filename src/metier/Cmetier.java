package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Cmetier implements ICataloguemetier {

	@Override
	public void addProduit(Produit p) {try {
		Connection conn=Iconnection.getConnection();
		String text="insert into produit(Reference,Designation,Quantité,Prix,PrixTotal,Client) values(?,?,?,?,?,?) ;";
		
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setString(1,p.getRefproduit());
		ps.setString(2,p.getDesignation());
		ps.setInt   (3,p.getQuantité());
		ps.setDouble(4,p.getPrix());
		ps.setDouble(5,p.getPrix()*p.getQuantité());
		ps.setString(6,p.getClientname());
		
		ps.executeUpdate();
		ps.close(); 
		
	             } catch (SQLException e) {e.printStackTrace();}}
	
	@Override
	public void addQttétotal(Produit p) {try {
		Connection conn=Iconnection.getConnection();
		String text1="update verificationstock set Qttotal=Qttotal - ? where reference =?;";
		PreparedStatement ps=conn.prepareStatement(text1);
		ps.setInt   (1,p.getQuantité());
		ps.setString(2,p.getRefproduit());
		
		ps.executeUpdate();
		ps.close(); 
		
	           } catch (SQLException e) {e.printStackTrace();}}
	@Override
	public void retourQttétotal(int id) {
		Connection conn=Iconnection.getConnection();
		String text="update verificationstock set Qttotal=Qttotal + (select Quantité FROM produit WHERE id =?) where reference=(select reference from produit WHERE id=?);;";
		try {
			PreparedStatement ps=conn.prepareStatement(text);
			ps.setInt(1,id);
			ps.setInt(2,id);
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}


	@Override
	public void verifStock(stock s) {try {
		Connection conn=Iconnection.getConnection();
		String text1="update verificationstock set Qttotal=Qttotal + ? where reference =?;";
		PreparedStatement ps=conn.prepareStatement(text1);
		ps.setInt   (1,s.getQttenter());
		ps.setString(2,s.getRefence());
		
		ps.executeUpdate();
		ps.close(); 
		
	           } catch (SQLException e) {e.printStackTrace();}}

	@Override
	public List<Produit> Produitparmcl(String mcl) {
		List<Produit> prds= new ArrayList<Produit>();
		Connection conn=Iconnection.getConnection();
		String text="select*from produit where Designation like ? or Reference = ? or Client like ?;";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setString(1, "%"+mcl+"%");
		ps.setString(2, mcl);
		ps.setString(3, "%"+mcl+"%");

		
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               Produit p=new Produit();
			                               p.setClientname(rs.getString("Client"));
			                               p.setRefproduit(rs.getString("Reference"));
			                               p.setDesignation(rs.getString("Designation"));
			                               p.setQuantité(rs.getInt("Quantité"));
			                               p.setPrix(rs.getDouble("Prix"));
			                               p.setDate(rs.getDate("DATE"));
			                               p.setId(rs.getInt("id"));
			                               p.setConfirmation(rs.getString("confirmation"));
			                               prds.add(p);
			                               
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return prds;}

	@Override
	public void deleteProduit(int id) {
		Connection conn=Iconnection.getConnection();
		String text="delete from produit where id=?;";
	try {
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setInt(1,id);
		ps.executeUpdate();
		
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	}

	@Override
	public void addqttstock(stock s) {try {
		Connection conn=Iconnection.getConnection();
		String text="insert into stock(reference,produit,Qtentrer) values(?,?,?);";
	
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setString(1,s.getRefence());
		ps.setString(2,s.getProduit());
		ps.setInt   (3,s.getQttenter());
		
		
		
		ps.executeUpdate();
		ps.close(); 
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	@Override
	public List<stock> stockparmcl(String mcl) {
		List<stock> stock= new ArrayList<stock>();
		Connection conn=Iconnection.getConnection();
		String text="select*from stock where produit like ? or reference = ? ;";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setString(1, "%"+mcl+"%");
		ps.setString(2, mcl);
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               stock s=new stock();
			                               s.setRefence(rs.getString("reference"));
			                               s.setProduit(rs.getString("produit"));
			                               s.setQttenter(rs.getInt("Qtentrer"));
			                               s.setDate(rs.getDate("Date"));
			                               stock.add(s);
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return stock;}
	
	public List<verifstock> Listverifstock() {
		List<verifstock> verifstock= new ArrayList<verifstock>();
		Connection conn=Iconnection.getConnection();
		String text="select*from verificationstock ;";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               verifstock vs=new verifstock();
			                               vs.setReference(rs.getString("reference"));
			                               vs.setProduit(rs.getString("produit"));
			                               vs.setQuantite(rs.getInt("Qttotal"));
			                              
			                               verifstock.add(vs);
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return verifstock;}
	

	@Override
	public List<verifstock> verifstockparmcl(String mcl) {

		List<verifstock> stock= new ArrayList<verifstock>();
		Connection conn=Iconnection.getConnection();
		String text="select*from verificationstock where produit like ? or reference = ? ;";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setString(1, "%"+mcl+"%");
		ps.setString(2, mcl);
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               verifstock vs=new verifstock();
			                               vs.setReference(rs.getString("reference"));
			                               vs.setProduit(rs.getString("produit"));
			                               vs.setQuantite(rs.getInt("Qttotal"));
			                               stock.add(vs);
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return stock;}
	
	@Override
	public void ajouteprdstock(verifstock vs) {try {
		Connection conn=Iconnection.getConnection();
		String text="insert into verificationstock(reference,produit,Qttotal) values(?,?,?);";
	
		PreparedStatement ps=conn.prepareStatement(text);
		ps.setString(1,vs.getReference());
		ps.setString(2,vs.getProduit());
		ps.setInt   (3,vs.getQuantite());
		
		
		
		ps.executeUpdate();
		ps.close(); 
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }}
	
	@Override
	public List<login> Produitparmcl(String log,String password) {
          List<login> lg = new ArrayList<login>();
          Connection cn=Iconnection.getConnection();
         
          PreparedStatement ps;
		try {
			ps = cn.prepareStatement("select * from connection where  login= ? and password = ?");
			ps.setString(1, log);
			ps.setString(2, password);

			ResultSet  rs=ps.executeQuery();
			
			while (rs.next()) {
				              login login =new login();
				              login.setLogin(rs.getString("login"));
				              login.setPassword(rs.getString("password"));
				              lg.add(login);
		                       	}

		} catch (SQLException e) {}
		     return lg;}

	@Override
	public void confirmProduit(int id) {Connection conn=Iconnection.getConnection();
	String text="update produit set produit.confirmation='ok' WHERE produit.id=?;";
try {
	PreparedStatement ps=conn.prepareStatement(text);
	ps.setInt(1,id);
	ps.executeUpdate();
	
	ps.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}

	@Override
	public List<verifstock> selectStock(String ref) {

			List<verifstock> stock= new ArrayList<verifstock>();
			Connection conn=Iconnection.getConnection();
			String text="select*from verificationstock where  reference = ? ;";
			try {
			PreparedStatement ps=conn.prepareStatement(text);
			ps.setString(1, ref);
			ResultSet rs=ps.executeQuery();
			                       while(rs.next()) {
				                               verifstock vs=new verifstock();
				                               vs.setReference(rs.getString("reference"));
				                               vs.setProduit(rs.getString("produit"));
				                               vs.setQuantite(rs.getInt("Qttotal"));
				                               stock.add(vs);
			                                         }
			   } catch (SQLException e) {e.printStackTrace();}
			return stock;}

	@Override
	public List<Produit> Produitnotconfirme() {
		List<Produit> prds= new ArrayList<Produit>();
		Connection conn=Iconnection.getConnection();
		String text="select*from produit where confirmation is null;";
		try {   PreparedStatement ps=conn.prepareStatement(text);
		        ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               Produit p=new Produit();
			                               p.setClientname(rs.getString("Client"));
			                               p.setRefproduit(rs.getString("Reference"));
			                               p.setDesignation(rs.getString("Designation"));
			                               p.setQuantité(rs.getInt("Quantité"));
			                               p.setPrix(rs.getDouble("Prix"));
			                               p.setDate(rs.getDate("DATE"));
			                               p.setId(rs.getInt("id"));
			                               p.setConfirmation(rs.getString("confirmation"));
			                               prds.add(p);
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return prds;}

	@Override
	public List<Produit> ListProduit() {
		List<Produit> prds= new ArrayList<Produit>();
		Connection conn=Iconnection.getConnection();
		String text="select * from produit where id=(select max(id)from produit);";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               Produit p=new Produit();
			                               p.setClientname(rs.getString("Client"));
			                               p.setRefproduit(rs.getString("Reference"));
			                               p.setDesignation(rs.getString("Designation"));
			                               p.setQuantité(rs.getInt("Quantité"));
			                               p.setPrix(rs.getDouble("Prix"));
			                               p.setDate(rs.getDate("DATE"));
			                               p.setId(rs.getInt("id"));
			                               p.setConfirmation(rs.getString("confirmation"));
			                               prds.add(p);
			                               
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return prds;}

	@Override
	public List<stock> Liststock() {
		List<stock> stock= new ArrayList<stock>();
		Connection conn=Iconnection.getConnection();
		String text="select * from stock where Date =(select max(Date)from stock);";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               stock s=new stock();
			                               s.setRefence(rs.getString("reference"));
			                               s.setProduit(rs.getString("produit"));
			                               s.setQttenter(rs.getInt("Qtentrer"));
			                               s.setDate(rs.getDate("Date"));
			                               stock.add(s);
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return stock;}

	@Override
	public List<Produit> statistique() {
		List<Produit> prds= new ArrayList<Produit>();
		Connection conn=Iconnection.getConnection();
String text="select concat(year(DATE),'-0',month(DATE)),Reference,Designation,avg(Quantité)*count(Quantité) FROM produit where Reference=? or Designation like ? and concat(year(DATE),'-0',month(DATE)) = ? group by Reference;";
		try {
		PreparedStatement ps=conn.prepareStatement(text);
		
		

		
		ResultSet rs=ps.executeQuery();
		                       while(rs.next()) {
			                               Produit s=new Produit();
			                               s.setRefproduit(rs.getString("Reference"));
			                               s.setDesignation(rs.getString("Designation"));
			                               s.setQuantité(rs.getInt("avg(Quantité)*count(Quantité)"));
			                               s.setDate(rs.getDate("concat(year(DATE),'-0',month(DATE))"));
			                               prds.add(s);
			                               
		                                         }
		   } catch (SQLException e) {e.printStackTrace();}
		return prds;}
	
}

